package TP4.Exo2.avecThreadNoSync;

import TP4.Exo2.Person;
import TP4.Exo2.Task;

public class MainAvecThreadsSansSync {
    public static void main(String[] args) {
        Person person = new Person("Marwan");
        Thread t1 = new Thread(new ActivityThread(person, Task.AWAKE));
        Thread t2 = new Thread(new ActivityThread(person, Task.TAKEN_BREAKFAST));
        Thread t3 = new Thread(new ActivityThread(person, Task.SMOKE_CIGARETTE));
        Thread t4 = new Thread(new ActivityThread(person, Task.WALK));
        Thread t5 = new Thread(new ActivityThread(person, Task.IN_CLASS));
        Thread t6 = new Thread(new ActivityThread(person, Task.FOLLOW_LECTURE));
        Thread t7 = new Thread(new ActivityThread(person, Task.DO_TP));
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
