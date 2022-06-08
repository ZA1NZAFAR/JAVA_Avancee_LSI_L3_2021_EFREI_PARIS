package TP4.Exo2.avecThreadPlusSync;


// Lock permet de définir si un/des threads sont disponibles ou non :

public class Lock {
    private boolean available;
    private int count;

    public Lock() {
        this.available = true;
        this.count = 0;
    }

    // s'ils ne sont pas disponibles, alors on attend. Cette attente se réalise à l'aide de "synchronized" afin de s'assurer que la mise en attente d'un thread n'empiète pas sur la réalisation d'un autre :
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

    //sinon on place la valeur available du thread à "true", c'est-à-dire à disponible :
    public synchronized void release() {
        available = true;
        notifyAll();
    }
}
