using System;

namespace ConsoleApplication
{
    public class Program
    {
        public static void Main(string[] args)
        {
			A[] elements = new A[] { new D(), new A(), new C(), new B() };
			for (int i = 0; i < elements.Length; i++) {
				Console.WriteLine(elements[i].method1());
				Console.WriteLine(elements[i].method2());
				Console.WriteLine();
			}
        }
    }
	
	class A
	{
		public virtual string method1() 
		{
			return "A1";
		}
		
		public virtual string method2() 
		{
			return "A2";
		}
	}
	
	class B : A
	{	
		public override string method2() 
		{
			return method1() + "B2";
		}
	}
	
	class C : B
	{	
		public override string method1() 
		{
			return "C1";
		}
	}
	
	class D : B
	{	
		public override string method1() 
		{
			return "D1";
		}
	}
}
