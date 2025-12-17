import java.util.Scanner;

public class TacoManager{
    public TacoManager(){};

    /**
     * Interactively builds a taco based on user input. Users may add ingredients, undo the last addition, or stop when finished.
     *
     * @return the completed user-built Taco
     */
    public Taco buildTaco(){
        Taco userTaco = new Taco();
        System.out.println("To add an ingredient to your taco, type it in. \n Remember, you can add 10 ingredients: spice, meat, veg, or sauce. Type stop whenever you are ready to serve. ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        while (!word.equalsIgnoreCase("stop")){
            if (word.equalsIgnoreCase("undo")) {
                String removed = userTaco.undoIngredient();
                if (removed == null){
                    System.out.println("nothing to undo");
                }
            } else {
            userTaco.addIngredient(word);
            }
            word = scanner.nextLine();
        }
        return userTaco;
    }
}