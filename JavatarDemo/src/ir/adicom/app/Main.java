package ir.adicom.app;

import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
    	Predicate<String> predicate = (s) -> s.length() > 3;

		System.out.println(predicate.test("123"));              // true
		System.out.println(predicate.negate().test("123"));     // false
    }
}

