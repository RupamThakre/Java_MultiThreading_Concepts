/*
* Volatile Keyword - used to make a variable's value always visible to all threads
*
* It ensures that when one thread updates the value of a variable,
* other threads immediately see the updated value - no caching, no delay
*
* In multithreading environment, each thread can keep a cached copy of variables for performace. This means
* - A thread might not see the latest value of a shared variable
* - Even though another thread updated it , the change is not visible immediately
*
* This can cause serious bugs - especially when the program logic depends on the
* latest value of that variable
*
* What volatile Does?
* - It tells Java Memory Model that the value of a variable must not be cached
* - Every read/write to a volatile goes directly to main memory
* - As a result, all threads always get the most recent value
* */

class VolatileExample {
    static boolean flag = true;

    static volatile boolean flagN = true;

    public static void main(String... args){
        Thread t1 = new Thread(()->{
            while(flag){
                //do nothing ... just loop
            }
            System.out.println("Thread stopped!");
        });
        t1.start();
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            flag = false; // main thread flag to false
        }
    }
}

/*
* What the problem?
*
* - In some cases, Thread t1 might never stop
* - Why? Becuase it keeps reading the cached value of the flag, which is still true
*
* In this case with using volatile keyword,
*  t1 sees the updated flag = false value and exits the loop properly
* This happens because volatile ensures visiblility between threads.
*
* - Read the latest value from Main memory instead of cached memory
*
*Limitations
* - only used for simple flag
* - todo more complex object need to use atomic keyword
*
* */


