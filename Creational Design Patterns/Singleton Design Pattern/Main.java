public class Main {
	public static void main(String[] args) {
		Singleton01 sing = Singleton01.getInstance();
		Student st = new Student();
		st.show();
	}
}

class Person {
}

class Student extends Person {
}