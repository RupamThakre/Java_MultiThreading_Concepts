/*
* Both Runnable and Callable are interfaces used to define tasks
* that can be executed by a thread or an executor.
* But they are not exactly the same - they differ in return types
* exception handling and how they are executed.
*
* 1. Runnable
* - Runnable is a functional interface with a single method - .run()
* - it does not return any result
* - it can not throw a checked exception
* */

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable is running");
    }
}

class ThreadInterfaces{
    public static void main(String... args){
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}

/*
* Use Runnable when you want a thread todo something, but you
*                                      don't need a result back
* */

/*
* Callable -  also a functional interface, but it's a part of the
* java.util.concurrent package
*
* - It returns a value call() methhod returns a result
* - It can throw checked exception
*
* */


import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Callable is done!";
    }
}
//TO run it, you need to use an ExecutorService

class Main{

    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<String> future = executor.submit(new MyCallable());
    String result = future.get();
    System.out.println(result);
    executor.shutdown();
}