package com.caleb.java.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author:Caleb
 * @Date :2021-09-12 16:26:34
 * 
 *       Filter && Predicate
 */
public class LambdaFilterAndPredicate {

	public static void main(String[] args) {
		List<String> langs = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

		System.out.println("Languages which starts with J :");
		filter(langs, (str) -> (str.startsWith("J")));

		System.out.println("Print language whose length greater than 4 :");
		filter(langs, (str) -> str.length() > 4);
	}

	public static void filter(List<String> names, Predicate<String> condition) {
		names.stream().filter(name -> condition.test(name)).forEach(System.out::println);
	}

	public static void filterMultiply(List<String> names, Predicate<String> condition1, Predicate<String> condition2) {
		names.stream().filter(condition1.and(condition2)).forEach(System.out::println);
	}

}