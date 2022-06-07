package TP4.Exo1;
// réation d'une classe permettant de définir un compte bancaire

public class Compte {
    int solde;

    public Compte(int solde) {
        this.solde = solde;
    }

    /* On définit les fonctions "crediter" et "debiter" + on identifie les cas improbables :
    1. Si l'utilisateur veut créditer le compte avec un montant négatif => impossible
    2. Si l'utilisateur suhaite réaliser un retrait inféiruer au solde du compte ou qu'il souhaite retirer un montant négatif
    */

    // "synchronized" permet de s'assurer qu'un thread accède à une ressource après un premier qui a terminé de l'utiliser

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

    // permet d'afficher le solde du compte
    public int getSolde() {
        return this.solde;
    }
}
