package com.rocket.domain;

import com.rocket.application.ExcedintPotenciaMaxException;

public class Propulsor {
	
	protected String codiCoet;
	
	protected int idPropulsor;
	protected int potenciaAct;
	protected int potenciaObj;
	protected int potenciaMax;
	
	public Propulsor(String codiCoet, int idPropulsor, int potMaxima) throws ExcedintPotenciaMaxException{
		
		// Validem que no es sobrepassi la pot�ncia m�xima
		
		if (potenciaAct > potMaxima) 
			throw new ExcedintPotenciaMaxException("La pot�ncia actual no pot sobrepassar la pot�ncia m�xima: " + potenciaMax);
		
		if (potenciaObj > potenciaMax)
			throw new ExcedintPotenciaMaxException("La pot�ncia objectiu �s superior a la pot�ncia m�xima!");
		
		this.codiCoet = codiCoet;
		this.idPropulsor = idPropulsor;
		this.potenciaMax = potMaxima;
		
		potenciaAct = 0;		// Inicialitzem la pot�ncia actual a 0
	}

	// Getters i Setters
	
	public String getCodiCoet() {
		return codiCoet;
	}
	
	public int getIdPropulsor() {
		return idPropulsor;
	}

	public int getPotenciaAct() {
		return potenciaAct;
	}

	public void setPotenciaAct(int potenciaAct) {
		this.potenciaAct = potenciaAct;
	}

	public int getPotenciaObj() {
		return potenciaObj;
	}

	public void setPotenciaObj(int potenciaObj) {
		this.potenciaObj = potenciaObj;
	}

	public int getPotenciaMax() {
		return potenciaMax;
	}

	public void setPotenciaMax(int potenciaMax) {
		this.potenciaMax = potenciaMax;
	}

	@Override
	public String toString() {
		return codiCoet + "-" + idPropulsor + ", potenciaAct=" + potenciaAct + ", potenciaObj=" + potenciaObj
				+ ", potenciaMax=" + potenciaMax;
	}
	
}
