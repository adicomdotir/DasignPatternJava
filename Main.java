import java.util.stream.*;
import java.util.*;

public class Main {
	@Override
	public void finalize(){
		System.out.println("object is garbage collected");
	}   
	
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
		
		Main m = new Main();
		m = null;
		System.gc();
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
	
	/*
	Given an array of ints, compute recursively the number of times that the 
	value 11 appears in the array. We'll use the convention of considering 
	only the part of the array that begins at the given index. In this way, 
	a recursive call can pass index+1 to move down the array. The initial 
	call will pass in index as 0.

	array11([1, 2, 11], 0) → 1
	array11([11, 11], 0) → 2
	array11([1, 2, 3, 4], 0) → 0
	*/
	public int array11(int[] nums, int index) {
		if(nums.length == 0) return 0;
		if(nums[index] == 11) return 1 + array11(nums, index+1);
		else return array11(nums, index + 1);
	}

	/*
	Given an array of ints, compute recursively if the array contains somewhere a
	value followed in the array by that value times 10. We'll use the convention 
	of considering only the part of the array that begins at the given index. 
	In this way, a recursive call can pass index+1 to move down the array. 
	The initial call will pass in index as 0.

	array220([1, 2, 20], 0) → true
	array220([3, 30], 0) → true
	array220([3], 0) → false
	*/
	public boolean array220(int[] nums, int index) {
		if(index == nums.length-1) return false;
		if(nums.length == 1) return false;
		if(nums[index]*10 == nums[index+1]) return true;
		else array220(nums, index+1);
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