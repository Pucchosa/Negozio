package Negozio;

import java.util.Date;
import java.util.HashMap;

public class ListaSpesa extends DataM{
	Cliente cliente;
	Double saldo;
	Date data;
	
	public ListaSpesa(Cliente c,DataM m){
		cliente=c;
		for (int k:m.elenco.keySet()){
			Merce x=m.get(k);
			x.setQuantita(0.0);
			elenco.put(k,x);
		}
		data=new Date();
		saldo=0.0;
	}
	
	public void compra(int merce,Double quantita){
		elenco.get(merce).setQuantita(quantita);
		Double prezzo=elenco.get(merce).getPrezzoV()*quantita;
		saldo=saldo+prezzo;
	}
	
	public Double getSaldo(){
		return saldo;
	}
	
	public String toString(){
		String stampa="";
		for (Merce a:elenco.values()){
			stampa=stampa+a+"/n";
		}
		stampa=stampa+"TOT. "+saldo+"eu.";
		return stampa;
	}
	public String salva(DataM m){
		String sav=data+" "+cliente.getNome()+" "+cliente.getCognome()+" tot da pagare: "+saldo+"eu./n";
		for (int k:elenco.keySet()){
			Double x=elenco.get(k).getPrezzoV();
			m.get(k).togli(x);
		}
		return sav;
	}

}
