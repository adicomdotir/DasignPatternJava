public class Square extends Shape {
	private float side;
	
	public Square() {
		this(1);
	}
	
	public Square(float s) {
		this.side = s;
	}
	
	public void setSide(float s) { this.side = s; }
	public float getSide() { return side; }
	
	@Override
	public float getArea() {
		return side * side;
	}
	
	@Override
	public float getPerimeter() {
		return side * 4;
	}
	
	@Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Square)) {
            return false;
        }
        Square s = (Square) o;
        return side == s.side;
    }
}