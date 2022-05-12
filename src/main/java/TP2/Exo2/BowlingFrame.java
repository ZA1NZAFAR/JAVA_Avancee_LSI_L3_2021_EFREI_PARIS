package TP2.Exo2;

/* Une partie de bowling est constituée d'un total de 10 frames. Un frame étant décomposée en 2 lancers.
un frame est un tour composé de 2 lancés s'il n'y a pas de strike (10 quilles touchées au premier tour)
Les 2 lancés peuvent donner un score total anodin, ou égal à celui d'un strike : 10. On parle alors de spare.
Le calcul des points dépend de la nature du lancer ayant été effectuée.
Différents cas de figures sont à considérer :
1. Le joueur a effectué un spare (10 quilles touchées au frame en cours) :
-> score intermédiaire = score du premier 1/2 frame + score du second 1/2 frames = 10 => on additionne à 10 le score du prochain 1/2 frame
2. Le joueur a effectué un strike (10 quilles touchées dès le 1/2 frame en cours) :
-> score intermédiaire = 10 + score du frame suivant
3. Le joueur a réalisé un frame d'un score anodin (différent de 10) :
-> score intermédiaire = somme des 1/2 frames effectué
Cas particulier :
Le dernier frame est composé de 3 lancés au lieu de 2
*
*/

public class BowlingFrame {
    protected int firstThrow;
    protected int secondThrow;
    protected int bonus;


    // On définit la partie de bowling :
    // le bonus représente la dernière partie
    public BowlingFrame() {
        this.firstThrow = 0;
        this.secondThrow = 0;
        this.bonus = 0;
    }

    // Mise en place d'un schéma de frame classique en dépit du dernier qu'on considérera par la suite
    public BowlingFrame(int firstThrow, int secondThrow) { // bonus est calculé a la fin de la partie
        setFirstThrow(firstThrow);
        setSecondThrow(secondThrow);
        this.bonus = 0;
    }

    // Calcul du score pour le premier lancer du frame en cours :
    public void setFirstThrow(int firstThrow) {
        // si on observe que le lancé n'est pas possible : erreur
        if (firstThrow < 0 || firstThrow > 10)
            throw new IllegalArgumentException("Le premier lancer doit être compris entre 0 et 10");
        // snon on considère la valeur de ce premier lancé
        this.firstThrow = firstThrow;
    }

    // Calcul du score pour le deuxième lancer du frame en cours :
    public void setSecondThrow(int secondThrow) {
        // si on observe que le lancé n'est pas possible : erreur
        if (secondThrow < 0 || secondThrow > 10)
            throw new IllegalArgumentException("Le deuxième lancer doit être compris entre 0 et 10");
        // Lorsque le premier lancé est un strike, le second lancée n'est pas réalisé : erreur
        if (this.isStrike())
            throw new IllegalArgumentException("Le deuxième lancer ne peut pas être défini pour un lancer de strike");
        // Le score d'un frame est compris dans [0;10], sinon erreur
        if (secondThrow + this.firstThrow > 10)
            throw new IllegalArgumentException("La somme des deux lancers ne peut pas dépasser 10");
        this.secondThrow = secondThrow;
    }

    public void setBonus(int bonus) {
        if (isStrike()) { // si c'est un strike, le bonus peut aller jusqu'à 20 (le strike est un strike)
            if (bonus < 0 || bonus > 20)
                throw new IllegalArgumentException("Le bonus suite à un strike doit être compris entre 0 et 20");
            else
                this.bonus += bonus;
        } else if (isSpare()) { // si c'est un spare, le bonus peut aller jusqu'à 10 (lancer suivant est un strike)
            if (bonus < 0 || bonus > 10)
                throw new IllegalArgumentException("Le bonus suite à un spare doit être compris entre 0 et 10");
            else
                this.bonus += bonus;
        } else { // si c'est un simple lancer, le bonus ne peut pas aller plus loin que le score du lancer
            throw new IllegalArgumentException("Le bonus ne peut être défini que pour un lancer de strike ou de spare");
        }
    }

    public int getScore() {
        return this.firstThrow + this.secondThrow + this.bonus;
    }

    // Le cas du strike est défini à part. On indique que ce dernier concerna le premier lancé car un strike ne peut as être effectué au second lancé du frame
    public boolean isStrike() {
        return this.firstThrow == 10;
    }

    // Si on observe que le lancé n'est pas un strike, et que la somme du premier et du second lancé vaut 10, alors on est dans un strike
    public boolean isSpare() {
        return !isStrike() && this.firstThrow + this.secondThrow == 10;
    }

    // Affichage du résultat du premier lancé du frame :
    public int getFirstThrowScore() {
        return this.firstThrow;
    }

    // Affichage du résultat du second lancé du frame :
    public int getSecondThrowScore() {
        return this.secondThrow;
    }
}