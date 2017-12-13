package ir.adicom.app;

import java.util.Scanner;
import java.util.function.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	java8StreamExample();
    }

    public static void java8OtherExample() {
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

    public static void java8StreamExample() {
    	List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		stringCollection.stream()
			.filter((s) -> s.startsWith("a"))
			.forEach(System.out::println);
		stringCollection.stream().sorted()
		    .filter((s) -> s.startsWith("a"))
		    .forEach(System.out::println);
		stringCollection.stream()
			.map(String::toUpperCase)
			.sorted((a, b) -> b.compareTo(a))
			.forEach(System.out::println);

		boolean anyStartsWithA = stringCollection.stream()
							        .anyMatch((s) -> s.startsWith("a"));

		System.out.println(anyStartsWithA);      // true

		boolean allStartsWithA = stringCollection.stream()
							        .allMatch((s) -> s.startsWith("a"));

		System.out.println(allStartsWithA);      // false

		boolean noneStartsWithZ = stringCollection.stream()
							        .noneMatch((s) -> s.startsWith("z"));

		System.out.println(noneStartsWithZ);      // true

		long startsWithB =
		    stringCollection
		        .stream()
		        .filter((s) -> s.startsWith("b"))
		        .count();

		System.out.println(startsWithB);    // 3

		Optional<String> reduced =
		    stringCollection
		        .stream()
		        .sorted()
		        .reduce((s1, s2) -> s1 + "#" + s2);

		reduced.ifPresent(System.out::println);
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

