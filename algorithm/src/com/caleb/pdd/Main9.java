package com.caleb.pdd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main9 {


	public void alg1(){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[][] nums = new int[count][2];
		for(int i = 0;i<count;i++){
			nums[i][0] = sc.nextInt();
			nums[i][1] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(nums,new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
			
		});
		for(int i = 0;i<count;i++){
			int preI = nums[i][0];
			int nextI = nums[i][1];
			for(int j = i+1;j<count;j++){
				if(preI <= nums[j][0] && nextI >= nums[j][1]){
					System.out.println(true);
					return;
				}
			}
		}
		System.out.println(false);

	}

	public static void main(String[] args) {
		Main9 m = new Main9();
		m.alg1();
	}
	
}
