package fr.pizzeria.service;

import java.util.Scanner;



import fr.pizzeria.exception.UpdatePizzaException;


import fr.pizzeria.Dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {
	
	private PizzaMemDao dao;
	public ModifierPizzaService(PizzaMemDao dao) {
		this.dao = dao;
	}

	@Override
	public void executeUC(Scanner scanner) throws UpdatePizzaException{
		System.out.println("Mise à jour d'une pizza");
		System.out.print("Quelle pizza souhaitez-vous modifier ? (code à trois lettres)\n>>>");
		String codePizzaAModifier = scanner.nextLine().toUpperCase();
		while(codePizzaAModifier.length() != 3){
			throw new UpdatePizzaException("ATTENTION : Vous devez saisir un code à trois lettres valide !");

		}
		
		System.out.print("Entrez le nouveau code à trois lettres S.V.P\n>>>");
		String newCode = scanner.nextLine().toUpperCase();
		if(newCode.length() != 3){
			throw new UpdatePizzaException("ATTENTION : Vous devez saisir un code à trois lettres valide !");
		}
		System.out.print("Quel sera son nouveau libellé ? (nom de pizza sans espace)\n>>>");
		String newLibelle = scanner.nextLine();
		if(!(newLibelle instanceof String)){
			throw new UpdatePizzaException("ATTENTION : Entrer un libellé sans espace valide !");

		}
		System.out.print("Et son nouveau prix ?\n>>>");
		Double newPrix=0.0;
		String newPrixStr = scanner.nextLine();
				
		if (newPrixStr.matches("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?")){
			newPrix=Double.parseDouble(newPrixStr);
		}
		
		else if (newPrix<=0){
			throw new UpdatePizzaException("ATTENTION : Vous devez entrer un prix supérieur à 0 !");	
		}
		
		else {
			throw new UpdatePizzaException("ATTENTION : Vous devez entrer un prix valide !");
		}
		
		Pizza pizza = new Pizza(newCode, newLibelle, newPrix);		
		dao.updatePizza(codePizzaAModifier, pizza);
		
	}

}
