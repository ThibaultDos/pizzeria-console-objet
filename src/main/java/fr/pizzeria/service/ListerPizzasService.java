package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.Dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {
	
	private IPizzaDao dao;
	
	public ListerPizzasService(IPizzaDao dao) {
		this.dao = dao;
	}

	@Override
	public void executeUC(Scanner scanner) {
		System.out.println("***********************************");
		System.out.println("**      Liste des pizze :        **");
		System.out.println("***********************************");
			
		Pizza[] carte = dao.findAllPizzas();
			
		StringBuilder affichage = new StringBuilder();
		for(Pizza pizza : carte){
			if (pizza != null){
				affichage.append(pizza.getCode()).append(" -> ").append(pizza.getLibelle()).append(" (").append(pizza.getPrix()).append("€)\n");
			}
		}
		System.out.println(affichage);

		
	}
		

		
}
