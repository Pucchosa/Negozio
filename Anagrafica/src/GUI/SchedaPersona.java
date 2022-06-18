package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;
import java.awt.event.*;

public class SchedaPersona extends Frame{

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
			
			setLayout(new BorderLayout(100,10));
			setLocation(150,150);
			setBackground(Est.chiaro);
			
			Panel contenuto=new Panel();
			contenuto.setLayout(new GridLayout(6,2));
			
	/*comp1*/  JLabel non=new JLabel();
			non.setText("Nominativo: ");
			non.setFont(Est.font);
			non.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
			contenuto.add(non);	
			JLabel nn=new JLabel();
			nn.setText(titolo+" "+cognome+" "+nome);
			nn.setFont(Est.font);
			nn.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
			contenuto.add(nn);	
			
	/*comp2*/  JLabel uni=new JLabel();
			uni.setText("Contatti: ");
			uni.setFont(Est.font);
			uni.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
			contenuto.add(uni);
			JLabel uu=new JLabel();
			uu.setText("tel: "+telefono+" eMail: "+email);
			uu.setFont(Est.font);
			uu.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
			contenuto.add(uu);
			
	/*comp3*/  JLabel ac=new JLabel();
			ac.setText("Partita IVA: ");
			ac.setFont(Est.font);
			ac.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
			contenuto.add(ac);
			JLabel aa=new JLabel();
			aa.setText("n. "+iva);
			aa.setFont(Est.font);
			aa.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
			contenuto.add(aa);
			
	/*comp4*/  JLabel ri=new JLabel();
			ri.setText("Saldo: ");
			ri.setFont(Est.font);
			ri.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
			contenuto.add(ri);
			JLabel rr=new JLabel();
			rr.setText(saldo+" eu. ");
			rr.setFont(Est.font);
			rr.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
			contenuto.add(rr);
			
	/*comp5*/  JLabel va=new JLabel();
			va.setText("Indirizzo: ");
			va.setFont(Est.font);
			va.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
			contenuto.add(va);
			JLabel vv=new JLabel();
			vv.setText(indirizzo+" ");
			vv.setFont(Est.font);
			vv.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
			contenuto.add(vv);
			
	/*comp6*/Button bex=new Button("-ESCI-");
			bex.setBackground(Est.scuro);
			bex.setPreferredSize(Est.piccolo);
			bex.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	setVisible(false);
			    	ConsultaPersone consultaP=new ConsultaPersone(c,f);
			    	consultaP.setVisible(true);
			    	dispose();
				}
			});
			contenuto.add(bex);
			
			Button bin=new Button("-MODIFICA-");
			bin.setBackground(Est.medio);
			bin.setPreferredSize(Est.piccolo);
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
