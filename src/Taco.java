import java.util.Stack;

public class Taco{
    private Stack<String> tacoBuild = new Stack<>();
    private int meatCount;
    private int vegCount;
    private int spiceCount;
    private int sauceCount;
    
    /**
     * Creates an empty taco.
     */
    public Taco(){}

    /**
     * Adds an ingredient to the taco if the size limit is not exceeded.
     * Updates ingredient category counts.
     *
     * @param name the ingredient category to add
     */
    public void addIngredient(String name) {
        if (tacoBuild.size() > 10){
            System.out.println("Taco is too big to add more ingredients! Remove some to add more");
        } else {
        tacoBuild.push(name);
        incrementCount(name);
        }
    }
    
    /**
     * Increments the count for the given ingredient category.
     *
     * @param ingredient the ingredient category
     */
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
    
    /**
     * @return the number of ingredients in the taco
     */
    public int size() {
        return tacoBuild.size();
    }

    /**
     * Determines the taco type based on ingredient counts.
     *
     * @return the taco name, or null if no category dominates
     */
    public String tacoName(){
        if (this.meatCount>=4){
            return "Meat Lover";
        } else if (this.vegCount>=4){
            return "Vegetarian";
        } else if (this.spiceCount>=4){
            return "Spicy";
        } else {
            return null;
        }
    }
    
    /**
     * Removes and returns the most recently added ingredient.
     *
     * @return the removed ingredient, or null if the taco is empty
     */
    public String undoIngredient() {
        if (!tacoBuild.isEmpty()) {
            return tacoBuild.pop();
        }
        return null;
    }
    
    /**
     * Getter method for the internal ingredient stack
     */
    public Stack<String> getTacoStack(){
        return tacoBuild;
    }

    /**
     * Rates this taco against a desired taco using ingredient counts
     * and order similarity.
     *
     * @param desiredTaco the target taco to compare against
     * @return a tip amount 
     */
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