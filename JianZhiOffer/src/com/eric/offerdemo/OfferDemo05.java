package com.eric.offerdemo;

/**
 * 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * @author：hanzhigang
 * @Date : 2021/3/2 9:04 AM
 */
public class OfferDemo05 {

    public String replaceSpace(String s) {
        s = s.replaceAll(" ", "%2O");
        return s;
    }

    //  首先统计空格出现的次数，然后新建字符数组，进行遍历，出现空格用%20替换，时间复杂度O(n),空间复杂度O(n)
    public String replaceSpace1(String s) {

        int length = s.length();

//      记录空格出现的次数
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                cnt++;
            }
        }

//      新建字符数组，数组长度为字符串的长度加上空格出现次数的两倍
        char[] sc = new char[length + 2 * cnt];
//      sc的下标
        int j = 0;

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                sc[j++] = '%';
                sc[j++] = '2';
                sc[j++] = '0';
            } else {
                sc[j++] = s.charAt(i);
            }
        }

        return String.valueOf(sc);

    }

    public static void main(String[] args) {
        OfferDemo05 offerDemo05 = new OfferDemo05();
        System.out.println(offerDemo05.replaceSpace1("We are happy."));
    }

}
