/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

import javax.swing.JTextArea;

public class Connexion implements Runnable{
    /**
 *
 * @author AGHEZZAF Mohamed
 */
    //Nous déclarons les variables que le thread utilise pour recevoir et envoyer des messages
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    JTextArea textServeur;
    //Liste des utilisateurs connectés au serveur
    private LinkedList<Socket> clients = new LinkedList<Socket>();
    String noms[] = {"mohamed", "ali", "alice"};
    private String connecter;
    private static int nb=0;   
    
    //Constructeur qui reçoit le socket qui va participer au thread et la liste des utilisateurs connectés
    public Connexion(Socket s,LinkedList client,JTextArea textServeur ){
        socket = s;
        clients = client;
        this.textServeur=textServeur;
       
    }
      
    
    @Override
    public void run() {
        try {
            //Nous initialisons les canaux de communication et envoyons un message de bienvenue
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream()); 
            if(nb==0)
            textServeur.setText("Serveur  "+"\n_________________________________________\n"+"server Connecte....\n"+"mohamed est bien connecter... \n");
            else  if(nb==1){
            textServeur.append("mohamed est bien connecter... \n");
            textServeur.append("ali est bien connecter... \n");}
            else if(nb==2){
            textServeur.append("mohamed est bien connecter... \n");
            textServeur.append("ali est bien connecter... \n");
            textServeur.append("alice est bien connecter... \n"); }
            
            out.writeUTF("Client  "+"\n_______________________________________________\n");
          
             //textServeur.append(connecter+" est bien connecter... \n");
               nb++;
             //Cycle infini pour écouter les messages des clients
            while(true){
               String msg = in.readUTF();
                                 String[] t4=msg.split("@");
                                 String destinataire=t4[1];
                                 String expediteur=t4[2];
                                 msg=t4[0];
                                  
	    			textServeur.append(expediteur+" a envoyer un message à: "+destinataire+" \n");
                          for(int i=0;i<noms.length;i++){
                              if(noms[i].equals(destinataire)){
	    		    	  out = new DataOutputStream(clients.get(i).getOutputStream());
	    		     out.writeUTF(expediteur+" :"+msg+"\n");  
                              }  
                                 if(noms[i].equals(expediteur)){
	    		    	  out = new DataOutputStream(clients.get(i).getOutputStream());
	    		     out.writeUTF("vous :"+msg+"\n");  
                              }  
                              }
                                
            }
            } catch (IOException e) {
            //Si une exception se produit, la chose la plus sûre est que le client est déconnecté, donc nous l'enlevons de la liste des connectés
            for (int i = 0; i < clients.size(); i++) {
                if(clients.get(i) == socket){
                	clients.remove(i);
                    break;
                } 
            }
        }
    }
}
