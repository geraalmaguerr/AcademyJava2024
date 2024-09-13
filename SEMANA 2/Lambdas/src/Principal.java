import java.util.function.*;

public class Principal {

    public static void main(String[] args) {
        // Supplier<T> - No arguments, returns a value of type T
        System.out.println("=== Supplier<T> ===");
        Supplier<String> stringSupplier = () -> "Hello, World!";
        System.out.println(stringSupplier.get()); // Output: Hello, World!

        Supplier<Integer> randomSupplier = () -> (int) (Math.random() * 100);
        System.out.println(randomSupplier.get()); // Output: Random number between 0 and 99

        Supplier<Double> piSupplier = () -> Math.PI;
        System.out.println(piSupplier.get()); // Output: 3.141592653589793

        Supplier<Boolean> booleanSupplier = () -> true;
        System.out.println(booleanSupplier.get()); // Output: true

        // Consumer<T> - Takes one argument of type T, returns nothing (void)
        System.out.println("\n=== Consumer<T> ===");
        Consumer<String> stringPrinter = (str) -> System.out.println(str);
        stringPrinter.accept("Hello, Consumer!"); // Output: Hello, Consumer!

        Consumer<Integer> squarePrinter = (num) -> System.out.println(num * num);
        squarePrinter.accept(4); // Output: 16

        Consumer<Double> halfPrinter = (num) -> System.out.println(num / 2);
        halfPrinter.accept(20.0); // Output: 10.0

        Consumer<Boolean> booleanPrinter = (bool) -> System.out.println(bool ? "True!" : "False!");
        booleanPrinter.accept(true); // Output: True!

        // BiConsumer<T,U> - Takes two arguments of types T and U, returns nothing (void)
        System.out.println("\n=== BiConsumer<T,U> ===");
        BiConsumer<String, Integer> repeatedPrinter = (str, times) -> {
            for (int i = 0; i < times; i++) {
                System.out.println(str);
            }
        };
        repeatedPrinter.accept("Repeat", 3); // Output: Repeat Repeat Repeat

        BiConsumer<Integer, Integer> sumPrinter = (a, b) -> System.out.println("Sum: " + (a + b));
        sumPrinter.accept(5, 10); // Output: Sum: 15

        BiConsumer<Double, Double> divisionPrinter = (a, b) -> {
            if (b != 0) {
                System.out.println("Division: " + (a / b));
            } else {
                System.out.println("Cannot divide by zero!");
            }
        };
        divisionPrinter.accept(10.0, 2.0); // Output: Division: 5.0

        BiConsumer<String, String> concatPrinter = (a, b) -> System.out.println(a + b);
        concatPrinter.accept("Hello", " World!"); // Output: Hello World!

        // Predicate<T> - Takes one argument of type T, returns a boolean
        System.out.println("\n=== Predicate<T> ===");
        Predicate<Integer> isEven = (num) -> num % 2 == 0;
        System.out.println(isEven.test(4)); // Output: true

        Predicate<String> isEmpty = (str) -> str.isEmpty();
        System.out.println(isEmpty.test("")); // Output: true

        Predicate<Double> isPositive = (num) -> num > 0;
        System.out.println(isPositive.test(-1.0)); // Output: false

        Predicate<Boolean> isTrue = (bool) -> bool;
        System.out.println(isTrue.test(true)); // Output: true

        // BiPredicate<T,U> - Takes two arguments of types T and U, returns a boolean
        System.out.println("\n=== BiPredicate<T,U> ===");
        BiPredicate<Integer, Integer> areEqual = (a, b) -> a.equals(b);
        System.out.println(areEqual.test(5, 5)); // Output: true

        BiPredicate<String, String> isPrefix = (a, b) -> a.startsWith(b);
        System.out.println(isPrefix.test("Hello", "He")); // Output: true

        BiPredicate<Double, Double> isGreater = (a, b) -> a > b;
        System.out.println(isGreater.test(5.5, 3.3)); // Output: true

        BiPredicate<Integer, Integer> isDivisible = (a, b) -> b != 0 && a % b == 0;
        System.out.println(isDivisible.test(10, 5)); // Output: true

        // Function<T,R> - Takes one argument of type T, returns a value of type R
        System.out.println("\n=== Function<T,R> ===");
        Function<String, Integer> stringLength = (str) -> str.length();
        System.out.println(stringLength.apply("Hello")); // Output: 5

        Function<Integer, Double> half = (num) -> num / 2.0;
        System.out.println(half.apply(10)); // Output: 5.0

        Function<Double, String> doubleToString = (num) -> "Value: " + num;
        System.out.println(doubleToString.apply(5.5)); // Output: Value: 5.5

        Function<Boolean, String> booleanToString = (bool) -> bool ? "True" : "False";
        System.out.println(booleanToString.apply(false)); // Output: False

        // BiFunction<T,U,R> - Takes two arguments of types T and U, returns a value of type R
        System.out.println("\n=== BiFunction<T,U,R> ===");
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(5, 10)); // Output: 15

        BiFunction<String, String, Integer> compareStrings = (a, b) -> a.compareTo(b);
        System.out.println(compareStrings.apply("apple", "banana")); // Output: Negative value (since "apple" < "banana")

        BiFunction<Double, Double, Double> multiply = (a, b) -> a * b;
        System.out.println(multiply.apply(3.0, 4.5)); // Output: 13.5

        BiFunction<Boolean, Boolean, Boolean> and = (a, b) -> a && b;
        System.out.println(and.apply(true, false)); // Output: false

        // UnaryOperator<T> - Takes one argument of type T, returns a value of type T
        System.out.println("\n=== UnaryOperator<T> ===");
        UnaryOperator<Integer> square = (num) -> num * num;
        System.out.println(square.apply(4)); // Output: 16

        UnaryOperator<String> toUpperCase = (str) -> str.toUpperCase();
        System.out.println(toUpperCase.apply("hello")); // Output: HELLO

        UnaryOperator<Double> negate = (num) -> -num;
        System.out.println(negate.apply(5.5)); // Output: -5.5

        UnaryOperator<Boolean> not = (bool) -> !bool;
        System.out.println(not.apply(true)); // Output: false

        // BinaryOperator<T> - Takes two arguments of type T, returns a value of type T
        System.out.println("\n=== BinaryOperator<T> ===");
        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
        System.out.println(max.apply(5, 10)); // Output: 10

        BinaryOperator<String> concat = (a, b) -> a + b;
        System.out.println(concat.apply("Hello", " World!")); // Output: Hello World!

        BinaryOperator<Double> min = (a, b) -> a < b ? a : b;
        System.out.println(min.apply(5.5, 3.3)); // Output: 3.3

        BinaryOperator<Boolean> xor = (a, b) -> a ^ b;
        System.out.println(xor.apply(true, false)); // Output: true
    }
}
