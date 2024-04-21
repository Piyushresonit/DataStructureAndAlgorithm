package com.resonit.concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/*
* String class and Wrapper classes implement the Comparable interface by default.
* So if you store the objects of string or wrapper classes in a list, set or map,
* it will be Comparable by default.
* */
public class ComparableExample {
    public static void main(String[] args) {
        List<Visitor> visitorList = new ArrayList<>();
        visitorList.add(new Visitor(25,"Piyush"));
        visitorList.add(new Visitor(35,"Sushma"));
        visitorList.add(new Visitor(30,"Rahul"));

        Collections.sort(visitorList);
        for (Visitor v: visitorList ){
            System.out.println(v);
        }
    }
}

class Visitor implements Comparable<Visitor> {
    int age;
    String name;

    @Override
    public int compareTo(Visitor o) {
        if(this.age > o.getAge()){
            return -1;
        }else if (this.age < o.getAge()){
            return 1;
        }else
        return 0;
    }

    private int getAge() {
        return age;
    }

    Visitor(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor emp = (Visitor) o;
        return age == emp.age && Objects.equals(name, emp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

}