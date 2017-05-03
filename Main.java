import java.util.stream.*;
import java.util.*;

public class Main {
	public static Integer threadCounter = new Integer(0);
	public static void main(String[] args) {

		// THIS EDIT BY VIM
		Student p1 = new Student();
		Student p2 = new Student();
		p2.setGrade(15.2);
		System.out.println(p1.equals(p2));

		Circle c1 = new Circle(2);
		Circle c2 = c1;
		System.out.println(c1.equals(c2));
		c2 = new Circle(2);
		System.out.println(c1.equals(c2));
		
		Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
		Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
		System.out.println("Factory PC Config::" + pc);
		System.out.println("Factory Server Config::" + server);

		myStream();

		MathOperation division = (int a, int b) -> a / b;
		System.out.println("" + division.operation(8,2));

		methodReferencesExample();

		List<Integer> list = Arrays.asList(1, 2, 3, 5, 4);
		list.forEach(x -> System.out.println(x));

		String value = "hassan";
		String str = Optional.ofNullable(value).map(x -> x.toUpperCase()).orElse("NONE");
		System.out.println(str);

		for (int i=0; i<5; i++) {
			Thread t = new Thread(new CountAndPrint("Instance " + i));
			t.start();
			try {
				t.join();
			} 
			catch(Exception e) {
				e.getMessage();
			}
		}
		
		System.out.println("");
		System.out.println("Thread Counter: " + threadCounter);
	}

	public static void myStream() {
		Stream<String> fruitStream = Stream.of("tomato", "apple",
			"banana", "kiwi", "orange");
		fruitStream.filter(s -> s.contains("a"))
		.map(String::toUpperCase)
				.sorted()
				.forEach(System.out::println);
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	public static void methodReferencesExample() {
		System.out.println("/////////////////////////");
		System.out.println("Method References Example");
		System.out.println("/////////////////////////");
		List names = new ArrayList();
		names.add("Sajjad");
		names.add("Saeed");
		names.add("Farzad");
		names.forEach(x -> System.out.println(x));
		// names.forEach(System.out::println);
	}
}

class CountAndPrint implements Runnable {
	private final String name;
	CountAndPrint(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Main.threadCounter++;
			System.out.println(this.name + ": " + i);
		}
	}
}

class MyThread extends Thread {
	@Override
	public void run() {  
   		System.out.println("My thread is in running state.");  
  	}   
}