package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;
import java.awt.event.*;

public class SchedaMerce extends Frame{
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
		
		setLayout(new BorderLayout(100,10));
		setLocation(150,150);
		setBackground(Est.chiaro);
		
		Panel contenuto=new Panel();
		contenuto.setLayout(new GridLayout(6,2));
		
/*comp1*/  JLabel non=new JLabel();
		non.setText("Merce: ");
		non.setFont(Est.font);
		non.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(non);	
		JLabel nn=new JLabel();
		nn.setText(""+nome);
		nn.setFont(Est.font);
		nn.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(nn);	
		
/*comp2*/  JLabel uni=new JLabel();
		uni.setText("In magazzino: ");
		uni.setFont(Est.font);
		uni.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(uni);
		JLabel uu=new JLabel();
		uu.setText(quantita+" "+unita);
		uu.setFont(Est.font);
		uu.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(uu);
		
/*comp3*/  JLabel ac=new JLabel();
		ac.setText("Prezzo d acquisto: ");
		ac.setFont(Est.font);
		ac.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(ac);
		JLabel aa=new JLabel();
		aa.setText(prezzoA+"eu al "+unita);
		aa.setFont(Est.font);
		aa.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(aa);
		
/*comp4*/  JLabel ri=new JLabel();
		ri.setText("Prezzo di vendita: ");
		ri.setFont(Est.font);
		ri.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(ri);
		JLabel rr=new JLabel();
		rr.setText(prezzoV+"eu (rincaro del "+rincaro+"%)");
		rr.setFont(Est.font);
		rr.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(rr);
		
/*comp5*/  JLabel va=new JLabel();
		va.setText("Valore complessivo merce: ");
		va.setFont(Est.font);
		va.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(va);
		JLabel vv=new JLabel();
		vv.setText(valore+"eu");
		vv.setFont(Est.font);
		vv.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(vv);
		
/*comp6*/Button bex=new Button("-ESCI-");
		bex.setBackground(Est.scuro);
		bex.setPreferredSize(Est.piccolo);
		bex.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	ConsultaMerci consultaM=new ConsultaMerci(m);
		    	consultaM.setVisible(true);
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
