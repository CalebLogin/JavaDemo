package com.eric.offerdemo;

/**
 * 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 质因子，先是因子，然后因子还得是质数
 *
 * @author：hanzhigang
 * @Date : 2021/3/13 11:35 PM
 */
public class OfferDemo49 {

    /**
     * 动态规划的思想
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
//      初始化数组，第一个丑数是1
        int[] dp = new int[n];
        dp[0] = 1;
//      计算过程在 dp[a] * 2, dp[b] * 3, dp[c] * 5 之间找最小数
//      需要注意的是这里的a,b,c有排序的功能，如果不用a,b,c的话，会造成乱序，并且不知道需要用哪个值来*2，3，5
//      在用到a,b,c后就类似于三匹马赛马，可能a跑的快了一点，a就想让b赶一赶，这时候可能a就需要暂停一下
//      c如果在最后，a,b可能需要暂停一下
//      设置3个索引a, b, c，分别记录前几个数已经被乘2， 乘3， 乘5了。
//      比如a表示前(a-1)个数都已经乘过一次2了，下次应该乘2的是第a个数；
//      b表示前(b-1)个数都已经乘过一次3了，下次应该乘3的是第b个数；
//      c表示前(c-1)个数都已经乘过一次5了，下次应该乘5的是第c个数；
        int a = 0, b = 0, c = 0;  // a->2 b->3 c->5
        for (int i = 1; i < n;i++ ) {
//          找出三个数中的最小值放到dp数组中
            int temp = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);
            dp[i] = temp;
//          如果当前位置参与了运算，则将当前位置+1
            if(temp == dp[a] * 2) a++;
            if(temp == dp[b] * 3) b++;
            if(temp == dp[c] * 5) c++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        OfferDemo49 offerDemo49 = new OfferDemo49();
        System.out.println(offerDemo49.nthUglyNumber(10));
    }

}
