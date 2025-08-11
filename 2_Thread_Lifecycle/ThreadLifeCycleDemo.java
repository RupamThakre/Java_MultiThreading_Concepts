public class ThreadLifeCycleDemo extends Thread {

    @Override
    public void run() {
        System.out.println("Thread is running......");
        try {
            Thread.sleep(10000); //goes to sleep
        }catch (InterruptedException e){
            System.out.println("Thread Interrupted!");
        }
        System.out.println("Thread finished!");
    }

}
