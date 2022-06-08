package TP4.Exo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Client class
class Client {

    // driver code
    public static void main(String[] args) {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 8080)) {

            // writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // reading from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // object of scanner class
            Scanner sc = new Scanner(System.in);
            String line = null;

            System.out.println("Entrez votre nom : ");


            // reading from user
            line = sc.nextLine();

            // sending the user input to server
            out.println(line);
            out.flush();


            // reading from server
            String response = in.readLine();

            // displaying server reply
            System.out.println("Server replied " + response);
            if (response.equals("OK!")) {
                System.out.println("Vous êtes connecté");
            } else {
                System.out.println("Vous n'êtes pas connecté");
            }


            // closing the scanner object
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
