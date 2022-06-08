package TP3.Exo3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) throws EmployeException {
        Entreprise e1 = new Entreprise("IBM");
        e1.ajouter(new Employe("Dupond", 5000));
        e1.ajouter(new Employe("Poiret", 6000));
        e1.ajouter(new Employe("Burot", 5700));
        e1.ajouter(new Employe("Pernaut", 4300));
        System.out.println(e1);

        // Remplit une liste avec les employés
        List<Employe> l = new ArrayList<>();
        for (Employe e : e1) {
            l.add(e);
        }

//        Tri par salaires croissants (version avec lambda)
        l.sort((emp1, emp2) -> Double.compare(emp1.getSalaire(), emp2.getSalaire()));
//        l'utilisation de l'expression lambda permet de se débarrasser de la classe CompareSalaire
//        ce qui permet de raccourcir le code et de le rendre plus lisible.


        System.out.println("Employés de " + e1.getNom() + " par ordre croissant des salaires");
        for (Employe employe : l) {
            System.out.println(employe.getNom() + " gagne " + employe.getSalaire());
        }
    }
}


/**
 * Une entreprise
 */
class Entreprise implements Iterable<Employe> {
    private String nom;
    private ArrayList<Employe> employes;

    public Entreprise(String nom) {
        this.nom = nom;
        employes = new ArrayList<Employe>();
    }

    public String getNom() {
        return nom;
    }

    public void ajouter(Employe emp) throws EmployeException {
        if (!employes.add(emp)) {
            throw new EmployeException("Employé déjà dans cette entreprise");
        }
    }

    @Override
    public Iterator<Employe> iterator() {
        return employes.iterator();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(nom);
        for (Employe employe : employes) {
            sb.append("\n   " + employe.getNom());
        }
        return sb.toString();
    }
}

/**
 * Un employé.
 */
class Employe {
    private String nom;
    private double salaire;

    protected Employe(String nom, double salaire) {
        this.nom = nom;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public double getSalaire() {
        return salaire;
    }
}

class EmployeException extends Exception {
    public EmployeException(String message) {
        super(message);
    }
}

// Après avoir utilisé l'expression lambda dans le code, nous n'avons plus besoin de cette classe.
//class CompareSalaire implements Comparator<Employe> {
//
//    /**
//     * Compare 2 employés suivant leur salaire.
//     *
//     * @return un nombre positif si le salaire de e1 est supérieur au
//     * salaire de e2, 0 si les 2 salaires sont les mêmes, et négatif sinon.
//     */
//    public int compare(Employe e1, Employe e2) {
//        return Double.compare(e1.getSalaire(), e2.getSalaire());
//    }
//}