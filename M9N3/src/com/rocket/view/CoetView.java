package com.rocket.view;

import java.util.List;

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

}
