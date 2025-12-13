public class DialogueChoice {

    private String choiceText;
    private DialogueNode nextNode;
    private int tipImpact;

    public DialogueChoice(String choiceText, DialogueNode nextNode, int tipImpact) {
        this.choiceText = choiceText;
        this.nextNode = nextNode;
        this.tipImpact = tipImpact;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public DialogueNode getNextNode() {
        return nextNode;
    }
    
    public int getTipImpact() {
        return tipImpact;
    }
}

