
class MyThread extends Thread {

    @Override
    public void run(){
        System.out.println("Thread is running ");
    }
}

public class ExtendingThreadClass
{
    public static void main(String[] args) {

        MyThread t = new MyThread();
        t.start();

        new Thread(()->{
            System.out.println("Thread 2 is running!");
        }).start();
    }
}