import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeTest {

    @Test
    public void testBlackCoffeeCost() {
        Coffee coffee = new BlackCoffee();
        assertEquals(2.00, coffee.cost(), 0.01);
        assertEquals("Black Coffee", coffee.getDescription());
    }

    @Test
    public void testLatteCost() {
        Coffee coffee = new Latte();
        assertEquals(3.00, coffee.cost(), 0.01);
        assertEquals("Latte", coffee.getDescription());
    }

    @Test
    public void testBlackCoffeeWithMilkAndSugar() {
        Coffee coffee = new BlackCoffee();
        coffee = new Milk(coffee);
        coffee = new Sugar(coffee);

        assertEquals(2.70, coffee.cost(), 0.01);
        assertEquals("Black Coffee, Milk, Sugar", coffee.getDescription());
    }

    @Test
    public void testLatteWithMilkAndVanillaShot() {
        Coffee coffee = new Latte();
        coffee = new Milk(coffee);
        coffee = new VanillaShot(coffee);

        assertEquals(4.30, coffee.cost(), 0.01);
        assertEquals("Latte, Milk, Vanilla Shot", coffee.getDescription());
    }

    @Test
    public void testBlackCoffeeWithAllAddOns() {
        Coffee coffee = new BlackCoffee();
        coffee = new Milk(coffee);
        coffee = new Sugar(coffee);
        coffee = new VanillaShot(coffee);

        assertEquals(3.50, coffee.cost(), 0.01);
        assertEquals("Black Coffee, Milk, Sugar, Vanilla Shot", coffee.getDescription());
    }

    @Test
    public void testLatteWithAllAddOns() {
        Coffee coffee = new Latte();
        coffee = new Milk(coffee); // Add Milk
        coffee = new Sugar(coffee); // Add Sugar
        coffee = new VanillaShot(coffee); // Add Vanilla Shot

        assertEquals(4.50, coffee.cost(), 0.01);
        assertEquals("Latte, Milk, Sugar, Vanilla Shot", coffee.getDescription());
    }

    @Test
    public void testNoAddOns() {
        Coffee coffee = new BlackCoffee();
        assertEquals(2.00, coffee.cost(), 0.01);
        assertEquals("Black Coffee", coffee.getDescription());

        coffee = new Latte();
        assertEquals(3.00, coffee.cost(), 0.01);
        assertEquals("Latte", coffee.getDescription());
    }

    @Test
    public void testAddOnsOnEmptyCoffee() {
        Coffee coffee = new BlackCoffee();
        coffee = new Milk(coffee);
        assertEquals(2.50, coffee.cost(), 0.01);
        assertEquals("Black Coffee, Milk", coffee.getDescription());

        coffee = new Latte();
        coffee = new Sugar(coffee);
        assertEquals(3.20, coffee.cost(), 0.01);
        assertEquals("Latte, Sugar", coffee.getDescription());
    }

    // New test for adding the same add-on multiple times
    @Test
    public void testBlackCoffeeWithDoubleMilk() {
        Coffee coffee = new BlackCoffee();
        coffee = new Milk(coffee);
        coffee = new Milk(coffee); // Adding Milk again

        assertEquals(3.00, coffee.cost(), 0.01); // 2.00 + 0.50 + 0.50 = 3.00
        assertEquals("Black Coffee, Milk, Milk", coffee.getDescription());
    }

    @Test
    public void testLatteWithDoubleSugar() {
        Coffee coffee = new Latte();
        coffee = new Sugar(coffee);
        coffee = new Sugar(coffee); // Adding Sugar again

        assertEquals(3.40, coffee.cost(), 0.01); // 3.00 + 0.20 + 0.20 = 3.40
        assertEquals("Latte, Sugar, Sugar", coffee.getDescription());
    }

    // Test different combinations of add-ons for Latte
    @Test
    public void testLatteWithMilkAndDoubleSugar() {
        Coffee coffee = new Latte();              // Base cost: 3.00
        coffee = new Milk(coffee);                // Milk cost: +0.50
        coffee = new Sugar(coffee);               // Sugar cost: +0.20
        coffee = new Sugar(coffee);               // Sugar cost: +0.20 (added again)

        assertEquals(3.90, coffee.cost(), 0.01); // Expected total cost: 3.00 + 0.50 + 0.20 + 0.20 = 3.90
        assertEquals("Latte, Milk, Sugar, Sugar", coffee.getDescription());
    }

    @Test
    public void testLatteWithAllAddOnsMultipleTimes() {
        Coffee coffee = new Latte();
        coffee = new Milk(coffee);
        coffee = new Sugar(coffee);
        coffee = new VanillaShot(coffee);
        coffee = new Milk(coffee); // Adding Milk again
        coffee = new Sugar(coffee); // Adding Sugar again

        assertEquals(5.20, coffee.cost(), 0.01); // 3.00 + 0.50 + 0.20 + 0.80 + 0.50 + 0.20 = 5.20
        assertEquals("Latte, Milk, Sugar, Vanilla Shot, Milk, Sugar", coffee.getDescription());
    }

    // New test method to print examples
    @Test
    public void printCoffeeExamples() {
        // Example 1: Black Coffee with Milk and Sugar
        Coffee coffee1 = new BlackCoffee();
        coffee1 = new Milk(coffee1);
        coffee1 = new Sugar(coffee1);
        System.out.println("Example 1:");
        System.out.println("Description: " + coffee1.getDescription());
        System.out.println("Cost: $" + coffee1.cost());

        // Example 2: Latte with Milk and Vanilla Shot
        Coffee coffee2 = new Latte();
        coffee2 = new Milk(coffee2);
        coffee2 = new VanillaShot(coffee2);
        System.out.println("Example 2:");
        System.out.println("Description: " + coffee2.getDescription());
        System.out.println("Cost: $" + coffee2.cost());
    }
}
