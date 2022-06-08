package TP4.Exo1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // on crée un compte crédité de 100€, on debite ce dernier de 20€ à l'aide de la classe de thread u'on a aupravant défini). Puis, on crédite 50€ => on obtient alors un total de 130€
        Compte compte = new Compte(100);
        DebiterRunnable debitRunnable = new DebiterRunnable(compte, 20);
        CrediterRunnable crediterRunnable = new CrediterRunnable(compte, 50);
        Thread debitThread = new Thread(debitRunnable);
        Thread creditThread = new Thread(crediterRunnable);

        debitThread.start(); // pour demarrer le thread
        creditThread.start();

        // on utilise 2 threads, afin de s'assurer qu'on exécute les 2 fonctions relatifs aux 2 threads au sein du main (3ème thread)) avant d'afficher le résultat final
        debitThread.join(); // pour attendre la fin du thread
        creditThread.join();

        System.out.println(compte.getSolde());
    }
}