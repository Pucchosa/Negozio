package Negozio;
import GUI.*;
//import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ErrorMessage extends Frame implements ActionListener{
	public ErrorMessage(){
		super("---ERRORE---");
		setLayout(new BorderLayout(100,50));
		setLocation(300,300);
		setBackground(Est.chiaro);
		
		JLabel tx=new JLabel();
		tx.setText("Mi dispiace, qualcosa e andato storto... ");
		tx.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		tx.setFont(Est.font);
		
		Pulsante ok=new Pulsante("OK");
		ok.addActionListener(this);
		
		add("North",tx);
		add("Center",ok);
		setAlwaysOnTop(true);
		pack();
	}
	public ErrorMessage(String a){
		super("---ERRORE---");
		setLayout(new BorderLayout(100,50));
		setLocation(300,300);
		setBackground(new Color(217,243,248));
		
		JLabel tx=new JLabel();
		tx.setText("Mi dispiace, qualcosa e andato storto... ");
		tx.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		tx.setFont(Est.font);
		
		Pulsante ok=new Pulsante("OK");
		ok.addActionListener(this);
		
		JLabel ty=new JLabel();
		ty.setText(a);
		ty.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		ty.setFont(new Font("Lucida",Font.PLAIN,14));
		
		add("North",tx);
		add("Center",ok);
		add("South",ty);
		setAlwaysOnTop(true);
		pack();
	}
	
	public ErrorMessage(int a){
		super("---ATTENZIONE---");
		setLocation(300,300);
		setBackground(new Color(217,243,248));
		
		JLabel tx=new JLabel();
		tx.setText("<html>Se è sicuri divoler eliminare questo prodotto? <br/> Numero:"+a+" Merce: "+DataM.elenco.get(a).getNome());
		tx.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		tx.setFont(Est.font);
		
		Pulsante ok=new Pulsante("ANNULLA");
		ok.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	ConsultaMerci consultaM=new ConsultaMerci();
		    	consultaM.setVisible(true);
		    	dispose();
			}
		});
		
		Pulsante ty=new Pulsante("ELIMINA");
		ty.setBackground(Est.rosso);
		ty.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	DataM.elimina(a);
		    	setVisible(false);
		    	ConsultaMerci consultaM=new ConsultaMerci();
		    	consultaM.setVisible(true);
		    	dispose();
			}
		});
		
		add("North",tx);
		add("Center",ok);
		add("South",ty);
		setAlwaysOnTop(true);
		pack();
	}
	
	public void actionPerformed(ActionEvent e){
		this.setVisible(false);
	}
}		
