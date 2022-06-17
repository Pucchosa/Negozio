package GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Negozio.*;

public class MyReadM {
	
	public static void carica(DataM c){
		BufferedReader reader;
		ArrayList<String> elenco=new ArrayList<String>();
		try{
			File file = new File("merce");
			
			FileReader fReader = new FileReader(file);
			reader = new BufferedReader(fReader);
			String line;
			while ((line = reader.readLine()) != null){
				elenco.add(line);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	
		
		for (String lin:elenco){
			String[] og=lin.split(",");
			String nome=og[0];
			Double quantita=Double.parseDouble(og[1]);
			int rincaro=Integer.parseInt(og[2]);
			Double prezzoA=Double.parseDouble(og[3]);
			String unita=og[4];
			Merce ogetto=new Merce(nome, quantita, rincaro, prezzoA, unita,c);
			c.agg(ogetto);
			
		}
	}
	public static void scarica(DataM c){
		ArrayList<String> elenco=new ArrayList<String>();
		for (Merce f:c.elenco.values()){
			String temp=f.getNome()+","+f.getQuantita()+","+f.getRincaro()+","+f.getPrezzoA()+","+f.getUnit();
			elenco.add(temp);
		}
		try{
			FileWriter fWriter = new FileWriter("merce", false);
			BufferedWriter writer = new BufferedWriter(fWriter);
			
			for (String stringa:elenco){
				writer.write(stringa+System.lineSeparator());
			}
			writer.close();

		}
		catch (Exception e){
			System.out.print("Errore");
			
		}
	}
}