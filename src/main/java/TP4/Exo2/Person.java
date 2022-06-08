package TP4.Exo2;

import java.util.HashMap;

//On définit la classe personne contenant les informations relatives à l'étudiant :

public class Person {
    private String name;
    private HashMap<Task, Boolean> activities;

    public Person(String name) {
        this.name = name;
        this.activities = new HashMap<>();

        //task est une énumération qui contient l'ensemble des valeurs que peut prendre "task"
        for (Task task : Task.values()) {
            activities.put(task, false);
        }
    }

    // on définit les différents cas possibles selon la valeur de task:

    public void doActivity(Task task) {
        switch (task) {
            case AWAKE:
                activities.put(task, true);
                System.out.println(name + " is awake");
                break;
            case TAKEN_BREAKFAST:
                if (!activities.get(Task.AWAKE)) {
                    System.out.println(name + "  should wake before taking a breakfast");
                } else {
                    activities.put(task, true);
                    System.out.println(name + "  took a breakfast");
                }
                break;
            case SMOKE_CIGARETTE:
                if (!activities.get(Task.TAKEN_BREAKFAST)) {
                    System.out.println(name + "  should take a breakfast before smoking a cigarette");
                } else {
                    activities.put(task, true);
                    System.out.println(name + "  smoked a cigarette");
                }
                break;
            case WALK:
                if (!activities.get(Task.SMOKE_CIGARETTE)) {
                    System.out.println(name + "  should take a transport before walking");
                } else {
                    activities.put(task, true);
                    System.out.println(name + "  walked");
                }
                break;
            case IN_CLASS:
                if (!activities.get(Task.WALK)) {
                    System.out.println(name + "  should walk before in class");
                } else {
                    activities.put(task, true);
                    System.out.println(name + "  is in class");
                }
                break;
            case FOLLOW_LECTURE:
                if (!activities.get(Task.IN_CLASS)) {
                    System.out.println(name + "  should in class before following a lecture");
                } else {
                    activities.put(task, true);
                    System.out.println(name + "  followed a lecture");
                }
                break;
            case DO_TP:
                if (!activities.get(Task.FOLLOW_LECTURE)) {
                    System.out.println(name + "  should follow a lecture before doing a TP");
                } else {
                    activities.put(task, true);
                    System.out.println(name + "  did a TP");
                }
                break;
            default:
                System.out.println(name + "  did nothing");
        }
    }
}
