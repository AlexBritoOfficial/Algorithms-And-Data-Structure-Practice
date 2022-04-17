package MultiThreading.ThreadProperties;

import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/***
 * A bank with a number of bank accounts.
 ***/
public class Bank {

    private final double[] accounts;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition sufficientFunds;


    /***
     * Constructs the bank.
     * @param n the number of accounts
     * @param initialBalance the initial balance for each account
     ***/
    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        sufficientFunds = reentrantLock.newCondition();
    }

    /***
     * Transfers the money from one account to another.
     * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     ***/

    public void transfer(int from, int to, double amount) throws InterruptedException {

        reentrantLock.lock();
        try {

            while(accounts[from] < amount) {
                sufficientFunds.await();
            }

            if(accounts[from] < amount) return;
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public synchronized void transferSynchronized(int from, int to, double amount) throws InterruptedException {

            while(accounts[from] < amount) {
                wait();
            }

            if(accounts[from] < amount) return;
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            notifyAll();
    }

    /***
     * Gets the sum of all account balances.
     * @return the total balance
     ***/
    public double getTotalBalance(){

        reentrantLock.lock();
        try {
            int sum = 0;

            for (double amount: accounts) {
                sum += amount;
            }
            return sum;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /***
     * Gets the number of accounts in the bank.
     * @return the number of accounts
     ***/
    public int size(){
        return accounts.length;
    }
}
