package Thread;

public class PrintHunderNumber {

    private int end=100;
    private int start=0;

    public void printOdd() throws InterruptedException {

        while(start<end){
            if(start%2!=0){
                System.out.println(start);
                wait();
            }
            start++;

        }

    }

    public void printEven() throws InterruptedException {
        while(start<end){
            if(start%2==0){
                System.out.println(start);
                wait();
            }
            start++;

        }

    }

    public static void main(String[] args) {

        PrintHunderNumber hunderNumber = new PrintHunderNumber();

        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    hunderNumber.printEven();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        th1.start();
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    hunderNumber.printOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        th2.start();

    }
}
