package GUI;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import Negozio.ListaSpesa;
import Negozio.Merce;

public class Tabella extends Frame{
	JTable tavola;
	DefaultTableModel model = new DefaultTableModel();
	
	public Tabella(){
		tavola=new JTable(model);
		tavola.setBackground(Est.chiaro);
				
		model.addColumn("PRODOTTO:");
		model.addColumn("QUANTITÀ:");
		model.addColumn("ToT:");

		JScrollPane sp=new JScrollPane(tavola);
		sp.add(tavola);
		add(sp);
	}
	public JScrollPane ta(){
		JScrollPane sp=new JScrollPane(tavola); 
		return sp;
	}
	public void aggiungi(Merce m, Double q){
		String nome=m.getNome();
		String quantita=q+"";
		String tot=Est.deci.format(m.getPrezzoV()*q)+" $";
		String[] riga={nome,quantita,tot};
		model.addRow(riga);
	}
	public void togli(int x){
		model.removeRow(x);
	}
	public void clear(){
		model.setRowCount(0);
	}
}
