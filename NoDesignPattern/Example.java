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
    }

    public static void methodReferenceJava8() {
        Sayable sayable = Example::printFullName;
        sayable.say();
    }

    public static void printFullName() {
        System.out.println("adicomdotir");
    }
}

interface Sayable {
    void say();
}