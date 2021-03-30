package com.eric.alorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * @author：hanzhigang
 * @Date : 2021/3/25 8:30 PM
 */
public class LRUCache146 {

}

class LRUCache {

    Map<Integer, Integer> map;
    int[] res;
    int size = -1;

    public LRUCache(int capacity) {
        res = new int[capacity];
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int i;
            for(i=0;i<=size && res[i] != key;i++);
            for(int j = i;j<size;j++){
                res[j] = res[j+1];
            }
            res[size] = key;
        }
        return map.getOrDefault(key,-1);


    }
    public void put(int key, int value) {
        System.out.println();
        if(map.containsKey(key)){
            map.put(key,value);
            get(key);
        }else{
            if(size == res.length-1){
                int last = res[0];
                for(int i = 0;i<size;i++){
                    res[i] = res[i+1];
                }
                res[size] = key;
                map.remove(last);
            }else{
                res[++size] = key;
            }
            map.put(key,value);
        }
    }
}
