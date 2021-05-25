package com.caleb.alorithm.leetcode;

/**
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 思路1：堆排序
 * 思路2：冒泡排序：时间复杂度太高
 * 思路3：快速排序
 *
 * @author：hanzhigang
 * @Date : 2021/3/25 5:12 PM
 */
public class FindKthLargest215 {

    /**
     * 利用快排的思想查找第K个最大的元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        return quickSort(nums, 0, nums.length-1, k);

    }

    public int quickSort(int[] nums, int startIndex, int endIndex, int k) {
        int start = startIndex, end = endIndex;
        if(start < end){
            int compare = nums[start];
            while (start < end) {
                while (start < end && nums[end] > compare) {
                    --end;
                }
                if (start < end) {
                    nums[start++] = nums[end];
                }
                while (start < end && nums[start] < compare) {
                    ++start;
                }
                if (start < end) {
                    nums[end--] = nums[start];
                }
            }
            nums[start] = compare;
        }


        // 如果当前元素位于倒数第K个，说明该数即是结果
        if (nums.length - start == k) {
            return nums[start];
        }else if(nums.length - start > k){  // 如果当前元素位于倒数第K个之前，则查找后面的
            return quickSort(nums,start+1,endIndex,k);
        }else{  // 否则查找前面的
            return quickSort(nums,startIndex,start-1,k);
        }
    }

    public static void main(String[] args) {
        FindKthLargest215 findKthLargest215 = new FindKthLargest215();
        System.out.println(findKthLargest215.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},9));
    }



}
