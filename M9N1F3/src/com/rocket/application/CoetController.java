package com.rocket.application;

import java.util.List;

import com.rocket.domain.Coet;
import com.rocket.domain.Propulsor;
import com.rocket.view.CoetView;

public class CoetController {
	
	CoetView cv = new CoetView();		// Creem un CoetView per mostrar missatges

	public Coet creaCoet3Propulsors(String codi, List<Propulsor> propulsors, int potMax1, int potMax2, int potMax3) {
		
		Propulsor p1, p2, p3;
		try {
			
			p1 = new Propulsor(codi, 1, potMax1);
			p2 = new Propulsor(codi, 2, potMax2);
			p3 = new Propulsor(codi, 3, potMax3);
			
			propulsors.add(p1);
			propulsors.add(p2);
			propulsors.add(p3);
			
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
		
		Propulsor p1, p2, p3, p4, p5, p6;
		try {
		
			p1 = new Propulsor(codi, 1, potMax1);
			p2 = new Propulsor(codi, 2, potMax2);
			p3 = new Propulsor(codi, 3, potMax3);
			p4 = new Propulsor(codi, 4, potMax4);
			p5 = new Propulsor(codi, 5, potMax5);
			p6 = new Propulsor(codi, 6, potMax6);

			propulsors.add(p1);
			propulsors.add(p2);
			propulsors.add(p3);
			propulsors.add(p4);
			propulsors.add(p5);
			propulsors.add(p6);
						
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
		
		String textCoets = "";
		
		for (Coet c: coets) {

			textCoets += c.toString() + "\n";

		}
			
		return textCoets;
	}
	
	public void iniciarThreads3propulsors(List<Propulsor> propulsors) {
		
		Thread t1_1 = new Thread(propulsors.get(0));
		Thread t1_2 = new Thread(propulsors.get(1));
		Thread t1_3 = new Thread(propulsors.get(2));
		
		t1_1.start();
		t1_2.start();
		t1_3.start();		
		
	}
	
	public void iniciarThreads6propulsors(List<Propulsor> propulsors) {
		
		Thread t2_1 = new Thread(propulsors.get(0));
		Thread t2_2 = new Thread(propulsors.get(1));
		Thread t2_3 = new Thread(propulsors.get(2));
		Thread t2_4 = new Thread(propulsors.get(3));
		Thread t2_5 = new Thread(propulsors.get(4));
		Thread t2_6 = new Thread(propulsors.get(5));
		
		t2_1.start();
		t2_2.start();
		t2_3.start();		
		t2_4.start();
		t2_5.start();
		t2_6.start();		
	}

}
