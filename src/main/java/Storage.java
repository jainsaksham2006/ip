import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles loading tasks from a file and saving tasks to a file.
 * Tasks are stored in a text file using a simple structured format.
 */
public class Storage {
    private String filePath = "./data/duke.txt";

    /**
     * Loads tasks from the storage file.
     *
     * @return a list of tasks loaded from the file
     */
    public ArrayList<Task> load() {
        ArrayList<Task> taskList = new ArrayList<>();

        try{
            File f = new File(filePath);

            // Create the file and directory if they do not exist
            if (!f.exists()) {
                f.getParentFile().mkdirs();
                f.createNewFile();
                return taskList;
            }

            Scanner scan = new Scanner(f);

            while(scan.hasNextLine()){
                String data = scan.nextLine().trim();
                if (data.isEmpty()) continue;

                String[] parts = data.split(" \\| ");

                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                String description = parts[2];

                Task task;

                if(type.equalsIgnoreCase("D")){
                    task = new Deadline(description, parts[3]);
                }else if(type.equalsIgnoreCase("T")){
                    task = new Todo(description);
                }else if (type.equalsIgnoreCase("E")){
                    String timeRange = parts[3];
                    String[] times = timeRange.split("-");

                    if (times.length < 2) {
                        continue;
                    }

                    task = new Event(description, times[0], times[1]);

                }else{
                    continue;
                }

                if (isDone) {
                    task.markAsDone();
                }

                taskList.add(task);
            }
            scan.close();
        }catch(IOException e){
            System.out.println("Error loading file.");
        }
        return taskList;
    }

    /**
     * Saves the current task list to the storage file.
     *
     * @param taskList the list of tasks to be saved
     */
    public void save(ArrayList<Task> taskList) {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(filePath);

            for (Task task : taskList){
                String done;
                if(task.isDone()){
                    done = "1";
                }else {
                    done = "0";
                }
                if(task instanceof Deadline){
                    Deadline d = (Deadline) task;
                    writer.println("D" + " | "+ done + " | " +
                            d.getDescription() + " | " + d.getBy());
                } else if (task instanceof Event){
                    Event e = (Event) task;
                    writer.println("E" + " | " + done + " | " +
                            e.getDescription() + " | " + e.getTimeRange());
                } else if (task instanceof Todo){
                    Todo t = (Todo) task;
                    writer.println("T" +" | " + done + " | " + t.getDescription());
                }
            }
        } catch(IOException e) {
            System.out.println("Error saving file.");
        }

        if (writer != null) {
            writer.close();
        }
    }
}
