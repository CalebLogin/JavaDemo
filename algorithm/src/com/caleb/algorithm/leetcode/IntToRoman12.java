package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-06-18 23:20:33
 */
public class IntToRoman12 {

	public String intToRoman(int num) {
		StringBuffer s = new StringBuffer();
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
		int[] nums = new int[4];
		int len = 0;
		while (num / 10 != 0) {
			nums[len] = num % 10;
			len++;
			num /= 10;
		}
		nums[len] = num;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 0) {
				continue;
			}
			int floorNum = (int) Math.pow(10, i);
			int currNum = (int) (nums[i] *floorNum);
			int nineNum = (int) (9 * floorNum);
			int midNum = (int) (5 * floorNum);
			int fourNum = (int) (4 * floorNum);
			
			if (currNum == midNum) {
				s.append(map.get(currNum));
			} else if (currNum == nineNum) {
				s.append(map.get(nineNum));
			} else if (currNum == fourNum) {
				s.append(map.get(fourNum));
			} else if (currNum >= floorNum && currNum < fourNum) {
				int count = currNum / floorNum;
				for(int j = 0;j<count;j++){
					s.append(map.get(floorNum));
				}
			}else{
				s.append(map.get(midNum));
				int count = (currNum-midNum) / floorNum;
				for(int j = 0;j<count;j++){
					s.append(map.get(floorNum));
				}
			}

		}
		return s.toString();

	}

	/**
	 * 硬编码数字
	 * @param num
	 * @return
	 */
	public String intToRoman1(int num){
		String[] thousands = {"", "M", "MM", "MMM"};
		String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }


	public static void main(String[] args) {
		IntToRoman12 intToRoman12 = new IntToRoman12();
		System.out.println(intToRoman12.intToRoman(1994));
	}

}
