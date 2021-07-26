package com.caleb.pdd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date  :2021-07-25 19:26:50
 */
public class Main{

	public void alg3(){
		Scanner sc =new Scanner(System.in);
		int count = sc.nextInt();
		int[][] nums = new int[count][4];
		for(int i = 0;i<count;i++){
			for(int j = 0;j<4;j++){
				nums[i][j] = sc.nextInt();
			}
		}
		sc.close();
		Queue<Integer> queue1;
		for(int i = 0;i<count;i++){
			queue1 = new LinkedList<>();
			queue1.offer(nums[i][3]);
			boolean flag = false;
			while(!queue1.isEmpty()){
				int num = queue1.poll();
				int divideNum = num / nums[i][2];
				int subNum = num - nums[i][1];
				if((num % nums[i][2]) % nums[i][1] == 0  || (num % nums[i][1]) % nums[i][2] == 0){
					flag = true;
					break;
				}
				if(divideNum > nums[i][0] && divideNum > nums[i][2]){
					queue1.add(divideNum);
				}
				if(subNum > nums[i][0] && subNum > nums[i][1]){
					queue1.add(subNum);
				}
			}
			if(flag){
				System.out.println(1);
			}else{
				System.out.println(0);
			}
		}
	}


	public static void main(String[] args) {
		Main m = new Main();
		m.alg3();
	}

}