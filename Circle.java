public class Circle extends Shape {
	private float raduis;
	
	public Circle() {
		this(1);
	}
	
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
		return (float) (Math.PI * raduis * 2);
	}
	
	@Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Circle)) {
            return false;
        }
        Circle c = (Circle) o;
        return raduis == c.raduis;
    }
}
	
