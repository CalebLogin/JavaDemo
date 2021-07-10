package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-07-10 09:27:33
 * 
 * 
 *       基于时间的键值存储 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 * 
 *       1. set(string key, string value, int timestamp)
 * 
 *       存储键 key、值 value，以及给定的时间戳 timestamp。 2. get(string key, int timestamp)
 * 
 *       返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <=
 *       timestamp。 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。 如果没有值，则返回空字符串（""）。
 * 
 */
public class TimeMap981 {
	public static void main(String[] args) {
		TimeMap t = new TimeMap();
		t.set("love", "high", 10);
		t.set("love", "low", 20);
		System.out.println(t.get("love", 5));
		System.out.println(t.get("love", 10));
		System.out.println(t.get("love", 15));
		System.out.println(t.get("love", 20));
		System.out.println(t.get("love", 25));
	}
}

class Versions {
	private int timestamp;
	private String value;

	public Versions(int timestamp, String value) {
		this.timestamp = timestamp;
		this.value = value;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

class TimeMap {

	// 类似版本链的形式
	private Map<String, List<Versions>> map;

	/** Initialize your data structure here. */
	public TimeMap() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		List<Versions> temp = map.getOrDefault(key, new ArrayList<>());
		temp.add(new Versions(timestamp, value));
		map.put(key, temp);
	}

	public String get(String key, int timestamp) {
		if (map.containsKey(key)) {
			List<Versions> temp = map.get(key);
			int left = 0, right = temp.size() - 1;
			if (timestamp >= temp.get(right).getTimestamp()) {
				return temp.get(right).getValue();
			}
			if (timestamp < temp.get(0).getTimestamp()) {
				return "";
			}
			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (temp.get(mid).getTimestamp() == timestamp) {
					return temp.get(mid).getValue();
				}
				if (temp.get(mid).getTimestamp() < timestamp) {
					right = mid - 1;
				} else {
					left = left + 1;
				}
			}
			if (right == -1) {
				return temp.get(left).getValue();
			}
			return temp.get(right).getValue();
		}
		return "";
	}
}