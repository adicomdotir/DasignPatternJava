public class Client {
	public static void main(String[] args) {
		Component c = new ChildComponent();
		Component com = new Decorator(c);

		com.getInfo();
	}
}