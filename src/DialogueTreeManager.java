import java.util.Scanner;

public class DialogueTreeManager{

    private DialogueNode startNode;
    private DialogueNode endNode;
    public DialogueTreeManager(){
        sampleTree();
    }
    
    public void sampleTree(){
        DialogueNode starterDialogueNode = new DialogueNode("Customer: hello", 1);
        DialogueNode niceReply = new DialogueNode("Thanks! I'd love to order some tacos!",2);
        DialogueNode midReply = new DialogueNode("Um, some tacos?", 3);
        DialogueNode rudeReply = new DialogueNode("Excuse me? I'm just trying to order some tacos!", 4);
        DialogueNode ending = new DialogueNode("Stop", 5);

        starterDialogueNode.addChoice(new DialogueChoice("Hello, I hope your day has been great so far! How may I help you?", niceReply));
        starterDialogueNode.addChoice(new DialogueChoice("What do you want?", midReply));
        starterDialogueNode.addChoice(new DialogueChoice("F@ck you", rudeReply));

        niceReply.addChoice(new DialogueChoice("pause", ending));
        midReply.addChoice(new DialogueChoice("pause", ending));
        rudeReply.addChoice(new DialogueChoice("pause", ending));

        startNode = starterDialogueNode;
        endNode = ending;
    }

    public void runSampleDialogue(){
        Scanner scanner = new Scanner(System.in);
        //start with starter node
        DialogueNode current = startNode;

        //loop until no nodes left
        while(!current.equals(endNode)){
            //prin the current node
            System.out.println(current.getText());

            //check if current node is endNode and stop if yes
            if(current.getChoices().isEmpty()){
                System.out.println("dialogue done");
                break;
            }

            //print choices of current node
            for(int i = 0; i<current.getChoices().size(); i++){
                System.out.println(current.getChoices().get(i).getChoiceText());
            }

            //move to next node based on choice
            //choice is equal to chosen int on list
            //current will be updated to the next node after choice is made
            int number = scanner.nextInt();
            DialogueChoice choice = current.getChoices().get(number - 1);
            current = choice.getNextNode();

        }
    }

    //running dialogue method
    //manage ending? stop when no choices left
    //move to next node based on choice (manage list index vs choice id)
}