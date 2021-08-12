package com.caleb.algorithm.offerdemo;

/**
 * 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 * 	&	按位与
 * 	^	按位异或
 * 	|	按位或
 *
 * 	原码，反码，补码知识
 *
 * @author：hanzhigang
 * @Date : 2021/3/15 11:07 PM
 */
public class OfferDemo56_I {

    /**
     * 思路：将数组进行一次异或操作，得到a异或b的值c。
     * 然后任取以为c中二进制为1的进位，对数组进行分组，两个不相同的数就会被分到了不同组中。
     * 接着对两个分组进行异或，就可以得到两个不相同的值
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
//      定义返回结果数组
        int[] res = new int[2];
        int add = 0;
        for(Integer num:nums){
            System.out.print(add+" ");
            add ^= num;
        }
        System.out.println("-------------------");

//      得到最低位是1的位置
        int lowbit = add & (-add);
        System.out.println(lowbit);
        System.out.println("--------------------");
        for(Integer i:nums){
            if((i & lowbit)==0){
                res[0] ^= i;
            }else{
                res[1] ^=i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = new int[]{1,2,10,4,1,4,3,3};
        singleNumbers(res);
    }
}
