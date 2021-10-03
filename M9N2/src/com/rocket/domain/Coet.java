package com.rocket.domain;

import java.util.List;

import com.rocket.application.CodiFormatException;
import com.rocket.view.CoetView;

public class Coet implements Runnable {
	
	protected String codi;		// codi alfanumèric de 8 caràcters
	protected List<Propulsor> propulsors;
	protected double vel0;		// velocitat inicial
	protected double velObj;		// velocitat objectiu
	protected int PT; 			// potència total (s'obté sumant les potències actuals dels propulsors)
	protected final int PTmax; 	// potència total màxima (constant que s'obté sumant les potències màximes dels propulsors)
	
	public Coet(String codi, List<Propulsor> propulsors) throws CodiFormatException {
		if (!codi.toUpperCase().matches("[A-Z0-9]{8}"))
			throw new CodiFormatException("El coet ha de tenir un codi alfanumèric de 8 caràcters");		// Validem el codi del coet
	
		this.codi = codi;
		this.propulsors = propulsors;	
		
		int ptMaxSuma = 0;
		for (Propulsor p: propulsors) {
			ptMaxSuma += p.getPotenciaMax();
		}
		this.PTmax = ptMaxSuma;	
	}
		
	public String getCodi() {
		return codi;
	}

	public List<Propulsor> getPropulsors() {
		return propulsors;
	}

	@Override
	public String toString() {
		String textPotenciesMax = "";
		for (Propulsor p: propulsors) {
			textPotenciesMax += p.getPotenciaMax() + " "; 
		}	
		return "Coet id=" + codi + ": Té " + propulsors.size() + " propulsors i potències màximes [" + textPotenciesMax + "]";
	}

	@Override
	public void run() {
		
		int vel0, velObj, velMax;
		int numPropulsors;
		int potAct1, potAct2, potAct3, potAct4, potAct5, potAct6;
		int potMax1, potMax2, potMax3, potMax4, potMax5, potMax6;
		int PTAct, PTObj, PTMax;
		
		CoetView cv = new CoetView();

		vel0 = 100;		// Suposem una velocitat inicial per defecte de 100 
		
		// Calculem velMàxima tenint en compte vel0 del coet i PTMax

		velMax = vel0 + 100 * (int) Math.sqrt(PTmax);
		velObj = cv.demanarVelocitatObj(velMax);
		numPropulsors = propulsors.size();
		
		switch (numPropulsors) {
		case 3:
			// Coet “32WESSDS”, amb 3 propulsors de potències màximes {10, 30, 80}
			
			potAct1 = propulsors.get(0).getPotenciaAct();
			potAct2 = propulsors.get(1).getPotenciaAct();
			potAct3 = propulsors.get(2).getPotenciaAct();
			
			potMax1 = propulsors.get(0).getPotenciaMax();
			potMax2 = propulsors.get(1).getPotenciaMax();
			potMax3 = propulsors.get(2).getPotenciaMax();
			
			PTAct = potAct1 + potAct2 + potAct3;
			PTMax = potMax1 + potMax2 + potMax3;
			
			// Calculem la potència total necessària per assolir la velocitat objectiu a partir de la velocitat inicial
			
			PTObj = (int) Math.pow(((velObj - vel0) / 100), 2); 

			// Validem si a partir de la velocitat inicial podem assolir la velocitat objectiu, tenint en compte la potència màxima dels propulsors del coet
			
			if (PTObj > PTMax) {
				cv.mostrarMissatge("No podem assolir la velocitat objectiu a partir d'aquesta velocitat inicial i la potència màxima dels propulsors! [vel0 = " 
						+ vel0 + ", PTmax = " + PTmax + "]");
				return;
			} else {	
				cv.mostrarMissatge("Activant propulsors per assolir la velocitat objectiu...");
			}

			// Anirem augmentant la potència dels propulsors d'un en un fins assolir la potència total objectiu
			
			cv.mostrarMissatge("PTObj = " + PTObj);

			while (PTAct < PTObj) {	
				try {				
					// ***** Propulsor 1 *****
					
					if (potAct1 < potMax1) {
						potAct1++;
					}
					
					// Validem si s'ha assolit la PTObj
					
					PTAct = potAct1 + potAct2 + potAct3;
					
					if (PTAct == PTObj) {
						cv.mostrarMissatge("PTObj assolida! PTAct = " + PTAct + ", PTObj = " + PTObj);
						return;
					} 
																		
					// ***** Propulsor 2 *****
										
					if (potAct2 < potMax2) {
						potAct2++;
					}
					
					// Validem si s'ha assolit la PTObj
					
					PTAct = potAct1 + potAct2 + potAct3;
					
					if (PTAct == PTObj) {
						cv.mostrarMissatge("PTObj assolida! PTAct = " + PTAct + ", PTObj = " + PTObj);
						return;
					} 									
										
					// ***** Propulsor 3 *****
					
					if (potAct3 < potMax3) {
						potAct3++;
					}
					
					// Validem si s'ha assolit la PTObj
					
					PTAct = potAct1 + potAct2 + potAct3;
					
					if (PTAct == PTObj) {
						cv.mostrarMissatge("PTObj assolida! PTAct = " + PTAct + ", PTObj = " + PTObj);
						return;
					} 										
					
					// ***** Fi de propulsors *****

					cv.mostrarMissatge("    potAct1 = " + potAct1 + ", potMax1 = " + potMax1);
					cv.mostrarMissatge("    potAct2 = " + potAct2 + ", potMax2 = " + potMax2);
					cv.mostrarMissatge("    potAct3 = " + potAct3 + ", potMax3 = " + potMax3);
					cv.mostrarMissatge("    PTAct = " + PTAct + ", PTObj = " + PTObj + ", PTMax = " + PTMax);
					
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					cv.mostrarMissatge(e.getMessage());
				}
			}		
			
		case 6:
			// Coet “LDSFJA32”, amb 6 propulsors de potències màximes {30, 40, 50, 50, 30, 10}
			
			potAct1 = propulsors.get(0).getPotenciaAct();
			potAct2 = propulsors.get(1).getPotenciaAct();
			potAct3 = propulsors.get(2).getPotenciaAct();
			potAct4 = propulsors.get(3).getPotenciaAct();
			potAct5 = propulsors.get(4).getPotenciaAct();
			potAct6 = propulsors.get(5).getPotenciaAct();
			
			potMax1 = propulsors.get(0).getPotenciaMax();
			potMax2 = propulsors.get(1).getPotenciaMax();
			potMax3 = propulsors.get(2).getPotenciaMax();
			potMax4 = propulsors.get(3).getPotenciaMax();
			potMax5 = propulsors.get(4).getPotenciaMax();
			potMax6 = propulsors.get(5).getPotenciaMax();
			
			PTAct = potAct1 + potAct2 + potAct3 + potAct4 + potAct5 + potAct6;
			PTMax = potMax1 + potMax2 + potMax3 + potMax4 + potMax5 + potMax6;
			
			// Calculem la potència total necessària per assolir la velocitat objectiu a partir de la velocitat inicial
			
			PTObj = (int) Math.pow(((velObj - vel0) / 100), 2); 

			// Validem si a partir de la velocitat inicial podem assolir la velocitat objectiu, tenint en compte la potència màxima dels propulsors del coet
			
			if (PTObj > PTMax) {
				cv.mostrarMissatge("No podem assolir la velocitat objectiu a partir d'aquesta velocitat inicial i la potència màxima dels propulsors! [vel0 = " 
						+ vel0 + ", PTmax = " + PTmax + "]");
				return;				
			} else {
				cv.mostrarMissatge("Activant propulsors per assolir la velocitat objectiu...");
			}

			// Anirem augmentant la potència dels propulsors d'un en un fins assolir la potència total objectiu
			
			cv.mostrarMissatge("PTObj = " + PTObj);

			while (PTAct < PTObj) {
				try {					
					// ***** Propulsor 1 *****
					
					if (potAct1 < potMax1) {
						potAct1++;
					}
					
					// Validem si s'ha assolit la PTObj
					
					PTAct = potAct1 + potAct2 + potAct3 + potAct4 + potAct5 + potAct6;
					
					if (PTAct == PTObj) {
						cv.mostrarMissatge("PTObj assolida! PTAct = " + PTAct + ", PTObj = " + PTObj);
						return;
					} 								
					
					// ***** Propulsor 2 *****
										
					if (potAct2 < potMax2) {
						potAct2++;
					}
					
					// Validem si s'ha assolit la PTObj
					
					PTAct = potAct1 + potAct2 + potAct3 + potAct4 + potAct5 + potAct6;
					
					if (PTAct == PTObj) {
						cv.mostrarMissatge("PTObj assolida! PTAct = " + PTAct + ", PTObj = " + PTObj);
						return;
					} 
													
					// ***** Propulsor 3 *****
					
					if (potAct3 < potMax3) {
						potAct3++;
					}
					
					// Validem si s'ha assolit la PTObj
					
					PTAct = potAct1 + potAct2 + potAct3 + potAct4 + potAct5 + potAct6;
					
					if (PTAct == PTObj) {
						cv.mostrarMissatge("PTObj assolida! PTAct = " + PTAct + ", PTObj = " + PTObj);
						return;
					} 								
					
					// ***** Propulsor 4 *****
					
					if (potAct4 < potMax4) {
						potAct4++;
					}
					
					// Validem si s'ha assolit la PTObj
					
					PTAct = potAct1 + potAct2 + potAct3 + potAct4 + potAct5 + potAct6;
					
					if (PTAct == PTObj) {
						cv.mostrarMissatge("PTObj assolida! PTAct = " + PTAct + ", PTObj = " + PTObj);
						return;
					}								
					
					// ***** Propulsor 5 *****
					
					if (potAct5 < potMax5) {
						potAct5++;
					}
					
					// Validem si s'ha assolit la PTObj
					
					PTAct = potAct1 + potAct2 + potAct3 + potAct4 + potAct5 + potAct6;
					
					if (PTAct == PTObj) {
						cv.mostrarMissatge("PTObj assolida! PTAct = " + PTAct + ", PTObj = " + PTObj);
						return;
					}							

					// ***** Propulsor 6 *****
					
					if (potAct6 < potMax6) {
						potAct6++;
					}
					
					// Validem si s'ha assolit la PTObj
					
					PTAct = potAct1 + potAct2 + potAct3 + potAct4 + potAct5 + potAct6;
					
					if (PTAct == PTObj) {
						cv.mostrarMissatge("PTObj assolida! PTAct = " + PTAct + ", PTObj = " + PTObj);
						return;
					} 
																		
					// ***** Fi de propulsors *****
					
					cv.mostrarMissatge("    potAct1 = " + potAct1 + ", potMax1 = " + potMax1);
					cv.mostrarMissatge("    potAct2 = " + potAct2 + ", potMax2 = " + potMax2);
					cv.mostrarMissatge("    potAct3 = " + potAct3 + ", potMax3 = " + potMax3);
					cv.mostrarMissatge("    potAct4 = " + potAct4 + ", potMax4 = " + potMax4);
					cv.mostrarMissatge("    potAct5 = " + potAct5 + ", potMax5 = " + potMax5);
					cv.mostrarMissatge("    potAct6 = " + potAct6 + ", potMax6 = " + potMax6);
					cv.mostrarMissatge("    PTAct = " + PTAct + ", PTObj = " + PTObj + ", PTMax = " + PTMax);
					
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					cv.mostrarMissatge(e.getMessage());
				}		
			}		
		}	
	}	
	
}
