public class Main {
	public static void main(String[] args) {
		Hero mage = new Hero.Builder(Profession.MAGE, "Riobard")
						.withHairColor(HairColor.BLACK)
						.withWeapon(Weapon.DAGGER)
						.build();
		/*
		Director d = new Director();
		ConcreteBuilder1 cb1 = new ConcreteBuilder1();
		d.construct(cb1);
		System.out.println(cb1.p);
		*/
	}
}