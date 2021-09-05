package com.caleb.rongyao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-04 19:11:55
 */
public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String com = sc.nextLine();
		String[] commands = com.split("\\|");
		List<String> list = new ArrayList<>();
		for (int i = 0; i < commands.length; i++) {
			String command = commands[i];
			String[] ags = command.split("\\s+", 3);
			if (ags.length < 2 || (i == 0 && !"i".equals(ags[1])) || Integer.valueOf(ags[0]) > i + 1) {
				System.out.println("error");
				continue;
			}
			int line = Integer.parseInt(ags[0]);
			switch (ags[1]) {
				case "i":
					list.add(line - 1, ags[2]);
					break;
				case "a":
					list.add(line, ags[2]);
					break;
				case "r":
					list.set(line - 1, ags[2]);
					break;
				case "d":
					list.remove(line - 1);
					break;
				default:
					System.out.println("error");
					return;
			}
		}
		for(String str : list){
			System.out.println(str);
		}
	}

}