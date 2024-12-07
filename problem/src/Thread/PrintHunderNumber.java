package Thread;

public class PrintHunderNumber {

    private int end=100;
    private int start=0;

    public synchronized void printOdd()  {

        while(start<end){
            if(start%2!=0){
                System.out.println(start);
                start++;
               notify();
            }


        }

    }

    public synchronized void printEven()  {
        while(start<end){
            if(start%2==0){
                System.out.println(start);
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
                hunderNumber.printEven();
            }
        });
        th2.start();

    }
}
