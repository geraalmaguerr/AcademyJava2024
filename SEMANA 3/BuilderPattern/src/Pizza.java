import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String size;
    private String crust;
    private String sauce;
    private String cheese;
    private List<String> toppings;

    // Private constructor to enforce the use of the Builder
    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings != null ? builder.toppings : new ArrayList<>();
    }

    // Getters
    public String getSize() {
        return size;
    }

    public String getCrust() {
        return crust;
    }

    public String getSauce() {
        return sauce;
    }

    public String getCheese() {
        return cheese;
    }

    public List<String> getToppings() {
        return toppings;
    }

    // toString() for easy printing of pizza details
    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", crust='" + crust + '\'' +
                ", sauce='" + sauce + '\'' +
                ", cheese='" + cheese + '\'' +
                ", toppings=" + toppings +
                '}';
    }

    // Static Builder class
    public static class PizzaBuilder {
        private String size;
        private String crust;
        private String sauce;
        private String cheese;
        private List<String> toppings;

        public PizzaBuilder(String size) {
            this.size = size;
        }

        public PizzaBuilder setCrust(String crust) {
            this.crust = crust;
            return this;
        }

        public PizzaBuilder setSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder setCheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder setToppings(List<String> toppings) {
            this.toppings = (toppings == null) ? new ArrayList<>() : toppings;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

	public int getBasePrice() {
		// TODO Auto-generated method stub
		return 0;
	}
}
