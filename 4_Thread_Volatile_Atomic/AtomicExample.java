import java.util.concurrent.atomic.AtomicInteger;
class AtomicExample {

    // here volatile would not work,
   // private int counter = 0;

    // could add synchronized - so that only one thread completes its increment then second thread got chance.
   /*
   * I want all these operations should be isolated,
   * right now, both the thread increment the value ,
   * we want one thread increment the value at a time,
   * - can use synchornized, lock , alongwith you can use
   * some predefined classes which Java has already given
   * to deal with this type of situation
   *
   * Atomicity - to acheieve isolation
   * */
//    public void increment(){
//        counter++;
//    }

    //Now with using AtomicInteger
    //If you dont want to use synchornized and locks

    private AtomicInteger counter = new AtomicInteger(0);

    public void increment(){
        counter.incrementAndGet();
    }


    public int getCounter(){
//        return counter;

        return counter.get();
    }

    static public void main(String... java){

        AtomicExample ae = new AtomicExample();
        Thread t1 = new Thread(()->{
            for(int i =0 ; i< 1000; i++){
                ae.increment();
            }
        });

        Thread t2 = new Thread(()->{
            for(int i = 0 ; i< 1000; i++){
                ae.increment();
            }
        });

        t1.start();
        t2.start();
//        t1.join();
//        t2.join();

        System.out.println(ae.getCounter());

    }
}