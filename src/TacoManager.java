import java.util.Scanner;
import java.util.Stack;

public class TacoManager{
    int meatcount;
    int vegcount;
    int spicecount;
    int saucecount;
    int trashcount;

    public TacoManager(){};


    public void buildTaco(){
        Taco userTaco = new Taco();
        System.out.println("To add an ingredient to your taco, type it in. Remember, you can add spice, meat, veg, or sauce. Type start to start, and stop whenever you are done adding ingredients");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        while (!word.equalsIgnoreCase("stop")){
            if (word.equalsIgnoreCase("undo")) {
                String removed = userTaco.undoLastStep();
                if (removed != null){
                    removeFromCount(removed);
                } else {
                    System.out.println("nothing to undo");
                }
            } else {
            userTaco.addIngredient(word);
            addToCount(word);
            }
            word = scanner.nextLine();
        }

        System.out.println("Alright, your taco is done. ");
        System.out.println("WOW! that is alot of " + highestIngredient());
        System.out.println(userTaco.getTacoStack().toString());
        
    }

    public void addToCount(String word){
        if (word.equalsIgnoreCase("meat")) {
                meatcount++;
        }
        else if (word.equalsIgnoreCase("vegetable")) {
                vegcount++;
        }
        else if (word.equalsIgnoreCase("spice")) {
                spicecount++;
        }
        else if (word.equalsIgnoreCase("sauce")) {
                saucecount++;
        }
        else {
            trashcount++;
        }
        System.out.println("Added " + word);
    }

    public void removeFromCount(String word){
        if (word.equalsIgnoreCase("meat")) {
                meatcount--;
        }
        else if (word.equalsIgnoreCase("vegetable")) {
                vegcount--;
        }
        else if (word.equalsIgnoreCase("spice")) {
                spicecount--;
        }
        else if (word.equalsIgnoreCase("sauce")) {
                saucecount--;
        }
        else {
            trashcount--;
        }
        System.out.println("Removed " + word);
    }

    public String highestIngredient(){
        int max = Math.max(Math.max(Math.max(meatcount, vegcount), spicecount),
                       Math.max(saucecount, trashcount));

        if (max == 0) return "nothing";
        if (max == meatcount) return "meat";
        if (max == vegcount) return "vegetable";
        if (max == spicecount) return "spice";
        if (max == saucecount) return "sauce";
        if (max == trashcount) return "random trash";

        return "everything";
    }

    public void rateTaco(Taco desiredTaco, Taco madeTaco){
        Stack desiredStack = desiredTaco.getTacoStack();
        Stack madeStack = madeTaco.getTacoStack();
        
        // rating by popping each one and comparing if the same. 
        // if the same, then add a point
    }
}