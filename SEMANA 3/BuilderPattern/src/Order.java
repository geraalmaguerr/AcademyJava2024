import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Pizza> pizzas;

    public Order() {
        this.pizzas = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            double price = 10.00; // Base price for any pizza
            List<String> toppings = pizza.getToppings();
            price += (toppings != null) ? toppings.size() * 1.50 : 0;
            total += price;
        }
        return total;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }
}
