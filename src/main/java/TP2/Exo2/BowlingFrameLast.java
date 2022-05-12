package TP2.Exo2;

// Particularité de la dernière partie ?
// -> Si le joueur réalise un strike => 3 lancés autorisés pour calculer les points de la dernière frame
// -> Si le joueur réalise un spare/score anodin => 2 lancés autorisés pour calculer les points de la dernière frame

// On étudie le dernier frame d'une partie de bowling dans cette classe à part qui est une "classe particulière" de Bowlingframe
public class BowlingFrameLast extends BowlingFrame {
    private int thirdThrow;

    // On définit le cas où la dernière colonne : 3ème collone supplémentaire ne sera pas définie
    public BowlingFrameLast() {
        super();
        this.thirdThrow = 0;
    }

    // Cas où le joueur n'a pas effectué de strike :
    public BowlingFrameLast(int firstThrow, int secondThrow) {
        super(firstThrow, secondThrow);
    }

    // Cas où le joueur a effectué un strike :
    public BowlingFrameLast(int firstThrow, int secondThrow, int thirdThrow) {
        super(firstThrow, secondThrow);
        this.thirdThrow = thirdThrow;
    }

    // On traite le cas du second lancer, et on indique que ce dernier ne peut être en dehors de [0;10]. Car en effet, un score supérieur à 10 au 2nd lancé n'est possible que dans le cas d'un strike est effectué.
    @Override
    public void setSecondThrow(int secondThrow) {
        if (secondThrow < 0 || secondThrow > 10)
            throw new IllegalArgumentException("Le deuxième lancer doit être compris entre 0 et 10");
        else if (!super.isStrike() && this.firstThrow + secondThrow > 10)
            throw new IllegalArgumentException("Le premier lancer + le deuxième lancer doit être inférieur ou égal à 10");
        else
            this.secondThrow = secondThrow;
    }

    // Le trosième lancé n'est autorisé que dans le cas d'un strike (prbl au niveau du premier "else if" ????)
    public void setThirdThrow(int thirdThrow) {
        if (thirdThrow < 0 || thirdThrow > 10)
            throw new IllegalArgumentException("Le troisième lancer doit être compris entre 0 et 10");
        else if (!super.isStrike() && !super.isSpare())
            throw new IllegalArgumentException("Le 3ème lancer ne peut être défini que pour un strike ou un spare");
        else
            this.thirdThrow = thirdThrow;
    }

    @Override
    public boolean isStrike() { // on ne prend pas en compte les strikes dans le dernier tour, car ils sont déjà pris en compte dans le score
        return false;
    }

    @Override
    public boolean isSpare() { // on ne prend pas en compte les spares dans le dernier tour, car ils sont déjà pris en compte dans le score
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