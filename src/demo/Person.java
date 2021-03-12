package demo;

/**
 * @author：hanzhigang
 * @Date : 2021/2/19 2:31 PM
 */
public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Person o) {
        if(this.getAge() > o.getAge()){
            return 1;
        }
        if(this.getAge() < o.getAge()){
            return -1;
        }
        return 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
