import java.util.Scanner;

/**
 * Handles all user interactions with the chatbot.
 * This class is responsible for displaying messages
 * and reading user input.
 */
public class Ui {

    private Scanner scanner = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("Hello! I'm Nova");
        System.out.println("What can I do for you?");
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void showBye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Displays an error message to the user.
     *
     * @param message the error message to display
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Displays the list of tasks currently stored.
     *
     * @param tasks the task list to display
     */
    public void showTaskList(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }


    /**
     * Displays confirmation that a task was added.
     *
     * @param task the task that was added
     * @param tasks the updated task list
     */
    public void showTaskAdded(Task task, TaskList tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}
