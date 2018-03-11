class Singleton02 {
	public static Singleton02 instance;

	private Singleton02() {}

	public Singleton02 getInstance() {
		if (instance == null) {
			instance = new Singleton02();
		}
		return this.instance;
	}
}