package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;
import Negozio.Ogg;
import java.awt.event.*;

public class ConsultaMerci extends Frame {
		boolean tipp=true;
		int index=-1;
		public ConsultaMerci(DataM c){
			super("CONSULTA data base Merci");
			setLocation(150,150);
			setBackground(new Color(217,243,248));
			Font ft=new Font("Lucida",Font.PLAIN,24);

			Panel contenuto=new Panel();
			contenuto.setLayout(new GridLayout(2,3));
			

	/*comp1*/  JLabel tx=new JLabel();
			tx.setText("Consulta merci: ");
			tx.setFont(ft);
			tx.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
			contenuto.add(tx);
			
	/*comp2*/Choice ele=new Choice();
			ele.add("Scegli");
			try{
				for (Merce a:c.elenco.values()){
					ele.add(a.getNome()+" "+a.getCod());
				}
			}
			catch (Exception e){
				ele.add("Lista vuota");
			}
			ele.setFont(ft);
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

/*comp3*/Button bent=new Button("-INVIO-");
			bent.setBackground(new Color(26,200,219));
			bent.setPreferredSize(new Dimension(80,50));
			bent.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	if (index!=-1){
				    	SchedaMerce aggg=new SchedaMerce(c, index);
				    	aggg.setVisible(true);
				    	dispose();
			    	}
				}
			});
			contenuto.add(bent);

/*comp4*/Button bex=new Button("-ESCI-");
			bex.setBackground(new Color(2,146,183));
			bex.setPreferredSize(new Dimension(80,50));
			bex.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	setVisible(false);
			    	dispose();
				}
			});
			contenuto.add(bex);
			
/*comp5*/	JLabel tv=new JLabel();
			tv.setText("           ");
			tv.setFont(ft);
			tv.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
			contenuto.add(tv);
			
/*comp6*/Button b2=new Button("+ Aggiungi +");
			b2.setBackground(new Color(26,200,219));
			b2.setPreferredSize(new Dimension(80,50));
			b2.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	AggiungiMerce aggg=new AggiungiMerce(c);
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