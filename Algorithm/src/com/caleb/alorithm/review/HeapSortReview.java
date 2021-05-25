package com.caleb.alorithm.review;

/**
 * 堆排序复习
 *
 * @author：hanzhigang
 * @Date : 2021/3/26 11:03 AM
 */
public class HeapSortReview {

    public int[] heapSort(int[] a) {
        int size = a.length;
        for (int i = size / 2; i >= 0; i--) {
            swqpHeap(a, i, size - 1);
        }
        for (int i = size - 1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            swqpHeap(a, 0, i - 1);
        }
        return null;
    }

    public void swqpHeap(int[] a, int start, int end) {
        int cur = start, l = 2 * start + 1;
        for (; l <= end; cur = l, l = 2 * cur + 1) {
            if (l + 1 <= end && a[l + 1] > a[l]) {
                l = l + 1;
            }
            if (a[cur] < a[l]) {
                int temp = a[l];
                a[l] = a[cur];
                a[cur] = temp;
            } else {
                break;
            }
        }
    }


}
