package com.caleb.demo1;

/**
 * @author：hanzhigang
 * @Date : 2021/2/24 1:34 PM
 */
public class Kids extends ManKind {
    private int yearsOld;

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }
    public void printAge(){
        System.out.println("yeasOld: "+getYearsOld());
    }
}
