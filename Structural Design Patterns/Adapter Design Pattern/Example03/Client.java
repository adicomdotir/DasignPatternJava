public class Client {
	public static void main(String[] args) {
		Adapter adp = new Adapter(new Adaptee());
		save(adp);
	}
	
	public static void save(Target target) {
		target.request();
	}
}