package com.caleb.java.java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author:Caleb
 * @Date :2021-09-12 17:21:16
 */
public class LambdaMapAndReduce {

	public static void main(String[] args) {
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println(bill);
	}

}