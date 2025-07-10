public class Main {
    public static void main(String[] args) {

        ThreadLifeCycleDemo t = new ThreadLifeCycleDemo();
        System.out.println("Thread State: "+t.getState());

        t.start();
        System.out.println("Thread State after start: "+t.getState());

        try {
            Thread.sleep(800); //Main Thread goes to sleep, gives t a chance to run
            System.out.println("Thread state during sleep : "+t.getState());
            t.join(); //wait for t to finish
        } catch (InterruptedException e) {
            System.out.println("Thread State after finish : "+t.getState());
        }
    }
}