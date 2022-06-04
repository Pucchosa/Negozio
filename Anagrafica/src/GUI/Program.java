package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import java.awt.event.*;

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
			
			// ISTANZIO TUTTI I FRAME SECONDARI
			DataB<Cliente> clienti=new DataB<Cliente>("cliente"); // poi togli
			DataB<Fornitore> fornitori=new DataB<Fornitore>("fornitori"); // poi togli
			ConsulPersona<DataB<Cliente>> consultaC=new ConsulPersona<DataB<Cliente>>(clienti);
			ConsulPersona<DataB<Fornitore>> consultaF=new ConsulPersona<DataB<Fornitore>>(fornitori);
			Al consF=new Al(consultaF);
			Al consC=new Al(consultaC);
			Inseri inserisci=new Inseri();
			Al ins=new Al(inserisci);
			
			Panel contenuto=new Panel();
			contenuto.setLayout(new GridLayout(2,2));
			
			JLabel tx=new JLabel();
			tx.setText("<html>Benvenuti nel database, cosa si desidera fare? ");
			tx.setFont(ft);
			add("North",tx);
			JLabel t1=new JLabel();
			t1.setText("<html>Si desidera consultare<br>o modificare i dati nel database? ");
			t1.setFont(ft);
			t1.setForeground(new Color(125,10,10));
			contenuto.add(t1);
			
			Choice ch1=new Choice();
			ch1.add("Scegli");
			ch1.add("Consulta");
			ch1.add("Aggiungi");
			ch1.setFont(ft);
			contenuto.add(ch1);
			
			JLabel t2=new JLabel();
			t2.setText("<html>Si desidera interagire con<br>il Database MERCI o PERSONE? ");
			t2.setFont(ft);
			t2.setForeground(new Color(10,10,125));
			contenuto.add(t2);
			
			Choice ch2=new Choice();
			ch2.add("Scegli");
			ch2.add("Persona");
			ch2.add("Prodotto");
			ch2.setFont(ft);
			contenuto.add(ch2);
			
			add("Center",contenuto);
			
			Button b1=new Button("-ENTER-");
			b1.setBackground(new Color(225,50,50));
			b1.setPreferredSize(new Dimension(80,50));
			b1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	int a=ch1.getSelectedIndex();
	            	int b=ch2.getSelectedIndex();
	            	if (a==1&&b==1){
	            		consF.actionPerformed(e);
	          //  		consC.actionPerformed(e);
	            	}
	            	else if (a==1&&b==2){
	            		ins.actionPerformed(e);
	            	}
	            	else if (a==2&&b==1){
	            		// aggiungi persona
	            	}
	            	else if (a==2&&b==2){
	            		// aggiungi prodotto
	            	}
	            	else {
	            		//erroreeee
	            	}
	        	}
			});
	        add("South",b1);
    	

	//		
	//		b1.addActionListener(al1);
			pack();
		}
	}
}