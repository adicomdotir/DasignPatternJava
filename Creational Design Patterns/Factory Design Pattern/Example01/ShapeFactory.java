public class ShapeFactory {
    public static Shape factory(String nameId) {
        switch (nameId) {
            case "Circle" : return new Circle();
            case "Rectangle" : return new Rectangle();
        }
        return null;
    }
}