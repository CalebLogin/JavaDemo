package com.caleb.alorithm.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author：hanzhigang
 * @Date : 2021/5/30 12:06 AM
 */
public class Vector2DExample {
    public static void main(String[] args) {
        Vector2D iterator = new Vector2D(new int[][]{{1,2},{3},{4}});

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}

class Vector2D {
    int outer = 0;
    int inner = 0;
    int[][] v;
    public Vector2D(int[][] vec) {
        v = vec;
    }

//    寻找下一个有效的值
    public void advanceToNext(int[][] v){
        while(outer < v.length && inner == v[outer].length){
            outer++;
            inner = 0;
        }
    }

    public int next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return v[outer][inner];
    }

    public boolean hasNext() {
        advanceToNext(v);
        return outer < v.length;
    }
}
class Vector2D1 {
    List<Integer> list;
    int pos = 0;
    public Vector2D1(int[][] vec) {
        list = new ArrayList<>();
        for(int i = 0;i<vec.length;i++){
            for(int j = 0;j<vec[i].length;j++){
                list.add(vec[i][j]);
                pos++;
            }
        }
    }

    public int next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return list.get(pos++);
    }

    public boolean hasNext() {
        return pos < list.size();
    }
}
