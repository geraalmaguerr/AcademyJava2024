public class BlackCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Black Coffee";
    }

    @Override
    public double cost() {
        return 2.00; // Base price for Black Coffee
    }
}