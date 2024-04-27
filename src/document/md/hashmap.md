# HashMap    

> A HashMap is a data structure that is used to store and retrieve values based on keys.
> Backing data structure - **Hash Table + Array**

* **Fast access time**: HashMaps provide constant time access to elements, which means that **retrieval** and **insertion** of elements are very fast, usually **O(1) time complexity**.
* **Allow duplicate Values**: HashMaps allow for duplicate values, but not duplicate keys. 
If a duplicate key is added, the previous **value** associated with the key is **overwritten**.
* **Null Insertion Allowed** : Allows 1 null key and many null values: This means that a null key can be used to store a value, and a null value can be associated with a key.
* **Ordered not followed**: HashMaps are not ordered, which means that the order in which elements are added to the map is not preserved. However, LinkedHashMap is a variation of HashMap that preserves the insertion order.
* **Uses hashing function**: HashMaps uses a hash function to **map keys to indices in an array**. 
This allows for a **quick lookup** of values based on keys.
* Stores **key-value pairs**: Each element in a HashMap consists of a key-value pair. 
The key is used to look up the associated value.
* **Thread-unsafe** or **Non-synchronized**: HashMaps are not thread-safe, which means that if multiple threads access the same hashmap simultaneously, it can lead to data inconsistencies. 
If thread safety is required, ConcurrentHashMap can be used.
* Use `Collections.synchronizedMap(new HashMap())` to get synchronized HashMap.
* Implements **Serializable** and **Cloneable** interfaces.
* **Capacity and load factor**: HashMaps have a capacity, which is the number of elements that it can hold, and a **load factor**, which is the measure of how full the hashmap can be before it is resized.
* The initial default capacity of HashMap is 16, and default load factor is 0.75.
* When HashMap elements count exceed this threshold, HashMap is resized and new capacity is double the previous capacity.
> Threshold = (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY).
* Best Choice: **Fast retrieval**

### Hashing
 
* Hashing is a process of converting an object into integer form by using the method hashCode(). 
* It’s necessary to write the hashCode() method properly for better performance of HashMap. 
> HashMap also allows a **null** key, so **hash code of null will always be 0**.

### `hashCode() `

* `hashCode()` is used to get the hash code of an object. 
* Returns the memory reference of an object in integer form. 
* Definition of `hashCode()` is `public native hashCode()`. It indicates the implementation of `hashCode()` is native because there is not any direct method in java to fetch the reference of the object. 
* It is possible to provide your implementation of `hashCode()`.  
* In HashMap, `hashCode()` is used to calculate the `bucket index`. 
	
### `equals()` 
* Used to check whether 2 objects are equal or not provided by the Object class.  
* You can override this in your class to provide your implementation.  
* HashMap uses `equals()` to **compare** the **key** to whether they are equal or not.  
* If the `equals()` method return true, they are equal otherwise not equal. 

```java
public Employee(String name){
    this.name = name;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return Objects.equals(name, employee.name);
}

@Override
public int hashCode() {
    return Objects.hash(name); // calls native hashCode()
}
```

[Contract between hashCode() and equals()](contract_between_hashCode_and_equals.md)

### Buckets
* Bucket is one element of the HashMap array. 
* It is used to **store nodes**. 
* Two or more nodes can have the same bucket. 
* In that case, a `LinkedList` structure is used to connect the nodes. 
* Buckets are different in capacity.
* A single bucket can have more than one node, it depends on the `hashCode()` method.
* The better your `hashCode()` is, the better your buckets will be utilized.
> Capacity = number of buckets * load factor

### Hash (Index) Calculation in HashMap

* The Hash code of the key may be large enough to create an array. 
* Hash code generated may be in the range of integer and if we create arrays for such a range, then it will easily cause `outOfMemoryException`. 
* So we generate an index to minimize the size of the array.

 The following operation is performed to calculate the index. 
>Index = hashCode(key) % number of bucket

>_WARNING_! if the hashing function is not properly implemented or if the load factor is too high, the performance of a HashMap can degrade.

### Rehash Threshold 
* **Rehashing**: The process of doubling the capacity of the HashMap after it reaches its Threshold.
* It is the product of Load Factor and Initial Capacity.
* In java, by default, it is (16 * 0.75 = 12). 
* That is, Rehashing takes place after inserting 12 key-value pairs into the HashMap.

> **TREEIFY_THRESHOLD** : From Java 8 onward, Java has started using Self Balancing BST instead of a linked list for chaining. The advantage of self-balancing bst is, we get the worst case (when every key maps to the same slot) search time is O(Log n).

### Constructor of a HashMap
      HashMap()
      HashMap(int initialCapacity)
      HashMap(int initialCapacity, float loadFactor)
      HashMap(Map map)

## Methods of LinkedList

| **Method**                                                                             | **Description**                                                                                                                                                                             |
|----------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| clear()                                                                                | **Removes** all of the mappings from this map.                                                                                                                                              |
| clone()                                                                                | Returns a **shallow copy** of this HashMap instance: the **keys** and **values themselves are not cloned**.                                                                                 |
| compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)          | Attempts to **compute a mapping** for the **specified key** and its **current mapped value** (or **null** if there is no current mapping).                                                  |
| computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)                | If the specified key is not already associated with a value (or is mapped to null), attempts to compute its value using the given mapping function and enters it into this map unless null. |
| computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction) | If the value for the specified key is present and non-null, attempts to compute a new mapping given the key and its current mapped value.                                                   |
| containsKey(Object key)                                                                | Returns true if this map contains a mapping for the specified key.                                                                                                                          |
| containsValue(Object value)                                                            | Returns true if this map maps one or more keys to the specified value.                                                                                                                      |
| entrySet()                                                                             | Returns a Set view of the mappings contained in this map.                                                                                                                                   |
| get(Object key)                                                                        | Returns the value to which the specified key is mapped or null if this map contains no mapping for the key.                                                                                 |
| isEmpty()                                                                              | Returns true if this map contains no key-value mappings.                                                                                                                                    |
| keySet()                                                                               | Returns a Set view of the keys contained in this map.                                                                                                                                       |
| merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)   | "If the specified key is not already associated with a value or is associated with null, associate it with the given non-null value.                                                        |
| put(K key, V value)                                                                    | Associates the specified value with the specified key in this map.                                                                                                                          |
| putAll(Map<? extends K,? extends V> m)                                                 | Copies all of the mappings from the specified map to this map.                                                                                                                              |
| remove(Object key)                                                                     | **Removes the mapping** for the specified **key** from this map if present.                                                                                                                         |
| size()                                                                                 | Returns the **number of key-value mappings** in this map.                                                                                                                                       |
| values()                                                                               | Returns a **Collection view of the values** contained in this map.                                                                                                                              |

# Internal working of a HashMap
---
[HOME](https://github.com/Piyushresonit/DataStructureAndAlgorithm/blob/master/README.md)