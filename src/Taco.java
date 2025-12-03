import java.util.Stack;

public class Taco{
    private Stack<String> tacoBuild = new Stack<>();

    public Taco(){}

    public void addIngredient(String name) {
        tacoBuild.push(name);
    }

    public void undoLastStep() {
        if (!tacoBuild.isEmpty()) {
            tacoBuild.pop();
        }
    }

    public Stack<String> getTacoStack(){
        return tacoBuild;
    }
    

    
}