package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;

import Negozio.Ogg;

import java.awt.event.*;

public class ConsultaPersone extends Frame {
	boolean tipp=true;
	public ConsultaPersone(DataB<Cliente> c,DataB<Fornitore> f){
		super("CONSULTA data base Persone");
//		setLayout(new BorderLayout(100,10));
		setLocation(300,300);
		Font ft=new Font("Lucida",Font.PLAIN,24);

		Panel contenuto=new Panel();
		contenuto.setLayout(new GridLayout(3,2));
		
/*comp1*/	JRadioButton client = new JRadioButton("Clienti");
	    client.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            sett(true);
	        }
	    });
	    contenuto.add(client);
 /*comp2*/    JRadioButton fornit = new JRadioButton("Fornitori");
	    fornit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	sett(false);
	        }
	    });
	    contenuto.add(fornit);
	    //Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(client);
	    group.add(fornit);

/*comp3*/  JLabel tx=new JLabel();
		String testo="Consulta ";
		if (tipp==false){
			testo=testo+"Fornitori: ";
		}
		else if (tipp==true){
			testo=testo+"Clienti: ";
		}
		tx.setText(testo);
		tx.setFont(ft);
		contenuto.add(tx);
		
/*comp4*/Choice ele=new Choice();
		ele.add("Scegli");
		if (tipp==false){
			try{
				for (Fornitore a:f.elenco){
					ele.add(a.getCognome()+" "+a.getNome());
				}
			}
			catch (Exception e){
				ele.add("Lista vuota");
			}
		}
		else if (tipp==true){
			try{
				for (Cliente a:c.elenco){
					ele.add(a.getCognome()+" "+a.getNome());
				}
			}
			catch (Exception e){
				ele.add("Lista vuota");
			}
		}
		ele.setFont(ft);
		contenuto.add(ele);

/*comp5*/Button bex=new Button("-ESCI-");
		bex.setBackground(new Color(225,50,50));
		bex.setPreferredSize(new Dimension(80,50));
		bex.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
			}
		});
		contenuto.add(bex);
		
/*comp6*/Button bent=new Button("-INVIO-");
		bent.setBackground(new Color(50,50,225));
		bent.setPreferredSize(new Dimension(80,50));
//		bent.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		    	setVisible(false);
//			}
//		});
		contenuto.add(bent);
		
		add(contenuto);
		pack();
	}
	public void sett(boolean a){
		this.tipp=a;
	}
}

		
/*		
		
		JLabel tx=new JLabel();
		tx.setText("<html>Pannello di consultazione: ");
		tx.setFont(ft);
		add("North",tx);
		JLabel t1=new JLabel();
		t1.setText("<html>Scegliere la voce <br/>dall'elenco: ");
		t1.setFont(ft);
		t1.setForeground(new Color(125,10,10));
		contenuto.add(t1);
		
		
		
		add("Center",contenuto);
		
		Button b1=new Button("-ENTER-");
		b1.setBackground(new Color(225,50,50));
		b1.setPreferredSize(new Dimension(80,50));
		b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// pri scheda persona
        	}
		});
        add("South",b1);

	*/