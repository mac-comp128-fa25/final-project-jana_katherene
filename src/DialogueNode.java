import java.util.ArrayList;
import java.util.List;
//character script/speech

public class DialogueNode {
    private String speakerText;  
    private List<DialogueChoice> choices; 
    public boolean tacoTrigger;
     
    
    public DialogueNode(String speakerText, boolean tacoTrigger) {
        this.tacoTrigger = tacoTrigger;
        this.speakerText = speakerText;
        this.choices = new ArrayList<>();
    }

    public DialogueNode(String speakerText) {
        this.tacoTrigger = false;
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

}

