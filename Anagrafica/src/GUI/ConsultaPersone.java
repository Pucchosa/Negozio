package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;
//import Negozio.Ogg;
import java.awt.event.*;

public class ConsultaPersone  extends Frame {
	int indexF=-1;
	int indexC=-1;
	boolean tipp=true;
	public ConsultaPersone(DataB<Cliente> c,DataB<Fornitore> f){
		super("CONSULTA data base Persone");
		setBackground(Est.chiaro);
		setLocation(150,150);

		Panel contenuto=new Panel();
		contenuto.setLayout(new GridLayout(3,3));
		
/*comp1*/  Etichetta tx1=new Etichetta("Consulta Fornitori");
		contenuto.add(tx1);
		
/*comp2*/Choice ele1=new Choice();
		ele1.add("Scegli");
		try{
			for (Fornitore a:f.elenco){
				ele1.add(a.getCognome()+", "+a.getNome());
			}
		}
		catch (Exception e){
			ele1.add("Lista vuota");
		}
		ele1.setFont(Est.font);
		ele1.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e){
				if (ele1.getSelectedItem().equals("Scegli")||ele1.getSelectedItem().equals("Lista vuota")){
				}
				else {
					String[] temp=ele1.getSelectedItem().split(", ");
					indexF=f.trovaPersona(temp[0], temp[1]);
				}
			}
		});
		contenuto.add(ele1);

/*comp3*/Pulsante bent1=new Pulsante("-INVIO-");
		bent1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (indexF!=-1){
					SchedaPersona aggg=new SchedaPersona(c,f, indexF,"fornitore");
				    aggg.setVisible(true);
				    dispose();
				 }
			}
		});
		contenuto.add(bent1);


/*comp4*/  Etichetta tx=new Etichetta("Consulta Clienti");
		contenuto.add(tx);
		
/*comp5*/Choice ele=new Choice();
		ele.add("Scegli");
		try{
			for (Cliente a:c.elenco){
				ele.add(a.getCognome()+", "+a.getNome());
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
					String[] temp=ele.getSelectedItem().split(", ");
					indexC=c.trovaPersona(temp[0], temp[1]);
				}
			}
		});
		contenuto.add(ele);

/*comp6*/Pulsante bent=new Pulsante("-INVIO-");
		bent.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (indexC!=-1){
		    		SchedaPersona aggg=new SchedaPersona(c,f, indexC,"cliente");
			    	aggg.setVisible(true);
			    	dispose();
			 }
		}
	});
		contenuto.add(bent);
		
/*comp7*/Pulsante bex=new Pulsante("-ESCI-");
		bex.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	dispose();
			}
		});
		contenuto.add(bex);
		
/*comp8*/Etichetta tv=new Etichetta("           ");
		contenuto.add(tv);
		
/*comp9*/Pulsante b2=new Pulsante("+ Aggiungi +");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AggiungiPersona aggg=new AggiungiPersona(c,f);
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