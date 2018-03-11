class Singleton01 {
	public static final Singleton01 INSTANCE = new Singleton01();

	private Singleton01() {
		// Constructor
	}

	public static Singleton01 getInstance() {
		return this.INSTANCE;
	}
}
