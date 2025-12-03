import java.util.Stack;

public class Taco{
    private Stack<Ingredient> tacoBuild = new Stack<>();

    public Taco(){}

    public void addIngredient(String name) {
        tacoBuild.push(new Ingredient(name));
    }

    public void undoLastStep() {
        if (!tacoBuild.isEmpty()) {
            tacoBuild.pop();
        }
    }

    public Stack<Ingredient> getTacoStack(){
        return tacoBuild;
    }
    

    
}