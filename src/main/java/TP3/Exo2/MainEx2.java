package TP3.Exo2;

public class MainEx2 {
    public static void main(String[] args) {
        Couple<Integer> c1 = new Couple<>(5, 2);
        c1.affiche();
        Couple<Integer> c2 = new Couple<>(5, 2);
        c2.affiche();
        CoupleNomme<String> cns = new CoupleNomme<>("Str1", "Str2","Str3");
        cns.affiche();
        CoupleNomme<Couple<Integer>> cnd = new CoupleNomme<>(c1, c2, "Couple Nomme");
        cnd.affiche();
        PointNomme p1 = new PointNomme(2, 5, "Point Nomme");
        p1.affiche();
    }
}
