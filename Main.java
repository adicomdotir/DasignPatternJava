public class Main {
	public static void main(String[] args) {
		Student p1 = new Student();
		Student p2 = new Student();
		p2.setGrade(15.2);
		System.out.println(p1.equals(p2));
	}
}