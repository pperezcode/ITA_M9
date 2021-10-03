package com.rocket.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.rocket.application.CoetController;
import com.rocket.domain.Coet;
import com.rocket.domain.Propulsor;

@SuppressWarnings("serial")
public class ControlPanelView extends JFrame implements ActionListener {
	
	private int valorVelAcc1, valorVelAcc2;
	private JPanel panel;
	
	private JLabel lblCodi1, lblCodi2, lblVelAccTitol1, lblVelAccTitol2;
	private JLabel lblVelAct1, lblVelAct2, lblVelMax1, lblVelMax2;
	private JLabel lblPropTitol1, lblPropTitol2, lblPotActTitol1, lblPotActTitol2, lblPotMaxTitol1, lblPotMaxTitol2;
	private JLabel lblVelObjTitol1, lblVelObjTitol2, lblVelObj1, lblVelObj2;
	private JLabel lblMsgCoet1, lblMsgCoet2, lblMsgStart1, lblMsgStart2;
	private JLabel lblProp, lblPotMax;
	private JButton btVelObj1, btVelObj2, btStart1, btStart2;
	private JTextField textVelObj1, textVelObj2;
	private Font lblTitolFont, lblTextFont, lblMsgFont;
	private JComboBox<String> velAcc1, velAcc2;
	private List<JLabel> lblPotAct1 = new ArrayList<JLabel>();
	private List<JLabel> lblPotAct2 = new ArrayList<JLabel>();

	private Coet c1, c2;
	protected List<Coet> coets = new ArrayList<Coet>();
	
	CoetController cc = new CoetController();
	
	public ControlPanelView (List<Coet> coets) {
		
		this.coets = coets;
		c1 = coets.get(0);
		c2 = coets.get(1);	
			
		// Definim el JFrame
		
		setSize(1000, 500);
		setTitle("Panell de control coets");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		// Definim els tipus de lletres que farem servir
		
		lblTitolFont = new Font("Arial", Font.BOLD, 24);
		lblTextFont = new Font("Arial", Font.BOLD, 18);
		lblMsgFont = new Font("Arial", Font.ITALIC, 16);
		
		// Afegim els components al JFrame
		
		iniciarComponents();
		
		//Acabem de definir el JFrame
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		//setVisible(true);

	}

	private void iniciarComponents() {		// Afegeix components a la finestra del panell de control
		
		afegirPanel();
		afegirTitols();
		afegirVelAcc();
		afegirVelocitats();
		afegirVelocitatObj();
		afegirVisorPropulsors();
		afegirMissatgeCoet1("COET " + c1.getCodi() + " PREPARAT PER INICIAR");
		afegirMissatgeCoet2("COET " + c2.getCodi() + " PREPARAT PER INICIAR");
		afegirMissatgeStartCoet1("EN ESPERA");
		afegirMissatgeStartCoet2("EN ESPERA");
		afegirComboBox();
		afegirBotons();

	}
	
	private void afegirPanel() {		// Afegeix un JPanel per controlar els coets

		panel = new JPanel();
		setContentPane(panel);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);
		
	}

	private void afegirTitols() {		// Afegeix el codi de cada coet
				
		lblCodi1 = new JLabel(c1.getCodi(), SwingConstants.CENTER);		// Títol coet1
		lblCodi1.setFont(lblTitolFont);
		lblCodi1.setForeground(Color.DARK_GRAY);
		lblCodi1.setBounds(0, 20, 450, 20);				
		panel.add(lblCodi1);
		
		lblCodi2 = new JLabel(c2.getCodi(), SwingConstants.CENTER);		// Títol coet2
		lblCodi2.setFont(lblTitolFont);
		lblCodi2.setForeground(Color.DARK_GRAY);
		lblCodi2.setBounds(500, 20, 500, 20);				
		panel.add(lblCodi2);
		
	}
	
	private void afegirVelAcc() {		// Afegeix el títol de la velocitat d'acceleració

		lblVelAccTitol1 = new JLabel("Acceleració", SwingConstants.LEFT);
		lblVelAccTitol1.setFont(lblTextFont);
		lblVelAccTitol1.setForeground(Color.DARK_GRAY);
		lblVelAccTitol1.setBounds(10, 60, 210, 30);				
		panel.add(lblVelAccTitol1);
		
		lblVelAccTitol2 = new JLabel("Acceleració", SwingConstants.LEFT);
		lblVelAccTitol2.setFont(lblTextFont);
		lblVelAccTitol2.setForeground(Color.DARK_GRAY);
		lblVelAccTitol2.setBounds(520, 60, 210, 30);				
		panel.add(lblVelAccTitol2);
	}
	
	private void afegirComboBox() {		// Afegim els factors d'acceleració x1, x2, x3, x4, x5
		
		velAcc1 = new JComboBox<String>();
		velAcc1.setBounds(40, 90, 50, 30);		
		velAcc1.addItem("x1");
		velAcc1.addItem("x2");
		velAcc1.addItem("x3");
		velAcc1.addItem("x4");
		velAcc1.addItem("x5");
		panel.add(velAcc1);		
		
		velAcc2 = new JComboBox<String>();
		velAcc2.setBounds(550, 90, 50, 30);		
		velAcc2.addItem("x1");
		velAcc2.addItem("x2");
		velAcc2.addItem("x3");
		velAcc2.addItem("x4");
		velAcc2.addItem("x5");
		panel.add(velAcc2);		
		
	}

	private void afegirVelocitatObj() {		// Afegeix el JTextField i les etiquetes per a establir la velocitat objectiu de cada coet
		
		// Coet 1
		lblVelObjTitol1 = new JLabel("Indica VelocitatObj", SwingConstants.LEFT);
		lblVelObjTitol1.setFont(lblTextFont);
		lblVelObjTitol1.setForeground(Color.DARK_GRAY);
		lblVelObjTitol1.setBounds(290, 60, 210, 30);				
		panel.add(lblVelObjTitol1);
		
		textVelObj1 = new JTextField();
		textVelObj1.setBounds(310, 90, 60, 30);
		textVelObj1.setBackground(Color.WHITE);
		panel.add(textVelObj1);
				
		lblVelObj1 = new JLabel("VelObj: " + c1.getVelObj() + " Km/s", SwingConstants.LEFT);
		lblVelObj1.setFont(lblTextFont);
		lblVelObj1.setForeground(Color.GREEN);
		lblVelObj1.setBounds(115, 90, 250, 30);				
		panel.add(lblVelObj1);
		
		// Coet2
		lblVelObjTitol2 = new JLabel("Indica VelocitatObj", SwingConstants.LEFT);
		lblVelObjTitol2.setFont(lblTextFont);
		lblVelObjTitol2.setForeground(Color.DARK_GRAY);
		lblVelObjTitol2.setBounds(800, 60, 210, 30);				
		panel.add(lblVelObjTitol2);
		
		textVelObj2 = new JTextField();
		textVelObj2.setBounds(820, 90, 60, 30);
		textVelObj2.setBackground(Color.WHITE);
		panel.add(textVelObj2);
		
		lblVelObj2 = new JLabel("VelObj: " + c2.getVelObj() + " Km/s", SwingConstants.LEFT);
		lblVelObj2.setFont(lblTextFont);
		lblVelObj2.setForeground(Color.GREEN);
		lblVelObj2.setBounds(630, 90, 250, 30);				
		panel.add(lblVelObj2);
	}
	
	private void afegirVelocitats() {		// Afegeix informació sobre velocitat actual i velocitat màxima

		lblVelMax1 = new JLabel("VelMax: " + c1.getVelMax() + " Km/s", SwingConstants.LEFT);
		lblVelMax1.setFont(lblTextFont);
		lblVelMax1.setForeground(Color.RED);
		lblVelMax1.setBounds(115, 130, 250, 30);				
		panel.add(lblVelMax1);
		
		lblVelAct1 = new JLabel("VelAct: " + c1.getVelAct() + " Km/s", SwingConstants.LEFT);
		lblVelAct1.setFont(lblTextFont);
		lblVelAct1.setForeground(Color.BLUE);
		lblVelAct1.setBounds(115, 170, 250, 30);				
		panel.add(lblVelAct1);
		
		lblVelMax2 = new JLabel("VelMax: " + c2.getVelMax() + " Km/s", SwingConstants.LEFT);
		lblVelMax2.setFont(lblTextFont);
		lblVelMax2.setForeground(Color.RED);
		lblVelMax2.setBounds(630, 130, 250, 30);				
		panel.add(lblVelMax2);
		
		lblVelAct2 = new JLabel("VelAct: " + c2.getVelAct() + " Km/s", SwingConstants.LEFT);
		lblVelAct2.setFont(lblTextFont);
		lblVelAct2.setForeground(Color.BLUE);
		lblVelAct2.setBounds(630, 170, 250, 30);				
		panel.add(lblVelAct2);
		
	}
	
	private void afegirVisorPropulsors() {		// Afegeix informació sobre els propulsors
		
		// Etiqueta propulsors
		
		lblPropTitol1 = new JLabel("Propulsor", SwingConstants.CENTER);
		lblPropTitol1.setFont(lblTextFont);
		lblPropTitol1.setForeground(Color.DARK_GRAY);
		lblPropTitol1.setBounds(20, 220, 100, 20);				
		panel.add(lblPropTitol1);
		
		lblPropTitol2 = new JLabel("Propulsor", SwingConstants.CENTER);
		lblPropTitol2.setFont(lblTextFont);
		lblPropTitol2.setForeground(Color.DARK_GRAY);
		lblPropTitol2.setBounds(540, 220, 100, 20);				
		panel.add(lblPropTitol2);
		
		// Etiqueta potència actual
		
		lblPotActTitol1 = new JLabel("PotActual", SwingConstants.CENTER);
		lblPotActTitol1.setFont(lblTextFont);
		lblPotActTitol1.setForeground(Color.DARK_GRAY);
		lblPotActTitol1.setBounds(160, 220, 100, 20);				
		panel.add(lblPotActTitol1);
		
		lblPotActTitol2 = new JLabel("PotActual", SwingConstants.CENTER);
		lblPotActTitol2.setFont(lblTextFont);
		lblPotActTitol2.setForeground(Color.DARK_GRAY);
		lblPotActTitol2.setBounds(680, 220, 100, 20);				
		panel.add(lblPotActTitol2);
		
		// Etiqueta potència màxima
		
		lblPotMaxTitol1 = new JLabel("PotMàxima", SwingConstants.CENTER);
		lblPotMaxTitol1.setFont(lblTextFont);
		lblPotMaxTitol1.setForeground(Color.DARK_GRAY);
		lblPotMaxTitol1.setBounds(320, 220, 100, 20);				
		panel.add(lblPotMaxTitol1);

		lblPotMaxTitol2 = new JLabel("PotMàxima", SwingConstants.CENTER);
		lblPotMaxTitol2.setFont(lblTextFont);
		lblPotMaxTitol2.setForeground(Color.DARK_GRAY);
		lblPotMaxTitol2.setBounds(840, 220, 100, 20);				
		panel.add(lblPotMaxTitol2);
		
		// Resultats propulsors
		
		afegirTitolsPropulsor(0, 0, c1);
		afegirTitolsPropulsor(0, 520, c2);
		
		resultatPropulsors1(3);
		resultatPropulsors2(6);
	}
	
	private void afegirTitolsPropulsor(int i, int j, Coet c) {		// La i va augmentant les línies i la j fa que pinti al coet 2
		
		for (Propulsor p : c.getPropulsors()) {
			
			lblProp = new JLabel(p.getIdPropulsor() + "", SwingConstants.CENTER);
			lblProp.setFont(lblTextFont);
			lblProp.setForeground(Color.DARK_GRAY);
			lblProp.setBounds((20 + j), (250 + 25*i), 100, 20);				
			panel.add(lblProp);
			
			lblPotMax = new JLabel(p.getPotenciaMax() + "", SwingConstants.CENTER);
			lblPotMax.setFont(lblTextFont);
			lblPotMax.setForeground(Color.DARK_GRAY);
			lblPotMax.setBounds((320 + j), (250 + 25*i), 100, 20);				
			panel.add(lblPotMax);
			
			i++;
		}		
	}
	
	private void resultatPropulsors1(int num) {		// Va afegint les potències dels propulsors del coet 1
		
		for(int i=0; i<num; i++) {
			JLabel tmp_label = new JLabel(c1.getPropulsors().get(i).getPotenciaAct() + "", SwingConstants.CENTER);
			tmp_label.setFont(lblTextFont);
			tmp_label.setForeground(Color.DARK_GRAY);
			tmp_label.setBounds(160, 250 + 25*i, 100, 20);
			
			lblPotAct1.add(tmp_label);
			
			panel.add(lblPotAct1.get(i));
			
		}
	}
	
	private void resultatPropulsors2(int num) {		// Va afegint les potències dels propulsors del coet 2
		
		for(int i=0; i<num; i++) {

			JLabel tmp_label = new JLabel(c2.getPropulsors().get(i).getPotenciaAct() + "", SwingConstants.CENTER);
			tmp_label.setFont(lblTextFont);
			tmp_label.setForeground(Color.DARK_GRAY);
			tmp_label.setBounds(160 + 520, 250 + 25*i, 100, 20);
			
			lblPotAct2.add(tmp_label);
			
			panel.add(lblPotAct2.get(i));
		}
	}
	
	private void afegirMissatgeCoet1(String msg1) {		// Afegeix missatges informatius del coet1
		
		lblMsgCoet1 = new JLabel(msg1, SwingConstants.CENTER);
		lblMsgCoet1.setFont(lblMsgFont);
		lblMsgCoet1.setForeground(Color.MAGENTA);
		lblMsgCoet1.setBounds(20, 410, 450, 30);				
		panel.add(lblMsgCoet1);
		
	}
	
	private void afegirMissatgeCoet2(String msg2) {		// Afegeix missatges informatius del coet1
		
		lblMsgCoet2 = new JLabel(msg2, SwingConstants.CENTER);
		lblMsgCoet2.setFont(lblMsgFont);
		lblMsgCoet2.setForeground(Color.MAGENTA);
		lblMsgCoet2.setBounds(520, 410, 450, 30);				
		panel.add(lblMsgCoet2);
		
	}
	
	private void afegirMissatgeStartCoet1(String msgStart1) {		// Afegeix missatge sobre acceleració i frenada
		
		lblMsgStart1 = new JLabel(msgStart1, SwingConstants.CENTER);
		lblMsgStart1.setFont(lblMsgFont);
		lblMsgStart1.setForeground(Color.MAGENTA);
		lblMsgStart1.setBounds(310, 170, 130, 30);				
		panel.add(lblMsgStart1);
		
	}
	
	private void afegirMissatgeStartCoet2(String msgStart2) {		// Afegeix missatge sobre acceleració i frenada
		
		lblMsgStart2 = new JLabel(msgStart2, SwingConstants.CENTER);
		lblMsgStart2.setFont(lblMsgFont);
		lblMsgStart2.setForeground(Color.MAGENTA);
		lblMsgStart2.setBounds(820, 170, 130, 30);				
		panel.add(lblMsgStart2);
			
	}

	private void afegirBotons() {		// Afegeix els botons del panell de control
		
		//Coet 1
		btVelObj1 = new JButton("OK");		// Estableix velocitat objectiu
		btVelObj1.setBounds(380, 90, 60, 30);
		btVelObj1.setEnabled(true); 
		panel.add(btVelObj1);
		btVelObj1.addActionListener(this);
		
		btStart1 = new JButton("START");	// Inicia el Thread
		btStart1.setBounds(310, 130, 130, 30);
		btStart1.setEnabled(true); 		
		panel.add(btStart1);
		btStart1.addActionListener(this);
			
		// Coet2
		btVelObj2 = new JButton("OK");		// Estableix velocitat objectiu
		btVelObj2.setBounds(890, 90, 60, 30);
		btVelObj2.setEnabled(true); 
		panel.add(btVelObj2);
		btVelObj2.addActionListener(this);
		
		btStart2 = new JButton("START");	// Inicia el Thread
		btStart2.setBounds(820, 130, 130, 30);
		btStart2.setEnabled(true); 		
		panel.add(btStart2);
		btStart2.addActionListener(this);
			
	}
	
	public int calcularFactorAcceleracio(String velAcc) {
		int valorVelAcc = 1;
		
		switch(velAcc) {
		case "x1":
			valorVelAcc = 1;
			break;
		case "x2":
			valorVelAcc = 2;
			break;
		case "x3":
			valorVelAcc = 3;
			break;
		case "x4":
			valorVelAcc= 4;
			break;
		case "x5":
			valorVelAcc = 5;
			break;
		default:
			valorVelAcc = 1;
		}
		return valorVelAcc;
	}
	
	// Sobreescrivim el mètode actionPerformed per a indicar les accions a fer quan es premen els botons

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String msgButton = "";
				
		if (e.getSource() == btVelObj1) {		// Estableix velocitat objectiu del coet 1
						
			try {
				c1.setVelObj(Integer.parseInt(textVelObj1.getText()));
				msgButton = "VelObj: " + c1.getVelObj() + " Km/s";
				lblVelObj1.setText(msgButton);
				
				if (c1.getVelObj() > c1.getVelMax()) {
					c1.setVelObj(c1.getVelMax());
					msgButton = "VelObj: " + c1.getVelObj() + " Km/s";
					lblVelObj1.setText(msgButton);
					lblMsgCoet1.setText("La velocitat objectiu no pot superar la màxima!!!!");
				}
				
			} catch (NumberFormatException numbFormExc1) {
				c1.setVelObj(0);
				msgButton = "VelObj: " + c1.getVelObj() + " Km/s";
				lblVelObj1.setText(msgButton);
			}			
			
		} else if (e.getSource() == btStart1) {		// Accelera el coet 1
			msgButton = "Coet en funcionament " + c1.getCodi() + " amb acceleració: " + velAcc1.getSelectedItem();
			
			lblMsgCoet1.setText(msgButton);

			// Afegir un Thread que vagi consultant acceleració, velAct i si accelerem o frenem
			StartCoet1 start1 = new StartCoet1();
			Thread t1 = new Thread(start1);
			t1.start();
			
		
		} else if (e.getSource() == btVelObj2) {		// Estableix velocitat objectiu del coet 2
			
			try {
				c2.setVelObj(Integer.parseInt(textVelObj2.getText()));
				msgButton = "VelObj: " + c2.getVelObj() + " Km/s";
				lblVelObj2.setText(msgButton);
				
				if (c2.getVelObj() > c2.getVelMax()) {
					c2.setVelObj(c2.getVelMax());
					msgButton = "VelObj: " + c2.getVelObj() + " Km/s";
					lblVelObj2.setText(msgButton);
					lblMsgCoet2.setText("La velocitat objectiu no pot superar la màxima!!!!");

				}
				
			} catch (NumberFormatException numbFormExc2) {
				c2.setVelObj(0);
				msgButton = "VelObj: " + c2.getVelObj() + " Km/s";
				lblVelObj2.setText(msgButton);
			}			
			
		
		} else if (e.getSource() == btStart2) {			// Accelera el coet 2
			
			msgButton = "Coet en funcionament " + c2.getCodi() + " amb acceleració: " + velAcc2.getSelectedItem();
			
			lblMsgCoet2.setText(msgButton);
			
			// Afegir un Thread que vagi consultant acceleració, velAct i si accelerem o frenem
			StartCoet2 start2 = new StartCoet2();
			Thread t2 = new Thread(start2);
			t2.start();
			
		}

	}
	
	// Definim les classes Runnable per iniciar el Coet 1 i el Coet 2	
	
	public class StartCoet1 implements Runnable {

		private double vel0, velObj, velAct;
		private int potAct1, potAct2, potAct3;
		private int PTAct;
		
		@Override
		public void run() {
			
			// Consulta velocitats i potències
			vel0 = 0;	
			velObj = c1.getVelObj();			
			velAct = c1.getVelAct();
					
			while (!Thread.currentThread().isInterrupted()) {
										
				try {
					
					if (velAct < velObj) {
						lblMsgStart1.setText("ACCELERANT");
						velObj = c1.getVelObj();
						valorVelAcc1 = calcularFactorAcceleracio(velAcc1.getSelectedItem().toString());
						lblVelAct1.setText("VelAct: " + c1.getVelAct() + " Km/s");

						int i = 0;
						for (Propulsor p: c1.getPropulsors()) {
							if (p.getPotenciaAct() < p.getPotenciaMax() && p.getPotenciaAct() >= 0) {
								p.setPotenciaAct(p.getPotenciaAct() + valorVelAcc1);
								if (p.getPotenciaAct() > p.getPotenciaMax()) {
									p.setPotenciaAct(p.getPotenciaMax());
								}
							}
							lblPotAct1.get(i).setText("" + c1.getPropulsors().get(i).getPotenciaAct());
							i++;
						}
						
					} else if (velAct > velObj) {
						lblMsgStart1.setText("FRENANT");
						velObj = c1.getVelObj();
						valorVelAcc1 = calcularFactorAcceleracio(velAcc1.getSelectedItem().toString());
						lblVelAct1.setText("VelAct: " + c1.getVelAct() + " Km/s");
						
						int i = 0;
						for (Propulsor p: c1.getPropulsors()) {
							if (p.getPotenciaAct() <= p.getPotenciaMax()) {
								p.setPotenciaAct(p.getPotenciaAct() - valorVelAcc1);
								if (p.getPotenciaAct() <= 0) {
									p.setPotenciaAct(0);
								}
							}
							lblPotAct1.get(i).setText("" + c1.getPropulsors().get(i).getPotenciaAct());
							i++;
						}
						
					} else if (velAct == velObj) {
						lblVelAct1.setText("VelAct: " + c1.getVelAct() + " Km/s");
						lblMsgStart1.setText("EN ESPERA");
						lblMsgCoet1.setText("VELOCITAT OBJECTIU ASSOLIDA!!");
						Thread.currentThread().interrupt();
					}
					
					// Actualitzo velAct
					potAct1 = c1.getPropulsors().get(0).getPotenciaAct();
					potAct2 = c1.getPropulsors().get(1).getPotenciaAct();
					potAct3 = c1.getPropulsors().get(2).getPotenciaAct();
					
					PTAct = potAct1 + potAct2 + potAct3;
					velAct = vel0 + 100 * (int) Math.sqrt(PTAct);
					c1.setVelAct(velAct);
					lblVelAct1.setText("VelAct: " + velAct + " Km/s");
					lblMsgCoet1.setText("AJUSTANT VELOCITAT...");

					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					lblMsgCoet1.setText("VELOCITAT OBJECTIU ASSOLIDA!!");
					Thread.currentThread().interrupt();
				}
			}
		}
	}
	
	
	public class StartCoet2 implements Runnable {

		private double vel0, velObj, velAct;
		private int potAct1, potAct2, potAct3, potAct4, potAct5, potAct6;
		private int PTAct;
		
		@Override
		public void run() {
			
			// Consulta velocitats i potències
			vel0 = 0;	
			velObj = c2.getVelObj();			
			velAct = c2.getVelAct();
					
			while (!Thread.currentThread().isInterrupted()) {
										
				try {
					
					if (velAct < velObj) {
						lblMsgStart2.setText("ACCELERANT");
						velObj = c2.getVelObj();
						valorVelAcc2 = calcularFactorAcceleracio(velAcc2.getSelectedItem().toString());
						lblVelAct2.setText("VelAct: " + c2.getVelAct() + " Km/s");

						int i = 0;
						for (Propulsor p: c2.getPropulsors()) {
							if (p.getPotenciaAct() < p.getPotenciaMax()) {
								p.setPotenciaAct(p.getPotenciaAct() + valorVelAcc2);
								if (p.getPotenciaAct() > p.getPotenciaMax()) {
									p.setPotenciaAct(p.getPotenciaMax());
								}
							}
							lblPotAct2.get(i).setText("" + c2.getPropulsors().get(i).getPotenciaAct());
							i++;
						}
						
					} else if (velAct > velObj) {
						lblMsgStart2.setText("FRENANT");
						velObj = c2.getVelObj();
						valorVelAcc2 = calcularFactorAcceleracio(velAcc2.getSelectedItem().toString());
						lblVelAct2.setText("VelAct: " + c2.getVelAct() + " Km/s");
						int i = 0;
						for (Propulsor p: c2.getPropulsors()) {
							if (p.getPotenciaAct() <= p.getPotenciaMax()) {
								p.setPotenciaAct(p.getPotenciaAct() - valorVelAcc2);
								if (p.getPotenciaAct() <= 0) {
									p.setPotenciaAct(0);
								}
							}
							lblPotAct2.get(i).setText("" + c2.getPropulsors().get(i).getPotenciaAct());
							i++;
						}
						
					} else if (velAct == velObj) {
						lblVelAct2.setText("VelAct: " + c2.getVelAct() + " Km/s");
						lblMsgStart1.setText("EN ESPERA");
						lblMsgCoet2.setText("VELOCITAT OBJECTIU ASSOLIDA!!");
						Thread.currentThread().interrupt();
					}
					
					// Actualitzo velAct
					potAct1 = c2.getPropulsors().get(0).getPotenciaAct();
					potAct2 = c2.getPropulsors().get(1).getPotenciaAct();
					potAct3 = c2.getPropulsors().get(2).getPotenciaAct();
					potAct4 = c2.getPropulsors().get(3).getPotenciaAct();
					potAct5 = c2.getPropulsors().get(4).getPotenciaAct();
					potAct6 = c2.getPropulsors().get(5).getPotenciaAct();
					
					PTAct = potAct1 + potAct2 + potAct3 + potAct4 + potAct5 + potAct6;
					velAct = vel0 + 100 * (int) Math.sqrt(PTAct);
					c2.setVelAct(velAct);
					lblVelAct2.setText("VelAct: " + velAct + " Km/s");
					lblMsgCoet2.setText("AJUSTANT VELOCITAT...");

					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					lblMsgCoet2.setText("VELOCITAT OBJECTIU ASSOLIDA!!");
					Thread.currentThread().interrupt();
				}
			}
		}
	}

}	
		