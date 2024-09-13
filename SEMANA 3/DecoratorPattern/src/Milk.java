public class Milk extends AddOnDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return 0.50 + coffee.cost(); // Cost of Milk
    }
}
