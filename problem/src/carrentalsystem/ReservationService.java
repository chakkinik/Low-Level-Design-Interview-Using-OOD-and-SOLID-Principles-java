package carrentalsystem;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


  /*
         In order to handle concurrency control while booking
         Multiple approach.
         a) Optimistic lock.
           Data base lock. database record version.
            lets if you do thread read the same record and same version.
            but while updating the record if version is same once record
            is sucess full but other not.
         b)Why Pessimistic Locking is Suitable for High Contention Scenarios:
Guaranteed Consistency:

Pessimistic locking prevents conflicts by ensuring only one transaction can access or modify a resource at a time.
Critical for avoiding overbooking the same seat or selling the same ticket multiple times.
Avoiding Retries:

In high-contention scenarios, optimistic locking would frequently fail due to conflicts, resulting in excessive retries, which can:
Increase system load.
Reduce responsiveness for users.
Immediate Blocking:

Pessimistic locking ensures that once a user starts booking a seat, others are immediately blocked from accessing it until the booking process completes, ensuring a smooth user experience.



     */

public class ReservationService {


    Map<Car, Long> lock_map = new ConcurrentHashMap<>();


    public boolean blockReservation(Car car) {

        /*
        Why It Works:
Thread-Safe Operations:
putIfAbsent() ensures that no two threads can add the same key to the map at the same time.
Non-Blocking:
Unlike traditional locks (e.g., synchronized or ReentrantLock), this approach does not block threads waiting for a resource. Instead, threads are immediately notified if the resource is locked.
Scoped Locking:
The "lock" exists only as long as the entry is in the map. Once the process is complete, the entry is removed, freeing the resource.

         */

        if (lock_map.putIfAbsent(car, System.currentTimeMillis()) == null) {

            try {

                //do something

                // reserver the car;
                bookReservation();


            } finally {
                lock_map.remove(car);
                return true;
            }

        }


        return false;


    }


    private final Lock lock = new ReentrantLock();


    /*

    What i understand using retrant lock.

    Advantage
    a) Its better way of locking because its give flexity of unlocking and timeout rather synchroized

    Disadvantage
    b) but taking as lock in this method. it will lock other car
    c) Fine grained is take lock on particular using concurrent hasmap


     */

    public void blockUsingRetrantLock(Car car) {


        lock.lock();
        try {
            // Check car availability and reserve
        } finally {
            lock.unlock();
        }
    }

    private boolean bookReservation() {

        return true;
    }


}







