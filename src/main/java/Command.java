/**
 * Represents a command that can be executed by the chatbot.
 * All specific commands (e.g., MarkCommand, DeleteCommand) inherit from this class.
 */

public abstract class Command {

    /**
     * Executes the command.
     *
     * @param tasks the list of tasks
     * @param ui the user interface for displaying messages
     * @param storage the storage handler for saving tasks
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

    public boolean isExit() {
        return false;
    }
}
