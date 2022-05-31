package GUI;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Inseri extends Frame implements ActionListener{
		public Inseri(){
			super("INSERIMENTO");
			setLayout(new BorderLayout(200,200));
			setLocation(600,300);
	//		setMinimumSize(new Dimension(500,200));
			Font ft=new Font("Lucida",Font.PLAIN,24);
			
			JLabel tx=new JLabel();
			tx.setText("<html>Inserire<br>nuovo? ");
			tx.setFont(ft);
			add("North",tx);
			
	/*		Panel contenuto=new Panel();
			contenuto.setLayout(new GridLayout(1,2));
			JLabel t1=new JLabel();
			t1.setText("<html>Inserire nuovi<br>dati nel database ");
			t1.setFont(ft);
			add("West",t1);
			JLabel t2=new JLabel();
			t2.setText("<html>Consultare i dati<br>presenti nel database ");
			t2.setFont(ft);
			add("East",t2);
			
			Button b1=new Button("INSERISCI");
			b1.setBackground(new Color(225,50,50));
			b1.setPreferredSize(new Dimension(80,50));
			Inseri insert = new Inseri();
			ActionListener al1=new ActionListener(insert);
			b1.addActionListener(al1);
			contenuto.add(b1);
			
			Button b2=new Button("CONSULTA");
			b2.setBackground(new Color(50,50,225));
			b2.setPreferredSize(new Dimension(80,50));
			Conul consu = new Consul();
			ActionListener al2=new ActionListener(consu);
			b2.addActionListener(al2);
			contenuto.add(b2);
			
			add("South",contenuto);	*/
			Button ok=new Button("OK");
			ok.setBackground(new Color(225,50,50));
			ok.setPreferredSize(new Dimension(80,50));
			ok.addActionListener(this);
			add(ok);
			pack();
			setVisible(false);
		}
		
		public void actionPerformed(ActionEvent e){
			this.setVisible(false);
			
		}
	}