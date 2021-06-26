/**
 * @author：hanzhigang
 * @Date : 2021/4/2 11:08 AM
 */
//public class Main {
//
//
//    public Main(int m) {
//        this.m = m;
//    }
//
//    private int m;
//
//    public int inc() {
//        return m + 1;
//    }
//}

public class TestCode {
    public int foo() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }


    }
}
