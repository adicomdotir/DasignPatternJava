import javax.swing.*;
 
public class RSATM {   
	public static void main(String[] args) {  
		MyClass myOne = new MyClass();
		myOne.m();
		new Demo().implement();
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

interface HasBody {
   default void first() {
      System.out.println("This is first default method in HasBody interface.");
   }

   default void second() {
      System.out.println("This is second default method in HasBody interface.");
   }

   void third();
   }

class Demo implements HasBody {

   @Override
   public void second() {
      System.out.println("Overriding default method in child class.");
   }

   @Override
   public void third() {
      System.out.println("This is implemented abstract method of an interface.");
   }

   public void implement() {
      HasBody ref = new Demo();
      // Calling first() default method declared in HasBody interface.
      ref.first();

      // Calling Overridden default method of HasBody interface.
      ref.second();

      // Calling implemented method of HasBody interface.
      ref.third();
   }
}