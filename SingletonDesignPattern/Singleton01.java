class Singleton01 {
	public static Singleton01 instance = new Singleton01();

	private Singleton01() {}

	public Singleton01 getInstance() {
		return this.instance;
	}
}