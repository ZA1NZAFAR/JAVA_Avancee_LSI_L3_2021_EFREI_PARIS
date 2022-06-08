package TP4.Exo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Client class
class Client {


    public static void main(String[] args) {
        // mise en place de la connexion entre le serveur et le client :
        try (Socket socket = new Socket("localhost", 8080)) {

            // Variable permettant d'écrire au niveau du serveur :
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Variable permettant de lire au niveau du serveur :
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // mis en place d'un scanner permettant de lire les données :
            Scanner sc = new Scanner(System.in);
            String line = null;

            System.out.println("Entrez votre nom : ");


            //lecture de la saisie de l'utilisateur :
            line = sc.nextLine();

            // Affichage de sa saisie :
            out.println(line);
            out.flush();


            // reading from server
            String response = in.readLine();

            // affichage de la réponse du serveur :
            System.out.println("Server replied " + response);
            if (response.equals("OK!")) {
                System.out.println("Vous êtes connecté");
            } else {
                System.out.println("Vous n'êtes pas connecté");
            }


            // fermeture du "scanneur de réponses" :
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
