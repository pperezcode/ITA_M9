package com.rocket.domain;

import java.util.List;

import com.rocket.application.CodiFormatException;

public class Coet {
	
	protected String codi;					// codi alfanumèric de 8 caràcters
	protected List<Propulsor> propulsors;	// llista de propulsors
	protected double velAct;				// velocitat actual
	protected double velObj;				// velocitat objectiu
	protected double velMax;				// velocitat màxima
	protected int PT, PTObj; 				// potència total (s'obté sumant les potències actuals dels propulsors)
	protected final int PTmax; 				// potència total màxima (constant que s'obté sumant les potències màximes dels propulsors)
	
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
		return "Coet id=" + codi + ": Té " + propulsors.size() + " propulsors i potències màximes [" + textPotenciesMax + "]";
	}

}
