package TP4.Exo3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainEx3 {
    public static void main(String[] args) {
        List<TP4.Exo3.Z.Employee> list = Arrays.asList(
                new TP4.Exo3.Z.Employee("John", "Manager", 10000),
                new TP4.Exo3.Z.Employee("Mary", "Manager", 10000),
                new TP4.Exo3.Z.Employee("Peter", "Manager", 10000),
                new TP4.Exo3.Z.Employee("Joohn", "Developer", 5000),
                new TP4.Exo3.Z.Employee("Maary", "Developer", 5000),
                new TP4.Exo3.Z.Employee("Pete", "Developer", 5000),
                new TP4.Exo3.Z.Employee("Johny", "QA", 5000),
                new TP4.Exo3.Z.Employee("Maryy", "QA", 5000)
        );


        // Hashmap by post using stream
        System.out.println("Hashmap by post using stream");
        HashMap<String, TP4.Exo3.Z.Employee> mapByPost = list.stream()
                .collect(HashMap::new, (m, e) -> m.put(e.getPost(), e), HashMap::putAll);


        System.out.println(mapByPost);


        // Average salary of all employees
        double averageSalary = list.stream()
                .mapToInt(TP4.Exo3.Z.Employee::getSalary)
                .average()
                .getAsDouble();
        System.out.println("Average salary of all employees: " + averageSalary);

    }
}
