package GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Negozio.*;

public class MyReadL {
	public static ArrayList<String> carica(){
		BufferedReader reader;
		ArrayList<String> elenco=new ArrayList<String>();
		try{
			File file = new File("trans");
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
		return elenco;
	}
	public static void scarica(ListaSpesa l){
		String riga="DATA: "+l.getData()+" CLIENTE: "+l.getCliente().getIntestazione()+" SALDO: "+Est.deci.format(l.getSaldo())+"eu. " ;
		
		try{
			FileWriter fWriter = new FileWriter("trans", true);
			BufferedWriter writer = new BufferedWriter(fWriter);
			
			writer.write(riga+System.lineSeparator());
			writer.close();

		}
		catch (Exception e){
			System.out.print("Errore");
			
		}
	}
}