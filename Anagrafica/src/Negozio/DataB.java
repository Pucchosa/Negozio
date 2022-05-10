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
		if (eDuplicato(t)==false){
			elenco.add(t);
		}
		else {
			System.out.println("Nominativo gia presente.");
		}
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
	public boolean eDuplicato(String nominativo){
		String[] nom=nominativo.split(" ");
		if (nom.length==2){
			if (trovaCognome(nom[0])!=-1){
				if (trovaNome(nom[1])!=-1){
					return true;
				}
			}
		}
		return false;
	}
	public boolean eDuplicato(String co, String no){
		String[] nom={co, no};
		if (trovaCognome(nom[0])!=-1){
			if (trovaNome(nom[1])!=-1){
				return true;
			}
		}
		return false;
	}
	public boolean eDuplicato(T ogg){
		String[] nom={ogg.getNome(), ogg.getCognome()};
		if (trovaCognome(nom[0])!=-1){
			if (trovaNome(nom[1])!=-1){
				return true;
			}
		}
		return false;
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
