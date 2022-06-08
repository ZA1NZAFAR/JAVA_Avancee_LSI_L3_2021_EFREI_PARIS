package TP4.Exo2.avecThreadNoSync;

import TP4.Exo2.Person;
import TP4.Exo2.Task;

public class ActivityThread implements Runnable {

    Person person;
    Task task;

    public ActivityThread(Person person, Task awake) {
        this.person = person;
        this.task = awake;
    }

    @Override
    public void run() {
        person.doActivity(task);
    }
}
