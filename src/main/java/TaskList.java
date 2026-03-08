import java.util.ArrayList;

/**
 * Represents the list of tasks managed by the chatbot.
 * Provides methods to add, remove, and retrieve tasks.
 */
public class TaskList {

    private ArrayList<Task> tasks;

    /**
     * Constructs a TaskList using an existing list of tasks.
     *
     * @param tasks the list of tasks loaded from storage
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the task at the specified index.
     *
     * @param index the position of the task in the list
     * @return the task at the given index
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Adds a new task to the task list.
     *
     * @param task the task to add
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes the task at the specified index.
     *
     * @param index the position of the task to remove
     * @return the removed task
     */
    public Task delete(int index) {
        return tasks.remove(index);
    }

    /**
     * Returns the number of tasks currently in the list.
     *
     * @return the total number of tasks
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns the entire list of tasks.
     *
     * @return the list of tasks
     */
    public ArrayList<Task> getAll() {
        return tasks;
    }
}
