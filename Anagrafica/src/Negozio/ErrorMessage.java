import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ErrorMessage extends Frame implements ActionListener{
		public ErrorMessage(){
			super("---ERRORE---");
			setLayout(new FlowLayout(20,20,20));
			setLocation(300,300);
			
			JLabel tx=new JLabel();
			tx.setText("<html>Mi dispiace, qualcosa e<br>andato storto... ");
			Font ft=new Font("Lucida",Font.PLAIN,24);
			tx.setFont(ft);
			
			Button ok=new Button("OK");
			ok.setBackground(new Color(225,50,50));
			ok.setPreferredSize(new Dimension(80,50));
			ok.addActionListener(this);
			
			add("North",tx);
			add("Center",ok);
			pack();
		}
		public void actionPerformed(ActionEvent e){
			this.setVisible(false);
		}
	}		
}
