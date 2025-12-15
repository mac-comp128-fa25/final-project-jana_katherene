import java.util.Scanner;
import java.util.Stack;

public class TacoManager{

    public TacoManager(){};

    public Taco buildTaco(){
        Taco userTaco = new Taco();
        System.out.println("To add an ingredient to your taco, type it in. Remember, you can add spice, meat, veg, or sauce. Type start to start, and stop whenever you are done adding ingredients");
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
        
        System.out.println("Alright, your taco is done. ");
        System.out.println(userTaco.getTacoStack().toString());
        return userTaco;
        
        
    }
}