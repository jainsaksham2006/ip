/**
 * Represents a Todo task without any associated date or time.
 */

public class Todo extends Task {

    /**
     * Constructs a Todo task with the given description.
     *
     * @param description the description of the task
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns the string representation of the Todo task.
     *
     * @return formatted Todo task string
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
