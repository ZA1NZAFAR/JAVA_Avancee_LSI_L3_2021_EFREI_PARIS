package TP3.Exo1;

// Triplet est une classe generique qui permet de representer un triplet de valeurs de type T (T peut etre n'importe quel type)
public class Triplet<T> {
    private T premier;
    private T second;
    private T troisieme;

    // Constructeur :
    public Triplet(T premier, T second, T troisieme) {
        this.premier = premier;
        this.second = second;
        this.troisieme = troisieme;
    }

// Ensemble de getters & setters :

    public T getPremier() {
        return premier;
    }

    public T getSecond() {
        return second;
    }

    public T getTroisieme() {
        return troisieme;
    }

    public void setPremier(T premier) {
        this.premier = premier;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public void setTroisieme(T troisieme) {
        this.troisieme = troisieme;
    }


    public String affiche() {
        return "Triplet{" + "premier=" + premier + ", second=" + second + ", troisieme=" + troisieme + '}';
    }
}
