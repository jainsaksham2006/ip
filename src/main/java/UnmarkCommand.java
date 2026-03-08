public class UnmarkCommand extends Command {

    private String[] userCommand;

    public UnmarkCommand(String[] userCommand) {
        this.userCommand = userCommand;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        if (userCommand.length < 2) {
            ui.showError("Please specify which task number to unmark.");
            return;
        }

        try {
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
