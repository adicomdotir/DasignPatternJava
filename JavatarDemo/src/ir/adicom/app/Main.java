package ir.adicom.app;

import java.util.Scanner;
import java.util.function.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Predicate<String> predicate = (s) -> s.length() > 3;

		System.out.println(predicate.test("123"));              // true
		System.out.println(predicate.negate().test("123"));     // false

		Supplier<Person> personSupplier = Person::new;
		Person p = personSupplier.get();   // new Person
		System.out.println(p);

		Consumer<Person> greeter = (per) -> System.out.println("Hello, " + per.firstName);
		greeter.accept(new Person("Luke", "Skywalker"));

		Comparator<Person> comparator = (per1, per2) -> per1.firstName.compareTo(per2.firstName);

		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");

		System.out.println(comparator.compare(p1, p2));  // > 0
		System.out.println(comparator.reversed().compare(p1, p2));  // < 0
    }
}

class Person {
	public String firstName;
	public String lastName;

	public Person() {}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}

