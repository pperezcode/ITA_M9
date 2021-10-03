package com.rocket.application;

import java.util.ArrayList;
import java.util.List;

import com.rocket.domain.Coet;
import com.rocket.view.CoetView;

public class AppController {
	
	public void iniciaApp() {
		
		// Crear dos coets amb els codis �32WESSDS�, amb 3 propulsors, i �LDSFJA32�, amb 6 propulsors. Afegim les pot�ncies m�ximes.
		
		List<Coet> llistaCoets = new ArrayList<Coet>();		// llista on s'afegiran els coets

		CoetController cc = new CoetController();
		
		int[] potenciesMax1 = {10, 30, 80};
		int[] potenciesMax2 = {30, 40, 50, 50, 30, 10};
		
		Coet c1 = cc.creaCoet("32WESSDS", 3, potenciesMax1);
		Coet c2 = cc.creaCoet("LDSFJA32", 6, potenciesMax2);
		
		llistaCoets.add(c1);
		llistaCoets.add(c2);

		//Mostrar per pantalla el codi dels coets, el n�mero de propulsors que t� i les seves pot�ncies m�ximes.
		
		CoetView cv = new CoetView();
		
		cv.mostrarCoets(llistaCoets);
						
	}

}
