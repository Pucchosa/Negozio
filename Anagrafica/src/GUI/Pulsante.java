package GUI;
import java.awt.Button;
import java.awt.Font;

public class Pulsante extends Button{
	public Pulsante(String x){
		super(x);
		setPreferredSize(Est.piccolo);
		setFont(Est.font2);
		if (x.equals("-INVIO-")){
			setBackground(Est.medio);
		}
		else if (x.equals("-ESCI-")){
			setBackground(Est.scuro);
		}
		else {
			setBackground(Est.chiarissimo);
		}
	}

}