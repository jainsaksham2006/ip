/**
 * Command that marks a task as completed.
 */

public class MarkCommand extends Command {

    private String[] userCommand;

    /**
     * Constructs a MarkCommand using the parsed user command.
     *
     * @param userCommand the command tokens entered by the user
     */
    public MarkCommand(String[] userCommand) {
        this.userCommand = userCommand;
    }

    /**
     * Executes the mark command by setting the specified task's status
     * to done and saving the updated task list.
     *
     * @param tasks the task list containing all tasks
     * @param ui the UI used for displaying messages
     * @param storage the storage used to persist tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        if (userCommand.length < 2) {
            ui.showError("Please specify which task number to mark.");
            return;
        }

        try {
            // Convert task number from user input to list index
            int index = Integer.parseInt(userCommand[1]) - 1;

            Task task = tasks.get(index);
            task.markAsDone();

            storage.save(tasks.getAll());

            System.out.println("Nice! I've marked this task as done:");
            System.out.println("  " + task);

        } catch (NumberFormatException e) {
            ui.showError("Task number must be a valid number.");

        } catch (IndexOutOfBoundsException e) {
            ui.showError("That task number does not exist.");
        }
    }
}
