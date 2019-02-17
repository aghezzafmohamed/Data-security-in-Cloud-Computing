package javaapplication;

 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

 
import javax.swing.JTextArea; 

public class Serveur implements Runnable {
    /**
 *
 * @author AGHEZZAF Mohamed
 */
       public static JTextArea textServeur;
public Serveur( JTextArea textServeur){
 
    this.textServeur=textServeur;
}

    //itialiser le port et le nombre maximum de connexions acceptées par le serveur
	private final int port = 12345;
      private DataInputStream in;
    private DataOutputStream out;
    //Nous créons une liste de sockets, où nous allons stocker les sockets qui sont connectés
    private LinkedList<Socket> clients = new LinkedList<Socket>();
   

   //Fonction pour que le serveur commence à recevoir des connexions de clients
    public void ecouter(){
        try {
            //Nous créons la socket serveur
            ServerSocket server = new ServerSocket(12345);
            //Cycle infini à l'écoute des nouveaux clients
            while(true){
               
               textServeur.setText("Serveur  "+"\n_________________________________________\n"+"server Connecte....\n");
                
                //Quand un client se connecte, nous gardons le socket dans notre liste
                Socket s = server.accept();
                clients.add(s);
               
                //Instancier un thread qui servira le client et nous le mettons à l'écoute
                Runnable  run = new Connexion(s,clients,textServeur);
                Thread t = new Thread(run);
                t.start();
             
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

@Override
public void run() {
ecouter();
	
}
}
    /*Fonction principale pour exécuter le serveur
    public static void main(String[] args) {
    	Serveur server= new Serveur();
    	server.ecouter();*/

