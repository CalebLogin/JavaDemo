package com.caleb.main;

/**
 * @author:Caleb
 * @Date :2021-09-16 16:09:00
 */
public class Main31 {

	public static String encode(String str) {
		int v = (str.hashCode() << 4) / 127;
		int mod = (str.hashCode() << 4) % 127;
		
		return null;
	}

	public static String decode(String str) {
		int v = (str.hashCode() << 4) / 127;
		int mod = (str.hashCode() << 4) % 127;
		return null;
	}

	public static void main(String[] args) {
		encode("sr");
	}

}