package com.caleb.algorithm.leetcode;

/**
 * 实现 strStr()
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。

 * @author：hanzhigang
 * @Date : 2021/4/5 8:12 PM
 */
public class StrStr28_ {
    /**
     * 利用双指针
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int commonLen = 1; // 找到needle中第一个与首字母重复的位置
        for(int i = 1;i<needle.length();i++){
            if(needle.charAt(i) == needle.charAt(0)){
                break;
            }else{
                commonLen++;
            }
        }

        int hStartIndex = 0,nStartIndex = 0; // 双指针，开始遍历haystack字符串，碰到相同的字符串，needle字符串开始同步遍历
        int temp;
        while(hStartIndex < haystack.length() && nStartIndex < needle.length()){
            temp = hStartIndex;
            while(hStartIndex < haystack.length() && nStartIndex < needle.length() && haystack.charAt(hStartIndex) == needle.charAt(nStartIndex)){
                hStartIndex++;
                nStartIndex++;
            }
            if(nStartIndex == needle.length()){
                break;
            }else if(nStartIndex <= commonLen){
                hStartIndex = ++temp;
            }else{
                hStartIndex = temp + commonLen;
            }
            nStartIndex = 0;
        }
        return nStartIndex == needle.length() ? hStartIndex - nStartIndex : -1;
    }

    public static void main(String[] args) {
        StrStr28_ strStr28 = new StrStr28_();
        System.out.println(strStr28.strStr("mississippi","pi"));
    }
}
