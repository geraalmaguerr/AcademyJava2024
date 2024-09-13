public class Latte implements Coffee {
    @Override
    public String getDescription() {
        return "Latte";
    }

    @Override
    public double cost() {
        return 3.00; // Base price for Latte
    }
}
