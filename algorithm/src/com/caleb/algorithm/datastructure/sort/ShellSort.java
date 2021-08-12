package com.caleb.algorithm.datastructure.sort;

/**
 * 希尔排序，不稳定的排序算法
 * 时间复杂度当gap为1时，退化为直接插入排序，时间复杂度最差，O(n2),Hibbard增量的希尔排序的时间复杂度为O(N3/2)。
 * 空间复杂度O(1)
 *
 * @author：hanzhigang
 * @Date : 2021/3/8 12:32 PM
 */
public class ShellSort {
    public static void shellSort(int[] a) {
//      数组的长度
        int size = a.length;
//      定义步长，组数和当前遍历的位置
//      定义gap步长后，数组会被分成gap组
        int gap, i, j;
        for (gap = size / 2; gap > 0; gap /= 2) {
            for (i = 0; i < gap; i++) {
                for (j = i + gap; j < size; j += gap) {
//                  如果前一个数大于当前数，找到插入的位置，将插入位置以及后面的数向后移，在插入位置插入数值
                    if (a[j - gap] > a[j]) {
                        int temp = a[j];
                        int k = j - gap;
                        while (k >= i && a[k] > temp) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
//                      在插入位置插入数值
                        a[k + gap] = temp;

                    }

                }
            }
        }
    }

    public static void main(String[] args) {

        int a[] = {80, 30, 60, 40, 20, 10, 50, 70};

        System.out.printf("before sort:");
        for (int i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        shellSort(a);

        System.out.printf("after  sort:");
        for (int i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
