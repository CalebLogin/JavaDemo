package com.caleb.algorithm.datastructure.sort;

/**
 * 堆排序，不稳定的排序算法
 * 时间复杂度O(nlogn),空间复杂度O(1)
 *
 * @author：hanzhigang
 * @Date : 2021/3/8 1:59 PM
 */
public class HeapSort {

    /**
     * (最大)堆的向下调整算法
     * <p>
     * 数组的实现堆中，第N个节点的左孩子是2N+1，右孩子是2N+2
     * <p>
     * 向下调整算法可以看成将a[start]放到本次循环中正确的位置。
     * 在不断的比较的过程中，其他元素因为它的调整也在不断调整，最终调整结束，在本次循环中，涉及到调整的每个元素都在正确的位置上。
     *
     * @param a
     * @param start
     * @param end
     */
    public static void maxHeapDown(int[] a, int start, int end) {

//      当前节点的位置和左孩子节点的位置
        int p = start, c = 2 * p + 1;
        int temp = a[p];


        for (; c <= end; p = c, c = 2 * p + 1) {
            if (c < end && a[c] < a[c + 1]) {
                c++;
            }
            if (temp < a[c]) {
                a[p] = a[c];
                a[c] = temp;
            } else {
                break;
            }
        }
    }


    public static void heapSort(int[] a) {
//      数组的长度
        int size = a.length;

//      初始化最大堆，最大值位于堆顶
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapDown(a, i, size - 1);
        }

//      从最后一个元素开始调整堆，不断缩小调整的范围，直到第一个元素
        for (int i = size - 1; i > 0; i--) {
//          将最后一个元素与第一个元素交换，类似于堆顶最大值与堆的最后一个值互换。
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
//          缩小遍历序列的范围，将刚才涉及队列的最后一个元素忽略，重新调整堆
            maxHeapDown(a, 0, i - 1);
        }


    }

    public static void main(String[] args) {
        int i;
        int a[] = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        heapSort(a);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

}
