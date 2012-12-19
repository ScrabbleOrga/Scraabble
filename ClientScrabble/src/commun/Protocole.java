package commun;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class Protocole {

    protected Socket socket;
    protected BufferedReader in;
    protected PrintWriter out;
    protected Message msg_recu = null;
    protected String adrIP;
    protected int port;
    
    //Messages de connexions
    public static final int CONN_OK = 100;
    public static final int CONN_KO = 200;
    public static final int CONN_ACK = 500;
    public static final int CONN_NO_SCRABBLE = 400;
    
    

    protected void write(String s) {
        out.println(s);
        out.flush();
    }

    protected void write(Message m) {
        out.println(m.toString());
        out.flush();
    }
}
