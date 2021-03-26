package com.eric.datastructure.sort;

/**
 * 选择排序，不稳定的排序算法
 * 时间复杂度O(n2),空间复杂度O(1)
 * @author：hanzhigang
 * @Date : 2021/3/8 1:15 PM
 */
public class SelectionSort {

    public static void selectionSort(int[] a){
//      数组的长度
        int size = a.length;
//      记录最小值的下标
        int min;
        for(int i =0;i<size;i++){
            min = i;
            for(int j = i;j<size;j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {80, 30, 60, 40, 20, 10, 50, 70};

        System.out.printf("before sort:");
        for (int i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        selectionSort(a);

        System.out.printf("after  sort:");
        for (int i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
