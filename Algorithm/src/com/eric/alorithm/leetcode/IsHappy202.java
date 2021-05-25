package com.eric.alorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * 输入：19
 * 输出：true
 * 解释：
 * 1**2 + 9**2 = 82
 * 8**2 + 2**2 = 68
 * 6**2 + 8**2 = 100
 * 1**2 + 0**2 + 0**2 = 1
 *
 * @author：hanzhigang
 * @Date : 2021/5/13 12:03 AM
 */
public class IsHappy202 {

    /**
     * 哈希
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int num = n;
        while (!set.contains(num) && num != 1) {
            set.add(num);
            int t = 0;
            while (num != 0) {
                t += Math.pow(num % 10, 2);
                num /= 10;
            }
            num = t;
        }
        return num == 1;
    }

    public int getNext(int n){
        int t = 0;
        while (n != 0) {
            t += Math.pow(n % 10, 2);
            n /= 10;
        }
        return t;
    }

    public boolean isHappy1(int n){
        int slow = n;
        int fast = getNext(n);
        while(fast != 1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    public static void main(String[] args) {
        IsHappy202 isHappy202 = new IsHappy202();
        System.out.println(isHappy202.isHappy(2));
    }
}
