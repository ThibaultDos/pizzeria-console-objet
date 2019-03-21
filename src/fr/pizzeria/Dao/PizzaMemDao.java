package fr.pizzeria.Dao;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {
	
	private Pizza [] carte = new Pizza[8] ;
	
	
	public PizzaMemDao(){
		carte[0] = new Pizza ("PEP", "Pepperoni", 12.50);
		carte[1] = new Pizza ("MAR", "Margherita", 14.00);
		carte[2] = new Pizza ("REI", "Reine", 11.50);
		carte[3] = new Pizza ("FRO", "4 fromages", 12.00);
		carte[4] = new Pizza ("CAN", "Cannibale", 12.50);
		carte[5] = new Pizza ("SAV", "Savoyarde", 13.00);
		carte[6] = new Pizza ("ORI", "Orientale", 13.50);
		carte[7] = new Pizza ("IND", "Indienne", 14.00);
	}

	@Override
	public Pizza[] findAllPizzas() {
		return carte;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		
		Pizza[] newCarte = new Pizza[carte.length+1] ;
		for (int i=0;i<carte.length;i++){
			newCarte[i]=carte[i];
		}		
		newCarte[newCarte.length-1] = pizza;
		carte = newCarte;
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		for (int i=0;i< carte.length;i++){
			if (carte[i].getCode().equals(codePizza)){
				carte[i]=pizza;
			}
		}
	}

	
	@Override
	public void deletePizza(String codePizza) {
		
		for (int j=0;j< carte.length;j++){			
			if (carte[j].getCode().equals(codePizza)){				
				carte[j]=null;
			}				
		}

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {		
	
		for (int j=0;j< carte.length;j++){			
			if (carte[j].getCode().equals(codePizza)){
				return carte[j];
			}
		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		for (int j=0;j< carte.length;j++){			
			if (carte[j].getCode().equals(codePizza)){
				return true;
			}
		}
		return false;
	}

}
