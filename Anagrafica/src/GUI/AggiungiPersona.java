package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;
import java.awt.event.*;

public class AggiungiPersona extends Finestra{
	String cognome="";
	String nome="";
	String telefono="";
	String email="";
	String indirizzo="";
	String tipo="";
	Double saldo=0.0;
	String titolo="";
	String iva="";
	boolean sett;
	Anagrafica mer=null;
	public AggiungiPersona(DataB<Cliente> c,DataB<Fornitore> f){
		super("Aggiungi persona");
		
		Panel contenuto=new Panel();
		contenuto.setLayout(new GridLayout(10,2));
		
/*comp1*/  Etichetta ty=new Etichetta("Scegliere DB: ");
		contenuto.add(ty);
		
/*comp2*/Panel ss=new Panel();
		ss.setLayout(new GridLayout(1,2));
		JRadioButton client = new JRadioButton("Clienti");
		client.setBackground(Est.chiaro);
	    client.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            tipo="cliente";
	        }
	    });
	    ss.add(client);
		JRadioButton fornit = new JRadioButton("Fornitori");
 		fornit.setBackground(Est.chiaro);
	    fornit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	tipo="fornitore";
	        }
	    });
	    ss.add(fornit);
	    //Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(client);
	    group.add(fornit);
	    contenuto.add(ss);
		
/*comp3*/  Etichetta un=new Etichetta("Titolo: ");
		contenuto.add(un);
		
/*comp4*/Choice uni=new Choice();
		uni.add("Scegli");
		uni.add("Ditta");
		uni.add("Sig.");
		uni.add("Sig.ra");
		uni.setFont(Est.font);
		uni.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e){
				if (uni.getSelectedIndex()>0){
					titolo=uni.getSelectedItem();
				}
			}
		});
		contenuto.add(uni);	
		
/*comp5*/  Etichetta non=new Etichetta("Nome: ");
		contenuto.add(non);
/*comp6*/ JPanel pan1=new JPanel();
		JTextField tf1 = new JTextField("Nome", 15);
		tf1.setForeground(Est.chiarissimo);
		tf1.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
				if (tf1.getText().equals("Nome")){
					tf1.setText("");
					tf1.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e){
				if (tf1.getText().isEmpty()){
					tf1.setText("Nome");
					tf1.setForeground(Est.chiarissimo);
				}
				else nome=tf1.getText();
			}
		});
		tf1.setFont(Est.font);
		pan1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan1.add(tf1);
		pan1.setBackground(Est.chiaro);
		contenuto.add(pan1);

/*comp7*/  Etichetta qtt=new Etichetta("Cognome: ");
		contenuto.add(qtt);
/*comp8*/JPanel pan2=new JPanel();
		JTextField tf2 = new JTextField("Cognome", 15);
		tf2.setForeground(Est.chiarissimo);
		tf2.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
				if (tf2.getText().equals("Cognome")){
					tf2.setText("");
					tf2.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e){
				if (tf2.getText().isEmpty()){
					tf2.setText("Cognome");
					tf2.setForeground(Est.chiarissimo);
				}
				else {
					cognome=tf2.getText();
				}
			}
		});
		tf2.setFont(Est.font);
		pan2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan2.add(tf2);
		pan2.setBackground(Est.chiaro);
		contenuto.add(pan2);
		
/*comp9*/  Etichetta tel=new Etichetta("Telefono: ");
		contenuto.add(tel);
/*comp10*/JPanel pan3=new JPanel();
		JTextField tf3 = new JTextField("Telefono", 15);
		tf3.setForeground(Est.chiarissimo);
		tf3.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
				if (tf3.getText().equals("Telefono")){
					tf3.setText("");
					tf3.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e){
				if (tf3.getText().isEmpty()){
					tf3.setText("Telefono");
					tf3.setForeground(Est.chiarissimo);
				}
				else {
					telefono=tf3.getText();
				}
			}
		});
		tf3.setFont(Est.font);
		pan3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan3.add(tf3);
		pan3.setBackground(Est.chiaro);
		contenuto.add(pan3);
		
/*comp11*/  Etichetta mai=new Etichetta("eMail: ");
		contenuto.add(mai);
/*comp12*/JPanel pan4=new JPanel();
		JTextField tf4 = new JTextField("eMail", 15);
		tf4.setForeground(Est.chiarissimo);
		tf4.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
				if (tf4.getText().equals("eMail")){
					tf4.setText("");
					tf4.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e){
				if (tf4.getText().isEmpty()){
					tf4.setText("eMail");
					tf4.setForeground(Est.chiarissimo);
				}
				else {
					email=tf4.getText();
				}
			}
		});
		tf4.setFont(Est.font);
		pan4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan4.add(tf4);
		pan4.setBackground(Est.chiaro);
		contenuto.add(pan4);
		
/*comp13*/  Etichetta ivv=new Etichetta("Partita IVA: ");
		contenuto.add(ivv);
/*comp14*/JPanel pan5=new JPanel();
		JTextField tf5 = new JTextField("IVA n.", 15);
		tf5.setForeground(Est.chiarissimo);
		tf5.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
				if (tf5.getText().equals("IVA n.")){
					tf5.setText("");
					tf5.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e){
				if (tf5.getText().isEmpty()){
					tf5.setText("IVA n.");
					tf5.setForeground(Est.chiarissimo);
				}
				else {
					iva=tf5.getText();
				}
			}
		});
		tf5.setFont(Est.font);
		pan5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan5.add(tf5);
		pan5.setBackground(Est.chiaro);
		contenuto.add(pan5);
		
/*comp15*/  Etichetta ind=new Etichetta("Indirizzo: ");
		contenuto.add(ind);
/*comp16*/JPanel pan6=new JPanel();
		JTextField tf6 = new JTextField("indirizzo", 15);
		tf6.setForeground(Est.chiarissimo);
		tf6.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
				if (tf6.getText().equals("indirizzo")){
					tf6.setText("");
					tf6.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e){
				if (tf6.getText().isEmpty()){
					tf6.setText("indirizzo");
					tf6.setForeground(Est.chiarissimo);
				}
				else {
					indirizzo=tf6.getText();
				}
			}
		});
		tf6.setFont(Est.font);
		pan6.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan6.add(tf6);
		pan6.setBackground(Est.chiaro);
		contenuto.add(pan6);
		
/*comp17*/  Etichetta prr=new Etichetta("Saldo iniziale: ");
		contenuto.add(prr);
/*comp18*/ JPanel pan7=new JPanel();
		JTextField tf7 = new JTextField("Saldo", 15);
		tf7.setForeground(Est.chiarissimo);
		tf7.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
				if (tf7.getText().equals("Saldo")){
					tf7.setText("");
					tf7.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e){
				if (tf7.getText().isEmpty()){
					tf7.setText("Saldo");
					tf7.setForeground(Est.chiarissimo);
				}
				else {
					try {
						saldo=Double.parseDouble(tf7.getText());
					}
					catch (Exception ex){
						ErrorMessage err=new ErrorMessage("inserire numero con . ");
						err.setVisible(true);
					}
				}
			}
		});
		tf7.setFont(Est.font);
		pan7.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan7.add(tf7);
		pan7.setBackground(Est.chiaro);
		contenuto.add(pan7);
			
/*comp19*/Pulsante bex=new Pulsante("-ESCI-");
		bex.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	ConsultaPersone consultaP=new ConsultaPersone(c,f);
		    	consultaP.setVisible(true);
		    	dispose();
			}
		});
		contenuto.add(bex);
		
/*comp20*/Pulsante bent=new Pulsante("-INVIO-");
		bent.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (tipo.contentEquals("cliente")){
		    		Cliente inser=new Cliente(titolo, nome, cognome, telefono, email, iva, indirizzo, saldo);
		    		c.agg(inser);
		    		ConsultaPersone consultaP=new ConsultaPersone(c,f);
			    	consultaP.setVisible(true);
			    	dispose();
		    	}
		    	else if (tipo.contentEquals("fornitore")){
		    		Fornitore inser=new Fornitore(titolo, nome, cognome, telefono, email, iva, indirizzo, saldo);
		    		f.agg(inser);
		    		ConsultaPersone consultaP=new ConsultaPersone(c,f);
			    	consultaP.setVisible(true);
			    	dispose();
		    	}
			}
		});
		contenuto.add(bent);
		
		add(contenuto);
		pack();
	}
	
	public AggiungiPersona(DataB<Cliente> c,DataB<Fornitore> f,int x,String tipo){
		super("Modifica persona");
		
		if (tipo.equals("fornitore")){
			try {
				mer=f.get(x);
			}
			catch (Exception e){
				ErrorMessage err=new ErrorMessage("Indice elenco errato...");
				err.setVisible(true);
				setVisible(false);
			    ConsultaPersone consultaP=new ConsultaPersone(c,f);
			    consultaP.setVisible(true);
			   	dispose();
			}
		}
		else {
			try {
				mer=c.get(x);
			}
			catch (Exception e){
				ErrorMessage err=new ErrorMessage("Indice elenco errato...");
				err.setVisible(true);
				setVisible(false);
			   	ConsultaPersone consultaP=new ConsultaPersone(c,f);
			   	consultaP.setVisible(true);
			   	dispose();		
			}
		}
		
			setLayout(new BorderLayout(100,10));
			setLocation(150,150);
			setBackground(Est.chiaro);
			
			Panel contenuto=new Panel();
			contenuto.setLayout(new GridLayout(10,2));
			
			titolo=mer.getTitolo();
    		iva=mer.getIva();
    		telefono=mer.getTelefono();
    		email=mer.getEmail();
    		saldo=mer.getSaldo();
    		indirizzo=mer.getIndirizzo();
			
	/*comp1*/  Etichetta ty=new Etichetta("Tipo persona: ");
			contenuto.add(ty);
			
	/*comp2*/Etichetta ty1=new Etichetta(""+tipo);
			contenuto.add(ty1);
			
	/*comp3*/  Etichetta un=new Etichetta("Titolo: ");
			contenuto.add(un);
	/*comp4*/JLabel uni=new JLabel();
			uni.setText(mer.getTitolo());
			uni.setFont(Est.font);
			uni.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
			contenuto.add(uni);
			
	/*comp5*/  Etichetta non=new Etichetta("Nome: ");
			contenuto.add(non);
	/*comp6*/ Etichetta nomm=new Etichetta(mer.getNome());
			contenuto.add(nomm);
	
	/*comp7*/  Etichetta qtt=new Etichetta("Cognome: ");
			contenuto.add(qtt);
	/*comp8*/Etichetta qtr=new Etichetta(mer.getCognome());
			contenuto.add(qtr);
			
	/*comp9*/  Etichetta tel=new Etichetta("Telefono: ");
			contenuto.add(tel);
	/*comp10*/JPanel pan3=new JPanel();
			JTextField tf3 = new JTextField(mer.getTelefono(), 15);
			tf3.setForeground(Est.chiarissimo);
			tf3.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e){
					if (tf3.getText().equals(mer.getTelefono())){
						tf3.setText("");
						tf3.setForeground(Color.BLACK);
					}
				}
				public void focusLost(FocusEvent e){
					if (tf3.getText().isEmpty()){
						tf3.setText(mer.getTelefono());
						tf3.setForeground(Est.chiarissimo);
					}
					else {
						telefono=tf3.getText();
					}
				}
			});
			tf3.setFont(Est.font);
			pan3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			pan3.add(tf3);
			pan3.setBackground(Est.chiaro);
			contenuto.add(pan3);
			
	/*comp11*/  Etichetta mai=new Etichetta("eMail: ");
			contenuto.add(mai);
	/*comp12*/JPanel pan4=new JPanel();
			JTextField tf4 = new JTextField(mer.getEmail(), 15);
			tf4.setForeground(Est.chiarissimo);
			tf4.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e){
					if (tf4.getText().equals(mer.getEmail())){
						tf4.setText("");
						tf4.setForeground(Color.BLACK);
					}
				}
				public void focusLost(FocusEvent e){
					if (tf4.getText().isEmpty()){
						tf4.setText(mer.getEmail());
						tf4.setForeground(Est.chiarissimo);
					}
					else {
						email=tf4.getText();
					}
				}
			});
			tf4.setFont(Est.font);
			pan4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			pan4.add(tf4);
			pan4.setBackground(Est.chiaro);
			contenuto.add(pan4);
			
	/*comp13*/  Etichetta ivv=new Etichetta("Partita IVA: ");
			contenuto.add(ivv);
	/*comp14*/JPanel pan5=new JPanel();
			JTextField tf5 = new JTextField(mer.getIva(), 15);
			tf5.setForeground(Est.chiarissimo);
			tf5.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e){
					if (tf5.getText().equals(mer.getIva())){
						tf5.setText("");
						tf5.setForeground(Color.BLACK);
					}
				}
				public void focusLost(FocusEvent e){
					if (tf5.getText().isEmpty()){
						tf5.setText(mer.getIva());
						tf5.setForeground(Est.chiarissimo);
					}
					else {
						iva=tf5.getText();
					}
				}
			});
			tf5.setFont(Est.font);
			pan5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			pan5.add(tf5);
			pan5.setBackground(Est.chiaro);
			contenuto.add(pan5);
			
	/*comp15*/  Etichetta ind=new Etichetta("Indirizzo: ");
			contenuto.add(ind);
	/*comp16*/JPanel pan6=new JPanel();
			JTextField tf6 = new JTextField(mer.getIndirizzo(), 15);
			tf6.setForeground(Est.chiarissimo);
			tf6.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e){
					if (tf6.getText().equals(mer.getIndirizzo())){
						tf6.setText("");
						tf6.setForeground(Color.BLACK);
					}
				}
				public void focusLost(FocusEvent e){
					if (tf6.getText().isEmpty()){
						tf6.setText(mer.getIndirizzo());
						tf6.setForeground(Est.chiarissimo);
					}
					else {
						indirizzo=tf6.getText();
					}
				}
			});
			tf6.setFont(Est.font);
			pan6.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			pan6.add(tf6);
			pan6.setBackground(Est.chiaro);
			contenuto.add(pan6);
			
	/*comp17*/  Etichetta prr=new Etichetta("Saldo iniziale: ");
			contenuto.add(prr);
	/*comp18*/ JPanel pan7=new JPanel();
			JTextField tf7 = new JTextField(""+mer.getSaldo(), 15);
			tf7.setForeground(Est.chiarissimo);
			tf7.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e){
					if (tf7.getText().equals(""+mer.getSaldo())){
						tf7.setText("");
						tf7.setForeground(Color.BLACK);
					}
				}
				public void focusLost(FocusEvent e){
					if (tf7.getText().isEmpty()){
						tf7.setText(""+mer.getSaldo());
						tf7.setForeground(Est.chiarissimo);
					}
					else {
						try {
							saldo=Double.parseDouble(tf7.getText());
						}
						catch (Exception ex){
							ErrorMessage err=new ErrorMessage("inserire numero con . ");
							err.setVisible(true);
						}
					}
				}
			});
			tf7.setFont(Est.font);
			pan7.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			pan7.add(tf7);
			pan7.setBackground(Est.chiaro);
			contenuto.add(pan7);
				
	/*comp19*/Pulsante bex=new Pulsante("-ESCI-");
			bex.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	setVisible(false);
			    	ConsultaPersone consultaP=new ConsultaPersone(c,f);
			    	consultaP.setVisible(true);
			    	dispose();
				}
			});
			contenuto.add(bex);
			
	/*comp20*/Pulsante bent=new Pulsante("-INVIO-");
			bent.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	if (tipo.contentEquals("cliente")){
			    		try {
			    		
				    		c.get(x).setTitolo(titolo);
				    		c.get(x).setIva(iva);
				    		c.get(x).setTelefono(telefono);
				    		c.get(x).setEmail(email);
				    		c.get(x).setSaldo(saldo);
				    		c.get(x).setIndirizzo(indirizzo);
				    		ConsultaPersone consultaP=new ConsultaPersone(c,f);
					    	consultaP.setVisible(true);
					    	dispose();
			    		}
			    		catch (Exception r){
			    			ErrorMessage err=new ErrorMessage("Indice elenco errato...");
			    			err.setVisible(true);
							setVisible(false);
						    ConsultaPersone consultaP=new ConsultaPersone(c,f);
						    consultaP.setVisible(true);
						    dispose();			    			
			    		}
			    	}
			    	else if (tipo.contentEquals("fornitore")){
			    		try {
				    		f.get(x).setTitolo(titolo);
				    		f.get(x).setIva(iva);
				    		f.get(x).setTelefono(telefono);
				    		f.get(x).setEmail(email);
				    		f.get(x).setSaldo(saldo);
				    		f.get(x).setIndirizzo(indirizzo);
				    		ConsultaPersone consultaP=new ConsultaPersone(c,f);
					    	consultaP.setVisible(true);
					    	dispose();
			    		}
			    		catch (Exception u){
			    			ErrorMessage err=new ErrorMessage("Indice elenco errato...");
			    			err.setVisible(true);
							setVisible(false);
						    ConsultaPersone consultaP=new ConsultaPersone(c,f);
						    consultaP.setVisible(true);
						    dispose();	
			    		}
			    	}
				}
			});
			contenuto.add(bent);
			
			add(contenuto);
			pack();

	}
}