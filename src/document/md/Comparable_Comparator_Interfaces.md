# Comparable and Comparator Interfaces

| **Comparable**                                                                                                                                  | **Comparator**                                                                                                                                            |
|---------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|
| Comparable provides a **single sorting sequence**. We can sort the collection on the basis of a single element such as id, name, and price. | The Comparator provides **multiple sorting sequences**. We can sort the collection on the basis of multiple elements such as id, name, and price etc. |
| Comparable affects the original class, i.e., the **actual class is modified**.                                                                  | 	Comparator doesn't affect the original class, i.e., the **actual class is not modified**.                                                            |
| Comparable provides compareTo() method to sort elements.                                                                                    | 	Comparator provides **compare()** method to sort elements. Also contains **equals()**.                                                               |
| Comparable is present in java.lang package.                                                                                                 | 	A Comparator is present in the **java.util** package.                                                                                                |
| Sort the list elements: **Collections.sort(List)** method.	                                                                                 | Sort the list elements : **Collections.sort(List, Comparator)** method.                                                                               |                                                             
| Default **Natural Sorting Order**	                                                                                                              | **Customized Sorting order**                                                                                                                              |

## Comparable Interface
* String class and Wrapper classes implement the Comparable interface by default.
* If you store the objects of string or wrapper classes in a list, set or map, it will be Comparable by default.

```java
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
```
#### Output
    Emp{age=35, name='Sushma'}
    Emp{age=30, name='Rahul'}
    Emp{age=25, name='Piyush'}

## Comparator Interface

>To compare two elements, it asks “Which is greater?” Compare method returns -1, 0, or 1 to say if it is less than, equal, or greater to the other. 
 
It uses this result to then determine if they should be swapped for their sort.

### VisitorNameComparator Example
```java
public class ComparatorExample {
    public static void main(String[] args) {
        List<Visitors> visitorList = new ArrayList<>();
        visitorList.add(new Visitors(25,"Piyush"));
        visitorList.add(new Visitors(35,"Sushma"));
        visitorList.add(new Visitors(30,"Rahul"));

        Collections.sort(visitorList, new VisitorNameComparator());
        for (Visitors e: visitorList ){
            System.out.println(e);
        }
    }
}

class VisitorNameComparator implements Comparator<Visitors>{
    @Override
    public int compare(Visitors o1, Visitors o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
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
```
#### Output
    Emp{age=25, name='Piyush'}
    Emp{age=30, name='Rahul'}
    Emp{age=35, name='Sushma'}

### VisitorAgeComparator Example

```java
public class ComparatorExample {
    public static void main(String[] args) {
        
        Collections.sort(visitorList, new VisitorAgeComparator());
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
```
#### Output
    Emp{age=25, name='Piyush'}
    Emp{age=30, name='Rahul'}
    Emp{age=35, name='Sushma'}

### VisitorNameAgeComparator Example

```java
public class ComparatorExample {
    public static void main(String[] args) {
       
        Collections.sort(visitorList, new VisitorNameAgeComparator());
        for (Visitors e: visitorList ){
            System.out.println(e);
        }
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
```
#### Output
    Emp{age=25, name='Piyush'}
    Emp{age=30, name='Rahul'}
    Emp{age=35, name='Sushma'}
---
[HOME](https://github.com/Piyushresonit/DataStructureAndAlgorithm/blob/master/README.md)
