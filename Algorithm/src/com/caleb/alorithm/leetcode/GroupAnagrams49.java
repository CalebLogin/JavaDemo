package com.eric.alorithm.leetcode;

import java.util.*;

/**
 * 字母异位词分组
 *
 * @author：hanzhigang
 * @Date : 2021/4/7 8:38 PM
 */
public class GroupAnagrams49 {

    /**
     * 排序
     * 思想就是把字符串按照顺序重新排列起来
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars); // 排序
            String strNew = new String(chars);  // 组合成新的字符串
            List<String> list = hashMap.getOrDefault(strNew, new ArrayList<>());
            list.add(str);
            hashMap.put(strNew, list);
        }
        return new ArrayList<>(hashMap.values());
    }

    /**
     * 计数
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            int[] ints = new int[26];
            for (int i = 0; i < str.length(); i++) {
                ints[str.charAt(i) - 'a'] += 1;
            }
            StringBuilder stringBuffer = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if(ints[i] != 0){
                    stringBuffer.append(ints[i]);
                    stringBuffer.append((char)(i+'a'));
                }

            }
            List<String> list = hashMap.getOrDefault(stringBuffer.toString(), new ArrayList<>());
            list.add(str);
            hashMap.put(stringBuffer.toString(), list);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
        List<List<String>> res = groupAnagrams49.groupAnagrams1(strs);
        for (List<String> list : res) {
            for (String str : list) {
                System.out.print(str + ",");
            }
            System.out.println();
        }
    }
}
