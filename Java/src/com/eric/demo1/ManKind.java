package com.eric.demo1;

/**
 * @author：hanzhigang
 * @Date : 2021/2/24 1:33 PM
 */
public class ManKind {
    private int sex,salary;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void manOrWoman(){
        if(getSex()==0){
            System.out.println("man");
        }else{
            System.out.println("woman");
        }
    }
    public void employeed(){
        if(getSalary()==0){
            System.out.println("no job");
        }else{
            System.out.println("has a jobInrruEx");
        }
    }
}
