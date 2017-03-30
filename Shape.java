public abstract class Shape {
	public abstract float getArea();
	public abstract float getPerimeter();
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " Area is " + getArea() + " Perimeter is " + getPerimeter();
	}
}