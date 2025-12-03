import java.util.Scanner;

public class TacoBuilder{
    
    public TacoBuilder(){};

    public void buildTaco(){
        Taco userTaco = new Taco();
        System.out.println("To add an ingredient to your taco, type it in. Remember, you can add spice, meat, veg, or sauce. Type start to start, and stop whenever you are done adding ingredients");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        while (!word.equalsIgnoreCase("stop")){
            userTaco.addIngredient(word);
            word = scanner.nextLine();
        }
        System.out.println("Alright, your taco is done. ");
        //System.out.println(userTaco.getTacoStack().toString());
        // need to decide if i want to replace the ingredient wrapper class and just do strings instead
        
    }
}