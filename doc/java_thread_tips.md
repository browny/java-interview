### Java Thread Tips

1. Difference between Runnable and Callable in Java?
    * Main difference between these two is that Callable's call() method can **return value** and **throw checked Exception**, which was not possible with Runnable's run() method. Commonly `FutureTask` is used along with `Callable` to get result of asynchronous computation task performed in call() method

2. Difference between `CyclicBarrier` and `CountDownLatch` in Java?
    * `CountDownLatch`: A `java.util.concurrent.CountDownLatch` is a concurrency construct that allows one or more threads to wait for a given set of operations to complete
    * `CyclicBarrier`: The `java.util.concurrent.CyclicBarrier` class is a synchronization mechanism that can synchronize threads progressing through some algorithm. In other words, it is a barrier that all threads must wait at, until all threads reach it, before any of the threads can continue. Here is a diagram illustrating that
    
    ![image](http://tutorials.jenkov.com/images/java-concurrency-utils/cyclic-barrier.png)
    
    * **Difference**: Though both CyclicBarrier and CountDownLatch wait for number of threads on one or more events, main difference between them is that you **can not re-use** `CountDownLatch` once count reaches to zero, but you **can reuse** same `CyclicBarrier` even after barrier is broken
    
3. What is `volatile` variable in Java?
    * volatile is a special modifier, which can only be used with instance variables. In concurrent Java programs, changes made by multiple threads on instance variables is not visible to other in absence of any synchronizers e.g. synchronized keyword or locks. Volatile variable **guarantees that a write will happen before any subsequent read**, as stated "volatile variable rule" in previous question
    
4. What is race condition in Java? Given one example? 
    * **Check and Act race condition**: classical example of "check and act" race condition in Java is `getInstance()` method of Singleton Class. If you call `getInstance()` method from two thread simultaneously its possible that while one thread is initializing singleton after null check, another thread sees value of _instance reference variable as null. Results in getInstance() **returning two separate instance of Singleton**
    * **Read-modify-update race condition**: classical example is the **non thread safe counter**
    				
			if(!hashtable.contains(key)){
				hashtable.put(key,value);
			}
			
        here we only insert object into hashtable if its not already there. point is both contains() and put() are atomic but still this code can result in race condition since **both operation together is not atomic**. Consider thread T1 checks for conditions and goes inside if block now CPU is switched from T1 to thread T2 which also checks condition and goes inside if block