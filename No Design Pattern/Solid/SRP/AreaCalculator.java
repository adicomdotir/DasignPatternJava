import java.util.List;

public class AreaCalculator {

    public Shape[] shapes;

    public AreaCalculator(Shape[] shapes) {
        this.shapes = shapes;
    }

    public float sum(Shape sh) {
        if (sh instanceof Circle) {
            Circle c = (Circle) sh;
            return (float) (Math.pow(c.radius, 2) * Math.PI);
        } else {
            Square s = (Square) sh;
            return (float) (Math.pow(s.length, 2));
        }

    }
}
