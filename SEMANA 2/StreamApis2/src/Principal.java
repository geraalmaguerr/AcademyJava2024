import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("Alice", Arrays.asList("Laptop", "Mouse"), 1500.0, true),
            new Order("Bob", Arrays.asList("Keyboard", "Monitor"), 400.0, false),
            new Order("Charlie", Arrays.asList("Laptop", "Mouse", "Keyboard"), 1800.0, true),
            new Order("David", Arrays.asList("Monitor"), 300.0, true),
            new Order("Eve", Arrays.asList("Laptop", "Headphones"), 1200.0, false)
        );

        // 1. Filtering out undelivered orders
        List<Order> pendingOrders = orders.stream()
            .filter(order -> !order.isDelivered())
            .collect(Collectors.toList());
        System.out.println("Pending Orders: " + pendingOrders.stream().map(Order::getCustomerName).collect(Collectors.joining(", ")));

        // 2. Calculating the total value of all orders
        double totalOrderValue = orders.stream()
            .mapToDouble(Order::getTotalValue)
            .sum();
        System.out.println("Total Order Value: " + totalOrderValue);

        // 3. Finding the most popular products
        List<String> popularProducts = orders.stream()
            .flatMap(order -> order.getProducts().stream())
            .collect(Collectors.groupingBy(product -> product, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .map(Map.Entry::getKey)
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("Most Popular Products: " + String.join(", ", popularProducts));

        // 4. Categorizing customers by their order value
        Map<String, String> customerCategories = orders.stream()
            .collect(Collectors.toMap(
                Order::getCustomerName,
                order -> {
                    if (order.getTotalValue() > 1500) return "Premium";
                    else if (order.getTotalValue() > 1000) return "Gold";
                    else return "Regular";
                }
            ));
        customerCategories.forEach((customer, category) ->
            System.out.println(customer + " is a " + category + " customer")
        );

        // 5. Checking if all orders are above 300 in value
        boolean allOrdersAbove300 = orders.stream()
            .allMatch(order -> order.getTotalValue() > 300);
        System.out.println("All orders above 300: " + allOrdersAbove300);
    }
}