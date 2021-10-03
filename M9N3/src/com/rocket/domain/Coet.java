package com.rocket.domain;

import java.util.List;

import com.rocket.application.CodiFormatException;

public class Coet {
	
	protected String codi;					// codi alfanum�ric de 8 car�cters
	protected List<Propulsor> propulsors;	// llista de propulsors
	protected double velAct;				// velocitat actual
	protected double velObj;				// velocitat objectiu
	protected double velMax;				// velocitat m�xima
	protected int PT, PTObj; 				// pot�ncia total (s'obt� sumant les pot�ncies actuals dels propulsors)
	protected final int PTmax; 				// pot�ncia total m�xima (constant que s'obt� sumant les pot�ncies m�ximes dels propulsors)
	
	public Coet(String codi, List<Propulsor> propulsors) throws CodiFormatException {
		if (!codi.toUpperCase().matches("[A-Z0-9]{8}"))
			throw new CodiFormatException("El coet ha de tenir un codi alfanum�ric de 8 car�cters");		// Validem el codi del coet
	
		this.codi = codi;
		this.propulsors = propulsors;	
		
		int ptMaxSuma = 0;
		for (Propulsor p: propulsors) {
			ptMaxSuma += p.getPotenciaMax();
		}
		this.PTmax = ptMaxSuma;
	}
	
	// Getters i Setters

	public String getCodi() {
		return codi;
	}

	public List<Propulsor> getPropulsors() {
		return propulsors;
	}

	public double getVelAct() {
		return velAct;
	}

	public void setVelAct(double velAct2) {
		this.velAct = velAct2;
	}

	public double getVelObj() {
		return velObj;
	}

	public void setVelObj(double velObj) {
		this.velObj = velObj;
	}
	
	public double getVelMax() {
		velMax = velAct + 100 * (int) Math.sqrt(PTmax);
		return velMax;
	}
	
	@Override
	public String toString() {
		String textPotenciesMax = "";
		for (Propulsor p: propulsors) {
			textPotenciesMax += p.getPotenciaMax() + " "; 
		}	
		return "Coet id=" + codi + ": T� " + propulsors.size() + " propulsors i pot�ncies m�ximes [" + textPotenciesMax + "]";
	}

}
