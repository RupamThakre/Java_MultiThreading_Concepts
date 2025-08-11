/*
* In multithreading - multiple threads needs to communicate with each other.
* That's where wait(), notify() and  notifyAll() come in
* - they allow threads to coordinate their actions
*
* These methods are defined in the object class, not the Thread class,
* bcz every object in java can be used as a lock
*
* Big Idea - Thread communication
*
* Let's says one thread is producing data and another thread is consuming it
* They should work in sync
* - Tje consumer should wait if there is no data
* - The producer should notify the consumer when new data is ready
*
* This kind of coordination is done using
* - wait() - tells the thread to pause and release the lock
* - notify() - wakes up one waiting thread
* - notifyAll() - wakes up all waiting threads
* */

/*
* 1. wait()
* - It causes the current thread to wait untill another thread notifies it
* - It must be called inside a synchronized block or method
* - when a thread calls wait(), it releases the lock and goes to the waiting state
*
* synchroized(object){
    object.wait(); // therad waits
}
* */

class ThreadMethods {
    boolean ready = false;

    synchronized void produce(){
        ready = true;
        System.out.println("Produced data");
        notify(); // notify one waiting thread
    }

    synchronized void consume(){
        while(!ready){
            try{
                wait(); // wait untill data is ready
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumed data");
        ready = false;
    }
}


