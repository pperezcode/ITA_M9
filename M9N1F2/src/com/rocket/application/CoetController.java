package com.rocket.application;

import java.util.List;

import com.rocket.domain.Coet;

public class CoetController {
	
	public Coet creaCoet(String codi, int numPropulsors, int[] potenciesMax) {
		
		Coet c = null;
		try {
			c = new Coet(codi, numPropulsors, potenciesMax);

		} catch (CodiFormatException e) {

			System.out.println(e.getMessage());
		}
		
		return c;
		
	}
	
	public String retornaLlistaCoets(List<Coet> llistaCoets) {
		
		String textCoets = "";
		
		for (Coet c: llistaCoets) {

			textCoets += c.toString() + "\n";

		}
			
		return textCoets;
	}

}
