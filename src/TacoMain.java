import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;
public class TacoMain {
    static TacoManager tacoManager;
    private static TacoOrderBank desiredTacoOrderBank;

    public static void main(String[] args) {
        TacoManager tacoManager = new TacoManager();
        TacoOrderBank desiredTacoOrderBank = new TacoOrderBank();
        DialogueTreeManager dialogueManager = new DialogueTreeManager();
        Scanner scanner = new Scanner(System.in);
        int totalTips = 0;
        int dayTips = 0;

        System.out.println("Hello! My name is Your Boss. Welcome to your first day at the Taco Shop. What's your name?");
        String username = scanner.nextLine();

        System.out.println("That's an okay name. Welcome " + username + "! ");
        System.out.println("Today we expect 5 customers. You're new here, so try to be courteous to our town's people. They can be a handful.... Good luck!");
        
        for (int i=0; i<5; i++){
            System.out.println("\n--- New Customer ---");
            Taco desiredTaco = desiredTacoOrderBank.getRandomOrder();

            DialogueNode root = dialogueManager.getRandomCustomerTree(username, desiredTaco);
            
            int dialogueTips = dialogueManager.runDialogue(root, desiredTaco, tacoManager);
            totalTips += dialogueTips;

            if (dialogueTips !=0){
                Taco userTaco = tacoManager.buildTaco();
                System.out.println("\n--- Customer has been served ---");
                int tacoScore = userTaco.rateTaco(desiredTaco);
                totalTips += tacoScore;
            }
            
            System.out.println("You earned " + (totalTips) + " in tips from this customer.");
            dayTips = dayTips + totalTips;
            totalTips = 0;
        }
        System.out.println("\nShift over! Total tips earned: " + dayTips);
    }
}
