package com.caleb.offerdemo;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 除0之外存在两张一样的，不是顺子
 * 每个数字之间的差值是否与0的个数符合，符合是顺子，不符合不是顺子
 * 存在10JQKA这种情况，怎么考虑合适
 *
 * @author：hanzhigang
 * @Date : 2021/3/20 8:58 PM
 */
public class OfferDemo61_ {

    public boolean isStraight(int[] nums) {
        // 对数组进行排序
        Arrays.sort(nums);
        int sub = 0, count = 0;  // 数字与数字之间的差值，0的个数
        // 如果两值相等，且不为0时，不是顺子
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] == nums[i] && nums[i] != 0) {
                return false;
            }
            if (nums[i] != 0) {
                sub = nums[i + 1] - nums[i];
            }else{
                count ++;
            }
        }
        if(nums[4] == 13){
            if(nums[0] == 0 && nums[1] == 10){
                return true;
            }
//            if(nums[0] == 0 && nums[1] == 0 )
        }
        if(sub-5+count == count){
            return true;
        }

        return false;
    }
}
