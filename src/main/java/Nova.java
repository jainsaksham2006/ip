import java.util.ArrayList;
import java.util.Scanner;

public class Nova {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Hello! I'm Nova");
        System.out.println("What can I do for you?");
        ArrayList<Task> taskList = new ArrayList<>();

        while (true) {

            String userInput = scan.nextLine();
            String[] userCommand = userInput.trim().split("\\s+");

            if (userCommand[0].equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;

            } else if (userCommand[0].equalsIgnoreCase("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskList.size(); i++) {
                    Task task = taskList.get(i);
                    System.out.println((i + 1) + ". " + task.getStatusIcon() + " " + task.getDescription());
                }
            } else if (userCommand[0].equalsIgnoreCase("mark") && userCommand.length > 1) {
                int index = Integer.parseInt(userCommand[1]) - 1;
                Task task = taskList.get(index);
                task.markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + task.getStatusIcon() + " " + task.getDescription());

            } else if (userCommand[0].equalsIgnoreCase("unmark") && userCommand.length > 1) {
                int index = Integer.parseInt(userCommand[1]) - 1;
                Task task = taskList.get(index);
                task.markAsNotDone();

                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + task.getStatusIcon() + " " + task.getDescription());
            } else {
                taskList.add(new Task(userInput));
                System.out.println("Added: " + userInput);
            }

        }
        scan.close();
    }
}

