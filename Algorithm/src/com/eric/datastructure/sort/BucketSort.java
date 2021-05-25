package com.eric.datastructure.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 桶排序
 * 将数组分配到有限数量的桶子里，
 *
 * @author：hanzhigang
 * @Date : 2021/3/8 3:50 PM
 */
public class BucketSort {
    public static void bucketSort(int[] a) {


        int size = a.length;    // 数组的大小
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;    // 记录最大值和最小值
        int bucketSize;     //记录桶的个数
        int aIndex = 0;       // 对a数组进行重新遍历时用到的索引
        List<List<Integer>> buckets = new ArrayList<>();   //新建桶


//      找到最大值和最小值
        for (int i = 0; i < size; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }

//      根据相应的映射规则得到桶的数量
        bucketSize = max / 10 - min / 10 + 1;

//      新建桶
        for (int i = 0; i < bucketSize; i++) {
            buckets.add(new ArrayList<Integer>());
        }

//      将数组中待排序的元素根据映射规则映射到对应的桶中
        for (int i = 0; i < size; i++) {
            int index = a[i] / 10 - min / 10;
            buckets.get(index).add(a[i]);
        }

//      对每个桶中的元素进行排序，并返回给原数组a
        for (int i = 0; i < bucketSize; i++) {
//          每个桶的大小
            int bSize = buckets.get(i).size();
            if (bSize == 0) {
                continue;
            }
//          将List<Integer> 转换为int[]
            int[] list = buckets.get(i).stream().mapToInt(Integer::intValue).toArray();
//          对桶中元素进行排序
            QuickSort.quickSort(list);
            for (int j = 0; j < list.length; j++) {
                a[aIndex++] = list[j];
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {30,40,60,10,20,50,10000};

        System.out.printf("before sort:");
        for (int i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        bucketSort(a);

        System.out.printf("after  sort:");
        for (int i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
