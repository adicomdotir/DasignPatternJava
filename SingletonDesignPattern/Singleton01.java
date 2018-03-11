class Singleton01 {
	public static final Singleton01 INSTANCE = new Singleton01();

	private Singleton01() {
		// Constructor
	}

	public Singleton01 getInstance() {
		return this.INSTANCE;
	}
}
