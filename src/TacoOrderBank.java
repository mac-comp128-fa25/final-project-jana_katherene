import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TacoOrderBank {
    
    private List<Taco> possibleOrders;
    private Random rand;

    /**
     * Constructs a TacoorderBank object which contains a list of orders
     * 
     */
    public TacoOrderBank() {
        possibleOrders = new ArrayList<>();
        rand = new Random();
        loadOrders();
    }

    /**
     * Creates a list of Taco objects available to order
     */
    private void loadOrders() {
        Taco meatLovers = new Taco();
        meatLovers.addIngredient("meat");
        meatLovers.addIngredient("meat");
        meatLovers.addIngredient("meat");
        meatLovers.addIngredient("meat");
        meatLovers.addIngredient("meat");
        meatLovers.addIngredient("meat");
        meatLovers.addIngredient("sauce");
        meatLovers.addIngredient("sauce");
        meatLovers.addIngredient("spice");
        meatLovers.addIngredient("spice");

        Taco veggie = new Taco();
        veggie.addIngredient("vegetable");
        veggie.addIngredient("vegetable");
        veggie.addIngredient("vegetable");
        veggie.addIngredient("vegetable");
        veggie.addIngredient("vegetable");
        veggie.addIngredient("vegetable");
        veggie.addIngredient("sauce");
        veggie.addIngredient("sauce");
        veggie.addIngredient("spice");
        veggie.addIngredient("spice");

        Taco spicy = new Taco();
        spicy.addIngredient("meat");
        spicy.addIngredient("meat");
        spicy.addIngredient("meat");
        spicy.addIngredient("vegetable");
        spicy.addIngredient("vegetable");
        spicy.addIngredient("vegetable");
        spicy.addIngredient("spice");
        spicy.addIngredient("spice");
        spicy.addIngredient("spice");
        spicy.addIngredient("spice");

        possibleOrders.add(meatLovers);
        possibleOrders.add(veggie);
        possibleOrders.add(spicy);
    }

    /**
     * Returns a randomly chosen taco order from the list available
     * @return Taco to be ordered by customer
     */
    public Taco getRandomOrder() {
        return cloneTaco(possibleOrders.get(rand.nextInt(possibleOrders.size())));
    }

    /**
     * Creates and returns a defensive copy of the taco to be ordered. Used for rating.
     * @param original Taco to be copied
     * @return copied taco 
     */
    private Taco cloneTaco(Taco original) {
        Taco copy = new Taco();
        for (String ingredient : original.getTacoStack()) {
            copy.addIngredient(ingredient);
        }
        return copy;
    }
}
