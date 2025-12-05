import java.util.Stack;

public class Taco{
    private Stack<String> tacoBuild = new Stack<>();
    private int meatCount;
    private int vegCount;
    private int spiceCount;
    private int sauceCount;

    public Taco(){}

    public void addIngredient(String name) {
        if (tacoBuild.size() > 10){
            System.out.println("Taco is too big to add more ingredients! Remove some to add more");
        } else {
        tacoBuild.push(name);
        incrementCount(name);
        }
    }

    private void incrementCount(String ingredient) {
    if (ingredient.equalsIgnoreCase("meat")) {
        meatCount++;
    } else if (ingredient.equalsIgnoreCase("vegetable")) {
        vegCount++;
    } else if (ingredient.equalsIgnoreCase("spice")) {
        spiceCount++;
    } else if (ingredient.equalsIgnoreCase("sauce")) {
        sauceCount++;
    }
}
    public int size() {
        return tacoBuild.size();
    }

    public String undoIngredient() {
        if (!tacoBuild.isEmpty()) {
            return tacoBuild.pop();
        }
        return null;
    }

    public Stack<String> getTacoStack(){
        return tacoBuild;
    }

    public int rateTaco(Taco desiredTaco){
        Stack<String> desiredStack = (Stack<String>) desiredTaco.getTacoStack().clone();
        Stack<String> userStack = (Stack<String>) this.getTacoStack().clone();
        int score = 0;

        int meatDiff = Math.abs(desiredTaco.meatCount - this.meatCount);
        int vegDiff = Math.abs(desiredTaco.vegCount - this.vegCount);
        int spiceDiff = Math.abs(desiredTaco.spiceCount - this.spiceCount);
        int sauceDiff = Math.abs(desiredTaco.sauceCount - this.sauceCount);
        
        score = score + (40 - (meatDiff+vegDiff+spiceDiff+sauceDiff));

        while (!desiredStack.isEmpty() && !userStack.isEmpty()){
            if (desiredStack.pop().equalsIgnoreCase(userStack.pop())){
                score = score + 6;
            }
        }
        return score;
    }
     
}