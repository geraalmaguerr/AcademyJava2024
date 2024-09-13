import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaBuilderTest {

    @Test
    public void testBuildPizzaWithAllOptions() {
        Pizza pizza = new Pizza.PizzaBuilder("Large")
                .setCrust("Thin")
                .setSauce("Tomato")
                .setCheese("Mozzarella")
                .setToppings(Arrays.asList("Pepperoni", "Mushrooms", "Onions"))
                .build();

        // Print pizza details
        System.out.println("Pizza with All Options: " + pizza.getSize() + " Pizza with " + pizza.getCrust() +
                " crust, " + pizza.getSauce() + " sauce, " + pizza.getCheese() +
                " cheese, Toppings: " + pizza.getToppings());

        // Verify pizza properties
        assertEquals("Large", pizza.getSize());
        assertEquals("Thin", pizza.getCrust());
        assertEquals("Tomato", pizza.getSauce());
        assertEquals("Mozzarella", pizza.getCheese());
        assertEquals(Arrays.asList("Pepperoni", "Mushrooms", "Onions"), pizza.getToppings());
    }

    @Test
    public void testBuildPizzaWithMinimalOptions() {
        Pizza pizza = new Pizza.PizzaBuilder("Small")
                .setCrust("Regular")
                .build();

        // Print pizza details
        System.out.println("Minimal Options Pizza: " + pizza.getSize() + " Pizza with " + pizza.getCrust() +
                " crust, No sauce, No cheese, No toppings.");

        // Verify pizza properties
        assertEquals("Small", pizza.getSize());
        assertEquals("Regular", pizza.getCrust());
        assertNull(pizza.getSauce()); // No sauce set
        assertNull(pizza.getCheese()); // No cheese set
        assertEquals(0, pizza.getToppings().size()); // No toppings set
    }

    @Test
    public void testBuildPizzaWithNoToppings() {
        Pizza pizza = new Pizza.PizzaBuilder("Medium")
                .setCrust("Thick")
                .setSauce("Pesto")
                .setCheese("Cheddar")
                .build();

        // Print pizza details
        System.out.println("Pizza with No Toppings: " + pizza.getSize() + " Pizza with " + pizza.getCrust() +
                " crust, " + pizza.getSauce() + " sauce, " + pizza.getCheese() +
                " cheese, No toppings.");

        // Verify pizza properties
        assertEquals("Medium", pizza.getSize());
        assertEquals("Thick", pizza.getCrust());
        assertEquals("Pesto", pizza.getSauce());
        assertEquals("Cheddar", pizza.getCheese());
        assertEquals(0, pizza.getToppings().size()); // No toppings set
    }

    @Test
    public void testOrderTotalPriceCalculation() {
        Pizza pizza1 = new Pizza.PizzaBuilder("Medium")
                .setCrust("Regular")
                .setCheese("Cheddar")
                .setToppings(Arrays.asList("Onions", "Mushrooms")) // 2 toppings
                .build();

        Pizza pizza2 = new Pizza.PizzaBuilder("Large")
                .setCrust("Thick")
                .setSauce("Pesto")
                .setToppings(Arrays.asList("Pepperoni", "Sausage")) // 2 toppings
                .build();

        // Print order details
        System.out.println("Order Summary:");
        System.out.println("Pizza 1: " + pizza1.getSize() + " Pizza with " + pizza1.getCrust() +
                " crust, " + pizza1.getCheese() + " cheese, Toppings: " + pizza1.getToppings());
        
        System.out.println("Pizza 2: " + pizza2.getSize() + " Pizza with " + pizza2.getCrust() +
                " crust, " + pizza2.getCheese() + " cheese, Toppings: " + pizza2.getToppings());

        Order order = new Order();
        order.addPizza(pizza1);
        order.addPizza(pizza2);

        // Calculate total price: (10 + 2*1.5) + (10 + 2*1.5) = 13 + 13 = 26
        assertEquals(26.00, order.calculateTotalPrice(), 0.01); // Updated expected total
    }

    @Test
    public void testOrderWithSinglePizza() {
        Pizza pizza = new Pizza.PizzaBuilder("Large")
                .setCrust("Thin")
                .setCheese("Mozzarella")
                .build();

        Order order = new Order();
        order.addPizza(pizza);

        // Print order details
        System.out.println("Order Summary:");
        System.out.println("Pizza: " + pizza.getSize() + " Pizza with " + pizza.getCrust() +
                " crust, Cheese: " + pizza.getCheese() + ", No Sauce or Toppings.");

        // Calculate total price for a single pizza with no toppings
        assertEquals(10.00, order.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testEmptyOrder() {
        Order order = new Order();

        // No pizzas added, total price should be 0
        double totalPrice = order.calculateTotalPrice();

        assertEquals(0.00, totalPrice, 0.01);
    }
}
