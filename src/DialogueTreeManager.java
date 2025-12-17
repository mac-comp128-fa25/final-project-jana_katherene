import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class DialogueTreeManager{
    private DialogueNode startNode;
    private Random rand = new Random();
    private TacoOrderBank desiredTacoOrderBank = new TacoOrderBank();
    
    /**
     * Creates a DialogueTreeManager responsible for generating and running
     * customer dialogue trees during gameplay.
     */
    public DialogueTreeManager(){
    }

    /**
     * Randomly selects and generates one of two possible dialogue trees 
     * for a customer interaction.
     *
     * @param name the customer's name
     * @param username the player's username
     * @param desiredTaco the taco the customer wants to order
     * @return the root DialogueNode of the generated dialogue tree
     */
    public DialogueNode getRandomCustomerTree(String name, String username, Taco desiredTaco) {
            int pick = rand.nextInt(2); 

            if (pick == 0) {
                return ATree(name, username, desiredTaco);
            } else {
                return BTree(name, username, desiredTaco);
            }
        }


    /**
     * Runs an interactive dialogue starting from the given node, allowing the player
     * to choose dialogue options that affect tip outcomes and conversation flow.
     *
     * @param startNode the starting node of the dialogue tree
     * @param desiredTaco the taco the customer wants
     * @param tacoManager the manager responsible for taco creation 
     * @return the total dialogue-based tip amount earned
     */
    public int runDialogue(DialogueNode startNode, Taco desiredTaco, TacoManager tacoManager){
        
        Scanner scanner = new Scanner(System.in);
        DialogueNode current = startNode;
        int dialogueTips = 0;

        while(true){
            System.out.println("\n" + current.getText());

            if (current.endEarly){
                System.out.println("Customer has left.");
                return 0;
            }

            if (current.getChoices().isEmpty()){
                System.out.println("Customer is waiting to be served.");
                if (dialogueTips == 0){
                    return dialogueTips +1; // this way, only get 0 tips if customer walks out & and you skip taco making
                }
                else {
                    return dialogueTips;
                }
            }

            for(int i = 0; i < current.getChoices().size(); i++){
                System.out.println((i + 1) + ". " +
                    current.getChoices().get(i).getChoiceText());
            }

            int choice;
            while (true) {
                System.out.print("Choose: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice >= 1 && choice <= current.getChoices().size()) {
                        break;
                    }
                } else {
                    scanner.nextLine();
                }
                System.out.println("Invalid input.");
            }

            DialogueChoice selected = current.getChoices().get(choice - 1);
            dialogueTips += selected.getTipImpact();
            current = selected.getNextNode();
        }
    }

    /**
     * Builds and returns Dialogue Tree A which represents one possible customer personality and interaction style.
     * 
     * @param name the customer's name
     * @param username the player's username
     * @param desiredTaco the taco the customer wants to order
     * @return the root DialogueNode for Dialogue Tree A
     */
    public DialogueNode ATree(String name, String username, Taco desiredTaco){
        String orderedTaco = desiredTaco.tacoName();
        
        // root node 
        DialogueNode starterDialogueNode = new DialogueNode(" Customer: Hello");
        
        // first customer responses 
        DialogueNode negReplyA1 = new DialogueNode("My name is " + name + ". Not dear. You won't get far in this town unless you're respectful..");
        DialogueNode negReplyA3 = new DialogueNode("Frick you! I will take my taco business elsewhere.",  true);
        DialogueNode posReplyA1 = new DialogueNode("Hi! So nice of you to ask, my name is " + name + ".");
        
        // first user choices 
        starterDialogueNode.addChoice(new DialogueChoice("Hello dear customer, What is your name and how may I help you?", negReplyA1, -5));
        starterDialogueNode.addChoice(new DialogueChoice("Hello... What's your name?", posReplyA1, +5));
        starterDialogueNode.addChoice(new DialogueChoice("HAHAHAH... Why are you at a taco stand at 8 am?", negReplyA3, -5));

        // second level customer responses 
        DialogueNode negReplyB2 = new DialogueNode("Ummmmmm. Ok. Can I get a " + orderedTaco);
        DialogueNode posReplyB1 = new DialogueNode("I would likeeee...." + orderedTaco);
        DialogueNode posReplyB2 = new DialogueNode("It's great to meet you " + username + ". Good to see a fresh face around these parts. ");
        DialogueNode posReplyB3 = new DialogueNode("Wow, you're so sweet");

        // second level user choices
        negReplyA1.addChoice(new DialogueChoice("I'm sorry... It's my first day... I''m really struggling.. I-", negReplyB2, -5)); 
        negReplyA1.addChoice(new DialogueChoice("Sorry.. What can I get you " + name + "?", posReplyB1, +5));
        negReplyA1.addChoice(new DialogueChoice("What would you like?", posReplyB1, +5));

        negReplyA3.addChoice(new DialogueChoice("I'm sorry... It's my first day... I''m really struggling.. I-", negReplyB2, -5)); 
        negReplyA3.addChoice(new DialogueChoice("Sorry.. What can I get you " + name + "?", posReplyB1, +5));
        negReplyA3.addChoice(new DialogueChoice("What would you like?", posReplyB1, +5));

        posReplyA1.addChoice(new DialogueChoice("My name's " + username + ".", posReplyB2, +5));
        posReplyA1.addChoice(new DialogueChoice("I loooove your hair today by the way. Super diva. ", posReplyB3, +10)); // or negReplyB4
        
        // last level customer speech
        DialogueNode posReplyC1 = new DialogueNode("I would like " + orderedTaco );

        // third level user choices
        posReplyB2.addChoice(new DialogueChoice("Anyways, what can I get for ya?", posReplyC1, +5));
        posReplyB2.addChoice(new DialogueChoice("Thanks for being so welcoming. What can I get for you?", posReplyC1, +5));
        posReplyB2.addChoice(new DialogueChoice("Hey, I am way out of your league. Stop flirting. What taco do you want?", posReplyC1, +5));
        
        posReplyB3.addChoice(new DialogueChoice("Anyways, what can I get for ya?", posReplyC1, +5));
        posReplyB3.addChoice(new DialogueChoice("Thanks for being so welcoming. What can I get for you?", posReplyC1, +5));
        posReplyB3.addChoice(new DialogueChoice("Hey, I am way out of your league. Stop flirting. What taco do you want?", posReplyC1, +5));
        
        startNode = starterDialogueNode;
        return startNode;
    }

     /**
     * Builds and returns Dialogue Tree B which represents one possible customer personality and interaction style.
     * 
     * @param name the customer's name
     * @param username the player's username
     * @param desiredTaco the taco the customer wants to order
     * @return the root DialogueNode for Dialogue Tree B
     */
    public DialogueNode BTree(String name, String username, Taco desiredTaco){
        String orderedTaco = desiredTaco.tacoName();

        // root node 
        DialogueNode starterDialogueNode = new DialogueNode(" Customer: Hello");
        
        // first customer responses 
        DialogueNode negReplyA2 = new DialogueNode("I don't know you... " );
        DialogueNode posReplyA1 = new DialogueNode("Hi! So nice of you to ask, my name is " + name + ".");
        DialogueNode posReplyA2 = new DialogueNode("You're right. It is kinda weird. I like you. My name is " + name);
        
        // first user choices 
        starterDialogueNode.addChoice(new DialogueChoice("Hello dear customer, What is your name and how may I help you?", negReplyA2, -5));
        starterDialogueNode.addChoice(new DialogueChoice("Hello... What's your name?", posReplyA1, +5));
        starterDialogueNode.addChoice(new DialogueChoice("HAHAHAH... Why are you at a taco stand at 8 am?", posReplyA2, +5));

        // second level customer responses 
        DialogueNode negReplyB1 = new DialogueNode("Man. I do not care. I'm leaving.", true);
        DialogueNode negReplyB4 = new DialogueNode("I dont like that. ");
        DialogueNode posReplyB1 = new DialogueNode("I would likeeee...." + orderedTaco);
        DialogueNode posReplyB2 = new DialogueNode("It's great to meet you " + username + ". Good to see a fresh face around these parts. ");
        DialogueNode posReplyB3 = new DialogueNode("Wow, you're so sweet");

        // last level customer speech
        DialogueNode posReplyC1 = new DialogueNode("I would like " + orderedTaco );
        
        // second level user choices
        negReplyA2.addChoice(new DialogueChoice("I'm sorry... It's my first day... I''m really struggling.. I-", negReplyB1, -5)); // also could be negReplyB2
        negReplyA2.addChoice(new DialogueChoice("Sorry.. What can I get you " + name + "?", posReplyB1, +5));
        negReplyA2.addChoice(new DialogueChoice("What would you like?", posReplyB1, +10));

        posReplyA1.addChoice(new DialogueChoice("My name's " + username + ".", posReplyB2, +5));
        posReplyA1.addChoice(new DialogueChoice("I loooove your hair today by the way. Super diva. ", negReplyB4, -5)); 
        posReplyA1.addChoice(new DialogueChoice("Anyways, what can I get for ya?", posReplyC1, +5));

        posReplyA2.addChoice(new DialogueChoice("My name's " + username + ".", posReplyB2, +5));
        posReplyA2.addChoice(new DialogueChoice("I loooove your hair today by the way. Super diva. ", negReplyB4, -5)); 
        posReplyA2.addChoice(new DialogueChoice("Anyways, what can I get for ya?", posReplyC1, +5));

        // third level user choices
        posReplyB2.addChoice(new DialogueChoice("Anyways, what can I get for ya?", posReplyC1, +5));
        posReplyB2.addChoice(new DialogueChoice("Thanks for being so welcoming. What can I get for you?", posReplyC1, +5));
        posReplyB2.addChoice(new DialogueChoice("Hey, I am way out of your league. Stop flirting. What taco do you want?", posReplyC1, +5));
        
        posReplyB3.addChoice(new DialogueChoice("Anyways, what can I get for ya?", posReplyC1, +5));
        posReplyB3.addChoice(new DialogueChoice("Thanks for being so welcoming. What can I get for you?", posReplyC1, +5));
        posReplyB3.addChoice(new DialogueChoice("Hey, I am way out of your league. Stop flirting. What taco do you want?", posReplyC1, +5));
        
        negReplyB4.addChoice(new DialogueChoice("Sorry, what taco would you like?", posReplyC1, +5));
        negReplyB4.addChoice(new DialogueChoice("Sorry I literally suck, what taco would you like?", posReplyC1, -5));
        negReplyB4.addChoice(new DialogueChoice("Damn tough crowd huh?, what taco would you like?", posReplyC1, -10));

        startNode = starterDialogueNode;
        return startNode;
    }
}