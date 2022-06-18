package GUI;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Etichetta extends JLabel{
	public Etichetta(String x){
		setText(x);
		setFont(Est.font);
		setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
	}
}
