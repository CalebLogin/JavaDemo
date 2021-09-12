package com.caleb.java.java8.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author:Caleb
 * @Date :2021-09-12 18:31:00
 */
public class LambdaCollector {

	public static void main(String[] args) {
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(G7Countries);
		List<Integer> res = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(a -> a.stream())
				.collect(Collectors.toList());
		System.out.println(res.toString());
		List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 5, 5);
		List<Integer> res1 = list.stream().map(Integer::intValue).distinct().collect(Collectors.toList());
		System.out.println(res1.toString());
		int count = (int) list.stream().filter(i -> i > 3).count();
		System.out.println(count);
		boolean anyMatch = list.stream().anyMatch(i -> i > 1);
		boolean allMatch = list.stream().allMatch(i -> i > 3);
		boolean noneMatch = list.stream().noneMatch(i -> i > 6);
		System.out.println(anyMatch);
		System.out.println(allMatch);
		System.out.println(noneMatch);
		System.out.println(list.stream().max((o1,o2)->o1.compareTo(o2)).get());
		IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(Integer::intValue).summaryStatistics();
		int iSMaxV = intSummaryStatistics.getMax();
		int iSMinV = intSummaryStatistics.getMin();
		long iSumV = intSummaryStatistics.getSum();
		double iAverageV = intSummaryStatistics.getAverage();


		
	}

}