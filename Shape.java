public abstract class Shape {
	public abstract float getArea();
	public abstract float getPerimeter();
	
	@Override
	public String toString() {
		return "Area is " + getArea() + " Perimeter is " + getPerimeter();
	}
}