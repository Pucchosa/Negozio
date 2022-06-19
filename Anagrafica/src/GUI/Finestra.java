package GUI;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import Negozio.DataM;

public class Finestra extends Frame{
	public Finestra (String x){
		super(x);
		setLayout(new BorderLayout(100,10));
		setLocation(150,150);
		setBackground(Est.chiaro);
		
	}
}
