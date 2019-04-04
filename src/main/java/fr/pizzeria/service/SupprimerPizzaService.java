package fr.pizzeria.service;

import java.util.Scanner;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.Dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService extends MenuService {
	private IPizzaDao dao;
	
	public SupprimerPizzaService(IPizzaDao dao) {
		this.dao = dao;
	}

	@Override
	public void executeUC(Scanner scanner) throws DeletePizzaException{
		
		System.out.println("Suppression d'une pizza");
		System.out.print("Quelle pizza souhaitez-vous supprimer ? (code à trois lettres)\n>>>");
		String code = scanner.nextLine();		
		if(code.length() != 3){
			throw new DeletePizzaException("ATTENTION : Vous devez saisir un code à trois lettres valide !");
		}
			
		Pizza[] carte = dao.findAllPizzas();			
		for(int i = 0; i<carte.length;i++){
			if (carte[i] != null && carte[i].getCode().equals(code)){			
				
				System.out.println("Adieu, pizza "+carte[i].getLibelle());
				dao.deletePizza(code);
			}
		}
	}
}