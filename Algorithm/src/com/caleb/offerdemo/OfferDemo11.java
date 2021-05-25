package com.caleb.offerdemo;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 解题思路，采用二分法对数组进行拆分
 *
 * @author：hanzhigang
 * @Date : 2021/3/2 1:59 PM
 */
public class OfferDemo11 {

    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length-1;
        while(low < high){
//          取中间值
            int j = low + (high-low)/2;
//          如果中间值小于number[high]，说明最小值在左边
//          如果中间值大于number[high]，说明最小值在右边
//          如果中间值等于number[high]，即使最小值等于number[high]，但是会有一个number[m]作为替代，所以将high-1
            if(numbers[j]<numbers[high]){
                high = j;

            }else if(numbers[j]> numbers[high]){
                low = j+1;
            }else{
                high = high-1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,2,2,0,1};
        OfferDemo11 offerDemo11 = new OfferDemo11();
        System.out.println(offerDemo11.minArray(a));
    }

}
