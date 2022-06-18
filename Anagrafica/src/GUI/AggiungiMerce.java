package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;

import java.awt.event.*;

public class AggiungiMerce extends Frame{
	String nome="";
	Double quantita=0.0;
	Double prezzoA=0.0;
	int rincaro=0;
	String unita="";
	public AggiungiMerce(DataM c){
		super("Aggiungi prodotto");
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
/*comp2*/ JPanel pan1=new JPanel();
		JTextField tf1 = new JTextField("Nome", 15);
		tf1.setForeground(Est.chiarissimo);
		tf1.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
				if (tf1.getText().equals("Nome")){
					tf1.setText("");
					tf1.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e){
				if (tf1.getText().isEmpty()){
					tf1.setText("Nome");
					tf1.setForeground(Est.chiarissimo);
				}
				else nome=tf1.getText();
			}
		});
		tf1.setFont(Est.font);
		pan1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan1.add(tf1);
		pan1.setBackground(Est.chiarissimo);
		contenuto.add(pan1);
		
/*comp3*/  JLabel un=new JLabel();
		un.setText("Scelta Unita: ");
		un.setFont(Est.font);
		un.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(un);
/*comp4*/Choice uni=new Choice();
		uni.add("Scegli");
		uni.add("Pezzi");
		uni.add("Kg");
		uni.add("grammi");
		uni.add("quintali");
		uni.add("tonnellate");
		uni.setFont(Est.font);
		uni.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e){
				if (uni.getSelectedIndex()>0){
					unita=uni.getSelectedItem();
				}
			}
		});
		contenuto.add(uni);	
		
/*comp5*/  JLabel qtt=new JLabel();
		qtt.setText("Quantita: ");
		qtt.setFont(Est.font);
		qtt.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(qtt);
/*comp6*/JPanel pan2=new JPanel();
		JTextField tf2 = new JTextField("Quantita", 15);
		tf2.setForeground(Est.chiarissimo);
		tf2.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
				if (tf2.getText().equals("Quantita")){
					tf2.setText("");
					tf2.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e){
				if (tf2.getText().isEmpty()){
					tf2.setText("Quantita");
					tf2.setForeground(Est.chiarissimo);
				}
				else {
					try {
						quantita=Double.parseDouble(tf2.getText());
					}
					catch (Exception ex){
						ErrorMessage err=new ErrorMessage("inserire numero con . ");
						err.setVisible(true);
					}
				}
			}
		});
		tf2.setFont(Est.font);
		pan2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan2.add(tf2);
		pan2.setBackground(Est.chiaro);
		contenuto.add(pan2);
		
/*comp7*/  JLabel prr=new JLabel();
		prr.setText("Prezzo d'acquisto: ");
		prr.setFont(Est.font);
		prr.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(prr);
/*comp8*/ JPanel pan3=new JPanel();
		JTextField tf3 = new JTextField("Prezzo", 15);
		tf3.setForeground(Est.chiarissimo);
		tf3.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
				if (tf3.getText().equals("Prezzo")){
					tf3.setText("");
					tf3.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e){
				if (tf3.getText().isEmpty()){
					tf3.setText("Prezzo");
					tf3.setForeground(Est.chiarissimo);
				}
				else {
					try {
						prezzoA=Double.parseDouble(tf3.getText());
					}
					catch (Exception ex){
						ErrorMessage err=new ErrorMessage("inserire numero con . ");
						err.setVisible(true);
					}
				}
			}
		});
		tf3.setFont(Est.font);
		pan3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan3.add(tf3);
		pan3.setBackground(Est.chiaro);
		contenuto.add(pan3);
		
/*comp9*/  JLabel rin=new JLabel();
		rin.setText("Imposta % rincaro: ");
		rin.setFont(Est.font);
		rin.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(rin);
/*comp10*/Choice rim=new Choice();
		rim.add("Scegli");
		rim.add("10");
		rim.add("20");
		rim.add("30");
		rim.add("50");
		rim.setFont(Est.font);
		rim.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e){
				if (rim.getSelectedIndex()>0){
					rincaro=Integer.parseInt(rim.getSelectedItem())+100;
				}
			}
		});
		contenuto.add(rim);	
			
/*comp11*/Button bex=new Button("-ESCI-");
		bex.setBackground(Est.scuro);
		bex.setPreferredSize(new Dimension(80,50));
		bex.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	ConsultaMerci consultaM=new ConsultaMerci(c);
		    	consultaM.setVisible(true);
		    	dispose();
			}
		});
		contenuto.add(bex);
		
/*comp12*/Button bent=new Button("-INVIO-");
		bent.setBackground(Est.medio);
		bent.setPreferredSize(Est.piccolo);
		bent.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
				Merce inserisci =new Merce(nome, quantita, rincaro, prezzoA, unita,c);
				c.agg(inserisci);
				ConsultaMerci consultaM=new ConsultaMerci(c);
		    	consultaM.setVisible(true);
		    	setVisible(false);
		    	dispose();
			}
		});
		

		contenuto.add(bent);
		
		add(contenuto);
		pack();
	}
	
	public AggiungiMerce(DataM c, int x){
		super("Modifica prodotto");
		Merce prod=c.get(x);
		
		nome=prod.getNome();
		quantita=prod.getQuantita();
		prezzoA=prod.getPrezzoA();
		rincaro=prod.getRincaro();
		unita=prod.getUnit();
		
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
/*comp2*/ JLabel nom=new JLabel();
		nom.setText(nome);
		nom.setFont(Est.font);
		nom.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(nom);
		
/*comp3*/  JLabel un=new JLabel();
		un.setText("Scelta Unita: ");
		un.setFont(Est.font);
		un.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(un);
/*comp4*/Choice uni=new Choice();
		uni.add(unita);
		uni.add("Pezzi");
		uni.add("Kg");
		uni.add("grammi");
		uni.add("quintali");
		uni.add("tonnellate");
		uni.setFont(Est.font);
		uni.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e){
				if (uni.getSelectedIndex()>0){
					unita=uni.getSelectedItem();
				}
			}
		});
		contenuto.add(uni);	
		
/*comp5*/  JLabel qtt=new JLabel();
		qtt.setText("Quantita: ");
		qtt.setFont(Est.font);
		qtt.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(qtt);
/*comp6*/JPanel pan2=new JPanel();
		JTextField tf2 = new JTextField(quantita+"", 15);
		tf2.setForeground(Est.chiarissimo);
		tf2.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
				if (tf2.getText().equals(quantita)){
					tf2.setText("");
					tf2.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e){
				if (tf2.getText().isEmpty()){
					tf2.setText(quantita+"");
					tf2.setForeground(Est.chiarissimo);
				}
				else {
					try {
						quantita=Double.parseDouble(tf2.getText());
					}
					catch (Exception ex){
						ErrorMessage err=new ErrorMessage("inserire numero con . ");
						err.setVisible(true);
					}
				}
			}
		});
		tf2.setFont(Est.font);
		pan2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan2.add(tf2);
		pan2.setBackground(Est.chiaro);
		contenuto.add(pan2);
		
/*comp7*/  JLabel prr=new JLabel();
		prr.setText("Prezzo d'acquisto: ");
		prr.setFont(Est.font);
		prr.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(prr);
/*comp8*/ JPanel pan3=new JPanel();
		JTextField tf3 = new JTextField(prezzoA+"", 15);
		tf3.setForeground(Est.chiarissimo);
		tf3.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
				if (tf3.getText().equals(prezzoA)){
					tf3.setText("");
					tf3.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e){
				if (tf3.getText().isEmpty()){
					tf3.setText(prezzoA+"");
					tf3.setForeground(Est.chiarissimo);
				}
				else {
					try {
						prezzoA=Double.parseDouble(tf3.getText());
					}
					catch (Exception ex){
						ErrorMessage err=new ErrorMessage("inserire numero con . ");
						err.setVisible(true);
					}
				}
			}
		});
		tf3.setFont(Est.font);
		pan3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan3.add(tf3);
		pan3.setBackground(Est.chiaro);
		contenuto.add(pan3);
		
/*comp9*/  JLabel rin=new JLabel();
		rin.setText("Imposta % rincaro: ");
		rin.setFont(Est.font);
		rin.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(rin);
/*comp10*/Choice rim=new Choice();
		rim.add(""+(rincaro-100));
		rim.add("10");
		rim.add("20");
		rim.add("30");
		rim.add("50");
		rim.setFont(Est.font);
		rim.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e){
				if (rim.getSelectedIndex()>0){
					rincaro=Integer.parseInt(rim.getSelectedItem())+100;
				}
			}
		});
		contenuto.add(rim);	
			
/*comp11*/Button bex=new Button("-ESCI-");
		bex.setBackground(Est.scuro);
		bex.setPreferredSize(Est.piccolo);
		bex.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	ConsultaMerci consultaM=new ConsultaMerci(c);
		    	consultaM.setVisible(true);
		    	dispose();
			}
		});
		contenuto.add(bex);
		
/*comp12*/Button bent=new Button("-INVIO-");
		bent.setBackground(Est.medio);
		bent.setPreferredSize(Est.piccolo);
		bent.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	c.get(x).setPrezzoA(prezzoA);
		    	c.get(x).setQuantita(quantita);
		    	c.get(x).setRincaro(rincaro);
		    	c.get(x).setUnita(unita);
		    	
				ConsultaMerci consultaM=new ConsultaMerci(c);
		    	consultaM.setVisible(true);
		    	setVisible(false);
		    	dispose();
			}
		});
		

		contenuto.add(bent);
		
		add(contenuto);
		pack();
	}
}
