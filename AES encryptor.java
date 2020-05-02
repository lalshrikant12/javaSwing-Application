package encryptor;
import javax.swing.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.security.MessageDigest;

import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class AES extends JFrame 
{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2;
	JButton b1,b2;
	public AES() { }
	
	public AES(String s)
	{
		super(s);
	}
	public void setComponents()
	{
		l1= new JLabel("ENTER NORMAL TEXT");
		l2=new JLabel("ENCRYPTED TEXT");
	    l3=new JLabel("MESSAGE ENCRYPTOR");
		t1=new JTextField();
		t2=new JTextField();
		b1= new JButton("AES");
		b2=new JButton("DES");
		setLayout(null);
		l1.setBounds(150,150,200,50);
	    l2.setBounds(150,420,200,50);
		t1.setBounds(360,150,300,200);
		b1.setBounds(370,360,100,50);
		t2.setBounds(360,420,300,200);
		l3.setBounds(200,20,150,150);
		b2.setBounds(400,360,100,50);
		b1.addActionListener(new Handler());
		add(l1);
		add(l2);
	    add(t2);
		add(t1);
		add(b1);
		add(l3);
		
				
	}
	public class Handler implements ActionListener
	{   
		

		public void actionPerformed(ActionEvent e)
		{//  		
			Cipher cipher;
			String plainText=t1.getText();
			KeyGenerator keyGenerator = null;
			try {
				keyGenerator = KeyGenerator.getInstance("AES");
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			keyGenerator.init(128);
			SecretKey secretKey = keyGenerator.generateKey();
			try {
				cipher = Cipher.getInstance("AES");
			} catch (NoSuchAlgorithmException | NoSuchPaddingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String plainText1 = t1.getText();
		//	String plainText = "AES Symmetric Encryption Decryption";
			System.out.println("Plain Text Before Encryption: " + plainText1);

			String encryptedText = null;
			try {
				encryptedText = encrypt(plainText1, secretKey);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//System.out.println("Encrypted Text After Encryption: " + encryptedText);

			//String decryptedText = decrypt(encryptedText, secretKey);
		//	System.out.println("Decrypted Text After Decryption: " + decryptedText);
			t2.setText(encryptedText);
		}

		public String encrypt(String plainText, SecretKey secretKey)
				throws Exception {
			byte[] plainTextByte = plainText.getBytes();
			Cipher cipher = null;
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encryptedByte = cipher.doFinal(plainTextByte);
			Base64.Encoder encoder = Base64.getEncoder();
			String encryptedText = encoder.encodeToString(encryptedByte);
			return encryptedText;
		}

	/*	public static String decrypt(String encryptedText, SecretKey secretKey)
				throws Exception {
			Base64.Decoder decoder = Base64.getDecoder();
			byte[] encryptedTextByte = decoder.decode(encryptedText);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
			String decryptedText = new String(decryptedByte);
			return decryptedText;
			*/
			//System.out.println( sha1 );
			
		
	        
		}
		
	
		
		
public static void main(String args[])
{
Hash jf=new Hash("Encryptor");
jf.setComponents();
jf.setSize(1000,1000);
jf.setVisible(true);
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}


