import java.util.Scanner;
import java.util.Stack;

public class DialogueTreeManager{

    private DialogueNode startNode;
    private DialogueNode endNode;
    public DialogueTreeManager(){
        //sampleTree();
    }
    
    // public void sampleTree(){
    //     DialogueNode starterDialogueNode = new DialogueNode("-Customer: hello");
    //     DialogueNode niceReply = new DialogueNode("Thanks! I'd love to order some tacos!");
    //     DialogueNode midReply = new DialogueNode("Um, some tacos?");
    //     DialogueNode rudeReply = new DialogueNode("Excuse me? I'm just trying to order some tacos!");
    //     DialogueNode ending = new DialogueNode("Stop");

    //     starterDialogueNode.addChoice(new DialogueChoice("Hello, I hope your day has been great so far! How may I help you?", niceReply));
    //     starterDialogueNode.addChoice(new DialogueChoice("What do you want?", midReply));
    //     starterDialogueNode.addChoice(new DialogueChoice("F@ck you", rudeReply));

    //     niceReply.addChoice(new DialogueChoice("pause", ending));
    //     midReply.addChoice(new DialogueChoice("pause", ending));
    //     rudeReply.addChoice(new DialogueChoice("pause", ending));

    //     startNode = starterDialogueNode;
    //     endNode = ending;
    // }

    public void runDialogue(DialogueNode startNode, Taco desiredTaco, TacoManager tacoManager){
        Scanner scanner = new Scanner(System.in);
        DialogueNode current = startNode;

        int dialogueTips = 0;

        while(true){
            // print the current node
            System.out.println(current.getText());

            //check if current node is endNode and stop if yes
            if(current.getChoices().isEmpty()){
                System.out.println("dialogue done");
                break;
            }

            //check if current node triggers taco building
            if(current.tacoTrigger){
                System.out.println("Time to build your Taco! Type in your ingredients");
                break;
            }

            // //print choices of current node
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

            current = current.getChoices().get(choice - 1).getNextNode();
        }
        
    }

    public DialogueNode cherylTree(String username){
        // root node 
        String name = "Cheryl";
        Taco desiredTaco = new Taco();
        Stack desiredTacoStack = desiredTaco.getTacoStack();
        
        DialogueNode starterDialogueNode = new DialogueNode(" Customer: Hello");
        
        // first reply responses 
        DialogueNode negReplyA1 = new DialogueNode("My name is " + name + ". Not dear. You won't get far in this town unless you're respectful..");
        DialogueNode negReplyA2 = new DialogueNode("I don't know you... " );
        DialogueNode negReplyA3 = new DialogueNode("Frick you! I will take my taco business elsewhere.", false);
        DialogueNode posReplyA1 = new DialogueNode("Hi! So nice of you to ask, my name is " + name + ".");
        DialogueNode posReplyA2 = new DialogueNode("You're right. It is kinda weird. I like you. My name is " + name);
        
        // first reply choices 
        starterDialogueNode.addChoice(new DialogueChoice("Hello dear customer, What is your name and how may I help you?", negReplyA1, -5));
        starterDialogueNode.addChoice(new DialogueChoice("Hello... What's your name?", posReplyA1, +5));
        starterDialogueNode.addChoice(new DialogueChoice("HAHAHAH... Why are you at a taco stand at 8 am?", negReplyA3, -5));

        // second level DialogueNodes for neg replies 
        DialogueNode negReplyB1 = new DialogueNode("Man. I do not care. I'm leaving.", false);
        DialogueNode negReplyB2 = new DialogueNode("Ummmmmm. Ok. Can I get a" + desiredTaco, true);
        DialogueNode posReplyB1 = new DialogueNode("I would likeeee...." + desiredTaco, true);
        DialogueNode posReplyB2 = new DialogueNode("It's great to meet you " + username + ". Good to see a fresh face around these parts. ");
        DialogueNode negReplyB3 = new DialogueNode("Your name is weird. I would like" + desiredTaco, true);
        DialogueNode posReplyB3 = new DialogueNode("Wow, you're so sweet");
        DialogueNode negReplyB4 = new DialogueNode("I dont like that. ");

        // second level DialogueChoices for neg replies 
        negReplyA1.addChoice(new DialogueChoice("1. I'm sorry... It's my first day... I''m really struggling.. I-", negReplyB1, -5)); // also could be negReplyB2
        negReplyA1.addChoice(new DialogueChoice("Sorry.. What can I get you " + name + "?", posReplyB1, +5));
        negReplyA1.addChoice(new DialogueChoice("What would you like?", posReplyB1, +5));
        posReplyA1.addChoice(new DialogueChoice("My name's " + username + ".", posReplyB2, +5));
        posReplyA2.addChoice(new DialogueChoice("I loooove your hair today by the way. Super diva. ", posReplyB3, +5)); // or negReplyB4
        
        // last level DialogueNode customer speech
        DialogueNode posReplyC1 = new DialogueNode("I would like " + desiredTaco );

        // Third level DialogueChoices
        posReplyB3.addChoice(new DialogueChoice("Anyways, what can i get for ya?", posReplyC1, +5));
        posReplyB2.addChoice(new DialogueChoice("Thanks for being so welcoming. What can I get for you?", posReplyC1, +5));
        posReplyB2.addChoice(new DialogueChoice("Hey, I am way out of your league. Stop flirting. What taco do you want?", posReplyC1, +5));
        
        startNode = starterDialogueNode;
        return startNode;
    }
    
}