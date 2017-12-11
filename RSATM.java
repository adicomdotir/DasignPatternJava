import javax.swing.*;
import java.util.TreeMap;
 
public class RSATM {   
	public static void main(String[] args) {
		Shape[] shapes = {
			new Rectangle(),
			new Square(),
			new Circle(),
			new Triangle(2, 3, 4, 5)
		};
		for(Shape s : shapes) {
			System.out.println("" + s);
		}
		
		TreeMap<Integer, String> hm = new TreeMap<Integer, String>();
        // add key-value pair to TreeMap
        hm.put(2, "FIRST INSERTED");
        hm.put(5, "SECOND INSERTED");
        hm.put(1,"THIRD INSERTED");
        System.out.println("My TreeMap content:");
        System.out.println(hm);
        System.out.println("Clearing TreeMap:");
        hm.clear();
        System.out.println("Content After clear:");
        System.out.println(hm);
		
		TestGeneric<Integer> test = new TestGeneric<>();
		Float[] f = new Float[] {
			new Float(5.6),
			new Float(5.9),
			new Float(5.1)
		};
		test.method(f, new Integer(5));
		
		main("Hello");
		Test t1 = new Test();
	}
	
	public static void main(String args) {
		System.out.println(args);
		ParentClass pc = new ChildClass();
	}
}

class TestGeneric<T> {
    public <E> void method(E[] p1, T t) {
		for(E e: p1) {
			System.out.println(e.toString());
		}
    }
}

class FlyingDragon extends Entity {
	private int Hp;
	public FlyingDragon(int x, int y, int Hp) {
		super (x, y);
		this.Hp = Hp;
	}
	public void setHp(int Hp) {
		this.Hp = 100;
	}

	public int getHp() {
		return Hp;
	}

	public void setType(String type) {
		super.setType("Flying Dragon");
	}
}

/**
 * Created by Yashar.P on 4/17/2017.
 */
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

class Test {
	static {
		System.out.println("Static");
	}
	{
		System.out.println("Instance");
	}
	public Test() {
		System.out.println("Constructor");
	}
}