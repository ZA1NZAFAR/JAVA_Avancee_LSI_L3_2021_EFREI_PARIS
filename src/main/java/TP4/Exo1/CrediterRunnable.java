package TP4.Exo1;
public class CrediterRunnable implements Runnable {
    private Compte compte;
    private int montant;

    public CrediterRunnable(Compte compte, int montant) {
        this.compte = compte;
        this.montant = montant;
    }

    @Override
    public void run() {
        compte.crediter(montant);
    }
}
