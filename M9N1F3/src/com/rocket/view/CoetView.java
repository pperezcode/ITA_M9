package com.rocket.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.rocket.application.CoetController;
import com.rocket.domain.Coet;
import com.rocket.domain.Propulsor;

public class CoetView {

	public void mostrarCoets(List<Coet> coets) {
		
		CoetController cc = new CoetController();
		
		System.out.println(cc.retornaLlistaCoets(coets));
		
	}
	
	public void mostrarPropulsorIDCoet(Propulsor p, int id) {		// Mostra el propulsor amb l'id indicat
		
		System.out.println(p.toString());			// Possem (id-1) perquè a la llista compta desde 0
		
	}
	
	public void mostrarMissatge(String msg) {

		System.out.println(msg);

	}

	public int demanarPotenciaObj() {

		int potObj = Integer.parseInt(JOptionPane.showInputDialog("Introdueix potència objectiu"));
		
		return potObj;
	}
	
}
