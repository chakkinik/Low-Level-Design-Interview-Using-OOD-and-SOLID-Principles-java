package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAccessingList {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        AtomicInteger at = new AtomicInteger();

        Runnable runObj = new Runnable() {
            @Override
            public void run() {
                while (at.get() < list.size()-1) {
                    synchronized (this) {
                        System.out.println(Thread.currentThread() + "==" + list.get(at.getAndIncrement()));


                    }
                }
            }
        };

        Thread t1 = new Thread(runObj);
        Thread t2 = new Thread(runObj);
        t1.start();
        t2.start();


    }
}
