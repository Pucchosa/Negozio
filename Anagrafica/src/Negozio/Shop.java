package Negozio;

import java.time.LocalDateTime;
import java.util.HashMap;

import GUI.Est;
import GUI.MyReadL;

public class Shop {
	private static double merchVal;
	private static double totSold;
	private static double totBought;
	private static double bal;
	
	public static double getMerchVal(){
		setMerchVal();
		return merchVal;
	}
	public static double getTotSold(){
		setTotSold();
		return totSold;
	}
	public static double getTotBought(){
		return totBought;
	}
	public static void setMerchVal(){
		merchVal=0.0;
		for (Merce m:DataM.elenco.values()){
			merchVal=merchVal+m.getValore();
		}
	}
	public static void setTotSold(){
		totSold=0.0;
		HashMap<LocalDateTime,String[]> elenco=MyReadL.carica();
		for (String[] a:elenco.values()){
			try{
			double tot=Est.deci.parse(a[2]).doubleValue();
			totSold=totSold+tot;
			}
			catch (Exception e){
			}
		}
	}
	public static void setTotBought(double x){
		/*totBought=totBought+x;
		 FIX WHEN FORNITORI TRANSACTION DONE*/
	}
	public static double getBal(){
		bal=totSold-totBought;
		return bal;
	}
}
