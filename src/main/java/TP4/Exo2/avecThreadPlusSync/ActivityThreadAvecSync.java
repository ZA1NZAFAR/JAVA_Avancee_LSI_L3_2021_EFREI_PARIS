package TP4.Exo2.avecThreadPlusSync;

import TP4.Exo2.Person;
import TP4.Exo2.Task;

public class ActivityThreadAvecSync implements Runnable {
    Person person;
    TP4.Exo2.Task task;
    Lock lock;
    int priority;

    public ActivityThreadAvecSync(Person person, Task task, Lock lock, int priority) {
        this.person = person;
        this.task = task;
        this.lock = lock;
        this.priority = priority;
    }

    @Override
    public void run() {
        lock.take(priority);
        person.doActivity(task);
        lock.release();
    }
}
