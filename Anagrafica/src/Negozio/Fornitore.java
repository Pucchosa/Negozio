package Negozio;
import GUI.*;

public class Fornitore extends Anagrafica {
	
	public Fornitore(String unCognome, String unNome){
		super(unCognome, unNome);
		setTipo("fornitore");
	}
	public Fornitore(){
		super();
		System.out.println("Inserire P.Iva: ");
		setIva(sc.nextLine());
		setTipo("fornitore");
	}

	public void pagamentoEffettuato(Double pagamento){
		setSaldo(getSaldo()+pagamento);
	}
	public void consegnaMerci(Double costo){
		setSaldo(getSaldo()-costo);
		System.out.println("merce ricevuta da "+getNome()+" fattuira registrata per P.IVA: "+getIva());
	}
}