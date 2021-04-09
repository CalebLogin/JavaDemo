import java.util.*;

/**
 * @author：hanzhigang
 * @Date : 2021/4/4 10:22 AM
 */
public class Main1 {

    public static void main(String[] args) {
        Main1 main = new Main1();
        System.out.println(main.fx());
    }


    public static void stu() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {

            }
        }

    }


    public int TotalCandy() {
        Scanner scanner = new Scanner(System.in);
        int[] a, b;
        int aSize = scanner.nextInt();
        int bSize = scanner.nextInt();
        a = new int[aSize];
        b = new int[bSize];
//        String strA = scanner.next();
//        String[] aTemp = scanner.next().split(",");
//        String[] bTemp = scanner.next().split(",");
        for (int i = 0; i < aSize; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < bSize; i++) {
            b[i] = scanner.nextInt();
        }

        return maxSize(a) + maxSize(b);

    }

    public int maxSize(int[] a) {
        int size = 0, maxSize = 0;
        for (int i = 0; i < a.length; i++) {
            size += a[i];
            maxSize = Math.max(size, maxSize);
        }
        return maxSize;
    }


    public int fx() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        int[] res;
        int[] kNum;
        int size = 0;

        kNum = subKNum(k);
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            res = subNum(nums[i]);
            size += resSize(res, kNum);
        }
        return size;
    }

    public int[] subKNum(int k) {
        int size = 0;
        int[] kNum;
        int temp = k;
        while (temp != 0) {
            size++;
            temp /= 10;
        }
        kNum = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            kNum[i] = k % 10;
            k /= 10;
        }
        return kNum;
    }

    // 获得当前字符串的不高兴度
    public int resSize(int[] res, int[] k) {
        int size = 0;
        for (int i = 0; i <= res.length - k.length; i++) {
            int j = 0;
            for (; j < k.length && res[i + j] == k[j]; j++) {

            }
            if (j == k.length) {
                size++;
            }
        }
        return size;
    }


    // 获得所有因子
    public int[] subNum(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public int subString() {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        List<List<Integer>> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();   // 记录每个字符出现的位置
        int start = 0, end = 0;
        while (end < s.length()) {

        }
        return 0;
    }

    public void helper(char[] c, int step) {

    }

}
