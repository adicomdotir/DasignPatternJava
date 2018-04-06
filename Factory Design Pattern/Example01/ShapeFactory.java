public class ShapeFactory {
    public static IShape factory(String nameId) {
        switch (nameId) {
            case "Circle" : return new Circle();
            case "Rectangle" : return new Rectangle();
        }
        return null;
    }
}