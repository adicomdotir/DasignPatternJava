public class Triangle extends Shape {
	private float base;
	private float height;
	private float side1;
	private float side2;
	
	public Triangle() {}
	public Triangle(float b, float h, float s1, float s2) {
		this.base = b;
		this.height = h;
		this.side1 = s1;
		this.side2 = s2;
	}
	
	public void setBase(float b) { this.base = b; }
	public float getBase() { return base; }
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
}