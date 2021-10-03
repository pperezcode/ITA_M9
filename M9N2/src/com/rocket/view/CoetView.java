package com.rocket.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.rocket.application.CoetController;
import com.rocket.domain.Coet;

public class CoetView {

	public void mostrarCoets(List<Coet> coets) {
		CoetController cc = new CoetController();
		System.out.println(cc.retornaLlistaCoets(coets));	
	}
	
	public void mostrarMissatge(String msg) {
		System.out.println(msg);
	}

	public int demanarCoetObj() {
		int coetObj = Integer.parseInt(JOptionPane.showInputDialog("Quin coet vols accelerar? \n1: 32WESSDS\n2: LDSFJA32"));		
		return coetObj;
	}
	
	public int demanarVelocitatObj(int velMax) {
		int velObj = Integer.parseInt(JOptionPane.showInputDialog("La velocitat inicial del coet és de 100 km/s.\nVelMax = " + velMax + "\nA quina velocitat vols arribar?"));
		return velObj;
	}
		
}
