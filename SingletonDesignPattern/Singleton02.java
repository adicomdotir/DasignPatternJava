class Singleton02 {
	private static Singleton02 sInstance;

	private Singleton02() {
		// Constructor
	}

	public static Singleton02 getInstance() {
		if (sInstance == null) {
			sInstance = new Singleton02();
		}
		return this.sInstance;
	}
}
