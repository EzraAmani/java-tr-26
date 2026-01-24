package assessments.assessment2.Question3.PartB;

public class Main {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        ScientificCalculator sciCalc = new ScientificCalculator();

        // Overloading because we see same method name, different parameters
        System.out.println(calc.add(2, 3));
        System.out.println(calc.add(2.5, 3.5));
        System.out.println(calc.add(1, 2, 3));

        // Overriding as here we see the child version is called
        System.out.println(sciCalc.add(5, 10));

        // The new methods from ScientificCalculator
        System.out.println("Power: " + sciCalc.power(2, 3));
        System.out.println("Square Root: " + sciCalc.sqrt(16));
    }
}
