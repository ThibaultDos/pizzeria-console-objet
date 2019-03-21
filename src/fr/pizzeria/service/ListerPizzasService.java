package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.Dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {
	
	private PizzaMemDao dao;
	
	public ListerPizzasService(PizzaMemDao dao) {
		this.dao = dao;
	}

	@Override
	public void executeUC(Scanner scanner) {
		System.out.println("***********************************");
		System.out.println("**      Liste des pizze :        **");
		System.out.println("***********************************");
			
		Pizza[] carte = dao.findAllPizzas();
			
		for(int i = 0; i<carte.length;i++){
			if (carte[i] != null){
				System.out.println(carte[i].getCode()+" -> "+carte[i].getLibelle()+" ("+carte[i].getPrix()+"€)");
			}
		}
		
	}
		

		
}
