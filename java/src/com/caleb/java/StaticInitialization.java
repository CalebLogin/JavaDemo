package com.caleb.java;

/**
 * @author：hanzhigang
 * @Date : 2021/3/14 2:41 PM
 */

class Bowl {
    Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }
}

class Tableware {
    static Bowl bowl7 = new Bowl(7);
    static {
        System.out.println("Tableware静态代码块");
    }

    Tableware() {
        System.out.println("Tableware构造方法");
    }

    Bowl bowl = new Bowl(6);
}

class Table extends Tableware {
    {
        System.out.println("Table非静态代码块_1");
    }
    Bowl bowl5 = new Bowl(5);
    {
        System.out.println("Table非静态代码块_2");
    }
    static Bowl bowl1 = new Bowl(1);
    static {
        System.out.println("Table静态代码块");
    }

    Table() {
        System.out.println("Table构造方法");
    }

    static Bowl bowl2 = new Bowl(2);
}

class Cupboard extends Tableware {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    Cupboard() {
        System.out.println("Cupboard构造方法");
    }

    void otherMethod(int marker) {
        System.out.println("otherMethod(" + marker + ")");
    }
}

public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("main()");
        cupboard.otherMethod(1);
        // A b = new B();
        // b = new B();
        // Set<Integer> s = new HashSet<>();
        // s.add(1);
        // s.add(2);
        // s.add(3);
        // Iterator<Integer> i = s.iterator();
        // while(i.hasNext()){
        //     if(i.next() == 1){
        //         i.remove();
        //     }
        //     System.out.println(i.next());
        // }
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}

class A {
    static {
        System.out.println("a");
    }

    public A() {
        System.out.println("b");
    }
}

class B extends A {
    static{
        System.out.println("c");
    }

    public B(){
        System.out.println("d");
    }
}
