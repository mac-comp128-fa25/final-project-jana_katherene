public class DialogueTreeManager{

    private DialogueNode startNode;
    public DialogueTreeManager(){
        sampleTree();
    }
    
    private void sampleTree(){
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
    }

    //running dialogue method
    //manage ending? stop when no choices left
    //move to next node based on choice (manage list index vs choice id)
}