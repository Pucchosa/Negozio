package Negozio;

import GUI.Spesa;

public class AoOexception extends Exception{
	public AoOexception(String mess,int index){
		super(mess);
		System.out.println("prendo");
		String mg=mess+" -ELEMENTO RIMOSSO DAL CARRELLO- "+DataM.get(index).getNome();
		ErrorMessage err=new ErrorMessage(mg);
    	err.setVisible(true);
	}
}