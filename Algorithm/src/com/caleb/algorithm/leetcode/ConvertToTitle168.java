package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date  :2021-06-29 09:14:41
 */
public class ConvertToTitle168{

	public String convertToTitle(int columnNumber) {
		if(columnNumber <= 0){
			return null;
		}
		StringBuilder s = new StringBuilder();
        while(columnNumber != 0){
			columnNumber -- ;
			s.append((char)(columnNumber % 26+'A'));
			columnNumber /= 26;
		}
		return s.reverse().toString();
    }

	public static void main(String[] args) {
		ConvertToTitle168 c = new ConvertToTitle168();
		System.out.println(c.convertToTitle(52));
	}

}