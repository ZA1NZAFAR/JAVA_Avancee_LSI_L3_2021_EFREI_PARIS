package TP2.Exo2;

public class BowlingFrameLast extends BowlingFrame {
    private int thirdThrow;

    public BowlingFrameLast() {
        super();
        this.thirdThrow = 0;
    }

    public BowlingFrameLast(int firstThrow, int secondThrow) {
        super(firstThrow, secondThrow);
    }

    public BowlingFrameLast(int firstThrow, int secondThrow, int thirdThrow) {
        super(firstThrow, secondThrow);
        this.thirdThrow = thirdThrow;
    }

    @Override
    public void setFirstThrow(int firstThrow) {
        if (firstThrow < 0 || firstThrow > 10) {
            throw new IllegalArgumentException("Le premier lancer doit être compris entre 0 et 10");
        } else {
            this.firstThrow = firstThrow;
        }
    }


    @Override
    public void setSecondThrow(int secondThrow) {
        if (secondThrow < 0 || secondThrow > 10)
            throw new IllegalArgumentException("Le deuxième lancer doit être compris entre 0 et 10");
        else if (!super.isStrike() && this.firstThrow + secondThrow > 10)
            throw new IllegalArgumentException("Le premier lancer + le deuxième lancer doit être inférieur ou égal à 10");
        else
            this.secondThrow = secondThrow;
    }

    public void setThirdThrow(int thirdThrow) {
        if (thirdThrow < 0 || thirdThrow > 10)
            throw new IllegalArgumentException("Le troisième lancer doit être compris entre 0 et 10");
        else if (!super.isStrike() && !super.isSpare())
            throw new IllegalArgumentException("Le 3ème lancer ne peut être défini que pour un strike ou un spare");
        else
            this.thirdThrow = thirdThrow;
    }

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public boolean isSpare() {
        return false;
    }

    @Override
    public int getScore() {
        return super.getScore() + this.thirdThrow;
    }

    @Override
    public void setBonus(int bonus) {
        throw new UnsupportedOperationException("Pas de bonus pour le dernier tour");
    }

}