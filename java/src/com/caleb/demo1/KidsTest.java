package com.caleb.demo1;

/**
 * @author：hanzhigang
 * @Date : 2021/2/24 1:37 PM
 */
public class KidsTest {
    public static void main(String[] args) {
        Kids somekid = new Kids();
        somekid.setSex(1);
        somekid.setSalary(1000);
        somekid.setYearsOld(12);
        somekid.employeed();
        somekid.manOrWoman();
        somekid.printAge();
    }
}
