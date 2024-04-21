package com.resonit.concepts;

import java.util.*;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Visitors> visitorList = new ArrayList<>();
        visitorList.add(new Visitors(25,"Piyush"));
        visitorList.add(new Visitors(35,"Sushma"));
        visitorList.add(new Visitors(30,"Rahul"));

       //Collections.sort(visitorList, new VisitorAgeComparator());
        Collections.sort(visitorList, new VisitorNameAgeComparator());
        //Collections.sort(visitorList, new VisitorNameComparator());
        for (Visitors e: visitorList ){
            System.out.println(e);
        }
    }
}

class VisitorAgeComparator implements Comparator<Visitors>{
    @Override
    public int compare(Visitors o1, Visitors o2) {
            if(o1.getAge() > o2.getAge()){
                return 1;
            }else if (o1.getAge() < o2.getAge()){
                return -1;
            }else
                return 0;
    }
}

class VisitorNameComparator implements Comparator<Visitors>{
    @Override
    public int compare(Visitors o1, Visitors o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
    }
}

// Sort collection by more than one field
class VisitorNameAgeComparator implements Comparator<Visitors>{
    @Override
    public int compare(Visitors o1, Visitors o2) {

        int nameComparator = o1.getName().compareToIgnoreCase(o2.getName());

        int ageComparator = 0;
        if(o1.getAge() > o2.getAge()){
            ageComparator = 1;
        }else if (o1.getAge() < o2.getAge()){
            ageComparator = -1;
        }
        // 2nd level comparison
        return (nameComparator == 0) ? ageComparator : nameComparator;
    }
}

class Visitors{
    int age;
    String name;

    Visitors(int age, String name){
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

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}