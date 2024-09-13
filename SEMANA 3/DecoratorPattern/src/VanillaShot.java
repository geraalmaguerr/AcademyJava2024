public class VanillaShot extends AddOnDecorator {
    public VanillaShot(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Vanilla Shot";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.80; // Cost of Vanilla Shot added to the existing cost
    }
}
