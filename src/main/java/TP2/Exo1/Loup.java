package TP2.Exo1;

public class Loup {
    private String nom;
    private Orientation orientation;

    public Loup() {
    }

    public Loup(String nom, Orientation orientation){
        this.nom = nom;
        this.orientation = orientation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void turnClockwise() {
        switch (orientation) {
            case NORD:
                orientation = Orientation.EST;
                break;
            case EST:
                orientation = Orientation.SUD;
                break;
            case SUD:
                orientation = Orientation.OUEST;
                break;
            case OUEST:
                orientation = Orientation.NORD;
                break;
        }
    }
}
