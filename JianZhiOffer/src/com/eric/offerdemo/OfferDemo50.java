package com.eric.offerdemo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母
 * @author：hanzhigang
 * @Date : 2021/3/14 9:55 PM
 */
public class OfferDemo50 {
    public char firstUniqChar(String s) {
//      记录每个字符出现的次数,使用有序Hash表
        LinkedHashMap<Character,Boolean> map = new LinkedHashMap<>();
//      将字符是否已经在map中存在存入hash
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),!map.containsKey(s.charAt(i)));
        }
        for(Map.Entry<Character,Boolean> d:map.entrySet()){
            if(d.getValue()) return d.getKey();
        }

        return ' ';
    }
    public char firstUniqChar1(String s) {
        int[] res = new int[256];
        char[] chars = s.toCharArray();
        for(Character c:chars){
            res[c]++;
        }
        for(Character c:chars){
            if(res[c] == 1){
                return c;
            }
        }

        return ' ';
    }
}
