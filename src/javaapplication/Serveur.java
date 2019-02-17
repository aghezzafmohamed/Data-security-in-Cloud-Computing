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

    //itialiser le port et le nombre maximum de connexions accept�es par le serveur
	private final int port = 12345;
      private DataInputStream in;
    private DataOutputStream out;
    //Nous cr�ons une liste de sockets, o� nous allons stocker les sockets qui sont connect�s
    private LinkedList<Socket> clients = new LinkedList<Socket>();
   

   //Fonction pour que le serveur commence � recevoir des connexions de clients
    public void ecouter(){
        try {
            //Nous cr�ons la socket serveur
            ServerSocket server = new ServerSocket(12345);
            //Cycle infini � l'�coute des nouveaux clients
            while(true){
               
               textServeur.setText("Serveur  "+"\n_________________________________________\n"+"server Connecte....\n");
                
                //Quand un client se connecte, nous gardons le socket dans notre liste
                Socket s = server.accept();
                clients.add(s);
               
                //Instancier un thread qui servira le client et nous le mettons � l'�coute
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
    /*Fonction principale pour ex�cuter le serveur
    public static void main(String[] args) {
    	Serveur server= new Serveur();
    	server.ecouter();*/

