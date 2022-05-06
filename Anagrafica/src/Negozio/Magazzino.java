package Negozio;
import java.util.*;

public class Magazzino {
	ArrayList<Merce> elenco=new ArrayList<Merce>();

	public void agg(Merce t){
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
	public int trovaQuantita(int qua){
		for (int i=0;i<elenco.size();i++){
			if (elenco.get(i).getQuantita()==qua){
				return i;
			}
		}
		System.out.println("Identificativo non trovato.");
		return -1;
	}
	public ArrayList<Integer> trovaRincaro(int rin){
		ArrayList<Integer> temp=new ArrayList<Integer>();
		for (int i=0;i<elenco.size();i++){
			if (elenco.get(i).getRincaro()==rin){
				temp.add(i);
			}
		}
		return temp;
	}
}