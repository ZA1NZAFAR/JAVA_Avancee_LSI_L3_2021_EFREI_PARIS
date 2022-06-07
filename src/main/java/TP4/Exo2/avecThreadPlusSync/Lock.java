package TP4.Exo2.avecThreadPlusSync;

public class Lock {
    private boolean available;
    private int count;

    public Lock() {
        this.available = true;
        this.count = 0;
    }

    public synchronized void take(int x) {
        while (!available || x != count) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        available = false;

    }

    public synchronized void release() {
        available = true;
        notifyAll();
    }
}
