/*
* Thread lifecycle in 5 parts
*
* 1. NEW - Thread is created but not started yet [Thread t = new Thread()]
* 2. RUNNABLE - calling .start() method [t.start()] Ready to run - but waiting for CPU to allocate it
* 3. RUNNING - when the CPU actually executing the thread
* 4. BLOCKED/WAITING/SLEEPING - Thread.sleep(1000) | waiting - another thread |
* 5. TERMINATED -
*
* */

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