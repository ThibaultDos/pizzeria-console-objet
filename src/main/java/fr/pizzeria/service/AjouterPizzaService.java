package fr.pizzeria.service;

import java.util.Scanner;
import fr.pizzeria.Dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {
	
	private IPizzaDao dao;
	
	public AjouterPizzaService(IPizzaDao dao) {
		this.dao = dao;
	}

	@Override
	public void executeUC(Scanner scanner) throws SavePizzaException {
		System.out.println("Ajout d'une nouvelle pizza");
		System.out.print("Quel est le code de la nouvelle pizza ?\n>>>");
		String code = scanner.nextLine().toUpperCase();
		if(code.length() !=3){
			throw new SavePizzaException("ATTENTION : Vous devez saisir un code à trois lettres valide !");
		}
		System.out.print("Et son libellé ?\n>>>");
		String libelle = scanner.nextLine().trim();
		if(!(libelle instanceof String)){
			throw new SavePizzaException("ATTENTION : Entrer un libellé valide !");

		}
		System.out.print("Combien coûte cette pizza ?\n>>>");
		String prixStr = scanner.nextLine();
		Double prix= 0.0;
		
		
		if (prixStr.matches("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?")){
			prix=Double.parseDouble(prixStr);
			if (prix<=0){
				throw new SavePizzaException("ATTENTION : Vous devez entrer un prix supérieur à 0 !");	
			}
		}
		
	
		else {
			throw new SavePizzaException("ATTENTION : Vous devez entrer un prix valide !");
		}
		
		
		Pizza pizza = new Pizza(code, libelle, prix);		
		dao.saveNewPizza(pizza);	
	}
}
