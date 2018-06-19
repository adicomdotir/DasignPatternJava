import java.util.Arrays;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        streamExample();
    }

    public static void stringExample() {
        String str1 = new String(new char[] {'a', 'b', 'c'});
        String str2 = "abc";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.compareTo(str2));
    }

    public static void streamExample() {
        String[] names = new String[] {"A", "Bb", "Ccc", "Dddd", "Eeeee"};
        Stream<String> stream = Arrays.stream(names);
        stream.filter(x -> x.length() > 2).forEach(System.out::println);
        Integer[] arr = new Integer[] { 1, 2, 3, 4 };
        Stream<Integer> intStream = Arrays.stream(arr);
        intStream.map(x -> x * 3).forEach(System.out::println); // with method reference
    }

    public static void methodReferenceJava8() {
        Sayable sayable = Example::printFullName;
        sayable.say();
    }

    public static void printFullName() {
        System.out.println("adicomdotir");
    }

    public static void lamdaExample() {
    	
        // without lambda
        Sayable say01 = new Sayable() {
        	@Override
        	public void say() {
        		System.out.println("Hello World, without lambda");
        	}
        };
        say01.say();
        // with lambda
        Sayable say02 = () -> System.out.println("Hello World, with lambda");
        say02.say();
    }
}

interface Sayable {
    void say();
}
