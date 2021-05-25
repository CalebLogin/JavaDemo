import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author：hanzhigang
 * @Date : 2021/4/19 7:12 PM
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int l = 0, r = l + k - 1;
        int index = l, sum = 0, max;
        for (int i = 0; i <= r; i++) {
            sum += a[i];
        }
        max = sum;

        if (k == n) {
            System.out.println(sum);
        }

        for (int i = 1; i < n; i++) {
            sum += a[(++r) % n] - a[(l++) % n];
            if(max < sum){
                index = l % n;
                max = sum;
            }
        }
        System.out.println(index+1);
    }
}
