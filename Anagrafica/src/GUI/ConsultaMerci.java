package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;
//import Negozio.Ogg;
import java.awt.event.*;

public class ConsultaMerci extends Finestra {
		boolean tipp=true;
		int index=-1;
		public ConsultaMerci(){
			super("CONSULTA data base Merci");

			Panel contenuto=new Panel();
			contenuto.setLayout(new GridLayout(2,3));
			

	/*comp1*/  Etichetta tx=new Etichetta("Consulta merci: ");
			contenuto.add(tx);
			
	/*comp2*/Choice ele=new Choice();
			ele.add("Scegli");
			try{
				for (Merce a:DataM.elenco.values()){
					ele.add(a.getNome()+" "+a.getCod());
				}
			}
			catch (Exception e){
				ele.add("Lista vuota");
			}
			ele.setFont(Est.font);
			ele.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e){
				}
				public void focusLost(FocusEvent e){
					if (ele.getSelectedItem().equals("Scegli")||ele.getSelectedItem().equals("Lista vuota")){
					}
					else {
						String temp=ele.getSelectedItem();
						String[] temAr=temp.split(" ");
						index=Integer.parseInt(temAr[temAr.length-1]);
					}
				}
			});
			contenuto.add(ele);

/*comp3*/Pulsante bent=new Pulsante("-INVIO-");
			bent.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	if (index!=-1){
				    	SchedaMerce aggg=new SchedaMerce(index);
				    	aggg.setVisible(true);
				    	dispose();
			    	}
				}
			});
			contenuto.add(bent);

/*comp4*/Pulsante bex=new Pulsante("-ESCI-");
			bex.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	setVisible(false);
			    	dispose();
				}
			});
			contenuto.add(bex);
			
/*comp5*/	Etichetta tv=new Etichetta("           ");
			contenuto.add(tv);
			
/*comp6*/Pulsante b2=new Pulsante("+ Aggiungi +");
			b2.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	AggiungiMerce aggg=new AggiungiMerce();
			    	aggg.setVisible(true);
			    	dispose();
				}
			});
	        contenuto.add(b2);
	        
	        
			add(contenuto);
			pack();
		}
		public void sett(boolean a){
			this.tipp=a;
		}
	}