package TP4.Exo2.sansThread;

public class MainSansThread {
    public static void main(String[] args) {
        // Good Marwan
        TP4.Exo2.Person person = new TP4.Exo2.Person("Marwan dans l'ordre");
        person.doActivity(TP4.Exo2.Task.AWAKE);
        person.doActivity(TP4.Exo2.Task.TAKEN_BREAKFAST);
        person.doActivity(TP4.Exo2.Task.SMOKE_CIGARETTE);
        person.doActivity(TP4.Exo2.Task.WALK);
        person.doActivity(TP4.Exo2.Task.IN_CLASS);
        person.doActivity(TP4.Exo2.Task.FOLLOW_LECTURE);
        person.doActivity(TP4.Exo2.Task.DO_TP);



        // Bad Marwan
        TP4.Exo2.Person person2 = new TP4.Exo2.Person("Marwan sans l'ordre");
        person2.doActivity(TP4.Exo2.Task.AWAKE);
        person2.doActivity(TP4.Exo2.Task.SMOKE_CIGARETTE);
        person2.doActivity(TP4.Exo2.Task.TAKEN_BREAKFAST);
        person2.doActivity(TP4.Exo2.Task.WALK);
        person2.doActivity(TP4.Exo2.Task.IN_CLASS);
        person2.doActivity(TP4.Exo2.Task.FOLLOW_LECTURE);
        person2.doActivity(TP4.Exo2.Task.DO_TP);

    }
}
