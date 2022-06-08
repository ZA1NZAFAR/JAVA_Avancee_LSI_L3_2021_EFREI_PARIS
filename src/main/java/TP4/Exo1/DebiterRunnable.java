package TP4.Exo1;
// on définit le thread Debiter
public class DebiterRunnable implements Runnable {
    private Compte compte;
    private int montant;

    public DebiterRunnable(Compte compte, int montant) {
        this.compte = compte;
        this.montant = montant;
    }

    @Override
    public void run() {
        compte.debiter(montant);
    }
}
