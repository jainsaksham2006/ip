import java.util.ArrayList;
import java.util.Scanner;

public class Nova {

    private static void printTaskList(ArrayList<Task> taskList) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            System.out.println((i + 1) + ". " + task);
        }
    }

    private static void printTaskAdded(Task task, ArrayList<Task> taskList) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Hello! I'm Nova");
        System.out.println("What can I do for you?");
        ArrayList<Task> taskList = new ArrayList<>();

        while (true) {

            String userInput = scan.nextLine().trim();

            if (userInput.isEmpty()) {
                System.out.println("Please enter a command. I didn't catch anything.");
                continue;
            }

            String[] userCommand = userInput.split("\\s+");
            if (userCommand[0].equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;

            } else if (userCommand[0].equalsIgnoreCase("list")) {
                printTaskList(taskList);

            } else if (userCommand[0].equalsIgnoreCase("mark") && userCommand.length > 1) {

                if (userCommand.length < 2) {
                    System.out.println("Please specify which task number to mark.");
                    continue;
                }

                int index = Integer.parseInt(userCommand[1]) - 1;
                Task task = taskList.get(index);
                task.markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + task);

            } else if (userCommand[0].equalsIgnoreCase("unmark") && userCommand.length > 1) {

                if (userCommand.length < 2) {
                    System.out.println("Please specify which task number to unmark.");
                    continue;
                }

                int index = Integer.parseInt(userCommand[1]) - 1;
                Task task = taskList.get(index);
                task.markAsNotDone();

                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + task);
            } else if (userCommand[0].equalsIgnoreCase("todo")) {
                String description = userInput.substring(5).trim();
                if(description.isEmpty()){
                    System.out.println("A todo needs a description. Please tell me what to do.");
                    continue;
                }
                Task task = new Todo(description);
                taskList.add(task);
                printTaskAdded(task, taskList);
            } else if (userCommand[0].equalsIgnoreCase("deadline") && userCommand.length > 1) {

                if (!userInput.contains("/by")) {
                    System.out.println("A deadline needs a /by date. Example: deadline homework /by Sunday");
                    continue;
                }

                String fullCommand = String.join(" ", userCommand);
                String[] parts = fullCommand.split("/by");
                String description = parts[0].replace("deadline", "").trim();
                String by = parts[1].trim();;
                Task task = new Deadline(description, by);
                taskList.add(task);
                printTaskAdded(task, taskList);

            } else if (userCommand[0].equalsIgnoreCase("event") && userCommand.length > 1) {

                if (!userInput.contains("/from") || !userInput.contains("/to")) {
                    System.out.println("An event needs /from and /to times.");
                    continue;
                }
                String fullCommand = String.join(" ", userCommand);
                String[] parts = fullCommand.split("/from");
                String description = parts[0].replace("event", "").trim();
                String[] duration = parts[1].split("/to", 2);
                String startTime = duration[0].trim();;
                String endTime = duration[1].trim();;
                Task task = new Event(description, startTime, endTime);
                taskList.add(task);
                printTaskAdded(task, taskList);

            } else {
                System.out.println("I don't recognize that command.");
            }

        }
        scan.close();
    }
}

