package com.caleb.pdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-07-25 20:31:06
 */
public class Main4 {

	public void alg4() {
		Scanner sc = new Scanner(System.in);
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			if (num != 0) {
				for (int j = 0; j < num; j++) {
					nums.add(i);
				}
			}
		}
		sc.close();
		Collections.sort(nums, new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		});
		long num1 = 0;
		long num2 = 0;
		for(int i = 0;i<nums.size();i++){
			num1 =num1 * 10 + nums.get(i++);
			if(i < nums.size()){
				num2 = num2 * 10 + nums.get(i);
			}
		}
		System.out.println(num1 * num2);
	}

	public static void main(String[] args) {
		Main4 m = new Main4();
		m.alg4();
	}

}