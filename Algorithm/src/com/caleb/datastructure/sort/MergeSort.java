package com.caleb.datastructure.sort;

/**
 * 归并排序，稳定的排序算法
 * 时间复杂度O(nlogn),空间复杂度O(1)
 *
 * @author：hanzhigang
 * @Date : 2021/3/8 2:37 PM
 */
public class MergeSort {

    /**
     * 将两个有序数组合并成一个
     *
     * @param a     数组
     * @param start 第一个有序数组的起始位置
     * @param mid   第二个有序数组的开始位置，第一个有序区间的结束地址
     * @param end   第二个数组的结束位置
     */
    public static void merge(int[] a, int start, int mid, int end) {
        int[] res = new int[end - start + 1];   // 定义结果数组存放排好序的数组
        int s1 = start;                         // 遍历第一个有序数组的索引
        int s2 = mid + 1;                       // 遍历第二个有序数组的索引
        int k = 0;                              // 新建结果数组的索引
//      将有序的结果存放到结果数组中
        while (s1 <= mid && s2 <= end) {
            if (a[s1] < a[s2]) {
                res[k++] = a[s1++];
            } else {
                res[k++] = a[s2++];
            }
        }
//      两个有序数组可能长度不同，当前一个有序数组还有元素时，继续添加
        while (s1 <= mid) {
            res[k++] = a[s1++];
        }
//      当后一个有序数组还有元素时，继续添加
        while (s2 <= end) {
            res[k++] = a[s2++];
        }
//      将a数组中start到end的元素覆盖，变成已经排好序的元素
        for (int i = 0; i < end - start + 1; i++) {
            a[start + i] = res[i];
        }
        res = null;
    }

    /**
     * 归并排序（自上向下进行排序）
     *
     * @param a     待排序的数组
     * @param start 数组的起始位置
     * @param end   数组的结束位置
     */
    public static void mergeSortUpToDown(int[] a, int start, int end) {
        if (a == null || start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;        // 取中间值
        mergeSortUpToDown(a, start, mid);           // 归并排序a[start...mid]
        mergeSortUpToDown(a, mid + 1, end);   // 归并排序a[mid+1...end]

        merge(a, start, mid, end);     // 将两个有序数组进行合并

    }

    /**
     * 对数组a做若干次合并，把它分为若干个gap长度的子数组
     * 将相邻的两组进行合并
     *
     * @param a      原数组
     * @param length 数组的长度
     * @param gap    数组的长度
     */
    public static void mergeGroups(int[] a, int length, int gap) {

        int i;
        int twoLen = 2 * gap;       //两个子数组的长度
//      每两个数组进行合并
        for (i = 0; i + twoLen - 1 < length; i += (twoLen)) {
            merge(a, i, i + gap - 1, i + 2 * gap - 1);
        }
//      如果i+gap-1<length-1，可能会剩下一组没有配对,把剩下的合并到排好序的数组中。
        if (i + gap < length) {
            merge(a, i, i + gap, length - 1);
        }
    }

    /**
     * 归并排序（自下向上）
     *
     * @param a 数组
     */
    public static void mergeSortDownToUp(int[] a) {
//      数组的长度
        int size = a.length;
        for (int i = 1; i < a.length; i *= 2) {
            mergeGroups(a, size, i);
        }
    }


    public static void main(String[] args) {

        int a[] = {80, 30, 60, 40, 20, 10, 50, 70};

        System.out.printf("before sort:");
        for (int i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

//        mergeSortUpToDown(a, 0, a.length - 1);        // 归并排序(从上往下)
        mergeSortDownToUp(a);                    // 归并排序(从下往上)

        System.out.printf("after  sort:");
        for (int i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
