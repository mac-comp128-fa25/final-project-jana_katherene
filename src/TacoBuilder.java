import java.util.Scanner;

public class TacoBuilder{
    int meatcount;
    int vegcount;
    int spicecount;
    int saucecount;
    int trashcount;

    public TacoBuilder(){};


    public void buildTaco(){
        Taco userTaco = new Taco();
        System.out.println("To add an ingredient to your taco, type it in. Remember, you can add spice, meat, veg, or sauce. Type start to start, and stop whenever you are done adding ingredients");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        while (!word.equalsIgnoreCase("stop")){
            if (word.equalsIgnoreCase("undo")) {
                userTaco.undoLastStep();
                removeFromCount(word);
                System.out.println("Last ingredient removed.");
            } else {
            userTaco.addIngredient(word);
            System.out.println(word + " added.");
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
        if (word.equalsIgnoreCase("vegetable")) {
                vegcount++;
        }
        if (word.equalsIgnoreCase("spice")) {
                spicecount++;
        }
        if (word.equalsIgnoreCase("sauce")) {
                saucecount++;
        }
        else {
            trashcount++;
        }
    }

    public void removeFromCount(String word){
        if (word.equalsIgnoreCase("meat")) {
                meatcount--;
        }
        if (word.equalsIgnoreCase("vegetable")) {
                vegcount--;
        }
        if (word.equalsIgnoreCase("spice")) {
                spicecount--;
        }
        if (word.equalsIgnoreCase("sauce")) {
                saucecount--;
        }
        else {
            trashcount--;
        }
    }

    public String highestIngredient(){
        if ((meatcount> vegcount && meatcount> spicecount) && (meatcount> saucecount && meatcount> trashcount)){
            return "meat";
        }
        if ((vegcount> meatcount && vegcount> spicecount) && (vegcount> saucecount && vegcount> trashcount)){
            return "vegetable";
        }
        if ((saucecount> vegcount && saucecount> spicecount) && (saucecount> meatcount && saucecount> trashcount)){
            return "sauce";
        }
        if ((spicecount> vegcount && spicecount> meatcount) && (spicecount> saucecount && spicecount> trashcount)){
            return "spice";
        }
        if ((trashcount> vegcount && trashcount> meatcount) && (trashcount> saucecount && trashcount> spicecount)){
            return "random trash";
        }
        else{
            return "everything";
        }
    }
}