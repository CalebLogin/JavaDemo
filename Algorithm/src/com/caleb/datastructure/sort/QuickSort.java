package com.caleb.datastructure.sort;

/**
 * 快速排序，不稳定的排序
 * 空间复杂度O(nlogn),时间复杂度最坏O(N2),平均O(nlogn)
 *
 * @author：hanzhigang
 * @Date : 2021/3/8 12:12 PM
 */
public class QuickSort {

    public static void quickSort(int[] a) {
//      数组长度
        int size = a.length;
        helper(a, 0, size-1);
    }

    public static void helper(int[] a, int left, int right) {

//      左下标和右下标
        int l = left, r = right;
//      当左下标小于右下标时
        if (l < r) {
            int x = a[l];
            while (l < r) {
                while (l < r && a[r] > x) {
                    r--;
                }
                if (l < r) {
                    a[l++] = a[r];
                }
                while (l < r && a[l] < x) {
                    l++;
                }
                if (l < r) {
                    a[r--] = a[l];
                }
            }
            a[l] = x;
//          递归调用
            helper(a, left, l - 1);
            helper(a, l + 1, right);
        }
    }

    public static void main(String[] args) {

        int a[] = {30,40,60,10,20,50};

        System.out.printf("before sort:");
        for (int i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        quickSort(a);

        System.out.printf("after  sort:");
        for (int i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
