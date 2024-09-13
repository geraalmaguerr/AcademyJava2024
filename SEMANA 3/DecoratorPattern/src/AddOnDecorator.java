public abstract class AddOnDecorator implements Coffee {
    protected Coffee coffee; // The coffee being decorated

    public AddOnDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
