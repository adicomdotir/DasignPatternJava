public class Main {
	public static void main(String[] args) {
		Director d = new Director();
		ConcreteBuilder1 cb1 = new ConcreteBuilder1();
		d.construct(cb1);
		System.out.println(cb1.p);
	}
}