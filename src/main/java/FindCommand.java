public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        if (keyword == null || keyword.trim().isEmpty()) {
            ui.showError("Please provide a keyword to search.");
            return;
        }

        System.out.println("Here are the matching tasks in your list:");

        int count = 1;

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);

            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(count + "." + task);
                count++;
            }
        }

        if (count == 1) {
            System.out.println("No matching tasks found.");
        }
    }
}
