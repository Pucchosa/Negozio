package Negozio;
import java.util.Scanner;

public class Merce {
	final String nome;
	int quantita;
	int rincaro;
	Double prezzoA;
	Double prezzoV;
	Double valore;
	Scanner sc = new Scanner(System.in);
	
	public Merce(int x){
		System.out.println("Inserire nome prodotto: ");
		nome=sc.nextLine();
		System.out.println("Inserire numero pezzi acquistati: ");
		quantita=sc.nextInt();
		System.out.println("Inserire prezzo acquisto all unita: ");
		prezzoA=sc.nextDouble();
		System.out.println("Inserire percentuale rincaro alla vendita: ");
		rincaro=sc.nextInt();
		prezzoV=(prezzoA/100*rincaro)+prezzoA;
		valore=x*prezzoA;
	}
	public String getNome(){
		return nome;
	}
	public int getQuantita(){
		return quantita;
	}
	public int getRincaro(){
		return rincaro;
	}
	public Double getPrezzoA(){
		return prezzoA;
	}
	public Double getPrezzoV(){
		return prezzoV;
	}
	public Double getValore(){
		return valore;
	}
	public void togli(int x){
		quantita=quantita-x;
	}
	public void aggiungi(int x){
		quantita=quantita+x;
	}
	public void setRincaro(int x){
		rincaro=x;
		prezzoV=(prezzoA/100*rincaro)+prezzoA;
	}
	public void setPrezzoA(Double x){
		prezzoA=x;
		prezzoV=(prezzoA/100*rincaro)+prezzoA;
		valore=quantita*prezzoA;
	}
	public Double compra(int x){
		aggiungi(x);
		return (x*prezzoA);
	}
	public Double vendi(int x){
		togli(x);
		return (x*prezzoV);
	}
}
