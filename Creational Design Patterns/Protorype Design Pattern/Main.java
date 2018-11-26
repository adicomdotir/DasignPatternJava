import java.lang.*;

class Person implements Cloneable {
	private int age;
	private String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
        return age;
    }
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + age + "]";
	}
	
	@Override
	public Object clone() {
		Object clone = null;
		
		try {
			clone = super.clone();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return clone;
	}
}

public class Main {
   public static void main(String[] args) {
	   Person p1 = new Person(31, "Sina");
	   
	   Person p2 = (Person) p1.clone();

       System.out.println(p2);	
   }
}