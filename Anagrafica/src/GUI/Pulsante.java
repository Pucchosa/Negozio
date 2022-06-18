package GUI;
import java.awt.Button;

public class Pulsante extends Button{
	public Pulsante(String x){
		super(x);
		setPreferredSize(Est.piccolo);
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