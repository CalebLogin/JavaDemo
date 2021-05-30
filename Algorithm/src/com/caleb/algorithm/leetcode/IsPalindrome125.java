package com.caleb.algorithm.leetcode;

/**
 * @author：hanzhigang
 * @Date : 2021/4/18 10:29 PM
 */
public class IsPalindrome125 {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char lc = Character.toLowerCase(s.charAt(l));
            char lr = Character.toLowerCase(s.charAt(r));
            if (((lc >= '0' && lc <= '9') || (lc >= 'a' && lc <= 'z')) && ((lr >= '0' && lr <= '9') || (lr >= 'a' && lr <= 'z'))) {
                if (lc != lr) {
                    return false;
                }
                l++;
                r--;
            } else {
                if ((lc < '0' || lc > '9') && (lc < 'a' || lc > 'z')) {
                    l++;
                }
                if ((lr < '0' || lr > '9') && (lr < 'a' || lr > 'z')) {
                    r--;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome125 isPalindrome125 = new IsPalindrome125();
        System.out.println(isPalindrome125.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
