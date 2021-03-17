package com.eric.offerdemo;

import java.util.*;

/**
 * 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * @author：hanzhigang
 * @Date : 2021/3/17 10:32 PM
 */
public class OfferDemo59_II {

}

/**
 * 单调队列来实现最大值
 */
class MaxQueue {

    // 定义存储数据的队列
    Queue<Integer> queue;
    // 定义单调双端队列来实现寻找最大值
    Deque<Integer> deque1;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque1 = new LinkedList<>();
    }

    public int max_value() {
        if(deque1.isEmpty()) return -1;
        return deque1.peekLast();
    }

    public void push_back(int value) {
        // 在队列尾寻找比当前value小的数，因为之前的数进去的早，出来的也早。
        // 所以当前面的数出去的时候，最大值还是当前的数，不会受到前面出去的值的影响。
        while(!deque1.isEmpty() && value > deque1.peekLast()){
            deque1.pollLast();
        }
        deque1.addLast(value);
        queue.add(value);


    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        int num = queue.poll();
        // 如果双端队列不为空，且队头元素等于当前出队的元素，弹出队头元素
        if(!deque1.isEmpty()){
            if(num == deque1.peekFirst()) deque1.pollFirst();
        }
        return num;
    }
}
