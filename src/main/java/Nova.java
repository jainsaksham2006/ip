import java.util.ArrayList;
import java.util.Scanner;
public class Nova {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Hello! I'm Nova");
        System.out.println("What can I do for you?");
        ArrayList<String> taskList = new ArrayList<>();
        ArrayList<Boolean> doneList = new ArrayList<>();

        while(true){

            String userInput = scan.nextLine();
            String[] userCommand = userInput.trim().split("\\s+");

            if(userCommand[0].equalsIgnoreCase("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                break;

            }else if(userCommand[0].equalsIgnoreCase("list")){
                System.out.println("Here are the tasks in your list:");
                for(int i=0; i<taskList.size();i++){
                    String status;
                    if(!doneList.get(i)){
                        status = "[ ]";
                    }else{
                        status = "[X]";
                    }
                    System.out.println((i+1) + ". "+ status +" "+ taskList.get(i));
                }
            }else if(userCommand[0].equalsIgnoreCase("mark") && userCommand.length>1){
                int taskNumber = Integer.parseInt(userCommand[1]) - 1;
                if(taskNumber >= 0 && taskNumber < taskList.size()){
                    doneList.set(taskNumber, true);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  [X] "+ taskList.get(taskNumber));
                }
            }else if(userCommand[0].equalsIgnoreCase("unmark") && userCommand.length>1){
                int taskNumber = Integer.parseInt(userCommand[1]) - 1;
                if(taskNumber >= 0 && taskNumber < taskList.size()){
                    doneList.set(taskNumber, false);
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  [ ] "+ taskList.get(taskNumber));
                }
            }else{
                System.out.println("added: " + userInput);
                taskList.add(userInput);
                doneList.add(false);
            }

        }
        scan.close();
    }
}
