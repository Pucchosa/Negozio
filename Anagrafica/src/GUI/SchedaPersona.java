package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;
import java.awt.event.*;

public class SchedaPersona extends Finestra{

	String titolo;
	String cognome;
	String nome;
	String iva="";
	String telefono;
	String email;
	Double saldo=0.00;
	String indirizzo;
	Anagrafica mer;
		public SchedaPersona(DataB<Cliente> c,DataB<Fornitore> f, int x, String tipo){
			super("Scheda "+tipo);
			if (x>-1){
				if (tipo.equals("fornitore")){
					try {
						mer=f.get(x);
					}
					catch (Exception e){
						
					}
				}
				else {
					try {
						mer=c.get(x);
					}
					catch (Exception e){
						
					}
				}

				this.titolo=mer.getTitolo();
				this.cognome=mer.getCognome();
				this.nome=mer.getNome();
				this.iva=mer.getIva();
				this.telefono=mer.getTelefono();
				this.email=mer.getEmail();
				this.saldo=mer.getSaldo();
				this.indirizzo=mer.getIndirizzo();
			}
			
			Panel contenuto=new Panel();
			contenuto.setLayout(new GridLayout(6,2));
			
	/*comp1*/  Etichetta non=new Etichetta("Nominativo: ");
			contenuto.add(non);	
			Etichetta nn=new Etichetta(titolo+" "+cognome+" "+nome);
			contenuto.add(nn);	
			
	/*comp2*/  Etichetta uni=new Etichetta("Contatti: ");
			contenuto.add(uni);
			Etichetta uu=new Etichetta("tel: "+telefono+" eMail: "+email);
			contenuto.add(uu);
			
	/*comp3*/  Etichetta ac=new Etichetta("Partita IVA: ");
			contenuto.add(ac);
			Etichetta aa=new Etichetta("n. "+iva);
			contenuto.add(aa);
			
	/*comp4*/  Etichetta ri=new Etichetta("Saldo: ");
			contenuto.add(ri);
			Etichetta rr=new Etichetta(saldo+" eu. ");
			contenuto.add(rr);
			
	/*comp5*/  Etichetta va=new Etichetta("Indirizzo: ");
			contenuto.add(va);
			Etichetta vv=new Etichetta(indirizzo+" ");
			contenuto.add(vv);
			
	/*comp6*/Pulsante bex=new Pulsante("-ESCI-");
			bex.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	setVisible(false);
			    	ConsultaPersone consultaP=new ConsultaPersone(c,f);
			    	consultaP.setVisible(true);
			    	dispose();
				}
			});
			contenuto.add(bex);
			
			Pulsante bin=new Pulsante("-MODIFICA-");
			bin.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	if (x!=-1){
				    	setVisible(false);
				    	AggiungiPersona modifP=new AggiungiPersona(c,f, x,tipo);
				    	modifP.setVisible(true);
			    	
				    	dispose();
			    	}
				}
			});
			contenuto.add(bin);
			
			add(contenuto);
			pack();
		}
	}
