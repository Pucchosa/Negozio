package Negozio;
import java.util.*;

public class DataB <T extends Ogg> {
	ArrayList<T> elenco=new ArrayList<T>();
	String tip="";
	
	public DataB(String s){
		tip=s.toLowerCase();
	}
	public String getTip(){
		return tip;
	}
	public void agg(T t){
		elenco.add(t);
	}
	public int trovaNome(String nome){
		for (int i=0;i<elenco.size();i++){
			if (elenco.get(i).getNome().equals(nome)){
				return i;
			}
		}
		System.out.println("Identificativo non trovato.");
		return -1;
	}
	public int trovaCognome(String cognome){
		for (int i=0;i<elenco.size();i++){
			if (elenco.get(i).getCognome().equals(cognome)){
				return i;
			}
		}
		System.out.println("Identificativo non trovato.");
		return -1;
	}
	public int trovaIva(String iva){
		for (int i=0;i<elenco.size();i++){
			if (elenco.get(i).getIva().equals(iva)){
				return i;
			}
		}
		System.out.println("Identificativo non trovato.");
		return -1;
	}
}
