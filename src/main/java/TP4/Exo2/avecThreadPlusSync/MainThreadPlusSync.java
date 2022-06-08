package TP4.Exo2.avecThreadPlusSync;

import TP4.Exo2.Task;
import TP4.Exo2.Person;

public class MainThreadPlusSync {
    public static void main(String[] args) {
        Person person = new Person("Marwan");
        Lock lock = new Lock();
        Thread t1 = new Thread(new ActivityThreadAvecSync(person, Task.AWAKE, lock, 0));
        Thread t2 = new Thread(new ActivityThreadAvecSync(person, Task.TAKEN_BREAKFAST, lock, 1));
        Thread t3 = new Thread(new ActivityThreadAvecSync(person, Task.SMOKE_CIGARETTE, lock, 2));
        Thread t4 = new Thread(new ActivityThreadAvecSync(person, Task.WALK, lock, 3));
        Thread t5 = new Thread(new ActivityThreadAvecSync(person, Task.IN_CLASS, lock, 4));
        Thread t6 = new Thread(new ActivityThreadAvecSync(person, Task.FOLLOW_LECTURE, lock, 5));
        Thread t7 = new Thread(new ActivityThreadAvecSync(person, Task.DO_TP, lock, 6));
        System.out.println("Starting threads");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

    }
}
