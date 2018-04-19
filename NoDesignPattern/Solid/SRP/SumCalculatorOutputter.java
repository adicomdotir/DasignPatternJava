public class SumCalculatorOutputter {
    protected AreaCalculator calculator;

    public SumCalculatorOutputter(AreaCalculator calculator) {
        this.calculator = calculator;
    }

    public void simpleOutput() {
        for (Shape sh : calculator.shapes) {
            System.out.println("Sum of the areas of provided shapes: " + calculator.sum(sh));
        }
    }

    public void complexOutput() {
    }
}
