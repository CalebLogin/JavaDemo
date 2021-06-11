import java.util.Scanner;

/**
 * @author：hanzhigang
 * @Date : 2021/4/12 7:04 PM
 */
public class Main4 {
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] res = new int[][]{{0, 1}, {1, 1}};
        int[][] temp;

        int count = 1;
        while (count < n) {
            temp = new int[res.length * 2][res.length * 2];
            int m = res.length;
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    temp[i][j + m] = res[i][j];
                    temp[i + m][j] = res[i][j];
                    temp[i + m][j + m] = res[i][j];
                }
            }
            res = temp;
            count++;
            sc.close();
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (j < res[0].length - 1) {
                    System.out.print(res[i][j] + " ");
                } else {
                    System.out.print(res[i][j]);
                }
            }
            System.out.println();
        }
    }
}
