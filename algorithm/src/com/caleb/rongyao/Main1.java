package com.caleb.rongyao;

import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-04 19:05:21
 */
public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String cond = sc.nextLine();
		sc.close();
		String[] contexts = input.split(" ");
		int pos = Integer.parseInt(cond.split(" ")[0]);
		int len = Integer.parseInt(cond.split(" ")[1]);
		StringBuffer stringBuffer = new StringBuffer();
        int count = 0;
		for (int i = pos - 1; i <= len + pos && i < contexts.length; i++) {
			stringBuffer.append(contexts[i]);
            count++;
			if(count == 20){
                System.out.println(stringBuffer.toString());
                stringBuffer = new StringBuffer();
                count = 0;
            }else {
                stringBuffer.append(";");
            }
		}
		String res = stringBuffer.toString();
		if (res.charAt(res.length() - 1) == ';') {
			res = res.substring(0, res.length()-1);
		}
		System.out.println(res);
	}

}