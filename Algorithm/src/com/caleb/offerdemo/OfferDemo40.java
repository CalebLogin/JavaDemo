package com.caleb.offerdemo;

import java.util.*;

/**
 * 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * @author：hanzhigang
 * @Date : 2021/3/11 8:08 PM
 */
public class OfferDemo40 {

    /**
     * 最小的k个数，朴素算法
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            int index = 0;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[arr.length - i - 1];
            arr[arr.length - 1 - i] = temp;
            res[i] = temp;
        }

        return res;

    }

    //  使用快排的思想
    public static int[] getLeastNumbers1(int[] arr, int k) {

        int[] res = new int[k];
        int startIndex = 0, endIndex = arr.length - 1, index = 0;   // 左指针，右指针和比较数
        while (true) {
//          查找arr[startIndex]在哪，根据位置选择前k个数
            index = arr[startIndex];
            int i = startIndex, j = endIndex;
            while (startIndex < endIndex) {
                while (startIndex < endIndex && arr[endIndex] > index) {
                    endIndex--;
                }
                if (endIndex > startIndex) {
                    arr[startIndex++] = arr[endIndex];
                }
                while (startIndex < endIndex && arr[startIndex] < index) {
                    startIndex++;
                }
                if (startIndex < endIndex) {
                    arr[endIndex--] = arr[startIndex];
                }
            }
            arr[startIndex] = index;
            if (startIndex == k - 1) {
                break;
            } else if (startIndex < k - 1) {
                startIndex = startIndex + 1;
                endIndex = j;
            } else {
                endIndex = startIndex - 1;
                startIndex = i;
            }
        }
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    //  使用堆的思想，利用优先队列来完成，使用大根堆，每次poll()出最大的数，剩下的就是前k小个数了
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);    //使用优先队列来实现大根堆
        for(int num:arr){
            if(queue.size() < k){
                queue.offer(num);
            }else{
                if(queue.peek() > num){
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        int[] res = new int[queue.size()];
        int i = 0;
        /*for(int j = 0;j<queue.size();j++){
            res[j] = queue.poll();
        }
        这是不对的，每次poll后，size会变小，切记
        */
        for(int num : queue){
            res[i++] = num;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1};
        System.out.println(getLeastNumbers1(arr, 2)[0]);
    }

}
