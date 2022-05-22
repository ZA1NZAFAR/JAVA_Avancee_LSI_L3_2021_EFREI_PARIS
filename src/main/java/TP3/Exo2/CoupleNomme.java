package TP3.Exo2;

// Il est dit de "créer par dérivation" = notion d'héritage => on utilise un extends ici
//La classe CoupleNomme est initialisée avec le même type de classe que la classe CoupleNomme
public class CoupleNomme<T> extends Couple<T> {
    private String str;

    // Constructeur impliquant la classe-mère avec "super(premier, second)"
    public CoupleNomme(T premier, T second, String str) {
        super(premier, second);
        this.str = str;
    }

    // De même pour l'affichage, on fait appel à la méthode d'affichage de la fonction mère à l'aide de "super.affiche()"
    public void affiche() {
        System.out.print("nom	=	" + str + "	-	");
        super.affiche();
    }
}