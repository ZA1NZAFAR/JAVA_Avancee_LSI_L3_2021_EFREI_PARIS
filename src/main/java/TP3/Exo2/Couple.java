package TP3.Exo2;

// Enoncé :
public class Couple<T> {
    private T x, y;

    public Couple(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public void affiche() {
        System.out.println("premiere valeur : " + x + " deuxieme valeur : " + y);
    }
}
