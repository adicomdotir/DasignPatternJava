public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        customMethod();
    }

    public void customMethod() {
        System.out.println("Border color : Red");
    }
}