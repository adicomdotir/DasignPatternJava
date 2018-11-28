public class Product {
    private String name;
    private String screen;
    private String os;

    public void setName(String name) { this.name = name; }
    public void setScreen(String screen) { this.screen = screen; }
    public void setOs(String os) { this.os = os; }

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return screen + "/" + os + "/" + name;
    }
}

interface IBuilder {
    void buildScreen();
    void buildOS();
}

class ConcreteBuilder1 implements IBuilder {
    public Product p;

    public ConcreteBuilder1() {
        p = new Product("Android Cell Phone");
    }

    public void buildScreen() {
        p.setScreen("Touch Screen 16 Inch!");
    }

    public void buildOS() {
        p.setOs("Android 4.4");
    }
    
    public Product getProduct() { return p; }
}

class ConcreteBuilder2 implements IBuilder {
    public Product p;

    public ConcreteBuilder2() {
        p = new Product("Windows Phone");
    }

    public void buildScreen() {
        p.setScreen("Touch Screen 32 Inch!");
    }

    public void buildOS() {
        p.setOs("Windows Phone 2014");
    }
    
    public Product getProduct() { return p; }
}

class Director {
    public void construct(IBuilder builder) {
        builder.buildScreen();
        builder.buildOS();
    }
}