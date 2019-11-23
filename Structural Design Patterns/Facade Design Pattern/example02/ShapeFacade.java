public class ShapeFacade {
	private Square square;
	private Rectangle rectangle;

	public ShapeFacade() {
		square = new Square();
		rectangle = new Rectangle();
	}

	public void drawSquare() {
		square.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}
}