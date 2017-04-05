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

class FlyingDragon extends Entity {
private int Hp;
public FlyingDragon(int x, int y, int Hp){
    super (x, y);
    this.Hp = Hp;
}
public void setHp(int Hp){
    this.Hp = 100;
}

public int getHp(){
   return Hp;}

public void setType(String type) {
 super.setType("Flying Dragon");}
}

    abstract class Entity { 
private int x; // x coordinate in the room
private int y; // y coordinate in the room


 public Entity (int x, int y) {
 this.x=x;
 this.y =y;
}
public void setType(String type) {
     }
	}