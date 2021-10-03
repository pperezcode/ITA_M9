package com.rocket.domain;

import com.rocket.application.CodiFormatException;
import com.rocket.view.CoetView;

public class Coet {
	
	protected String codi;		// codi alfanumèric de 8 caràcters
	protected int numPropulsors;		// número de propulsors del coet
	protected int[] potenciesMax;
	
	public Coet(String codi, int numPropulsors, int[] potenciesMax ) throws CodiFormatException {
		
		if (!codi.toUpperCase().matches("[A-Z0-9]{8}"))
			throw new CodiFormatException("El coet ha de tenir un codi alfanumèric de 8 caràcters");		// Validem el codi del coet
	
		this.codi = codi;
		this.numPropulsors = numPropulsors;
		this.potenciesMax = potenciesMax;
		
	}

	@Override
	public String toString() {
		
		CoetView cv = new CoetView();

		String textPotenciesMax = cv.mostrarPotenciesMax(potenciesMax);
		
		return "Coet id=" + codi + ": Té " + numPropulsors + " propulsors i potències màximes [" + textPotenciesMax + "]";
	}
		
}