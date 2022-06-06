package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;
import Negozio.Ogg;
import java.awt.event.*;

public class AggiungiMerce extends Frame{
	public AggiungiMerce(){
		super("Aggiungi prodotto");
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
