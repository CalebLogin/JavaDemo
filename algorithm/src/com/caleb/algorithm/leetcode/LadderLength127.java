package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 单词接龙 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 序列中第一个单词是
 * beginWord 。 序列中最后一个单词是 endWord 。 每次转换只能改变一个字母。 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列
 * 中的 单词数目 。 如果不存在这样的转换序列，返回 0。
 *
 * @author：hanzhigang
 * @Date : 2021/4/18 11:05 PM
 */
public class LadderLength127 {
    /**
     * 思路：广度优先遍历
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 记录当前单词是否已经访问过了
        Map<String, Boolean> visited = new HashMap<>();
        // 字典里所有的单词
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        // 切换单词的个数
        int count = 1;
        queue.offer(beginWord);
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                for (String word : genWordList(queue.poll())) {
                    // 如果当前单词存在字典里并且没有被访问过
                    if (wordSet.contains(word) && !visited.getOrDefault(word, false)) {
                        if (word.equals(endWord)) {
                            return count;
                        }
                        queue.offer(word);
                        visited.put(word, true);
                    }
                }
            }

        }
        return 0;

    }

    /**
     * 双向BFS优先遍历
     * 
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        // 单词字典，用来判断单词是否出现在字典中
        Set<String> wordSet = new HashSet<>(wordList);
        // 记录当前单词是否被访问过
        Set<String> visited = new HashSet<>();

        if (!wordList.contains(endWord)) {
            return 0;
        }

        // 用两个哈希来实现双向BFS，也可以用两个队列来实现
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);
        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 总是计算个数小的set，这样的话不容易扩散的太厉害，每次都扩散最小的个数
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            // 使用一个新的哈希来存储下一层的所有单词
            Set<String> nextLevelSet = new HashSet<>();
            step++;
            for (String word : beginVisited) {
                visited.add(word);
                for (String str : genWordList(word)) {
                    if (!visited.contains(str) && wordSet.contains(str)) {
                        if (endVisited.contains(str)) {
                            return step;
                        }
                        nextLevelSet.add(str);
                    }
                }
            }
            beginVisited = nextLevelSet;

        }
        return 0;

    }

    /**
     * 对于单词的每个位置，生成其他的字母
     * 
     * @param str
     * @return
     */
    private List<String> genWordList(String str) {
        List<String> wordList = new ArrayList<>();
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char temp = cs[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == temp) {
                    continue;
                }
                cs[i] = j;
                wordList.add(new String(cs));
            }
            cs[i] = temp;
        }
        return wordList;
    }

    public static void main(String[] args) {
        String str1 = "hit";
        String str2 = "cog";
        List<String> list = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        LadderLength127 ladderLength127 = new LadderLength127();
        System.out.println(ladderLength127.ladderLength1(str1, str2, list));
    }

}
