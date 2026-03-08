/**
 * Command that deletes a task from the task list.
 */

public class DeleteCommand extends Command {

    private String[] userCommand;

    /**
     * Constructs a DeleteCommand using the parsed user command.
     *
     * @param userCommand the command entered by the user
     */
    public DeleteCommand(String[] userCommand) {
        this.userCommand = userCommand;
    }

    /**
     * Executes the delete command by removing the specified task
     * from the task list and saving the updated list to storage.
     *
     * @param tasks the task list containing all tasks
     * @param ui the UI used for displaying messages
     * @param storage the storage used to persist tasks
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        if (userCommand.length < 2) {
            ui.showError("Please specify which task number to delete.");
            return;
        }

        try {

            // Convert user task number to list index
            int index = Integer.parseInt(userCommand[1]) - 1;
            Task task = tasks.delete(index);

            storage.save(tasks.getAll());

            System.out.println("Noted. I've removed this task:");
            System.out.println(" " + task);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");

        } catch (NumberFormatException e) {
            ui.showError("Task number must be a valid number.");
        } catch (IndexOutOfBoundsException e) {
            ui.showError("That task number does not exist.");
        }
    }
}