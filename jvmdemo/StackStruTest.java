/**
 *
 * 栈寄存器操作数demo
 * 跨平台性、指令集小、指令多，执行性能比寄存器差
 *
 * 为什么不将结构更换为基于寄存器的架构
 * answer：基于栈寄存器的优点
 *
 * @author：hanzhigang
 * @Date : 2021/2/26 5:34 PM
 */
public class StackStruTest {

    public static void main(String[] args) {
        int i = 2;
        int j = 3;
        int k = i + j;

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hello");

    }

}
