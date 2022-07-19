package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;

import GUI.Program.Home;

import java.awt.event.*;

public class Balance extends Finestra{

	private double merchVal;
	private double totSold;
	private double totBought;
	private double bal;
	
		public Balance(){
			super("Bilancio negozio:");
			this.merchVal=Shop.getMerchVal();
			this.totSold=Shop.getTotSold();
			this.totBought=Shop.getTotBought();
			this.bal=Shop.getBal();
			
			Panel contenuto=new Panel();
			contenuto.setLayout(new GridLayout(4,2));
			
	/*comp1*/  Etichetta non=new Etichetta("Valore merce in magazzino: ");
			contenuto.add(non);	
			Etichetta nn=new Etichetta(Est.deci.format(merchVal)+" eu. ");
			contenuto.add(nn);	
			
	/*comp2*/  Etichetta uni=new Etichetta("Totale vendite: ");
			contenuto.add(uni);
			Etichetta uu=new Etichetta(Est.deci.format(totSold)+" eu. ");
			contenuto.add(uu);
			
	/*comp3*/  Etichetta ac=new Etichetta("Totale acquisti: ");
			contenuto.add(ac);
			Etichetta aa=new Etichetta(Est.deci.format(totBought)+" eu. ");
			contenuto.add(aa);
			
	/*comp4*/  Etichetta ri=new Etichetta("BILANCIO FINALE: ");
			contenuto.add(ri);
			Etichetta rr=new Etichetta(Est.deci.format(bal)+" eu. ");
			contenuto.add(rr);
			
			add("Center", contenuto);
			
	/*es*/Pulsante bex=new Pulsante("-ESCI-");
			bex.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	setVisible(false);
			    	Home home=new Home();
					home.setVisible(true);
			    	dispose();
				}
			});
			add("South", bex);
			pack();
		}
	}

