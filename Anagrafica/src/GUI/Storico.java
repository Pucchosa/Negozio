package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.Program.Home;
import Negozio.Anagrafica;
import Negozio.DataB;

public class Storico extends Finestra{

	String titolo;
	String cognome;
	String nome;
	String iva="";
	String telefono;
	String email;
	Double saldo=0.00;
	String indirizzo;
	Anagrafica mer;
	
		public Storico(){
			super("Storico Vendite: ");
					
			Etichetta non=new Etichetta("Storico Vendite: ");
			add("North",non);
			
			StorTab tab=new StorTab();
			add("Center",tab.ta());
			
			Pulsante bex=new Pulsante("-ESCI-");
			bex.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	setVisible(false);
			    	Home home=new Home();
					home.setVisible(true);
			    	dispose();
				}
			});
			add("South",bex);
			
			pack();
		}
	}
