import javax.swing.*;
 
public class RSATM {   
	public static void main(String[] args) {  
		MyClass myOne = new MyClass();
		myOne.m();
	}  
}

abstract class A {
   public void hello() {
        System.out.println("Hello");
    } 
    abstract void boo();
}

class B extends A {
     public void hello() {
        System.out.println("No");
     }
    
    public void boo() {
        System.out.println("Say haha");

    }
}

class C extends A {
	public void boo() {
		System.out.println("Say haha");
	}
}

interface MyOne {
	default void m1() {
		System.out.println("MyOne");
	}
}

interface MyTwo {
	default void m() {
		System.out.println("MyTwo");
	}
}

class MyClass implements MyOne, MyTwo {
}