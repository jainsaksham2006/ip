import java.util.Scanner;
public class Nova {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Hello! I'm Nova");
        System.out.println("What can I do for you?");

        while(true){
            if(!scan.hasNextLine()){
                break;
            }
            String userInput = scan.nextLine();

            if(userInput.equalsIgnoreCase("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }else{
                System.out.println(userInput);
            }

        }
        scan.close();
    }
}
