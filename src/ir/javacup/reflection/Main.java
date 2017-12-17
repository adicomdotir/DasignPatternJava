package ir.javacup.reflection;

public class Main {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("Ali");
		p1.setAge(30);
		Person p2 = new Person();
		new Copier("age").copy(p1, p2);
		System.out.print(p2);
	}
}

class Person {
	public int age;
	public String name;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() { return name; }

	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() { return age; }

	@Override
	public String toString() {
		return "[" + name + "," + age + "]";
	}
}