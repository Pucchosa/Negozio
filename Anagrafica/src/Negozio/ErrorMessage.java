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
	public void actionPerformed(ActionEvent e){
		this.setVisible(false);
	}
}		
