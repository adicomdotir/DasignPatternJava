import javax.swing.*;
 
public class RSATM {   
	public static void main(String[] args) {
		Shape[] shapes = {
			new Rectangle(),
			new Square(),
			new Circle(),
			new Triangle(2,3,4,5)
		};
		for(Shape s : shapes) {
			System.out.println("" + s);
		}
	}  
}
