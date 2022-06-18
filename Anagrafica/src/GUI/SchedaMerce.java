package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class SchedaMerce extends Finestra{
	String nome;
	int codice;
	Double quantita;
	int rincaro;
	Double prezzoA;
	Double prezzoV;
	Double valore;
	String unita;
	public SchedaMerce(DataM m, int x){
		super("Scheda prodotto");
		
		if (x!=-1&&m.elenco.containsKey(x)){
			Merce mer=m.elenco.get(x);
			this.nome=mer.getNome();
			this.quantita=mer.getQuantita();
			this.rincaro=mer.getRincaro();
			this.prezzoA=mer.getPrezzoA();
			this.unita=mer.getUnit();
			this.prezzoV=mer.getPrezzoV();
			this.valore=mer.getValore();
			this.codice=x;
		}
		
		Panel contenuto=new Panel();
		contenuto.setLayout(new GridLayout(6,2));
		
/*comp1*/  Etichetta non=new Etichetta("Merce: ");
		contenuto.add(non);	
		Etichetta nn=new Etichetta(""+nome);
		contenuto.add(nn);	
		
/*comp2*/  Etichetta uni=new Etichetta("In magazzino: ");
		contenuto.add(uni);
		Etichetta uu=new Etichetta(quantita+" "+unita);
		contenuto.add(uu);
		
/*comp3*/  Etichetta ac=new Etichetta("Prezzo d acquisto: ");
		contenuto.add(ac);
		Etichetta aa=new Etichetta(prezzoA+"eu al "+unita);
		contenuto.add(aa);
		
/*comp4*/  Etichetta ri=new Etichetta("Prezzo di vendita: ");
		contenuto.add(ri);
		Etichetta rr=new Etichetta(prezzoV+"eu (rincaro del "+rincaro+"%)");
		contenuto.add(rr);
		
/*comp5*/  Etichetta va=new Etichetta("Valore complessivo merce: ");
		contenuto.add(va);
		Etichetta vv=new Etichetta(valore+"eu");
		contenuto.add(vv);
		
/*comp6*/Pulsante bex=new Pulsante("-ESCI-");
		bex.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	ConsultaMerci consultaM=new ConsultaMerci(m);
		    	consultaM.setVisible(true);
		    	dispose();
			}
		});
		contenuto.add(bex);
		
		Pulsante bin=new Pulsante("-MODIFICA-");
		bin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (x!=-1){
			    	setVisible(false);
			    	AggiungiMerce modifM=new AggiungiMerce(m, x);
			    	modifM.setVisible(true);
		    	
			    	dispose();
		    	}
			}
		});
		contenuto.add(bin);
		
		add(contenuto);
		pack();
	}
	
}
