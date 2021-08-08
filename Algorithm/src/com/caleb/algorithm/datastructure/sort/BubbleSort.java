package com.caleb.algorithm.datastructure.sort;

/**
 * 冒泡排序,稳定的排序算法
 * 空间复杂度O(1),时间复杂度O(n2),O(n)
 *
 * @author：hanzhigang
 * @Date : 2021/3/8 10:56 AM
 */
public class BubbleSort {

//  冒泡排序
    public static void bubbleSort(int[] a) {
//      标记是否在一次循环中发生过交换
        boolean flag = false;
//      数组的长度
        int size = a.length;
        for (int i = size - 1; i > 0; i--) {
//          新的循环开始，flag置为false
            flag = false;
            for (int j = 0; j < i; j++) {
//              如果前面数值大于后面，进行交换
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
//                  发生过数值交换，flag置为true
                    flag = true;
                }
            }
//          如果没有发生过交换操作，说明数组已经有序，直接跳出循环
            if(!flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50};

        System.out.printf("before sort:");
        for (int i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        bubbleSort(a);

        System.out.printf("after  sort:");
        for (int i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
