import javax.swing.*;
 
public class RSATM {   
	public static void main(String[] args) {
		Shape[] shapes = {
			new Rectangle(3,2),
			new Square(3),
			new Circle(3),
			new Triangle(2,3,4,5)
		};
		for(Shape s : shapes) {
			System.out.println("" + s);
		}
	}  
}
