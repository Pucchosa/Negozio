package GUI;
//import java.util.*;
import java.awt.*;
//import javax.swing.*;
import java.awt.event.*;
public class Al implements ActionListener{
	Frame tol;
	public Al(Frame x){
		tol=x;
	}
	public void actionPerformed(ActionEvent e){
		tol.setVisible(true);
		
	}		
}