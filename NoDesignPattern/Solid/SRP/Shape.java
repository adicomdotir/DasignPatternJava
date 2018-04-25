public interface Shape {}

class Circle implements Shape {
    public float radius;
    public Circle(float radius) {
        this.radius = radius;
    }
}

class Square implements Shape {
    public int length;
    public Square(int length) {
        this.length = length;
    }
}
