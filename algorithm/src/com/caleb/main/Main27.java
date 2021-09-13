package com.caleb.main;

import java.util.Scanner;

public class Main27 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		if(str1.indexOf(str2) != -1){
			System.out.println(true);
		}else{
			System.out.println(false);
		}
		
	}

	public void isSubsequence() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        System.out.println(i == n);
    }



}