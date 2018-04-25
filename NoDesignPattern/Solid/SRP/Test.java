public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {
            new Circle(2), new Square(5), new Square(6)
        };
        new SumCalculatorOutputter(new AreaCalculator(shapes)).simpleOutput();
    }
}
