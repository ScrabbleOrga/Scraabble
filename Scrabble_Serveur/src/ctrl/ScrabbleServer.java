package Server.ctrl;

import serveur.connexion.ProtocoleSrv;
import java.io.*;
import java.net.*;

public class ScrabbleServer {

    public static void main(String[] args) {
        ScrabbleServer ScrabbleServer = new ScrabbleServer();
        ScrabbleServer.start();
    }
    
    public ScrabbleServer() {}
    
    public ScrabbleServer(int port) {
        this.port = port;
    }
 
    public void start() {
        int nbconn = 0;
        try {
            InetAddress adresse = InetAddress.getLocalHost();
            System.out.println("Adresse: " + adresse);
            ServerSocket server = new ServerSocket(port);
            while (true) {
                System.out.println("Connexion(s) établie(s) : " + nbconn);
                Socket s = server.accept();
                nbconn++;
                ProtocoleSrv proto = new ProtocoleSrv(s);
                Thread thrClient = new ThreadCtrl(proto);
                thrClient.start();
            }
        } catch (IOException e) {
            System.out.println("Erreur: " + e);
        }
    }
    private int port = 8189;
}

