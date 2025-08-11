/*
* Executor framework is high level API introduced in Java5 under
* java.util.concurrent package that helps manage and control multiple
* threads without having to manually create and manage them
*
* Think of it like a smart thread manager - you give it tasks, and it
* figures out how to run them efficiently  using availble threads.
*
* Why Introuced?
* Before Java5
*
* new Thread(()->{
* //some task
* }).start();
* - no control over the number of threads,
* - threads kept creating and dying - wasting system resources
* - no build-in way to manage or reuse threads
*
* Solves
* 1. Thread reuse (thread pools)
* 2. Task scheduling
* 3. Result tracking(future)
* 4. better performance and scalability
*
* Core components
*
* 1. Executor -> Root interface with single method, execute()
* 2. ExecutorService ->  subinterface that adds more features like submit(),shutdown()
* 3. Executors -> utility class to create different types of executor services
* 4. Future -> represents the result of an asynchoronous computation
* 5. Callable -> like Runnable but returns a result
*
* */

//Common Executors provided by Java

//1. Single thread executor
ExecutorService executor = Executors.newSingleThreadExecutor();

//2. Fixed Thread pool
ExecutorService executor = Executors.newFixedThreadPool(5);

//3. Cached Thread pool
ExecutorServce executor = Executors.newCachedThreadPool();

//4. Scheduled Thread Pool
ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
//For delayed or periodic tasks (like setTimeout or setInterval in JavaScript).


import java.util.concurrent.*;
class ThreadExecutor{

    public static void main(String... java){

        ExecutorService executor = Executors.newFixedThread(3);

        Runnable task = ()->{
          System.out.println("Thread running: "+Thread.currentThread().getName());
        };

        for(int i = 0 ;i < 5; i++){
            executor.execute(task);
        }

        executor.shutdown();
    }
}

/*
* This creates a thread pool of 3 threads and submits 5 tasks
* The executor will reuse threads and avoid creating a new one each time
* */

/*
* execute() -> accepts Runnable, returns void
* submit() -> accepts Runnable or Callable, returns a Future
* */

Future<String> future = executor.submit(()->"Hello from callable");
String reult = future.get(); //blocks untill result is ready











