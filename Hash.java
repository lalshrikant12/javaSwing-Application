package encryptor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.security.MessageDigest;
public class Hash extends JFrame 
{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2;
	JButton b1;
	public Hash() { }
	
	public Hash(String s)
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
		b1= new JButton("ENCRYPT");
		setLayout(null);
		l1.setBounds(150,150,200,50);
	    l2.setBounds(150,420,200,50);
		t1.setBounds(360,150,300,200);
		b1.setBounds(370,360,100,50);
		t2.setBounds(360,420,300,200);
		l3.setBounds(200,20,150,150);
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
			String s1=t1.getText();
			//String value = "this is a test";

			String sha1 = "";
			
			// With the java libraries
			try {
				MessageDigest digest = MessageDigest.getInstance("SHA-1");
		        digest.reset();
		        digest.update(s1.getBytes("utf8"));
		        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
			} catch (Exception e1){
				e1.printStackTrace();
			}

			
			//System.out.println( sha1 );
			t2.setText(sha1);
		
	        
		}

		
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
