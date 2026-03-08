/**
 * Command that marks a task as not done.
 */

public class UnmarkCommand extends Command {

    private String[] userCommand;

    /**
     * Constructs an UnmarkCommand using the parsed user command.
     *
     * @param userCommand the command tokens entered by the user
     */
    public UnmarkCommand(String[] userCommand) {
        this.userCommand = userCommand;
    }

    /**
     * Executes the unmark command by setting the specified task's status
     * to not done and saving the updated task list.
     *
     * @param tasks the task list containing all tasks
     * @param ui the UI used for displaying messages
     * @param storage the storage used to persist tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        if (userCommand.length < 2) {
            ui.showError("Please specify which task number to unmark.");
            return;
        }

        try {
            // Convert task number from user input to list index
            int index = Integer.parseInt(userCommand[1]) - 1;

            Task task = tasks.get(index);
            task.markAsNotDone();

            storage.save(tasks.getAll());

            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println("  " + task);

        } catch (NumberFormatException e) {
            ui.showError("Task number must be a valid number.");

        } catch (IndexOutOfBoundsException e) {
            ui.showError("That task number does not exist.");
        }
    }
}
