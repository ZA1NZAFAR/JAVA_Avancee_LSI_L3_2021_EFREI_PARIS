package TP4.Exo1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Compte compte = new Compte(100);
        DebiterRunnable debitRunnable = new DebiterRunnable(compte, 20);
        CrediterRunnable crediterRunnable = new CrediterRunnable(compte, 50);
        Thread debitThread = new Thread(debitRunnable);
        Thread creditThread = new Thread(crediterRunnable);

        debitThread.start(); // pour demarrer le thread
        creditThread.start();

        debitThread.join(); // pour attendre la fin du thread
        creditThread.join();

        System.out.println(compte.getSolde());
    }
}