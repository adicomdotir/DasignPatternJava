public class Triangle extends Shape {
	private float base;
	private float height;
	private float side1;
	private float side2;
	
	public Triangle() {
		this(1, 1, 1, 1);
	}
	
	public Triangle(float b, float h, float s1, float s2) {
		this.base = b;
		this.height = h;
		this.side1 = s1;
		this.side2 = s2;
	}
	
	public void setBase(float b) { this.base = b; }
	public float getBase() { return base; }
	public void setSide1(float s) { this.side1 = s; }
	public float getSide1() { return side1; }
	public void setSide2(float s) { this.side2 = s; }
	public float getSide2() { return side2; }
	public void setHeight(float h) { this.height = h; }
	public float getHeight() { return height; }
	
	@Override
	public float getArea() {
		return (height * base) / 2;
	}
	
	@Override
	public float getPerimeter() {
		return base + side1 + side2;
	}
	
	@Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Triangle)) {
            return false;
        }
        Triangle t = (Triangle) o;
        return base == t.base && height == t.height && side1 == t.side1 && side2 == t.side2;
    }
}