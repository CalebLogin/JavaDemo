package com.caleb.java.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Supplier;

/**
 * @author:Caleb
 * @Date :2021-09-12 15:32:46
 */
public class LambdaDemo1 {

	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3, 4, 5);
		list.forEach((s) -> System.out.println(s));
		;
		list.forEach(System.out::println);
		list.sort(Integer::compare);
		Supplier<List<Integer>> list1 = ArrayList<Integer>::new;
		Person[] pers = new Person[30];
		Arrays.sort(pers, Person::compareByAge);
		TreeSet<String> set = new TreeSet<>(String::compareTo);
		set.forEach(System.out::println);
	}

}

class Person {
	private String name;
	private Integer age;

	public static int compareByAge(Person a, Person b) {
		return a.age.compareTo(b.age);
	}
}