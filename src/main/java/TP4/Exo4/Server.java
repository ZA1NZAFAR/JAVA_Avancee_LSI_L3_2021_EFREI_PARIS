package TP4.Exo4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Server class
class Server {
    public static void main(String[] args) {
        int nbClients = 0;
        ServerSocket server = null;
        // on observe qu'il y a la mise en place commune d'un port de communication faisant intervenir un socket de communication entre la partie cliente et serveur :
        try {
            server = new ServerSocket(8080);
            server.setReuseAddress(true);

            while (true) {

                // Dès lors que la connexion a été établie => affichage des infos concernant le client :
                Socket client = server.accept();
                nbClients++;

                System.out.println("New client connected with ipAddress : " + client.getInetAddress().getHostAddress() + " nbClients : " + nbClients);

                //Cas de la mise en place d'un thread qui va s'occuper de la mise en place du client à part, indépendamment de la partie serveur :
                ClientHandler clientSock = new ClientHandler(client);

                new Thread(clientSock).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Classe ClientHandler :
    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        // Constructeur :
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        // définition du thread :
        public void run() {
            System.out.println("Thread started");
            PrintWriter out = null;
            BufferedReader in = null;
            try {

                // outputstream du client :
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                // inputstream du client :
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                //Message de l'utilisateur :
                String line = in.readLine();

                //Vérifier que le fichier contient les infos concernant l'utilisateur, si ce n'est pas le cas => on retourne une exception, sinon on affiche un message de validation :
                Scanner sc = new Scanner(new File("users.txt"));
                while (sc.hasNextLine()) {
                    String line2 = sc.nextLine();
                    if (line2.contains(line)) {
                        out.println("OK!");
                        break;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
