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
		
/*comp1*/  JLabel tx1=new JLabel();
		tx1.setBorder(BorderFactory.createEmptyBorder(30, 5, 5, 70));
		String testo="Consulta Fornitori";
		tx1.setText(testo);
		tx1.setFont(Est.font);
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

/*comp3*/Button bent1=new Button("-INVIO-");
		bent1.setBackground(Est.medio);
		bent1.setPreferredSize(Est.piccolo);
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


/*comp4*/  JLabel tx=new JLabel();
		tx.setBorder(BorderFactory.createEmptyBorder(30, 5, 5, 70));
		tx.setText("Consulta Clienti");
		tx.setFont(Est.font);
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

/*comp6*/Button bent=new Button("-INVIO-");
		bent.setBackground(Est.medio);
		bent.setPreferredSize(Est.piccolo);
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
		
/*comp7*/Button bex=new Button("-ESCI-");
		bex.setBackground(Est.scuro);
		bex.setPreferredSize(Est.piccolo);
		bex.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	dispose();
			}
		});
		contenuto.add(bex);
		
/*comp8*/JLabel tv=new JLabel();
		tv.setText("           ");
		tv.setFont(Est.font);
		tv.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(tv);
		
/*comp9*/Button b2=new Button("+ Aggiungi +");
		b2.setBackground(Est.chiarissimo);
		b2.setPreferredSize(Est.piccolo);
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