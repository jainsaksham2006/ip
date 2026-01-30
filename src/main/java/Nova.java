import java.util.ArrayList;
import java.util.Scanner;
public class Nova {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Hello! I'm Nova");
        System.out.println("What can I do for you?");
        ArrayList<String> taskList = new ArrayList<>();

        while(true){

            String userInput = scan.nextLine();

            if(userInput.equalsIgnoreCase("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                break;

            }else if(userInput.equalsIgnoreCase("list")){
                for(int i=0; i<taskList.size();i++){
                    System.out.println((i+1) + ". "+ taskList.get(i));
                }
            }else{
                System.out.println("added: " + userInput);
                taskList.add(userInput);
            }

        }
        scan.close();
    }
}
