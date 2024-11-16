package creationalpattern.singleton;

/*

    5 why understanding of singleton

    1) Why singleton is required.
     - we often require classes that can only have one object.
       For example: thread pools, caches, loggers etc.
    2) why we required only one object.
     -- To prevent of overutlisation of resources.. Below example of preventing
     executorService being creating multiple times using singleton
    3) why we required to make this resource Synchronization
     --  multiple threads attempt to access the getInstance() method of a
            Singleton without proper synchronization, it can lead to the creation of multiple objects,
            breaking the Singleton principle.
          This problem arises due to a race condition when the instance is being initialized.
       Thread A and Thread B simultaneously check if (instance == null).
       Both threads see instance as null.
       Both proceed to create a new Singleton instance.
       Now two instances of the Singleton class exist, violating the Singleton principle.

    How to Prevent This

    To ensure thread safety and avoid creating multiple instances:
    Use synchronized blocks or methods.
    Implement Double-Checked Locking.
    Use the Eager Initialization or Initialization-on-Demand Holder Idiom.

    4) why do we create instance as volatile
    -volatile keyword is a modifier that ensures that a variable's value is always read from and written to main memory, rather than from a thread's local cache. This is important

      in multi-threaded applications where multiple threads may be accessing the same variable.

      The volatile keyword ensures two things:

    Visibility: Changes made to the instance variable in one thread are immediately visible to other threads.
    Prevention of Reordering: The volatile modifier prevents instruction reordering for the instance variable. This guarantees that:
    Memory is allocated.
    The object is fully initialized.
    The reference is assigned to instance in the correct order.
    So with volatile, Thread B will not see a partially constructed Singleton.

   5) Purpose: Thread Safety
Multiple threads could pass the first if (instance == null) check simultaneously before any thread acquires the lock.
Without the second check, every thread that reaches the synchronized block would create a new Singleton instance, violating the Singleton principle.
Example Without Second Check:

Thread A and Thread B both pass the first if (instance == null).
Thread A enters the synchronized block, initializes the instance, and exits.
Thread B then enters the synchronized block and initializes the instance again, overwriting the first.






 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Singleton {


    private static Singleton singleton_instance;

    private static volatile Singleton singleton_volatile_instance;

    private ExecutorService executorService;

    private Singleton() {
        this.executorService = Executors.newFixedThreadPool(10);
    }

    /*
        Pros: Simple and thread-safe.
        Cons: Synchronized methods can cause performance bottlenecks
        due to unnecessary locking once the instance is created.
     */
    public synchronized static Singleton getInstance() {
        if (singleton_instance == null) {
            singleton_instance = new Singleton();
        }

        return singleton_instance;
    }

    /*

      At the point where we check if (instance == null), the instance reference
        has not yet been initialized (it's null).
        Synchronizing on a null reference would result in a NullPointerException.


     */
    public static Singleton getSingleton_instance__npe() {
        if (singleton_instance == null) {

            synchronized (singleton_instance) {
                if (singleton_instance == null) {
                    singleton_instance = new Singleton();
                }
            }

        }

        return singleton_instance;
    }

    public static Singleton getSingleton_instance() {
        if (singleton_volatile_instance == null) {

            synchronized (Singleton.class) {
                if (singleton_volatile_instance == null) {
                    singleton_volatile_instance = new Singleton();
                }
            }

        }

        return singleton_volatile_instance;
    }

    /*
     a) This method we are accessing only through singleton
     */
    public void accessResource() {
        System.out.println("this method is accessed");
    }

    /*
      b) Why we do we required Singleton.
        --Here we are using same executorService show the threadpool is not getting creating again.
        we can leverage same threadpool for job execution
     */
    public ExecutorService getExecutorService() {
        return this.executorService;
    }


}

class AcessSingleton {
    public static void main(String[] args) {
        Singleton instance = Singleton.getSingleton_instance();
        instance.accessResource();
    }
}
