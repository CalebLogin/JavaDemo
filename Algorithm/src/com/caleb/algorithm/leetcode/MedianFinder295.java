package com.caleb.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 例如， [2,3,4] 的中位数是 3
 * [2,3]的中位数是 (2 + 3) / 2 = 2.5 设计一个支持以下两种操作的数据结构： void addNum(int num) -
 * 从数据流中添加一个整数到数据结构中。 double findMedian() - 返回目前所有元素的中位数。
 * 
 * @author:Caleb
 * @Date :2021-06-18 10:30:14
 */
public class MedianFinder295 {

	public static void main(String[] args) {
		MedianFinder m = new MedianFinder();
		m.addNum(1);
		m.addNum(2);
		System.out.println(m.findMedian());
		m.addNum(3); 
		System.out.println(m.findMedian());
	}

}

class MedianFinder {

	/** initialize your data structure here. */
	PriorityQueue<Integer> priorityQueue1;	// 大根堆
	PriorityQueue<Integer> priorityQueue2;	// 小根堆

	public MedianFinder() {
		priorityQueue1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
		priorityQueue2 = new PriorityQueue<>((o1, o2) -> o1 - o2);
	}

	public void addNum(int num) {
		if (priorityQueue1.size() > priorityQueue2.size()) {
			priorityQueue1.add(num);
			priorityQueue2.add(priorityQueue1.poll());
		} else {
			priorityQueue2.add(num);
			priorityQueue1.add(priorityQueue2.poll());
		}
	}

	public double findMedian() {
		if(priorityQueue1.size() > priorityQueue2.size()){
			return priorityQueue1.peek();
		}else{
			if(!priorityQueue1.isEmpty()){
				return (priorityQueue1.peek() + priorityQueue2.peek())/2.0;
			}
		}
		return 0.0;

	}
}