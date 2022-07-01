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
		MyReadM.carica();
		MyReadF.carica();
		MyReadC.carica();
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
			
			
			Panel contenuto=new Panel();
			contenuto.setLayout(new GridLayout(2,2));
			
			Etichetta tx=new Etichetta("<html>Benvenuti nel database, cosa si desidera fare? ");
			add("North",tx);
			
			Pulsante b1=new Pulsante("Consulta DataBase Persone");
			b1.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	ConsultaPersone consultaP=new ConsultaPersone();
			    	consultaP.setVisible(true);
			    	setVisible(false);
				}
			});
	        contenuto.add(b1);
			
	        Pulsante b2=new Pulsante("Consulta DataBase Merci");
			b2.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	ConsultaMerci consultaM=new ConsultaMerci();
			    	consultaM.setVisible(true);
			    	setVisible(false);
			    	dispose();
				}
			});
	        contenuto.add(b2);
			

			
			add("Center",contenuto);
			
			Pulsante bex=new Pulsante("-ESCI-");
			bex.setBackground(Est.rosso);
			bex.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	MyReadM.scarica();
	    			MyReadF.scarica();
	    			MyReadC.scarica();
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