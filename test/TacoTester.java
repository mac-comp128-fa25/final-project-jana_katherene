import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class TacoTester {
    
    /**
     * Tests addIngredient's size bound
     */
    @Test
    void addIngredientTester() {
        Taco taco = new Taco();
        for (int i = 0; i < 11; i++) {
            taco.addIngredient("meat");
        }
        assertEquals(11, taco.size());
    }

    /**
     * Tests undoIngredient's regular and null cases 
     */
    @Test
    void undoIngredientTester() {
        Taco taco = new Taco();

        taco.addIngredient("meat");
        taco.addIngredient("sauce");

        String removed = taco.undoIngredient();

        assertEquals("sauce", removed);
        assertEquals(1, taco.size());

        Taco taco1 = new Taco();
        assertNull(taco1.undoIngredient());
    }

    /**
     * Tests rateTaco by testing when there is a perfect match, same amounts and differing order, partially same order, 
     * different counts, different taco size, all different, and empty taco
     */
    @Test
    void rateTacoTester() {
        // perfect match
        Taco desired1 = new Taco();
        Taco user1 = new Taco();

        desired1.addIngredient("meat");
        desired1.addIngredient("vegetable");
        desired1.addIngredient("spice");

        user1.addIngredient("meat");
        user1.addIngredient("vegetable");
        user1.addIngredient("spice");

        assertEquals(58, user1.rateTaco(desired1));

        // same counts, different order
        Taco desired2 = new Taco();
        Taco user2 = new Taco();

        desired2.addIngredient("meat");
        desired2.addIngredient("vegetable");
        desired2.addIngredient("spice");

        user2.addIngredient("spice");
        user2.addIngredient("vegetable");
        user2.addIngredient("meat");

        assertEquals(46, user2.rateTaco(desired2));

        // partial order match
        Taco desired3 = new Taco();
        Taco user3 = new Taco();

        desired3.addIngredient("meat");
        desired3.addIngredient("vegetable");
        desired3.addIngredient("spice");

        user3.addIngredient("sauce");
        user3.addIngredient("vegetable");
        user3.addIngredient("spice");

        assertEquals(50, user3.rateTaco(desired3));

        // different counts 
        Taco desired4 = new Taco();
        Taco user4 = new Taco();

        desired4.addIngredient("meat");
        desired4.addIngredient("meat");
        desired4.addIngredient("meat");

        user4.addIngredient("meat");

        assertEquals(44, user4.rateTaco(desired4));

        // larger desired taco than user taco
        Taco desired5 = new Taco();
        Taco user5 = new Taco();

        desired5.addIngredient("meat");
        desired5.addIngredient("vegetable");
        desired5.addIngredient("spice");
        desired5.addIngredient("sauce");

        user5.addIngredient("meat");
        user5.addIngredient("vegetable");

        assertEquals(38, user5.rateTaco(desired5));

        // completely different tacos
        Taco desired6 = new Taco();
        Taco user6 = new Taco();

        desired6.addIngredient("meat");
        desired6.addIngredient("meat");
        desired6.addIngredient("meat");
        desired6.addIngredient("meat");

        user6.addIngredient("vegetable");
        user6.addIngredient("vegetable");
        user6.addIngredient("vegetable");
        user6.addIngredient("vegetable");

        assertEquals(32, user6.rateTaco(desired6));

        // empty user taco
        Taco desired7 = new Taco();
        Taco user7 = new Taco();

        desired7.addIngredient("meat");
        desired7.addIngredient("vegetable");

        assertEquals(38, user7.rateTaco(desired7));
    }
}