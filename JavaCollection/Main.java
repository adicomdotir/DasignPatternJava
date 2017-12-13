import java.util.*;  

public class Main {
	public static void main(String[] args) {
		int number = 5;
		B<Integer, Shape> bClass = new B<>();
		bClass.multiple(number);
		bClass.sum(new Rectangle());

		List<Short> list = new ArrayList<>();
		list.add(new Short("5"));
		list.add(new Short("80"));
		new Gen().sum(list);
		sum((x) -> System.out.println("Hello " + x));
		Formula f = new Formula() {
			public double calculate(int a) {
				return 0;
			}
		};
		System.out.println("Size of byte: " + (Byte.SIZE/8) + " bytes.");
	    System.out.println("Size of short: " + (Short.SIZE/8) + " bytes.");
	    System.out.println("Size of int: " + (Integer.SIZE/8) + " bytes.");
	    System.out.println("Size of long: " + (Long.SIZE/8) + " bytes.");
	    System.out.println("Size of char: " + (Character.SIZE/8) + " bytes.");
	    System.out.println("Size of float: " + (Float.SIZE/8) + " bytes.");
	    System.out.println("Size of double: " + (Double.SIZE/8) + " bytes.");

	    List<String> names = Arrays.asList("Ali", "Hassan", "Hussein", "Sajjad", "Bagher");

		Collections.sort(names, (a, b) -> b.compareTo(a));

		for (String str : names) {
	    	System.out.print(str + ",");
	    }

		// Converter<String, Integer> converter = Integer::valueOf;
		// Integer converted = converter.convert("123");
		// System.out.println(converted);   // 123

		Something something = new Something();

		// Method Refrence
		// Converter<String, String> converter = something::startsWith;
		// With Return
		// Converter<String, String> converter = (String form) -> { return something.startsWith(form); };
		Converter<String, String> converter = form -> something.startsWith(form);
		String converted = converter.convert("Java");
		System.out.println(converted);    // "J"

		// FactoryPerson<Person> factoryPerson = Person::new;
		FactoryPerson<Person> factoryPerson = (fn, ln) -> new Person(fn, ln);
		Person person = factoryPerson.create("Ali", "Panahi");
		System.out.println(person.firstName + " " + person.lastName);
	}

	public static void sum(OnClickListener onClickListener) {
		onClickListener.click(50);
	}
}

class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

interface FactoryPerson<p extends Person> {
	p create(String firstName, String lastName);
}

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

// @FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

interface OnClickListener {
	void click(int x);
}

class Gen {
	private double val;
	public Gen() {
	}
	public void show(){
	}

	public void sum(List<? extends Number> list) {
		System.out.println(list.size());
	}
}

class A<U extends Shape> {
	public void sum(U e) {
		System.out.println("sum = " + (e));
	}
}

class B<E extends Number, U extends Shape> extends A<U> {
	public void multiple(E e) {
		System.out.println("multiple = " + (e));
	}
}

interface Shape<T> {
	void draw(T t);
}

class Circle implements Shape<Float> {
	@Override
	public void draw(Float t) {
		System.out.println("draw = " + (t));
	}
}

class Rectangle implements Shape<String> {
	@Override
	public void draw(String t) {
		System.out.println("draw = " + (t));
	}
}

