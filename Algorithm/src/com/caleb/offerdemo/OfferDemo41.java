package com.caleb.offerdemo;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * @author：hanzhigang
 * @Date : 2021/3/18 9:15 PM
 */
public class OfferDemo41 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

/**
 * 思路1：数组，插入排序，然后返回
 * 思路2：一个大根堆，一个小根堆，大根堆存放较小的数据，小根堆存放较大的数据
 */
class MedianFinder {

    /**
     * initialize your data structure here.
     */
    // queue1 大根堆，queue2小根堆
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MedianFinder() {
        queue1 = new PriorityQueue<>((x1, x2) -> x2 - x1);
        queue2 = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 如果他俩大小不想等，肯定1大，2小，将num加入1，然后将1中的最大值给2
        if (queue1.size() != queue2.size()) {
            queue1.add(num);
            queue2.add(queue1.poll());
        } else { // 要是相等，始终让1中的大一点，则是先把num加入2，然后把2中的小值给1
            queue2.add(num);
            queue1.add(queue2.poll());
        }
    }

    public double findMedian() {
        return queue1.size() != queue2.size() ? queue1.peek() : (queue1.peek() + queue2.peek()) / 2.0;
    }
}
