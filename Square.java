public class Square extends Shape {
	private float side;
	
	public Square(float s) {
		this.side = s;
	}
	
	@Override
	public float getArea() {
		return side * side;
	}
	
	@Override
	public float getPerimeter() {
		return side * 4;
	}
}