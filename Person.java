public class Person {
	protected String name;
	protected int age;
	
	public Person() {
		this("NoName", 0);
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Person)) {
				return false;
		}
		Person person = (Person) o;
		return age == person.age && name.equals(person.name);
	}
}
