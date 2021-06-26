package com.caleb.java.desginmode.singleton.student;

/**
 * @Date 2021/6/21 9:58
 * 枚举用在switch中
 */
public class Demo1 {
    public static void main(String[] args) {
        Week week=Week.MONDAY;
        switch (week){
            case SUNDAY:
                System.out.println("吃海鲜");
                break;
            case MONDAY:
                System.out.println("吃小龙虾");
                break;
            case TUESDAY:
                System.out.println("鲍鱼");
                break;
            case WEDNESDAY:
                System.out.println("麻辣烫");
                break;
            case THURSDAY:
                System.out.println("热干面");
                break;
            case FRIDAY:
                System.out.println("包子");
                break;
            case SATURDAY:
                System.out.println("烧烤");
                break;
            default:
                System.out.println("大盘鸡");
                break;
        }
    }
}
