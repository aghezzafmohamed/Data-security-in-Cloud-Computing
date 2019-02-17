package javaapplication;
 
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.hslf.record.Document;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
 
 
public class AES {
 /**
 *
 * @author AGHEZZAF Mohamed
 */
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static String line;
    private static String cle;
    static ArrayList<String> txt=new ArrayList<>();
    static ArrayList<String> txtCrypte=new ArrayList<>();
    static ArrayList<String> txtDecrypte=new ArrayList<>();;

    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
//methode pour crypter
    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("erreur lors d'encryption: " + e.toString());
        }
        return null;
    }
    
//methode pour decrypter
    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
        
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getMimeDecoder().decode(strToDecrypt)));
           
        }
        catch (Exception e)
        {
            System.out.println("erreur lors de decyption: " + e.toString());
        }
        return null;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
    }
        
    } 