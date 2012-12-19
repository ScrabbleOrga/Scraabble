package commun;

public class Message {

    private Integer code = 0;
    private String message = "";
    private Integer point = 0;
    private String paquet = "";
    
    
    //Messages de retour
    public static final int M_OK = 1; //Pas de probleme
    public static final int M_KO = 2; //KO raion inconnue
    public static final int M_JOUEXIST = 3; //KO : Le client existe
    public static final int M_JOUNOTEXIST = 4; //KO : Le joueur n'existe pas
    
    //Messages d'opérations
    public static final int OP_I = 10; //Initialisation
    public static final int OP_U = 20; //Remise à zero
   
    public Message(Integer code, String message) {
        this.code = code;
        this.message = message;
        setPaquet();
    }

    public Message(String msg) {
        String[] str = new String[3];
        str = msg.split(":");
        this.code = Integer.parseInt(str[0]);
        this.message = str[1];
        this.point = Integer.parseInt(str[2]);
        setPaquet();
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getMontant() {
        return point;
    }

    @Override
    public String toString() {
        return paquet;
    }

    private void setPaquet() {
        paquet = code.toString() + ":" + message + ":" + point.toString();
    }
}
