package ServerScrabble.Ctrl;

import java.io.*;
import java.net.*;
import ServerScrabble.connexion.ProtocoleSrv;
/**
 *
 * @author Vince
 */
public class ServerScrabble {

    public static void main(String[] args) {
        ServerScrabble serverScrabble = new ServerScrabble();
        serverScrabble.start();
    }
    public ServerScrabble() {}
    
    public ServerScrabble(int port) {
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

