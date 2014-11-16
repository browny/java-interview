### Java Collection Tips

1. `fail-fast` Iterator vs `fail-safe` Iterator?
    * fail-fast Iterators fail as soon as they realized that structure of Collection has been changed since iteration has begun
    * fail-safe iterator doesn't throw any Exception if Collection is modified structurally
while one thread is Iterating over it because they work on clone of Collection instead of original collection and that’s why they are called as fail-safe iterator

2. `ArrayList` vs. `Vector`
    * 1) **Synchronization**: `ArrayList` is non-synchronized which means multiple threads can work on ArrayList at the same time while `Vector` is synchronized.
    * 2) **Resize**: Both `ArrayList` and `Vector` can grow and shrink dynamically to maintain the optimal use of storage, however the way they resized is different. `ArrayList` grow by **half of its size** when resized while `Vector` **doubles the size of itself** by default when grows
    * 3) **Performance**: `ArrayList` gives better performance as it is non-synchronized
    * 4) **Failfast**: Enumeration returned by `Vector` is not fail-fast (其他是 fail-fast). On the other side the iterator and listIterator returned by `ArrayList` are fail-fast
    * 5) **Legacy**: There is nothing about `Vector` which List collection cannot do. Therefore Vector should be avoided. If there is a need of thread-safe operation, use `CopyOnWriteArrayList` which is a **thread-safe** variant of `ArrayList`
    
3. Use`ArrayDeque` implements **Stack** and **Queue**
    
    [http://www.shaunabram.com/stacks-and-queues-in-java/]()
    
4. `ArrayList` vs. `LinkedList`

    `LinkedList` and `ArrayList` are two different implementations of the List interface. `LinkedList` implements it with a **doubly-linked list**. `ArrayList` implements it with a **dynamically resizing array**
    
    `LinkedList<E>` allows for constant-time insertions or removals using iterators, but only sequential access of elements. In other words, you can walk the list forwards or backwards, but **finding a position in the list takes time proportional to the size of the list**.

    `ArrayList<E>`, on the other hand, allow fast random read access, so you can grab any element in constant time. But **adding or removing from anywhere but the end requires shifting all the latter elements over**, either to make an opening or fill the gap. Also, if you add more elements than the capacity of the underlying array, a new array (1.5 times the size) is allocated, and the old array is copied to the new one, so adding to an ArrayList is O(n) in the worst case but constant on average.

    ![image](http://www.codejava.net/images/articles/javacore/collections/List%20API%20class%20diagram.png)

5. `HashSet`, `TreeSet` and `LinkedHashSet`

    In brief, if you need a fast set, you should use `HashSet` (Implemented using a hash table); if you need a sorted set, then `TreeSet`(implemented using a red-black tree) should be used; if you need a set that can be store the insertion order, `LinkedHashSet` (implemented as a hash table with a linked list running through it) should be used.

    ![image](http://www.codejava.net/images/articles/javacore/collections/Set%20API%20class%20diagram.png)

6. `HashMap`, `LinkedHashMap` and `TreeMap`

    * `HashMap` makes absolutely no guarantees about the iteration order. It can (and will) even change completely when new elements are added.
    * `TreeMap` will iterate according to the "natural ordering" of the keys according to their `compareTo()` method (or an externally supplied Comparator). Additionally, it implements the SortedMap interface, which contains methods that depend on this sort order.
    * `LinkedHashMap` will iterate in the order in which the entries were put into the map

    ![image](http://www.codejava.net/images/articles/javacore/collections/Map%20API%20class%20diagram.png)

7.  `ArrayBlockingQueue`, `ConcurrentLinkedQueue`, `LinkedBlockingQueue` and/or `LinkedList`

    * `ConcurrentLinkedQueue` is an appropriate choice when many threads will share access to a common collection. This queue does not permit null elements.
    * `ArrayBlockingQueue` is a classic "bounded buffer", in which a fixed-sized array holds elements inserted by producers and extracted by consumers. This class supports an optional fairness policy for ordering waiting producer and consumer threads
    * `LinkedBlockingQueue` typically have higher throughput than array-based queues but less predictable performance in most concurrent applications.
    
    Basically the difference between them are performance characteristics and blocking behavior.
 
   ![image](http://www.codejava.net/images/articles/javacore/collections/Queue%20API%20class%20diagram.png) 