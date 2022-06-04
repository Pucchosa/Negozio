package Negozio;
import GUI.*;

public class Cliente extends Anagrafica {
	
	public Cliente(String unCognome, String unNome){
		super(unCognome, unNome);
		setTipo("cliente");
	}
	public Cliente(){
		super();
		System.out.println("E in possesso di P.Iva?(S/N) ");
		String risp=sc.nextLine();
		setTipo("cliente");
		if (risp.equalsIgnoreCase("s")){
			System.out.println("Inserire P.Iva: ");
			setIva(sc.nextLine());
		}
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