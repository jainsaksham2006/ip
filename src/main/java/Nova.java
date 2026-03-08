import java.util.*;

/**
 * Main class for the Nova.
 * It initializes the UI, storage and task list,
 * and runs the main command loop for user interaction.
 */

public class Nova {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructs a Nova chatbot.
     * Loads tasks from storage and prepares UI.
     */
    public Nova() {
        ui = new Ui();
        storage = new Storage();
        tasks = new TaskList(storage.load());
    }

    /**
     * Runs the chatbot loop, reading and executing user commands
     * until the user exits the program.
     */
    public void run() {

        ui.showWelcome();

        while (true) {

            String userInput = ui.readCommand();

            if (userInput.isEmpty()) {
                ui.showError("Please enter a command. I didn't catch anything.");
                continue;
            }

            // Parse the command into words
            String[] userCommand = Parser.parse(userInput);

            if (userCommand[0].equalsIgnoreCase("bye")) {
                ui.showBye();
                break;

            } else if (userCommand[0].equalsIgnoreCase("list")) {
                ui.showTaskList(tasks);

            } else if (userCommand[0].equalsIgnoreCase("mark")) {

                Command command = new MarkCommand(userCommand);
                command.execute(tasks, ui, storage);

            } else if (userCommand[0].equalsIgnoreCase("unmark")) {

                Command command = new UnmarkCommand(userCommand);
                command.execute(tasks, ui, storage);

            } else if (userCommand[0].equalsIgnoreCase("todo")) {

                if (userInput.length() <= 5) {
                    ui.showError("A todo needs a description. Please tell me what to do.");
                    continue;
                }

                // Extract description after the command word
                String description = userInput.substring(5).trim();

                if (description.isEmpty()) {
                    ui.showError("A todo needs a description. Please tell me what to do.");
                    continue;
                }

                Task task = new Todo(description);
                tasks.add(task);
                storage.save(tasks.getAll());
                ui.showTaskAdded(task, tasks);

            } else if (userCommand[0].equalsIgnoreCase("deadline")) {

                try {

                    if (userCommand.length == 1) {
                        System.out.println("A deadline needs a description and date.");
                        continue;
                    }

                    if (!userInput.contains("/by")) {
                        ui.showError("A deadline needs a /by date. Example: deadline homework /by Sunday");
                        continue;
                    }

                    String fullCommand = String.join(" ", userCommand);
                    String[] parts = fullCommand.split("/by");

                    // Extract deadline description and date
                    String description = parts[0].replace("deadline", "").trim();
                    String by = parts[1].trim();

                    if (by.isEmpty()) {
                        ui.showError("Deadline date cannot be empty.");
                        continue;
                    }

                    if (description.isEmpty()) {
                        ui.showError("Deadline description cannot be empty.");
                        continue;
                    }

                    Task task = new Deadline(description, by);
                    tasks.add(task);
                    storage.save(tasks.getAll());
                    ui.showTaskAdded(task, tasks);

                } catch (Exception e) {
                    ui.showError("Invalid Deadline Format.");
                }

            } else if (userCommand[0].equalsIgnoreCase("event")) {

                try {

                    if (userCommand.length == 1) {
                        System.out.println("An event needs a description and time.");
                        continue;
                    }

                    if (!userInput.contains("/from") || !userInput.contains("/to")) {
                        ui.showError("An event needs /from and /to times.");
                        continue;
                    }

                    String fullCommand = String.join(" ", userCommand);
                    String[] parts = fullCommand.split("/from");

                    // Extract event description and time range
                    String description = parts[0].replace("event", "").trim();
                    String[] duration = parts[1].split("/to", 2);

                    String startTime = duration[0].trim();
                    String endTime = duration[1].trim();

                    if (startTime.isEmpty() || endTime.isEmpty()) {
                        ui.showError("Event time cannot be empty.");
                        continue;
                    }

                    if (description.isEmpty()) {
                        ui.showError("Event description cannot be empty.");
                        continue;
                    }

                    Task task = new Event(description, startTime, endTime);
                    tasks.add(task);
                    storage.save(tasks.getAll());
                    ui.showTaskAdded(task, tasks);

                } catch (Exception e) {
                    ui.showError("Invalid Event Format.");
                }

            } else if (userCommand[0].equalsIgnoreCase("delete")) {

                Command command = new DeleteCommand(userCommand);
                command.execute(tasks, ui, storage);


            } else if (userCommand[0].equalsIgnoreCase("find")) {

                if (userCommand.length < 2) {
                    ui.showError("Please provide a keyword to search.");
                    continue;
                }

                // Extract keyword after "find"
                String keyword = userInput.substring(5).trim();

                Command command = new FindCommand(keyword);
                command.execute(tasks, ui, storage);

            }else {
                ui.showError("I don't recognize that command.");
            }
        }
    }

    /**
     * Starts the Nova chatbot.
     */
    public static void main(String[] args) {
        new Nova().run();
    }
}

