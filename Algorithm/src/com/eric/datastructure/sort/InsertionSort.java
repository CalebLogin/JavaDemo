package com.eric.datastructure.sort;

/**
 * 插入排序，稳定的排序
 * 空间复杂度O(1),时间复杂度O(n2),O(n)
 *
 * @author：hanzhigang
 * @Date : 2021/3/8 11:08 AM
 */
public class InsertionSort {
    //  插入排序
    public static void insertionSort(int[] a) {
//      数组的长度
        int size = a.length;
        for (int i = 1; i < size; i++) {
//          j等于i的前一位，当前一位大于后一位时，一直向前查找，一直查找到比a[i]小的值，或者查找到0处
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[i] > a[j]) {
                    break;
                }
            }
//          如果发生了查找，将前面的数向后移，然后将空出的位置填上a[i]
            if (j != i - 1) {
                int k = i-1;
                int temp = a[i];
                for (; k > j; k--) {
                    a[k + 1] = a[k];
                }
                a[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[] a = {20, 40, 30, 10, 60, 50};

        System.out.printf("before sort:");
        for (int i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        insertionSort(a);

        System.out.printf("after  sort:");
        for (int i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
