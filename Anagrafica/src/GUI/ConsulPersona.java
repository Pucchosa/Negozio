package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;

import Negozio.Ogg;

import java.awt.event.*;

public class ConsulPersona <T extends DataB<?>> extends Frame implements ActionListener{
	public ConsulPersona(T lis){
		super("CONSULTA data base "+lis.getTip());
		setLayout(new BorderLayout(100,10));
		setLocation(300,300);
		Font ft=new Font("Lucida",Font.PLAIN,24);

		Panel contenuto=new Panel();
		contenuto.setLayout(new GridLayout(2,1));
		
		JLabel tx=new JLabel();
		tx.setText("<html>Pannello di consultazione: ");
		tx.setFont(ft);
		add("North",tx);
		JLabel t1=new JLabel();
		t1.setText("<html>Scegliere la voce <br/>dall'elenco: ");
		t1.setFont(ft);
		t1.setForeground(new Color(125,10,10));
		contenuto.add(t1);
		
		Choice ch1=new Choice();
		ch1.add("Scegli");
		ch1.add("prova");
	//	if (lis.elenco.size()>0){
	//		for (int a=0;a<lis.elenco.size();a++){
	//			ch1.add(lis.elenCogn(a));
	//		}
	//	}
		ch1.setFont(ft);
		contenuto.add(ch1);
		
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
	

		pack();
	}
	
	public void actionPerformed(ActionEvent e){
		this.setVisible(false);
		
	}		
}