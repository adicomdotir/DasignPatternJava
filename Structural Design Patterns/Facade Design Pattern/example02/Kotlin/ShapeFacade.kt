public class ShapeFacade {
    private val square: Square = Square()
    private val rectangle: Rectangle = Rectangle()

    fun drawSquare() {
        square.draw()
    }

    fun drawRectangle() {
        rectangle.draw()
    }
}