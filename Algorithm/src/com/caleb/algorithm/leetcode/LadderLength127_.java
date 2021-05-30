package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单词接龙
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。
 * 如果不存在这样的转换序列，返回 0。
 *
 * @author：hanzhigang
 * @Date : 2021/4/18 11:05 PM
 */
public class LadderLength127_ {
    int min = Integer.MAX_VALUE;
    int[][] res;
    List<String> wordList1;
    String begin;
    String end;

    /**
     * 思路：先进行预处理，再进行回溯算法
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        this.wordList1 = wordList;
        this.begin = beginWord;
        this.end = endWord;
        // 将wordList中的endWord换到最后的位置，1是方便判断存不存在endWord，2是便于后面的优化
        for (int i = 0; i < wordList1.size(); i++) {
            if (wordList1.get(i).equals(endWord)) {
                wordList1.set(i, wordList1.get(wordList1.size() - 1));
                wordList1.set(wordList1.size() - 1, endWord);
                break;
            }
        }
        // 如果wordList中不存在endWord，返回0
        if (!wordList1.get(wordList1.size() - 1).equals(endWord)) {
            return 0;
        }
        // 进行优化，建立字符相差1个的关系数组
        this.res = new int[wordList.size()][wordList.size()];
        for (int i = 0; i < wordList1.size(); i++) {
            Arrays.fill(res[i], -1);
            int count = 0;
            for (int j = 0; j < wordList1.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (ladderLengthHelper(wordList1.get(i), wordList1.get(j))) {
                    res[i][count++] = j;
                }
            }
        }

        // 挨个遍历wordList中的元素，找到关系路径，并关系路径长度与最小值比较
        for (int i = 0; i < wordList1.size(); i++) {
            if (ladderLengthHelper(beginWord, wordList1.get(i))) {
                helper(i, 0);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private void helper(int index, int depth) {
        // 如果存在一条路径，取当前路径长度与最小值结果的最小值
        if (wordList1.get(index).equals(end)) {
            min = Math.min(min, depth + 2);
            return;
        }
        // 如果路径长度超过了wordList的长度，说明重复或者不存在，return
        if (depth > wordList1.size() - 1) {
            return;
        }
        for (int i = 0; i < res[index].length && res[index][i] != -1; i++) {
            helper(res[index][i], depth + 1);
        }
    }

    private boolean ladderLengthHelper(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        String str1 = "hit";
        String str2 = "cog";
        List<String> list = new ArrayList<>(Arrays.asList("hot","dot","lot","cog"));
        LadderLength127_ ladderLength127 = new LadderLength127_();
        System.out.println(ladderLength127.ladderLength(str1, str2, list));
    }

}
