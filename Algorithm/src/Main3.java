import java.util.Scanner;

/**
 * @author：hanzhigang
 * @Date : 2021/4/9 7:45 PM
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int k = in.nextInt();
        int[] res = new int[m];
        int[][] temp = new int[k][2];
        for (int i = 0; i < k; i++) {
            temp[i][0] = in.nextInt();
            temp[i][1] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            res[i] = i+1;
        }
        for (int i = 0; i < temp.length; i++) {
            int l = temp[i][0] - 1;
            int r = temp[i][1] - 1;
            if(l != r){
                swap(res,l,r);
            }

        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
        in.close();
    }

    public static void swap(int[] res, int l, int r) {
        while (l < r) {
            int temp = res[l];
            res[l] = res[r];
            res[r] = temp;
            l++;
            r--;
        }
    }
}
