package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class AggiungiPersona  extends Frame{
	public AggiungiPersona(){
		super("Aggiungi persona");
		setLayout(new BorderLayout(100,10));
		setLocation(300,300);
		setBackground(new Color(217,243,248));
		Font ft=new Font("Lucida",Font.PLAIN,24);
		
		Panel contenuto=new Panel();
		contenuto.setLayout(new GridLayout(10,2));
		
		
		add(contenuto);
		pack();
	}
}
