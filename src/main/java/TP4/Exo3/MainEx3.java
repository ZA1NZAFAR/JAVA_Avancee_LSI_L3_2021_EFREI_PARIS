package TP4.Exo3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// on met tout d'abord en place une liste d'employés ayant les même caractéristiques que ceux présents dans le constructeur :
public class MainEx3 {
    public static void main(String[] args) {
        List<TP4.Exo3.Employee> list = Arrays.asList(
                new TP4.Exo3.Employee("John", "Manager", 10000),
                new TP4.Exo3.Employee("Mary", "Manager", 10000),
                new TP4.Exo3.Employee("Peter", "Manager", 10000),
                new TP4.Exo3.Employee("Joohn", "Developer", 5000),
                new TP4.Exo3.Employee("Maary", "Developer", 5000),
                new TP4.Exo3.Employee("Pete", "Developer", 5000),
                new TP4.Exo3.Employee("Johny", "QA", 5000),
                new TP4.Exo3.Employee("Maryy", "QA", 5000)
        );


        // On réalise des HashMap pour s'en service par la suite :
        System.out.println("Hashmap by post using stream");
        HashMap<String, TP4.Exo3.Employee> mapByPost = list.stream()
                .collect(HashMap::new, (m, e) -> m.put(e.getPost(), e), HashMap::putAll);


        System.out.println(mapByPost);


        // Calcul du salaire moyen de l'ensemble des employées :
        double averageSalary = list.stream()
                .mapToInt(TP4.Exo3.Employee::getSalary)
                .average()
                .getAsDouble();
        System.out.println("Average salary of all employees: " + averageSalary);

    }
}
