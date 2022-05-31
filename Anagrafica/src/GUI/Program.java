package GUI;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Program{
	public static void main(String[] args) {
		Home prova=new Home();
		prova.setVisible(true);
	}
	
	public static class Home extends Frame{
		public Home(){
			super("HOME");
			setLayout(new BorderLayout(100,10));
			setLocation(300,300);
			Font ft=new Font("Lucida",Font.PLAIN,24);
			
			JLabel tx=new JLabel();
			tx.setText("<html>Benvenuti nel database, cosa si desidera fare? ");
			tx.setFont(ft);
			add("North",tx);
			JLabel t1=new JLabel();
			t1.setText("<html>Inserire nuovi<br>dati nel database ");
			t1.setFont(ft);
			t1.setForeground(new Color(125,10,10));
			add("West",t1);
			JLabel t2=new JLabel();
			t2.setText("<html>Consultare i dati<br>presenti nel database ");
			t2.setFont(ft);
			t2.setForeground(new Color(10,10,125));
			add("East",t2);
			
			Panel contenuto=new Panel();
			contenuto.setLayout(new GridLayout(1,2));
			
			Button b1=new Button("INSERISCI");
			b1.setBackground(new Color(225,50,50));
			b1.setPreferredSize(new Dimension(80,50));
			Inseri insert = new Inseri();
			Al al1=new Al(insert);
			b1.addActionListener(al1);
			contenuto.add(b1);
			
			Button b2=new Button("CONSULTA");
			b2.setBackground(new Color(50,50,225));
			b2.setPreferredSize(new Dimension(80,50));
			Consul consu = new Consul();
			Al al2=new Al(consu);
			b2.addActionListener(al2);
			contenuto.add(b2);
			
			add("South",contenuto);
			pack();
		}
	}		
}