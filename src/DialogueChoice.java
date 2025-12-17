public class DialogueChoice {
    private String choiceText;
    private DialogueNode nextNode;
    private int tipImpact;

    /**
     * Constructs a DialogueChoice object representing an option offered to the user
     * as dialogue
     * @param choiceText String of the choice text
     * @param nextNode Customer response prompted by the choice
     * @param tipImpact positive or negative integer value representing tip impact of choice
     */
    public DialogueChoice(String choiceText, DialogueNode nextNode, int tipImpact) {
        this.choiceText = choiceText;
        this.nextNode = nextNode;
        this.tipImpact = tipImpact;
    }

    /**
     * Getter method for choice text
     */
    public String getChoiceText() {
        return choiceText;
    }

    /**
     * Getter method for next node
     */
    public DialogueNode getNextNode() {
        return nextNode;
    }
    
    /**
     * Getter method for tip impact
     */
    public int getTipImpact() {
        return tipImpact;
    }
}

