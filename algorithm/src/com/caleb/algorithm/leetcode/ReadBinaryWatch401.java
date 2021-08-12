package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。 每个 LED 代表一个 0 或
 * 1，最低位在右侧。 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * 小时不会以零开头： 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。 分钟必须由两位数组成，可能会以零开头： 例如，"10:2"
 * 是无效的时间，正确的写法应该是 "10:02" 。
 * 
 * @author:Caleb
 * @Date :2021-06-21 00:11:00
 */
public class ReadBinaryWatch401 {

	List<Integer> genString;
	// 记录回溯过程中的结果
	List<String> processedNums = new ArrayList<>();

	public List<String> readBinaryWatch(int turnedOn) {
		List<String> res = new ArrayList<>();
		int hourLEDNum = 0; // 小时LED亮的个数
		int minuteLEDNum = 0; // 分钟LED亮的个数
		while (hourLEDNum >= 0 && hourLEDNum <= 4) {
			// 0
			minuteLEDNum = turnedOn - hourLEDNum;
			if (minuteLEDNum >= 0 && minuteLEDNum <= 6) {
				int maxMinNum = 0; // 当前分钟LED最大能表示的数字
				int maxHourNum = 0; // 当前小时LED最大能表示的数字
				for (int i = 1; i <= minuteLEDNum; i++) {
					maxMinNum |= (1 << i);
				}
				for (int i = 1; i <= hourLEDNum; i++) {
					maxHourNum |= (1 << i);
				}
				// 表示的小时最小不能大于12，表示的分钟最小不能大于60
				if (maxHourNum < 12 && maxMinNum < 60) {
					genString = new ArrayList<>();
					binaryCountToString(0, hourLEDNum, 4, 11);
					List<Integer> hourInts = genString;
					genString = new ArrayList<>();
					binaryCountToString(0, minuteLEDNum, 6, 59);
					List<Integer> minInts = genString;
					for (Integer hourInt : hourInts) {
						for (Integer minInt : minInts) {
							res.add(hourInt + ":" + String.format("%02d", minInt));
						}
					}
				}
			}

			hourLEDNum++;
		}
		return res;
	}

	private void binaryCountToString(int start, int numCount, int maxNum, int maxV) {
		if (numCount == 0) {
			int finalNum = 0;
			for (String str : processedNums) {
				finalNum |= (1 << Integer.valueOf(str));
			}
			if (finalNum <= maxV) {
				genString.add(finalNum);
			}
			return;
		}
		for (int i = start; i < maxNum; i++) {
			if (numCount <= (maxNum - i)) {
				processedNums.add(i + "");
				binaryCountToString(i + 1, numCount - 1, maxNum, maxV);
				processedNums.remove(i + "");
			}
		}

	}

	// 枚举时分
	public List<String> readBinaryWatch1(int turnedOn) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 60; j++) {

				if(Integer.bitCount(i) + Integer.bitCount(j) == turnedOn){
					res.add(i+":"+String.format("%02d", j));
				}
			}
		}
		return res;
	}

	// 二进制枚举
	public List<String> readBinaryWatch2(int turnedOn) {
		List<String> res = new ArrayList<>();
		for(int i = 0;i<1024;i++){
			int h = i >> 6,m = i & 63;
			if(h < 12 && m < 60 && Integer.bitCount(i) == turnedOn){
				res.add(h+":"+String.format("%02d", m));	
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		ReadBinaryWatch401 r = new ReadBinaryWatch401();
		List<String> res = r.readBinaryWatch(2);
		for (String str : res) {
			System.out.println(str);
		}

	}

}