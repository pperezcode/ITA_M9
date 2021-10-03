package com.rocket.domain;

import java.util.List;

import com.rocket.application.CodiFormatException;

public class Coet {
	
	protected String codi;		// codi alfanum�ric de 8 car�cters
	protected List<Propulsor> propulsors;
	
	public Coet(String codi, List<Propulsor> propulsors) throws CodiFormatException {
		if (!codi.toUpperCase().matches("[A-Z0-9]{8}"))
			throw new CodiFormatException("El coet ha de tenir un codi alfanum�ric de 8 car�cters");		// Validem el codi del coet
	
		this.codi = codi;
		this.propulsors = propulsors;	
	
	}
	
	// Getters i Setters
	
	public String getCodi() {
		return codi;
	}
	
	public void setCodi(String codi) {
		this.codi = codi;
	}

	public List<Propulsor> getPropulsors() {
		return propulsors;
	}

	public void setPropulsors(List<Propulsor> propulsors) {
		this.propulsors = propulsors;
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
