/**
 * @author：hanzhigang
 * @Date : 2021/4/2 6:41 PM
 */
public class JVMMemory {
    public static void main(String[] args) {
        // JVM堆大小
        long initalMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        // JVM堆的最大内存
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms : "+initalMemory+"M");
        System.out.println("-Xmx : "+maxMemory+"M");

        System.out.println("系统内存大小 : "+initalMemory * 64 / 1024.0+"G");
        System.out.println("系统内存大小 : "+maxMemory * 4 / 1024.0+"G");
    }
}
