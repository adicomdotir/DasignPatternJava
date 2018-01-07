package ir.adicom.app;

import java.util.Scanner;
import java.util.function.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	try {
	    	javaThreadExample();
    	} catch (InterruptedException e) {}
    }

    public static void javaThreadExample() throws InterruptedException {
    	BankAccount ba = new BankAccount(new Double(0));
    	MyThread t01 = new MyThread(ba);
    	t01.start();
    	MyThread t02 = new MyThread(ba);
    	t02.start();
    	MyThread t03 = new MyThread(ba);
    	t03.start();
    	MyThread t04 = new MyThread(ba);
    	t04.start();
    	try {
	    	t01.join();
	    	t02.join();
	    	t03.join();
	    	t04.join();
    	} catch(Exception e) {}

    	System.out.println(ba);

    	// Producer & Consumer problem
    	final PC pc = new PC();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
 
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
 
        // t1.start();
        // t2.start();
        // t3.start();
 
        // t1.join();
        // t2.join();
        // t3.join();

        Function<Integer, String> function = (t) -> {
			if (t % 2 == 0) {
				return t+ " is even number";
			} else {
				return t+ " is odd number";
			}
		};
		System.out.println(function.apply(5));
		System.out.println(function.apply(8));

		Function<Person, String> function1 = (t) -> {
			return t.firstName + " " + t.lastName;
		};
		System.out.println(function1.apply(new Person("Aku", "Daei")));

        /*

        */
    }

    public static void java8OtherExample() {
    	Predicate<String> predicate = (s) -> s.length() > 3;

		System.out.println(predicate.test("123"));              // true
		System.out.println(predicate.negate().test("123"));     // false

		// Supplier<Person> personSupplier = Person::new;
		Supplier<Person> personSupplier = () -> new Person();
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


interface MyJava8Interface {

    void doSomething();

    default void doSomethingElse() {
        System.out.println("doSomethingElse");
    }

    static void somethingStatic() {
        System.out.println("somethingStatic");
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}
 
class Thread2 extends Thread {
    @Override
    public void run() {
        for(int i = 1001; i<= 2000; i++) {
            System.out.println(i);
        }
    }
}

class BankAccount {
	private Double balance;

	public BankAccount(Double balance) {
		this.balance = balance;
	}

	// public synchronized void deposit(double amount) {
	// 	balance += amount;
	// }

	// public synchronized void withdraw(double amount) {
	// 	balance -= amount;
	// }

	public void deposit(double amount) {
		synchronized(this) {
			balance += amount;
		}
	}

	public void withdraw(double amount) {
		synchronized(this) {
			balance -= amount;
		}
	}

	@Override
	public String toString() {
		return "Balance: " + this.balance;
	}
}

class MyThread extends Thread {
	private BankAccount ba;

	public MyThread(BankAccount ba) {
		this.ba = ba;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			ba.deposit(1);
		}
	}
}

class PC {
	private LinkedList<Integer> list = new LinkedList<>();
    private int capacity = 3;
    private int value = 0;

    public void produce() throws InterruptedException {
    	while (true) {
    		synchronized(this) {
    			while (list.size() == capacity) { 
    				wait();
    			}

				System.out.println("Producer produced-" + value);

				list.add(value++);

				notify();

				Thread.sleep(1000);
    		} 
    	}
    }

    public void consume() throws InterruptedException {
    	while(true) {
    		synchronized (this) {
    			while (list.size() == 0) {
    				wait();
    			}

    			int val = list.removeFirst();

    			System.err.println("Consumer consumed-" + val);

    			notify();

    			Thread.sleep(1000);
    		}
    	}
    }
}

