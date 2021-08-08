package com.caleb.algorithm.review;

import java.util.PriorityQueue;

/**
 * @author:Caleb
 * @Date :2021-08-08 16:19:40
 */
public class MedianFinder41 {

}

class MedianFinder {

	// 两个优先队列解决问题，一个大跟堆一个小根堆
	/** initialize your data structure here. */
	PriorityQueue<Integer> p1;
	PriorityQueue<Integer> p2;

	public MedianFinder() {
		// 小根堆
		p1 = new PriorityQueue<>((o1, o2) -> o1 - o2);
		// 大跟堆
		p2 = new PriorityQueue<>((o1, o2) -> o2 - o1);
	}

	public void addNum(int num) {
		// 先给大跟堆，再给小根堆，大跟堆始终大于等于小根堆
		p2.offer(num);
		p1.offer(p2.poll());
		if (p1.size() > p2.size()) {
			p2.offer(p1.poll());
		}
	}

	public double findMedian() {
		if (p1.size() == 0 && p2.size() == 0) {
			return 0.0;
		}
		if (p1.size() == p2.size()) {
			return (p1.peek() + p2.peek()) / 2.0;
		}else{
			return p2.peek();
		}
	}
}