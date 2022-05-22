package TP3.Exo2;

//La classe couple est initialisée avec le même type de classe que la classe CoupleNomme
public class CoupleNomme<T> extends Couple<T> {
    private String str;

    public CoupleNomme(T premier, T second, String str) {
        super(premier, second);
        this.str = str;
    }

    public void affiche() {
        System.out.print("nom	=	" + str + "	-	");
        super.affiche();
    }
}