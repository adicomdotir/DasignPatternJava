public class Test {
    public static void main(String[] args) {
        Shape shape = ShapeFactory.factory("Circle");
        shape.draw();
        shape = ShapeFactory.factory("Rectangle");
        shape.draw();
    }
}