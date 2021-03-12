package demo;
/**
 * @author：hanzhigang
 * @Date : 2020/6/20 11:21 PM
 */

class Solution {
    public String convert(String s, int numRows) {
        int len = s.length()/(2 * numRows - 2) * (numRows-1);
        if (s.length() % (2 * numRows - 2) != 0){
            len +=(numRows-1);
        }
        char[][] stringbuffer = new char[numRows][len];
        int position = 0;
        for(int j=0;j<len;j++){
            for(int i=0;i<numRows;i++){
                if(position == s.length()){
                    stringbuffer[i][j] = '0';
                    continue;
                }
                if(j % (numRows-1) != 0){
                    if(i == numRows - 1 - j%(numRows-1)){
                        stringbuffer[i][j] = s.charAt(position);
                        position++;
                    }else{
                        stringbuffer[i][j] = '0';
                    }
                }else{
                    stringbuffer[i][j] = s.charAt(position);
                    position++;
                }


            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<len;j++){
                System.out.print(stringbuffer[i][j]);
                if(stringbuffer[i][j] != '0'){
                    stringBuffer.append(stringbuffer[i][j]);
                }
            }
            System.out.println("");
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert(
                "PAYPALISHIRING", 3));
    }
}
