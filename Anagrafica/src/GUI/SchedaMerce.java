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
		setLocation(300,300);
		setBackground(new Color(217,243,248));
		Font ft=new Font("Lucida",Font.PLAIN,24);
		
		Panel contenuto=new Panel();
		contenuto.setLayout(new GridLayout(6,2));
		
/*comp1*/  JLabel non=new JLabel();
		non.setText("Merce: ");
		non.setFont(ft);
		non.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(non);	
		JLabel nn=new JLabel();
		nn.setText(""+nome);
		nn.setFont(ft);
		nn.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(nn);	
		
/*comp2*/  JLabel uni=new JLabel();
		uni.setText("In magazzino: ");
		uni.setFont(ft);
		uni.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(uni);
		JLabel uu=new JLabel();
		uu.setText(quantita+" "+unita);
		uu.setFont(ft);
		uu.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(uu);
		
/*comp3*/  JLabel ac=new JLabel();
		ac.setText("Prezzo d acquisto: ");
		ac.setFont(ft);
		ac.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(ac);
		JLabel aa=new JLabel();
		aa.setText(prezzoA+"eu al "+unita);
		aa.setFont(ft);
		aa.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(aa);
		
/*comp4*/  JLabel ri=new JLabel();
		ri.setText("Prezzo di vendita: ");
		ri.setFont(ft);
		ri.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(ri);
		JLabel rr=new JLabel();
		rr.setText(prezzoV+"eu (rincaro del "+rincaro+"%)");
		rr.setFont(ft);
		rr.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(rr);
		
/*comp5*/  JLabel va=new JLabel();
		va.setText("Valore complessivo merce: ");
		va.setFont(ft);
		va.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(va);
		JLabel vv=new JLabel();
		vv.setText(valore+"eu");
		vv.setFont(ft);
		vv.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(vv);
		
/*comp6*/Button bex=new Button("-ESCI-");
		bex.setBackground(new Color(2,146,183));
		bex.setPreferredSize(new Dimension(80,50));
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
		bin.setBackground(new Color(2,146,183));
		bin.setPreferredSize(new Dimension(80,50));
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