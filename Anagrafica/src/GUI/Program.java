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
			setLocation(150,150);
			setBackground(Est.chiaro);
			
			// ISTANZIO TUTTI I FRAME SECONDARI
			DataB<Cliente> clienti=new DataB<Cliente>("cliente");
			DataB<Fornitore> fornitori=new DataB<Fornitore>("fornitore");
			DataM merci=new DataM();
			MyReadM.carica(merci);
			MyReadF.carica(fornitori);
			MyReadC.carica(clienti);
			
			Panel contenuto=new Panel();
			contenuto.setLayout(new GridLayout(2,2));
			
			Etichetta tx=new Etichetta("<html>Benvenuti nel database, cosa si desidera fare? ");
			add("North",tx);
			
			Pulsante b1=new Pulsante("Consulta DataBase Persone");
			b1.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	ConsultaPersone consultaP=new ConsultaPersone(clienti, fornitori);
			    	consultaP.setVisible(true);
				}
			});
	        contenuto.add(b1);
			
	        Pulsante b2=new Pulsante("Consulta DataBase Merci");
			b2.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	ConsultaMerci consultaM=new ConsultaMerci(merci);
			    	consultaM.setVisible(true);
				}
			});
	        contenuto.add(b2);
			

			
			add("Center",contenuto);
			
			Pulsante bex=new Pulsante("-ESCI-");
			bex.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	MyReadM.scarica(merci);
	    			MyReadF.scarica(fornitori);
	    			MyReadC.scarica(clienti);
	            	setVisible(false);
	            	dispose();
	            	System.exit(0);
	        	}
			});
	        add("South",bex);
	        
			pack();
		}
	}
}