public class Example {
	public static void main(String[] args) {
		stringExample();
	}

	public static void stringExample() {
		String str1 = new String(new char[] {'a', 'b', 'c'});
		String str2 = "abc";
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1.compareTo(str2));
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