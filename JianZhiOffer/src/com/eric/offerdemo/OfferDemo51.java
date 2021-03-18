package com.eric.offerdemo;

/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 思路1：利用归并排序，在进行合并的时候，计算与右数组的大小值，左数组中的某个值与右数组中的数组成逆序对的个数等于右数组指针的偏移量。
 *
 * @author：hanzhigang
 * @Date : 2021/3/18 11:17 PM
 */
public class OfferDemo51 {
    int count = 0;
    public int reversePairs(int[] nums) {
        // 在归并排序的过程中不断的计算逆序对
        mergeSortUpToDown(nums,0,nums.length-1);
        //  返回结果
        return count;
    }

    // 对两个相邻的数组进行合并，并计算逆序对的个数
    public void merge(int[] a, int start, int mid, int end) {
        int[] res = new int[end - start + 1];
        int left = start, right = mid+1;
        int k = 0;
        while (left <= mid && right <= end) {
            if (a[left] > a[right]) {
                res[k++] = a[right++];
            }else{  // 如果左边数组加入结果数组，则通过right-mid-1来计算左边数组当前的数组对于右边数组的偏移量。
                // 如果右边数组仍在原位，则表示右边数组没有比该数小的值，偏移量为0，不存在逆序对。
                count += right-mid-1;
                res[k++] = a[left++];
            }
        }
        while(left<=mid){   // 如果左边数组没有遍历完成，说明右边数组对于左边数组剩余的数来说都是逆序对，逆序对个数位right-mid-1也就是end-mid
            count += right-mid-1;
            res[k++] = a[left++];
        }
        while(right <= end){
            res[k++] = a[right++];
        }
        for(int i = 0;i<res.length;i++){
            a[i+start] = res[i];
        }
    }

    public void mergeSortUpToDown(int[] nums, int start, int end) {
        // 如果start 大于等于 end返回
        if (start >= end) return;
        // 取中间值
        int mid = start + (end - start) / 2;
        // 归并左数组
        mergeSortUpToDown(nums, start, mid);
        // 归并右数组
        mergeSortUpToDown(nums, mid + 1, end);
        // 合并两个已经排好序的子数组
        merge(nums, start, mid, end);
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,5,6,7};
        OfferDemo51 offerDemo51 = new OfferDemo51();
        System.out.println(offerDemo51.reversePairs(a));
    }

}
