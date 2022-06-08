package TP3.Exo2;

//La classe PointNomme n'est pas generique mais la classe Couple est generique et donc on peut l'utiliser avec des types differents
public class PointNomme extends Couple<Integer> {
    private String nom;

    public PointNomme(Integer premier, Integer second, String nom) {
        super(premier, second);
        this.nom = nom;
    }

    public void affiche() {
        System.out.print("nom	=	" + nom + "	-	");
        super.affiche();
    }
}