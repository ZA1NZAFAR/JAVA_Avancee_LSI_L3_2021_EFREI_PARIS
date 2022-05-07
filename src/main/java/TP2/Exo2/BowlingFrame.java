package TP2.Exo2;

public class BowlingFrame {
    protected int firstThrow;
    protected int secondThrow;
    protected int bonus;


    public BowlingFrame() {
        this.firstThrow = 0;
        this.secondThrow = 0;
        this.bonus = 0;
    }

    public BowlingFrame(int firstThrow, int secondThrow) { // bonus est calculé a la fin de la partie
        setFirstThrow(firstThrow);
        setSecondThrow(secondThrow);
        this.bonus = 0;
    }

    public void setFirstThrow(int firstThrow) { // score pour le premier lancer
        if (firstThrow < 0 || firstThrow > 10)
            throw new IllegalArgumentException("Le premier lancer doit être compris entre 0 et 10");
        this.firstThrow = firstThrow;
    }

    public void setSecondThrow(int secondThrow) { // score pour le deuxième lancer
        if (secondThrow < 0 || secondThrow > 10)
            throw new IllegalArgumentException("Le deuxième lancer doit être compris entre 0 et 10");
        if (this.isStrike())
            throw new IllegalArgumentException("Le deuxième lancer ne peut pas être défini pour un lancer de strike");
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

    public boolean isStrike() {
        return this.firstThrow == 10;
    }

    public boolean isSpare() {
        return !isStrike() && this.firstThrow + this.secondThrow == 10;
    }

    public int getFirstThrowScore() {
        return this.firstThrow;
    }

    public int getSecondThrowScore() {
        return this.secondThrow;
    }
}
