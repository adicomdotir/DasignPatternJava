public class Main {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person("ali", 28);
		System.out.println(p1.equals(p2));
	}
}