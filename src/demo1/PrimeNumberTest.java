package demo1;

/**
 *
 * 打印质数
 * @author：hanzhigang
 * @Date : 2021/2/24 10:10 AM
 */
public class PrimeNumberTest {
    public static void main(String[] args) {

//      最小质数为2
        int j = 2;
        for (int i = 2; i <= 100; i++) {
            for (j = 2; j < i/2; j++) {
                if(i % j == 0){
                    break;
                }
            }
            if(j>=i/2){
                System.out.println(i);
            }
        }
    }
}
