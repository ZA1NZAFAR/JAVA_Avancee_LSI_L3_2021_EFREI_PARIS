package TP3.Exo2;

public class MainEx2 {
    public static void main(String[] args) {
        Couple<Integer> c1 = new Couple<>(5, 2);
        c1.affiche();
        Couple<Integer> c2 = new Couple<>(5, 2);
        c2.affiche();
        CoupleNomme<String> cns = new CoupleNomme<>("Bonbon", "Barbe à papa","Super Glace");
        cns.affiche();
        CoupleNomme<Couple<Integer>> cnd = new CoupleNomme<>(c1, c2, "Couple numéro 4");
        cnd.affiche();
        PointNomme p1 = new PointNomme(2, 5, "Point numéro 1");
        p1.affiche();
    }
}
