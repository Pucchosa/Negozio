package GUI;
import Negozio.*;
//import java.util.*;
import java.awt.*;
import Negozio.*;
import javax.swing.*;
import java.awt.event.*;

public class AggiungiPersona extends Frame{
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
	
	public AggiungiPersona(DataB<Cliente> c,DataB<Fornitore> f){
		super("Aggiungi persona");
		setLayout(new BorderLayout(100,10));
		setLocation(200,200);
		setBackground(new Color(217,243,248));
		Font ft=new Font("Lucida",Font.PLAIN,24);
		
		Panel contenuto=new Panel();
		contenuto.setLayout(new GridLayout(10,2));
		
/*comp1*/  JLabel ty=new JLabel();
		ty.setText("Scegliere DB: ");
		ty.setFont(ft);
		ty.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(ty);
		
/*comp2*/Panel ss=new Panel();
		ss.setLayout(new GridLayout(1,2));
		JRadioButton client = new JRadioButton("Clienti");
		client.setBackground(new Color(217,243,248));
	    client.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            tipo="cliente";
	        }
	    });
	    ss.add(client);
		JRadioButton fornit = new JRadioButton("Fornitori");
 		fornit.setBackground(new Color(217,243,248));
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
		
/*comp3*/  JLabel un=new JLabel();
		un.setText("Titolo: ");
		un.setFont(ft);
		un.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(un);
/*comp4*/Choice uni=new Choice();
		uni.add("Scegli");
		uni.add("Ditta");
		uni.add("Sig.");
		uni.add("Sig.ra");
		uni.setFont(ft);
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
		
/*comp5*/  JLabel non=new JLabel();
		non.setText("Nome: ");
		non.setFont(ft);
		non.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(non);
/*comp6*/ JPanel pan1=new JPanel();
		JTextField tf1 = new JTextField("Nome", 15);
		tf1.setForeground(new Color(117,223,235));
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
					tf1.setForeground(new Color(117,223,235));
				}
				else nome=tf1.getText();
			}
		});
		tf1.setFont(ft);
		pan1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan1.add(tf1);
		pan1.setBackground(new Color(217,243,248));
		contenuto.add(pan1);

/*comp7*/  JLabel qtt=new JLabel();
		qtt.setText("Cognome: ");
		qtt.setFont(ft);
		qtt.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(qtt);
/*comp8*/JPanel pan2=new JPanel();
		JTextField tf2 = new JTextField("Cognome", 15);
		tf2.setForeground(new Color(117,223,235));
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
					tf2.setForeground(new Color(117,223,235));
				}
				else {
					cognome=tf2.getText();
				}
			}
		});
		tf2.setFont(ft);
		pan2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan2.add(tf2);
		pan2.setBackground(new Color(217,243,248));
		contenuto.add(pan2);
		
/*comp9*/  JLabel tel=new JLabel();
		tel.setText("Telefono: ");
		tel.setFont(ft);
		tel.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(tel);
/*comp10*/JPanel pan3=new JPanel();
		JTextField tf3 = new JTextField("Telefono", 15);
		tf3.setForeground(new Color(117,223,235));
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
					tf3.setForeground(new Color(117,223,235));
				}
				else {
					telefono=tf3.getText();
				}
			}
		});
		tf3.setFont(ft);
		pan3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan3.add(tf3);
		pan3.setBackground(new Color(217,243,248));
		contenuto.add(pan3);
		
/*comp11*/  JLabel mai=new JLabel();
		mai.setText("eMail: ");
		mai.setFont(ft);
		mai.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(mai);
/*comp12*/JPanel pan4=new JPanel();
		JTextField tf4 = new JTextField("eMail", 15);
		tf4.setForeground(new Color(117,223,235));
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
					tf4.setForeground(new Color(117,223,235));
				}
				else {
					email=tf4.getText();
				}
			}
		});
		tf4.setFont(ft);
		pan4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan4.add(tf4);
		pan4.setBackground(new Color(217,243,248));
		contenuto.add(pan4);
		
/*comp13*/  JLabel ivv=new JLabel();
		ivv.setText("Partita IVA: ");
		ivv.setFont(ft);
		ivv.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(ivv);
/*comp14*/JPanel pan5=new JPanel();
		JTextField tf5 = new JTextField("IVA n.", 15);
		tf5.setForeground(new Color(117,223,235));
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
					tf5.setForeground(new Color(117,223,235));
				}
				else {
					iva=tf5.getText();
				}
			}
		});
		tf5.setFont(ft);
		pan5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan5.add(tf5);
		pan5.setBackground(new Color(217,243,248));
		contenuto.add(pan5);
		
/*comp15*/  JLabel ind=new JLabel();
		ind.setText("Indirizzo: ");
		ind.setFont(ft);
		ind.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(ind);
/*comp16*/JPanel pan6=new JPanel();
		JTextField tf6 = new JTextField("indirizzo", 15);
		tf6.setForeground(new Color(117,223,235));
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
					tf6.setForeground(new Color(117,223,235));
				}
				else {
					indirizzo=tf6.getText();
				}
			}
		});
		tf6.setFont(ft);
		pan6.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan6.add(tf6);
		pan6.setBackground(new Color(217,243,248));
		contenuto.add(pan6);
		
/*comp17*/  JLabel prr=new JLabel();
		prr.setText("Saldo iniziale: ");
		prr.setFont(ft);
		prr.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 70));
		contenuto.add(prr);
/*comp18*/ JPanel pan7=new JPanel();
		JTextField tf7 = new JTextField("Saldo", 15);
		tf7.setForeground(new Color(117,223,235));
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
					tf7.setForeground(new Color(117,223,235));
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
		tf7.setFont(ft);
		pan7.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pan7.add(tf7);
		pan7.setBackground(new Color(217,243,248));
		contenuto.add(pan7);
			
/*comp19*/Button bex=new Button("-ESCI-");
		bex.setBackground(new Color(2,146,183));
		bex.setPreferredSize(new Dimension(80,50));
		bex.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	ConsultaPersone consultaP=new ConsultaPersone(c,f);
		    	consultaP.setVisible(true);
		    	dispose();
			}
		});
		contenuto.add(bex);
		
/*comp20*/Button bent=new Button("-INVIO-");
		bent.setBackground(new Color(26,200,219));
		bent.setPreferredSize(new Dimension(80,50));
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
}