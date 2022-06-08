package Negozio;
import GUI.*;
import java.util.Scanner;

public class Program{
/*
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int c=0;
		int f=0;
		Double saldoAz=0.00;
		DataB<Fornitore> fornitori=new DataB<Fornitore>("fornitore");
		DataB<Cliente> clienti=new DataB<Cliente>("cliente");
		System.out.println("Benvenuto nel database del negozio!");
		System.out.println("Si desidera eseguire un`operazione o aggiornare un database? (opp/agg)");
		
		
		System.out.println("Si desidera modificare/eliminare/aggiornare un dato?");
		
		System.out.println("");
		
		
		while (c<10&&f<10){
			System.out.println("Si desidera aggiungere un nuovo nominativo?(S/N) ");
			String ris = sc.nextLine();
			if (ris.equalsIgnoreCase("s")){
				int r=0;
				while (r==0){
					System.out.println("Si desidera inserire un nuovo fornitore o un nuovo cliente?(F/C) ");
					ris = sc.nextLine();
					if (ris.equalsIgnoreCase("f")){
						Fornitore forn=new Fornitore();
						fornitori.agg(forn);
						f++;
						r=1;
					}
					else if (ris.equalsIgnoreCase("c")){
						Cliente clie=new Cliente();
						clienti.agg(clie);
						c++;
						r=2;
					}
					else {System.out.println("Scusa non ho capito...");	}
				}
			}
			else if (ris.equalsIgnoreCase("n")){
				c=c+20;
				f=f+20;
			}
			else {System.out.println("Scusa non ho capito...");	}
		}
		System.out.println("Numero massimo di nominativi raggiunto.");
		
/*		for (Fornitore a:fornitori){
			if (a!=null){
				System.out.println(a);
			}
		}
		for (Cliente a:clienti){
			if (a!=null){
				System.out.println(a);
			}
		}	*/
	/*	
		// FAI OPERAZ
		int o=0;
		while (o==0){
			System.out.println("Si desidera effettuare una nuova operazione?(S/N) ");
			String ris = sc.nextLine();
			if (ris.equalsIgnoreCase("s")){
				int r=0;
				while (r==0){
					System.out.println("Si desidera Ordinare o Inviare della merce?(O/I) ");
					System.out.println("Oppure si vuole registrare un pagamento?(P) ");
					ris = sc.nextLine();
					if (ris.equalsIgnoreCase("o")){
						System.out.println("Da quale fornitore si desidera ordinare?");
						String ordina=sc.nextLine();
						System.out.println("Qale e il valore della merce da ordinare?");
						Double tot=sc.nextDouble();
						int index=fornitori.trovaCognome(ordina);
						try{
							fornitori.get(index).consegnaMerci(tot);
						}
						catch (Exception e){System.out.println(e.getMessage());	}
						r=1;
					}
					else if (ris.equalsIgnoreCase("i")){
						System.out.println("A quale cliente si desidera spedire la merce?");
						String ordina=sc.nextLine();
						System.out.println("Qale e il valore della merce da spedire?");
						Double tot=sc.nextDouble();
						int index=clienti.trovaCognome(ordina);
						try{
							clienti.get(index).consegnaMerci(tot);
						}
						catch (Exception e){System.out.println(e.getMessage());	}
						r=2;
					}
					else if (ris.equalsIgnoreCase("p")){
						int z=0;
						while (z==0){
							System.out.println("Si vuole registrare un pagamento in entrata o in uscita?(E/U) ");
							ris = sc.nextLine();
							if (ris.equalsIgnoreCase("e")){
								System.out.println("Quale cliente ha effettuato un pagamento?");
								String ordina=sc.nextLine();
								System.out.println("Qale e il totale del pagamento?");
								Double tot=sc.nextDouble();
								int index=clienti.trovaCognome(ordina);
								try{
									clienti.get(index).pagamentoEffettuato(tot);
								}
								catch (Exception e){System.out.println(e.getMessage());	}
								saldoAz=saldoAz+tot;
								z=1;
								r=2;
							}
							else if (ris.equalsIgnoreCase("u")){
								System.out.println("A quale fornitore e stato fatto un pagamento?");
								String ordina=sc.nextLine();
								System.out.println("Qale e il totale del pagamento?");
								Double tot=sc.nextDouble();
								int index=fornitori.trovaCognome(ordina);
								try{
									fornitori.get(index).pagamentoEffettuato(tot);
								}
								catch (Exception e){System.out.println(e.getMessage());	}
								saldoAz=saldoAz-tot;
								z=2;
								r=2;
							}
							else {System.out.println("Scusa non ho capito...");	}
						}
					}
					else {System.out.println("Scusa non ho capito...");	}
				}
			}
			else if (ris.equalsIgnoreCase("n")){
				o=1;
			}
			else {System.out.println("Scusa non ho capito...");	}
		}
		System.out.println("Si desidera stampare la situazione?(S) ");
		String ris = sc.nextLine();
		if (ris.equalsIgnoreCase("s")){
			System.out.println("+++++-----  Saldo aziendale: "+saldoAz+" euro  -----++++++");
			System.out.println("+++++  Situazone fornitori: ++++++");
			System.out.println(fornitori);
			System.out.println("/n +++++  Situazone clienti: ++++++");
			System.out.println(clienti);
		}
		
	}	*/
}