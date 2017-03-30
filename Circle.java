public class Circle extends Shape {
	private float raduis;
	
	public Circle(float r) {
		this.raduis = r;
	}
	
	public void setRaduis(float r) { this.raduis = r; }
	public float getRaduis() { return raduis; }
	
	@Override
	public float getArea() {
		return (float) (Math.PI * raduis * raduis);
	}
	
	@Override
	public float getPerimeter() {
		return 0.0f;
	}
}
	