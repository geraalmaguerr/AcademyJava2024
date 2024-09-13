import java.util.*;
import java.util.stream.Collectors;

class Order {
    String customerName;
    List<String> products;
    double totalValue;
    boolean isDelivered;

    Order(String customerName, List<String> products, double totalValue, boolean isDelivered) {
        this.customerName = customerName;
        this.products = products;
        this.totalValue = totalValue;
        this.isDelivered = isDelivered;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<String> getProducts() {
        return products;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public boolean isDelivered() {
        return isDelivered;
    }
}