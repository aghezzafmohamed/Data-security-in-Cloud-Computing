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
import java.util.ArrayList;
import static javaapplication.Application.jTextArea3;
 
import javax.swing.JTextArea;


public class Client implements Runnable{
    /**
 *
 * @author AGHEZZAF Mohamed
 */
    //Nous d�clarons les variables n�cessaires pour la connexion et la communication
    private Socket client;
    public static String noms;
    private DataInputStream in;
    private DataOutputStream out;
    //Le port doit �tre le m�me sur lequel le serveur �coute
    private int port = 12345;
    //Si nous sommes dans notre m�me machine, nous utilisons localhost sinon l'adresse IP de la machine serveur
    private String host = "localhost";
    private String messages = "";
   
    JTextArea textClient;
    public static ArrayList<String> ch =new ArrayList(); 
    //Le constructeur re�oit comme param�tre le panneau o� les messages seront affich�s
    public Client(JTextArea textClient, String nom,String host){
    	
        this.host=host;
        this.textClient = textClient;
        try {
           
            client = new Socket(host,port);
            jTextArea3.append("Serveur  \n"+"_________________________________________\n"+nom+" est bien connecter\n");
            
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        
    @Override
    public void run() {
        try{
            //Cycle infini qui �coute les messages du serveur et les affiche sur le panneau
            while(true){
            	messages += in.readUTF();
            	textClient.setText(messages);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Fonction utilis�e pour envoyer des messages au serveur
    public void envoyermsg(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    	
    }
    
