package com.caleb.iqiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author:Caleb
 * @Date :2021-08-01 15:24:09
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		Solution s = new Solution();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(10000));
		final Scanner reader = new Scanner(System.in);
		final String next = reader.next();
		List<Line> lines = Arrays.stream(next.split(",")).map(str -> new StringLine(str)).collect(Collectors.toList());
		List<Line> result = s.translateAll(lines, "", threadPoolExecutor);
		String resultString = result.stream().map(l -> l.toString()).collect(Collectors.joining(","));
		System.out.println(resultString);
		reader.close();
		threadPoolExecutor.shutdown();
		System.out.println(threadPoolExecutor.isShutdown());
	}

	public interface Line {
		/**
		 * translate the line to the specific language
		 * 
		 * @param language - the language to translate
		 * @return the line of translated by the {@code language}
		 */
		Line translate(String language);
	}

	public static class Solution {
		/**
		 * translate the all lines to the specific language
		 * 
		 * @param lines    the text lines of episode
		 * @param language the language to translate
		 * @return the lines of translated by the {@code language}
		 */
		public List<Line> translateAll(List<Line> lines, String language, Executor executor)
				throws InterruptedException {
			Job<Line> job = new Job<>();
			for (Line line : lines) {
				Callable<Line> callable = () -> line.translate(language);
				job.newTask(callable);
			}
			job.execute(executor);
			return job.get();
		}
	}

	public static class Job<V> {
		int count = 0;
		Map<Integer, Callable<V>> map = new HashMap<>();
		Map<Integer, V> res = new HashMap<>();
		List<V> finalRes = new ArrayList<>();

		public void newTask(Callable<V> runnable) {
			// 待实现
			map.put(count++, runnable);
		}

		public void execute(Executor executor) {
			for (Map.Entry<Integer, Callable<V>> entry : map.entrySet()) {
				try {
					Future<V> fu = ((ThreadPoolExecutor) executor).submit(entry.getValue());
					res.put(entry.getKey(), fu.get());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		public List<V> get() throws InterruptedException {
			// 待实现
			List<Integer> keys = new ArrayList<>(res.keySet());
			Collections.sort(keys);

			for (Integer i : keys) {

				finalRes.add(res.get(i));

			}

			return finalRes;
		}

	}

	/**
	 * translate the string line to upper case
	 */
	public static class StringLine implements Line {
		private String text;

		public StringLine(String text) {
			this.text = text;
		}

		@Override
		public Line translate(String language) {
			return new StringLine(text.toUpperCase());
		}

		@Override
		public String toString() {
			return text;
		}
	}

}
