
public class Main {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        t1.start();

        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable working!!!");
            }
        };

        new Thread(r1).start();

    }
}