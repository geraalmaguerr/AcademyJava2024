public class CoffeeOrder {
    public static void main(String[] args) {
        // Create a simple Black Coffee
        Coffee coffee = new BlackCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        // Decorate it with Milk
        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        // Decorate it with Sugar
        coffee = new Sugar(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        // Create a Latte with Milk and Vanilla Shot
        Coffee latte = new Latte();
        latte = new Milk(latte);
        latte = new VanillaShot(latte);
        System.out.println(latte.getDescription() + " $" + latte.cost());
    }
}
