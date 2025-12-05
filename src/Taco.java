import java.util.Stack;

public class Taco{
    private Stack<String> tacoBuild = new Stack<>();

    public Taco(){}

    public void addIngredient(String name) {
        if (tacoBuild.size() > 10){
            System.out.println("Taco is too big to add more ingredients! Remove some to add more");
        } else {
        tacoBuild.push(name);
        }
    }

    public String undoLastStep() {
        if (!tacoBuild.isEmpty()) {
            return tacoBuild.pop();
        }
        return null;
    }

    public Stack<String> getTacoStack(){
        return tacoBuild;
    }

    public int rateTaco(Taco desiredTaco){
        Stack desiredStack = desiredTaco.getTacoStack();
        Stack madeStack = this.getTacoStack();
        return 0;
        // rating by popping each one and comparing if the same. 
        // if the same, then add a point
    }
    

    
}