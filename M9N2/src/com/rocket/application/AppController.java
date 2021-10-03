package com.rocket.application;

import java.util.ArrayList;
import java.util.List;

import com.rocket.domain.Coet;
import com.rocket.domain.Propulsor;
import com.rocket.view.CoetView;

public class AppController {
	
	public void iniciaApp() {
		
		CoetController cc = new CoetController();
		
		List<Coet> coets = new ArrayList<Coet>();		// Llista on s'afegiran els coets
		
		List<Propulsor> propulsors1 = new ArrayList<Propulsor>();		// Llista on s'afegiran els propulsors del 1er coet
		List<Propulsor> propulsors2 = new ArrayList<Propulsor>();		// Llista on s'afegiran els propulsors del 2n coet
				
		// Creem el primer coet: “32WESSDS”, amb 3 propulsors de potències màximes {10, 30, 80}
		
		Coet c1 = cc.creaCoet3Propulsors("32WESSDS", propulsors1, 10, 30, 80);
		
		// Creem el segon coet: “LDSFJA32”, amb 6 propulsors de potències màximes {30, 40, 50, 50, 30, 10}

		Coet c2 = cc.creaCoet6Propulsors("LDSFJA32", propulsors2, 30, 40, 50, 50, 30, 10);
				
		// Afegim els coets a la llista de coets
		
		coets.add(c1);
		coets.add(c2);
		
		// Mostrar coets per consola
		
		CoetView cv = new CoetView();
		
		cv.mostrarCoets(coets);
		cv.mostrarMissatge("Coets en funcionament...");

		// Demanar coet a accelerar
		
		int coetObj = cv.demanarCoetObj();
		
		do {
			if (coetObj == 1) {
				cc.accelerarCoetObj(c1);
			} else if (coetObj == 2) {
				cc.accelerarCoetObj(c2);
			}
		} while (coetObj != 1 && coetObj != 2);
		
	}

}
