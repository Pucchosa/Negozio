package Negozio;
import java.util.Scanner;

public abstract class Anagrafica extends Ogg{
	private String cognome;
	private String nome;
	private String iva="";
	private String telefono;
	private String email;
	private Double saldo=0.00;
	private String indirizzo;
	private String tipo;
	Scanner sc = new Scanner(System.in);

	public Anagrafica(){
		System.out.println("Inserire cognome: ");
		cognome=sc.nextLine();
		System.out.println("Inserire nome: ");
		nome=sc.nextLine();
		System.out.println("Inserire numero di telefono: ");
		telefono=sc.nextLine();
		System.out.println("Inserire indirizzo: ");
		indirizzo=sc.nextLine();
		System.out.println("Inserire eMail: ");
		email=sc.nextLine();
	}
	public Anagrafica(String unCognome, String unNome){
		cognome=unCognome;
		nome=unNome;
	}

	public String getNome(){
		return nome;
	}
	public String getCognome(){
		return cognome;
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	public void setCognome(String cognome){
		this.cognome=cognome;
	}
	public void setIva(String iva){
		this.iva=iva;
	}
	public void setTelefono(String telefono){
		this.telefono=telefono;
	}
	public void setEmail(String mail){
		email=mail;
	}
	public void setIndirizzo(String indir){
		indirizzo=indir;
	}
	public String getIva(){
		return iva;
	}
	public String getTelefono(){
		return telefono;
	}
	public String getEmail(){
		return email;
	}
	public String getIndirizzo(){
		return indirizzo;
	}
	public abstract void pagamentoEffettuato(Double pagamento);
	public String getTipo(){
		return tipo;
	}
	public void setTipo(Boolean t){
		if (t==true){
			tipo="fornitore";
		}
		else tipo="cliente";
	}
	public Double getSaldo(){
		return saldo;
	}
	public void setSaldo(Double costo){
		saldo=costo;
	}
	public abstract void consegnaMerci(Double costo);
	public String toString(){
		String stamp="";
		if (getTipo().equals("fornitore")){
			stamp=getNome()+" Piva: "+getIva()+" Debito totale: "+getSaldo();
		}
		else {
			stamp=getNome()+" "+getCognome()+" Debito totale: "+getSaldo();
		}
		return stamp;
	}
}