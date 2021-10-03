package com.rocket.domain;

import com.rocket.application.CodiFormatException;

public class Coet {
	
	protected String codi;		// codi alfanum�ric de 8 car�cters
	protected int numPropulsors;		// n�mero de propulsors del coet
	
	public Coet(String codi, int numPropulsors) throws CodiFormatException {
		
		if (!codi.toUpperCase().matches("[A-Z0-9]{8}"))
			throw new CodiFormatException("El coet ha de tenir un codi alfanum�ric de 8 car�cters");		// Validem el codi del coet
	
		this.codi = codi;
		this.numPropulsors = numPropulsors;
				
	}

	@Override
	public String toString() {
		return "Coet id=" + codi + ": T� " + numPropulsors + " propulsors";
	}
		
}