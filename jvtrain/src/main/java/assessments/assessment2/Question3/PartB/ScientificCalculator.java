package assessments.assessment2.Question3.PartB;

public class ScientificCalculator extends Calculator {

    // Method OVERRIDING
    @Override
    public int add(int a, int b) {
        System.out.println("ScientificCalculator: Adding two integers");
        return super.add(a, b); // call parent version
    }

    // New scientific methods
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double sqrt(double num) {
        return Math.sqrt(num);
    }
}
