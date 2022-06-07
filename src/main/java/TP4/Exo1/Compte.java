package TP4.Exo1;

public class Compte {
    int solde;

    public Compte(int solde) {
        this.solde = solde;
    }

    public synchronized void crediter(int montant) {
        if (montant < 0) {
            throw new IllegalArgumentException("Montant négatif");
        }
        solde += montant;
    }

    public synchronized void debiter(int montant) {
        if (montant < 0) {
            throw new IllegalArgumentException("Montant négatif");
        }
        if (solde < montant) {
            throw new IllegalArgumentException("Solde insuffisant");
        }
        this.solde -= montant;
    }

    public int getSolde() {
        return this.solde;
    }
}
