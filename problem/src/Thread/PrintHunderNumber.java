package Thread;

public class PrintHunderNumber {

    private int end = 100;
    private int start = 0;

    public synchronized void printOdd() {

        while (start < end) {
            notify();
            //  System.out.println(Thread.currentThread());
            if (start % 2 != 0) {
                System.out.println(Thread.currentThread() + "-" + start);
                start++;
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    this.notify();
                }
            }


        }

        System.out.println("printed to end");

    }

    public synchronized void printEven() {
        while (start < end) {
            notify();
            if (start % 2 == 0) {
                System.out.println(Thread.currentThread() + "-" + start);
                start++;
                try {
                    wait();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {

                     notify();
                }
            }


        }

    }

    public static void main(String[] args) {

        PrintHunderNumber hunderNumber = new PrintHunderNumber();

        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                hunderNumber.printEven();
            }
        });
        th1.start();
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                hunderNumber.printOdd();
            }
        });
        th2.start();

    }
}
