

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnnable interface thread");
    }
}

public class Main
{
    public static void main(String[] args) {

        Runnable r1 = ()->{ System.out.println("Runnnable using Lambda Function");};

        MyThread t = new MyThread();
        Thread t1 = new Thread(t);
        t1.start();

        new Thread(r1).start();
    }

}