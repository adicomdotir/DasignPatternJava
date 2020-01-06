public abstract class HouseTemplate {
	public final void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built.");
	}

	private viod buildWindows() {
		System.out.println("Building Glass Windows");
	}

	public abstract void buildWalls();
	public abstract void buildPillars();

	private viod buildFoundation() {
		System.out.println("Building foundation with cement,iron rods
and sand");
	}
}