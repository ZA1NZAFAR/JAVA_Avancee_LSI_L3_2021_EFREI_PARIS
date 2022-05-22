package TP3.Exo1;

import java.util.Locale;

// On définit l'ensemble des attributs d'une instance de la classe Triplet et on récupère les attributs nécessaires qu'on affiche avec les méthodes "get" de la classe :
public class MainEx1 {
    public static void main(String[] args) {
        Triplet<String> t = new Triplet<>("Premier", "Second", "Troisieme");
        t.setPremier(t.getPremier().toUpperCase(Locale.ROOT));
        t.setSecond(t.getSecond().toUpperCase(Locale.ROOT));
        t.setTroisieme(t.getTroisieme().toUpperCase(Locale.ROOT));
        System.out.println(t);
    }
}
