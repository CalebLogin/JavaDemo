package demo;

/**
 * @author：hanzhigang
 * @Date : 2020/11/22 11:17 AM
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {

        char[] indexs = new char[26];
        for (char c : s.toCharArray()){
            indexs[c-'a']++;
        }
        for (char c : t.toCharArray()){
            indexs[c-'a']--;
        }
        for(int i=0;i<indexs.length;i++){
            if(indexs[i] != 0){
                return false;
            }
        }
        return true;
    }
}
