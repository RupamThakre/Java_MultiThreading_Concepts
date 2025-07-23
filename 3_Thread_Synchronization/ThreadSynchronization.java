/*
Synchronization - only one thread access the resource at a one time
Especially when multiple threads try to read/write on shared data
*
*/

class BankAccount {
    int balance = 100;

    public void witDraw(int amount){
        if(balance > amount){
            balance = balance - amount;
        }
    }
}

/*
* let us suppose 2 thread wants to widraw amount at same time
* Therefore, to prevent such problem, we synchronize the critical
* section,
* 1. Method level synchronization
* 2. Block level synchronization
*  */

class BankAccount {
    int balance = 100;

    public synchronized void withdraw(int amount){
        if(balance > amount){
            balance = balance - amount;
        }
    }
}


