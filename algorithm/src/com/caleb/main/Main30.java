package com.caleb.main;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-09-16 15:29:17
 * 
 * 
 *       originurl:http://career.huawei.com/reccampportal
 *
 *       secreturl:http://t.cn/219iAm
 * 
 **/
public class Main30 {

	/**
	 * 解密
	 * 
	 * @param str
	 * @return
	 */
	public static String decode(String str) {
		char[] charArray = str.toCharArray();
		int epoch = 5;
		for (int i = 0; i < charArray.length; i += epoch) {
			for (int j = i; j < i + epoch && j < charArray.length; j++) {
				charArray[j] = (char) (((charArray[j]) - 'a') % 26 - epoch + 'a');
			}
		}

		return new String(charArray);
	}

	/**
	 * 加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encode(String str) {
		char[] charArray = str.toCharArray();
		int epoch = 5;
		for (int i = 0; i < charArray.length; i += epoch) {
			for (int j = i; j < i + epoch && j < charArray.length; j++) {
				charArray[j] = (char) (((charArray[j]) - 'a') % 26 + epoch + 'a');
			}
		}

		return new String(charArray);
	}

	public static void main(String[] args) {
		String url = "http://career.huawei.com/reccampportal/";
		String[] params = url.split("\\/");
		StringBuilder st = new StringBuilder();
		Map<String,String> map = new HashMap<>();
		map.put("career.huawei.com", "t.cn");
		map.put("t.cn","career.huawei.com");
		for(int i = 0;i<3;i++){
			st.append(map.getOrDefault(params[i], params[i])+"/");
		}
		for (int i = params.length - 1; i >= 3; i--) {
			
			String preStr = params[i];
			String afterStr = encode(preStr);
			st.append(afterStr+"/");
		
		}

		String secreturl = st.toString();
		String[] params1 = secreturl.split("\\/");
		StringBuilder sts = new StringBuilder();
		for(int i = 0;i<3;i++){
			sts.append(map.getOrDefault(params1[i], params1[i])+"/");
		}
		for (int i = params.length - 1; i >= 3; i--) {
			String afterStr = params1[i];
			String reStr = decode(afterStr);
			sts.append(reStr+"/");
		}
		String resStr = sts.toString();
		System.out.println(secreturl);
		System.out.println(resStr);
	}

}