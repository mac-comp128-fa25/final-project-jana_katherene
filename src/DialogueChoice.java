public class DialogueChoice {
    private String choiceText;
    private DialogueNode nextNode;

    public DialogueChoice(String choiceText, DialogueNode nextNode) {
        this.choiceText = choiceText;
        this.nextNode = nextNode;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public DialogueNode getNextNode() {
        return nextNode;
    }
}

