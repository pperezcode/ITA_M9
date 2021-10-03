package com.rocket.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.rocket.application.CoetController;
import com.rocket.domain.Coet;

public class CoetView {

	public void mostrarCoets(List<Coet> llistaCoets) {
		
		CoetController cc = new CoetController();
		
		String textCoets = 	cc.retornaLlistaCoets(llistaCoets);	
		
		JOptionPane.showMessageDialog(null, textCoets);
		
	}

}
