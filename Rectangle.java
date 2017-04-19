public class Rectangle extends Shape {
	
	private float length;
	private float width;
	
	public Rectangle() {
		this(1,1);
	}
	
	public Rectangle(float l, float w) {
		this.length = l;
		this.width = w;
	}
	
	public void setLength(float l) { this.length = l; }
	public void setWidth(float w) { this.width = w; }
	public float getLength() { return length; }
	public float getWidth() { return width; }
	
	@Override
	public float getArea() {
		return length * width;
	}
	
	@Override
	public float getPerimeter() {
		return (length + width) * 2;
	}
	
	@Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Rectangle)) {
            return false;
        }
        Rectangle r = (Rectangle) o;
        return length == r.length && width == r.width;
    }
}