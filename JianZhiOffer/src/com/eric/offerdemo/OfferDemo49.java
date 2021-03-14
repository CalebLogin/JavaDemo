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
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int num = 2;
        int count = 1;
        while (count < n) {
            if (!isPrim(num) || num == 2 || num == 3 || num == 5) {
                int tmp = num;
                while (tmp != 1) {
                    if (tmp % 2 == 0) tmp /= 2;
                    else if (tmp % 3 == 0) tmp /= 3;
                    else if (tmp % 5 == 0) tmp /= 5;
                    else break;
                }
                if (tmp == 1) {
                    count++;
                }
            }
            num++;
        }
        return --num;
    }

    private boolean isPrim(int num) {
        int i = 2;
        if (num == 1) {
            return true;
        }
        while (i <= num / 2) {
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        OfferDemo49 offerDemo49 = new OfferDemo49();
        System.out.println(offerDemo49.nthUglyNumber(10));
    }

}
