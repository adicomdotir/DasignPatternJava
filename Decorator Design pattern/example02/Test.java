public class Test {
    public static void main(String[] args) {
        Shape sh01 = new Circle();
        sh01.draw();
        sh01 = new RedShapeDecorator(new Circle());
        sh01.draw();
        sh01 = new RedShapeDecorator(new Rectangle());
        sh01.draw();
    }
}