package com.rocket.application;

import java.util.List;

import javax.swing.JFrame;

import com.rocket.domain.Coet;
import com.rocket.domain.Propulsor;
import com.rocket.view.CoetView;
import com.rocket.view.ControlPanelView;

public class CoetController {
	
	CoetView cv = new CoetView();		// Creem un CoetView per mostrar missatges

	public Coet creaCoet3Propulsors(String codi, List<Propulsor> propulsors, int potMax1, int potMax2, int potMax3) {
				
		try {			
			propulsors.add(new Propulsor(codi, 1, potMax1));
			propulsors.add(new Propulsor(codi, 2, potMax2));
			propulsors.add(new Propulsor(codi, 3, potMax3));
		} catch (ExcedintPotenciaMaxException e1) {
			cv.mostrarMissatge(e1.getMessage());
		}
		
		Coet c = null;
		
		try {
			c = new Coet(codi, propulsors);
		} catch (CodiFormatException e2) {
			cv.mostrarMissatge(e2.getMessage());
		}
		
		return c;
	}
	
	public Coet creaCoet6Propulsors(String codi, List<Propulsor> propulsors, int potMax1, int potMax2, int potMax3, int potMax4, int potMax5, int potMax6) {
		
		try {
			propulsors.add(new Propulsor(codi, 1, potMax1));
			propulsors.add(new Propulsor(codi, 2, potMax2));
			propulsors.add(new Propulsor(codi, 3, potMax3));
			propulsors.add(new Propulsor(codi, 4, potMax4));
			propulsors.add(new Propulsor(codi, 5, potMax5));
			propulsors.add(new Propulsor(codi, 6, potMax6));				
		} catch (ExcedintPotenciaMaxException e1) {
			cv.mostrarMissatge(e1.getMessage());
		}
		
		Coet c = null;
		
		try {
			c = new Coet(codi, propulsors);
		} catch (CodiFormatException e2) {
			cv.mostrarMissatge(e2.getMessage());
		}
		
		return c;
	}

	public String retornaLlistaCoets(List<Coet> coets) {
		
		StringBuilder str = new StringBuilder();
		
		for (Coet c: coets) {
			str.append(c.toString() + "\n");
		}
		
		return str.toString();
	}
	
	public void controlPanelCoets(List<Coet> coets) {		// Fa visible el panell de control de coets
		JFrame cpv = new ControlPanelView(coets);
		cpv.setVisible(true);
	}

}
