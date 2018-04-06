public class Test {
    public static void main(String[] args) {
        IShape shape = ShapeFactory.factory("Circle");
        shape.draw();
        shape = ShapeFactory.factory("Rectangle");
        shape.draw();
    }
}