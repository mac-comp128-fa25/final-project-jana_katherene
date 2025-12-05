import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;
public class TacoMain {

    HashMap<String, Customer> mapOne;
    static Customer sally;
    int tips; 
    String username;
    static TacoManager tacoManager;

    public static void main(String[] args) {

        DialogueTreeManager testRun = new DialogueTreeManager();
        testRun.runSampleDialogue();
        //sample text interaction
        // sally = new Customer(0, 0, "sally");
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter your name:");

        // sally.name = scanner.nextLine();

        // System.out.println(sally.getName());
        // run intro text
        // prompt user to press start
        // once begins, enter c-style loop of 10 times
            //  get a random customer, add them to queue
            // call tree dialogue method ****** (figure this out, do we need multiple trees?) 
            // calculate amount of money earned from interaction 
            // append to tips instance variable 
        // 
        TacoManager tacoManager = new TacoManager();
        
        System.out.println("Hello! My name is Your Boss. Welcome to your first day at the Taco Shop. What's your name?");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        
        System.out.println("That's an okay name. Welcome " + username + "! ");
        System.out.println("Today we expect 10 customers. You're new here, so try to be courteous to our town's people. They can be a handful.... Good luck!");
        tacoManager.buildTaco();
        
    }
}
