package com.eric.demo;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author：hanzhigang
 * @Date : 2021/1/13 8:28 PM
 */
public class ConflictHashCodeTest {
    private static class Person{
        int age;
        String name;

        /**
         * 重写equals
         * @param o
         * @return
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            int nameHash = name.toUpperCase().hashCode();
            return nameHash ^ age;
        }

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person(100,"eee");
        Person p2 = new Person(100,"eee");
        Person p3 = new Person(200,"aaa");
        Person p4 = new Person(100,"EEE");

        HashSet set = new HashSet();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n",p1.equals(p2),p1.hashCode(),p2.hashCode());
        System.out.printf("p1.equals(p4) : %s; p1(%d) p4(%d)\n",p1.equals(p4),p1.hashCode(),p4.hashCode());
        System.out.printf("set:%s \n",set);

    }
}
