/**
 * Represents a generic task with a description and completion status.
 * This is the base class for specific task types such as Todo, Deadline, and Event.
 */

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a task with the given description.
     * The task is initially marked as not done.
     *
     * @param description the description of the task
     */

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return formatted task string with status icon and description
     */
    public String toString() {
        return getStatusIcon() + " " + description;
    }
    public void markAsDone() {
        isDone = true;
    }

    public void markAsNotDone() {
        isDone = false;
    }

    /**
     * Returns whether the task has been completed.
     *
     * @return true if the task is done, false otherwise
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Returns the status icon of the task.
     *
     * @return "[X]" if done, "[ ]" if not done
     */
    public String getStatusIcon() {
        if(isDone == true){
            return "[X]";
        } else {
            return "[ ]";
        }
    }

    /**
     * Returns the description of the task.
     *
     * @return the task description
     */
    public String getDescription() {

        return description;
    }
}





