import java.util.ArrayList;
import java.util.List;
//character script/speech

public class DialogueNode {
    private String speakerText;  
    private List<DialogueChoice> choices; 
    public boolean end;
     
    public DialogueNode(String speakerText, boolean end) {
        this.speakerText = speakerText;
        this.end = end;
        this.choices = new ArrayList<>();
    }

    public DialogueNode(String speakerText) {
        this.speakerText = speakerText;
        this.end = false;
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

