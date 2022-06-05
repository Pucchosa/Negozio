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
			DataB<Fornitore> fornitori=new DataB<Fornitore>("fornitore"); // poi togli
	//		DataM merci=new DataM(); // poi togli
			ConsultaPersone consultaC=new ConsultaPersone(clienti, fornitori);
	//		ConsulPersona<DataM> consultaM=new ConsulPersona<DataM>(merci);
			Al consP=new Al(consultaC);
	//		Al consM=new Al(consultaM);
	//		Inseri inserisci=new Inseri();
	//		Al ins=new Al(inserisci);
			
			Panel contenuto=new Panel();
			contenuto.setLayout(new GridLayout(2,2));
			
			JLabel tx=new JLabel();
			tx.setText("<html>Benvenuti nel database, cosa si desidera fare? ");
			tx.setFont(ft);
			add("North",tx);
			
			Button b1=new Button("Consulta DataBase Persone");
			b1.setBackground(new Color(100,100,255));
			b1.setPreferredSize(new Dimension(80,50));
			b1.addActionListener(consP);
	        contenuto.add(b1);
			
	        Button b2=new Button("Consulta DataBase Merci");
			b2.setBackground(new Color(100,255,100));
			b2.setPreferredSize(new Dimension(80,50));
//			b2.addActionListener(consM);
	        contenuto.add(b2);
			

			
			add("Center",contenuto);
			
			Button bex=new Button("-ESCI-");
			bex.setBackground(new Color(225,50,50));
			bex.setPreferredSize(new Dimension(80,50));
			bex.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	setVisible(false);
	        	}
			});
	        add("South",bex);
    	

			pack();
		}
	}
}