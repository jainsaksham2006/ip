/**
 * Represents a task that must be completed before a specific date or time.
 */

public class Deadline extends Task {

    protected String by;

    /**
     * Constructs a Deadline task with a description and due date.
     *
     * @param description the description of the task
     * @param by the deadline of the task
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the deadline of the task.
     *
     * @return the due date or time
     */
    public String getBy() {
        return by;
    }

    /**
     * Returns the string representation of the deadline task.
     *
     * @return formatted deadline task string
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}