# Java Collection Framework

> Group of objects which are represented as a single unit is known as the **collection** 

> A **framework** is a set of classes and interfaces which provide a ready-made architecture

**Collection interface** (**java.util.Collection**) and **Map interface** (**java.util.Map**) are the two main “root” interfaces of Java collection classes.

* Achieve all the operations that you perform on a data such as **searching**, **sorting**, **insertion**, **manipulation**, and **deletion**.
* Java Collection framework provides 
  * **Interfaces** (Set, List, Queue, Deque) 
  * **Classes** (ArrayList, Vector, LinkedList, PriorityQueue, HashSet, LinkedHashSet, TreeSet).
* Collection is an **in-memory data structure**.
* **Eager Computation**: Every element has to be computed before it can be added to the Collection.
* Collection **can’t be processed in parallel without multithreading**.
* Collection **can store data**.
* An operation on a Collection **can modify its source** and produces a result.
* Collection have a **finite size**.
* When to use: Want to represent a group of an objects as a single entity.

## Pros
* **Consistent and reusable API**: The API has a basic set of interfaces, classes  that implement these interfaces have some common set of methods.
* **Reduces programming effort**: A programmer can focus on its best use in his program and not on the design. Therefore, **abstraction** has been successfully implemented.
* **Increases program speed and quality**: Increases performance by providing **high-performance implementations** of useful data structures and algorithms.

## Methods and implementation

| **Method**                 | **Description**                                                                                                     |
|----------------------------|---------------------------------------------------------------------------------------------------------------------|
| add(Object)                | Add an object to the collection.                                                                                    |
| addAll(Collection c)       | Adds all the elements from given collection to this collection.                                                     |
| clear()                    | (empty) Removes all of the elements from this collection.                                                           |
| contains(Object o)         | Returns true if the collection contains the specified element.                                                      |
| containsAll(Collection c)  | This method returns true if this collection contains all of the elements in the given collection.                   |
| remove(Object o)           | Remove the given object from the collection. Duplicate values: Removes the first occurrence of the object.          |
| removeAll(Collection c)    | Remove all the objects mentioned in the given collection from this collection.                                      |
| removeIf(Predicate filter) | Removes all the elements of this collection that satisfy the given predicate (lambda expression).                   |
| removeIf(Predicate filter) | Removes all the elements of this collection that satisfy the given predicate (lambda expression).                   |
| retainAll(Collection c)    | Retain only the elements in this collection that are contained in the specified collection.                         |
| indexOf(Object o)          | Returns the index of the first occurrence of the element in this list. -1 if this list does not contain the element |
| lastIndexOf(Object o)      | Returns the index of the last occurrence of the element in this list . -1 if this list does not contain the element |                                                                                                                      |
| equals(Object o)           | Compares the specified object with this collection for **equality**.                                                |
| hashCode()                 | This method is used to return the **hash code value** for this collection.                                          |
| isEmpty()                  | Returns **true** if this collection contains **no elements.**                                                       |
| iterator()                 | Returns an **iterator** over the elements in this collection.                                                       |
| listIterator()             | Returns a **listIterator** over the elements in this collection.                                                    |
| max()                      | Return the **maximum value** present in the collection.                                                             |
| parallelStream()           | Returns a **parallel Stream** with this collection as its source.                                                   |
| size()                     | Return the **number of elements** in the collection.                                                                |
| spliterator()              | Create a **Spliterator** over the elements in this collection.                                                      |
| stream()                   | Return a **sequential Stream** with this collection as its source.                                                  |
| toArray()                  | Return an **array** containing all of the elements in this collection.                                              |

## Java Collections Hierarchy
![img](/src/document/images/collection_interface.png)

## Java Map Hierarchy
![img](/src/document/images/map_interface.png)

### Fail-Fast Iterators - `ConcurrentModificationException`
* **Fail-Fast**: If the list is structurally modified at any time after the iterator is created, in any way except through the Iterators own methods, 
the iterator will throw `ConcurrentModificationException`
* Fail-Fast iterators use an internal flag called `modCount` which is updated each time a collection is modified.
* Fail-fast iterators check this flag while calling `next()` method to retrieve next value and if it finds that `modCount` changed after iterator being created, 
it throws `ConcurrentModificationException`.

#### Advantage: 
Fail-Fast mechanism provides a proactive approach to detect and handle **concurrent modifications** during iteration, 
enhancing the reliability and robustness of programs, **maintaining data consistency** and preventing unintended side effects caused by concurrent access and modification of collections.

## Appendices
* **Serializable**: It is a marker interface that classes must implement if they are to be serialized and deserialized.
* **Cloneable**: This is an interface in Java which needs to be implemented by a class to allow its objects to be cloned.
* **Iterable<E>**: This interface represents a collection of objects which is iterable — meaning which can be iterated.
* **Collection<E>**: A Collection represents a group of objects known as its elements. The Collection interface is used to pass around collections of objects where maximum generality is desired.
* **List<E>**: The List interface provides a way to store the ordered collection. It is a child interface of Collection.
* **RandomAccess**: This is a marker interface used by List implementations to indicate that they support fast (generally constant time) random access.

1. [Contract between hashCode() and equals()](src/document/md/contract_between_hashCode_and_equals.md)
2. [Comparable and Comparator Interfaces](src/document/md/comparable_comparator_interfaces.md)
3. [Collections Methods](src/document/md/collections_method.md)
4. [Generics](src/document/md/generics.md)
5. [ShallowCopyVsDeepCopy](src/document/md/shallowcopy_vs_deepcopy.md)
6. [Array](src/document/md/array.md)
7. [ArrayList](src/document/md/arraylist.md)
8. [LinkedList](src/document/md/linkedlist.md)
8. [Stack](src/document/md/stack.md)
8. [Stack LinkedList Implementation](src/document/md/stackLinkedListImpl.md)
8. [HashMap](src/document/md/hashmap.md)