package Negozio;
import GUI.*;

public class Cliente extends Anagrafica {
	
	public Cliente(String unCognome, String unNome){
		super(unCognome, unNome);
		setTipo("cliente");
	}
	public Cliente(String titolo,String nome,String cognome,String telefono,String email,String iva,String indirizzo,Double saldo){
		super(titolo, nome, cognome, telefono, email, iva, indirizzo, saldo);
		setTipo("cliente");
	}

	public void pagamentoEffettuato(Double pagamento){
		setSaldo(getSaldo()-pagamento);
	}
	public void consegnaMerci(Double costo){
		setSaldo(getSaldo()+costo);
		System.out.println("merce inviata al sign. "+getNome()+" all indirizzo: "+getIndirizzo());
		if (!getIva().equals("")){
			System.out.println(" e fattura emessa a P.IVA: "+getIva()+" dell importo di euro"+costo);
		}
	}
}