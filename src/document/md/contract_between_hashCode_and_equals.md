## Contract between hashCode() and equals()

* It is necessary to **override** the **hashCode()** method whenever **equals()** method is 
**overridden**, to maintain the general contract for the hashCode() method, which states 
that **equal objects must have equal hash codes** should remain consistent from one 
execution of an application.
* Whenever it is invoked on the same object more than once during an execution of a Java 
application, the hashCode method must consistently return the same integer, provided no 
information used in equals comparisons on the object is modified.
* Also this integer value need not remain consistent from one execution of an application to 
another execution of the same application.
* If two objects are equal according to the equals(Object) method, then calling the hashCode 
method on each of the two objects must produce the same integer result.
* It is not required that if two objects are unequal according to the equals(java.lang.Object) 
method, then calling the hashCode method on each of the two objects must produce distinct 
integer results.

```java
// Creating Stream using stream.of
Object o1 = new Object();
Object o2 = o1;
Object o3 = new Object();

System.out.println("o1.equals(o2) => " + o1.equals(o2));
System.out.println("o1.equals(o3) => " + o1.equals(o3));

System.out.println("o1 hashcode => " + o1.hashCode());
System.out.println("o2 hashcode => " + o2.hashCode());
System.out.println("o3 hashcode => " + o3.hashCode());
```
##### Output:
    o1.equals(o2) => true
    o1.equals(o3) => false
    o1 hashcode => 1747585824
    o2 hashcode => 1747585824
    o3 hashcode => 1023892928


> If two objects are equal, then hashcode() must have return same value.

    A.equals(B) // means
    A.hashCode() == B.hashCode()

> If two objects have the same hash code, they may not be equal.

    A.hashCode() == B.hashCode() // does not necessarily mean
    A.equals(B)

#### Hashing: 
>"Finding a good, descriptive value (integer) that can be reproduced by the very same instance again and again".

### Hash Collision: Two distinct Objects produce the same hashCode

Hash codes from Java's `Object.hashCode()` are of type int, you can only have 232 different values.
That's why you will have so-called "collisions" depending on the hashing algorithm.
Typically, this does not produce any problems, because `hashCode()` is mostly used together with `equals()`. 
<br>
Example:<br> 
**HashMap** will call `hashCode()` upon its keys, to know whether the keys may already be contained in the HashMap. 
If the HashMap does not find the hash code, it's obvious the key is not contained in the HashMap yet. 
But if it does, it will have to double-check all keys having that same hash code using `equals()`.

#### What happens if hashCode() method always return same value?
If multiple objects return the same value from `hashCode()`, it means that they would be 
stored in the same bucket. If many objects are stored in the same bucket it means that 
on average it requires more comparison operations to search a given object.

#### What happens if equals() method always return false value?
If `equals()` always returns false it means we are going to keep duplicate values in the same bucket which violates in case of HashMap where duplicate keys are not allowed.

```java
public class EqualAndHashcodeContract {
    static class Visitor{
        int visitor_id;
        String city;

        public Visitor(int visitor_id, String city) {
            this.visitor_id = visitor_id;
            this.city = city;
            visitor_id;
        }
    }
    public static void main(String[] args) {
        Visitor v1 = new Visitor(1,"mumbai");
        Visitor v2 = new Visitor(1,"mumbai");
        System.out.println("v1.equals(v2) => " + v1.equals(v2));
        System.out.println("v1 hashcode => " + v1.hashCode());
        System.out.println("v2 hashcode => " + v2.hashCode());
    }
}
```
#### Output:
    v1.equals(v2) => false
    v1 hashcode => 1023892928
    v2 hashcode => 558638686

#### Override equals() and hashcode()
```java
public class EqualAndHashcodeContract {
    static class Visitor{
        int visitor_id;
        String city;

        public Visitor(int visitor_id, String city) {
            this.visitor_id = visitor_id;
            this.city = city;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Visitor visitor = (Visitor) o;
            return visitor_id == visitor.visitor_id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(visitor_id);
        }
    }
    public static void main(String[] args) {
        Visitor v1 = new Visitor(1,"mumbai");
        Visitor v2 = new Visitor(1,"mumbai");
        System.out.println("v1.equals(v2) => " + v1.equals(v2));
        System.out.println("v1 hashcode => " + v1.hashCode());
        System.out.println("v2 hashcode => " + v2.hashCode());
    }
}
```
##### Output:
    v1.equals(v2) => true
    v1 hashcode => 32
    v2 hashcode => 32

---
[HOME](https://github.com/Piyushresonit/DataStructureAndAlgorithm/blob/master/README.md)