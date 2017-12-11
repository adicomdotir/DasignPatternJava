public class Main {
	public static void main(String[] args) {
		int number = 5;
		B<Integer, Shape> bClass = new B<Integer, Shape>();
		bClass.multiple(number);
		bClass.sum(new Rectangle());
	}
}

class A<U> {
	public void sum(U e) {
		System.out.println("sum = " + (e));
	}
}

class B<E, U> extends A<U> {
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

