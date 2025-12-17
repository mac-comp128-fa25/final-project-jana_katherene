import java.util.ArrayList;
import java.util.List;

public class DialogueNode {    
    private String speakerText;  
    private List<DialogueChoice> choices; 
    public boolean endEarly;
    
    /**
     * Constructs a DialogueNode object representing the customer's dialogue 
     * and a node in the DialogueTree 
     * @param speakerText String of customer's speech
     * @param endEarly Boolean representing whether the tree ends early
     */
    public DialogueNode(String speakerText, boolean endEarly) {
        this.speakerText = speakerText;
        this.endEarly = endEarly;
        this.choices = new ArrayList<>();
    }

    /**
     * Constructs a DialogueNode object representing the customer's dialogue 
     * and a node in the DialogueTree 
     * @param speakerText String of customer's speech
     */
    public DialogueNode(String speakerText) {
        this.speakerText = speakerText;
        this.endEarly = false;
        this.choices = new ArrayList<>();
    }
    /** 
     * Getter method for the customer's speech
     */
    public String getText() {
        return speakerText;
    }

    /**
     * Getter method for the dialogue choices a given node has
     */
    public List<DialogueChoice> getChoices() {
        return choices;
    }

    /**
     * Adds a choice to the list of dialogue choices a node has
     */
    public void addChoice(DialogueChoice choice) {
        this.choices.add(choice);
    }

}

