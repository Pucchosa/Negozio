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
		setBackground(new Color(217,243,248));
		
		JLabel tx=new JLabel();
		tx.setText("Mi dispiace, qualcosa e andato storto... ");
		tx.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		Font ft=new Font("Lucida",Font.PLAIN,24);
		tx.setFont(ft);
		
		Button ok=new Button("OK");
		ok.setBackground(new Color(26,200,219));
		ok.setPreferredSize(new Dimension(80,50));
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
		Font ft=new Font("Lucida",Font.PLAIN,24);
		tx.setFont(ft);
		
		Button ok=new Button("OK");
		ok.setBackground(new Color(26,200,219));
		ok.setPreferredSize(new Dimension(80,50));
		ok.addActionListener(this);
		
		JLabel ty=new JLabel();
		ty.setText(a);
		ty.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		Font fy=new Font("Lucida",Font.PLAIN,18);
		ty.setFont(fy);
		
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
