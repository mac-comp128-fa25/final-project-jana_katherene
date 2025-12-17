import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerName {
    public List<String> possibleNames;
    private Random rand;

    /**
     * Creates a bank of possible customer names as an ArrayList
     */
    public CustomerName() {
        rand = new Random();
        possibleNames = new ArrayList<>();
        possibleNames.add("Cheryl");
        possibleNames.add("Ezra");
        possibleNames.add("Kaia");
        possibleNames.add("Daryl");
        possibleNames.add("Jose");
        possibleNames.add("Valeria");
        possibleNames.add("Hank");
        possibleNames.add("Betsy");
        possibleNames.add("Jarvis");
    }

    /**
     * Finds and returns a random name from the possibleNames ArrayList
     * @return randomly generated customer name as String
     */
    public String getRandomName(){
        return possibleNames.get(rand.nextInt(possibleNames.size()));
    }
}
