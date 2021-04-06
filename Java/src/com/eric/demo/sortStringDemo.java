package com.eric.demo;

/**
 * @author：hanzhigang
 * @Date : 2020/11/30 11:27 PM
 */
public class sortStringDemo {
    public String sortString(String s){
        if(s.length()==1){
            return s;
        }
        StringBuffer result = new StringBuffer();
        int[] sChar = new int[26];
        for(char c:s.toCharArray()){
            sChar[c-'a']++;
        }

        while(result.length() < s.length()){
            for(int i=0;i<sChar.length;i++){
                if(sChar[i]!=0){
                    sChar[i]--;
                    result.append((char)(97+i));
                }
            }
            for(int i=sChar.length-1;i>=0;i--){
                if(sChar[i]!=0){
                    sChar[i]--;
                    result.append((char)(97+i));
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new sortStringDemo().sortString("abcdfdgdgdg"));
    }
}
