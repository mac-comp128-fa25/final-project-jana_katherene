import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;
public class TacoMain {
    static TacoManager tacoManager;
    private static TacoOrderBank desiredTacoOrderBank;

    public static void main(String[] args) throws InterruptedException {
        TacoManager tacoManager = new TacoManager();
        TacoOrderBank desiredTacoOrderBank = new TacoOrderBank();
        CustomerName customerNameBank = new CustomerName();
        DialogueTreeManager dialogueManager = new DialogueTreeManager();
        Scanner scanner = new Scanner(System.in);
        int totalTips = 0;
        int dayTips = 0;

        System.out.println("Hello! My name is Your Boss. Welcome to your first day at the Taco Shop. What's your name?");
        String username = scanner.nextLine();
        Thread.sleep(1000);

        System.out.println("That's an okay name. Welcome " + username + "! ");
        Thread.sleep(1000);

        System.out.println("Today we expect 5 customers.");
        Thread.sleep(1000);

        System.out.println("You're new here, so try to be courteous to our town's people. They can be a handful.... ");
        Thread.sleep(1000);

        System.out.println("If they like you, you will earn tips!");
        Thread.sleep(1200);

        System.out.println("And hey, if you keep it up, you can join our community!");
        Thread.sleep(1500);

        System.out.println("I will check back in with you after your shift. Oh look! I see someone already!");
        Thread.sleep(3000);

        for (int i=0; i<5; i++){
            System.out.println("\n--- New Customer ---");
            Taco desiredTaco = desiredTacoOrderBank.getRandomOrder();
            String name = customerNameBank.getRandomName();
            DialogueNode root = dialogueManager.getRandomCustomerTree(name, username, desiredTaco);
            
            int dialogueTips = dialogueManager.runDialogue(root, desiredTaco, tacoManager);
            totalTips += dialogueTips;

            Thread.sleep(2000);

            if (dialogueTips !=0){
                Taco userTaco = tacoManager.buildTaco();
                System.out.println("\n--- Customer has been served ---");
                int tacoScore = userTaco.rateTaco(desiredTaco);
                totalTips += tacoScore;
            }
            
            System.out.println("You earned " + ((double) totalTips/10) + " in tips from this customer.");
            dayTips = dayTips + totalTips;
            totalTips = 0;
        }

        System.out.println("\nShift over! Total tips earned: " + dayTips/10);
        
        if (dayTips>100){
            System.out.println("You made so many tips! The town must really like you! ");
        }else if (dayTips<100){
            System.out.println("You have not made enough... Seems you made a bad impression");
        }
    }
}
