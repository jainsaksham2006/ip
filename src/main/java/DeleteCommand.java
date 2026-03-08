public class DeleteCommand extends Command {

    private String[] userCommand;

    public DeleteCommand(String[] userCommand) {
        this.userCommand = userCommand;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        if (userCommand.length < 2) {
            ui.showError("Please specify which task number to delete.");
            return;
        }

        try {
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