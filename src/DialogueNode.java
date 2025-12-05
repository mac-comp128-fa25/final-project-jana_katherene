import java.util.ArrayList;
import java.util.List;
//character script/speech

public class DialogueNode {
    private int nodeID;
    private String speakerText;  
    private List<DialogueChoice> choices; 
    private boolean triggersTacoBuilding; 
    
    public DialogueNode(String speakerText, int nodeID) {
        this.nodeID = nodeID;
        this.speakerText = speakerText;
        this.choices = new ArrayList<>();
    }

    public String getText() {
        return speakerText;
    }

    public List<DialogueChoice> getChoices() {
        return choices;
    }

    public void addChoice(DialogueChoice choice) {
        this.choices.add(choice);
    }

    // public void tacoTriggered(){
    //     TacoManager tacobuilder = new TacoBuilder();
    //     // tacobuilder.beginTacoBuild();
    // }
}

