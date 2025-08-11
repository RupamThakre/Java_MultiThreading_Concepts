
class ThreadLifeCycle extends Thread {

    @Override
    public void run() {
        System.out.println("Thread is running ");

        try{
            Thread.sleep(10000);
        }catch(InterruptedException e){
            System.out.println("Thread interrupted!");
        }
    }
}


public class Main
{
    public static void main(String[] args) {

        ThreadLifeCycle t = new ThreadLifeCycle();

        System.out.println("Thread state : "+t.getState());

        t.start();
        System.out.println("Thread state : "+t.getState());

        try {
            Thread.sleep(800);
            System.out.println("Thread state : "+t.getState());
            t.join();
        }catch(InterruptedException e){
            System.out.println("Thread state after finish: " + t.getState());
        }
        System.out.println("Thread state : "+t.getState());
    }

}