package Negozio;
import GUI.*;
import java.util.Scanner;

public class Merce {
	private final String nome;
	private int codice;
	private Double quantita;
	private int rincaro;
	private Double prezzoA;
	private Double prezzoV;
	private Double valore;
	private String unita;
	private Scanner sc = new Scanner(System.in);
	
	public Merce(DataM c){
		System.out.println("Inserire nome prodotto: ");
		nome=sc.nextLine();
		System.out.println("Inserire lúnita di misura del prodotto: ");
		unita=sc.nextLine();
		System.out.println("Inserire prezzo acquisto all unita: ");
		prezzoA=sc.nextDouble();
		System.out.println("Inserire percentuale rincaro alla vendita: ");
		rincaro=sc.nextInt();
		prezzoV=(prezzoA/100*rincaro)+prezzoA;
		valore=quantita*prezzoA;
		codice=c.nextIndice();
	}
	public Merce(String nome, Double quantita, int rincaro, Double prezzoA, String unita,DataM c){
		this.nome=nome;
		this.quantita=quantita;
		this.rincaro=rincaro;
		this.prezzoA=prezzoA;
		this.unita=unita;
		this.prezzoV=prezzoA/100*rincaro;
		this.valore=prezzoA*quantita;
		this.codice=c.nextIndice();
	}
	public int getCod(){
		return codice;
	}
	public String getUnit(){
		return unita;
	}
	public String getNome(){
		return nome;
	}
	public Double getQuantita(){
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
	public void setQuantita(Double x){
		quantita=x;
	}
	public void setUnita(String x){
		unita=x;
	}
}
