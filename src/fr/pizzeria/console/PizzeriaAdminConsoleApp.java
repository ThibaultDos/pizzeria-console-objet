package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.Dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.AjouterPizzaService;
import fr.pizzeria.service.ListerPizzasService;
import fr.pizzeria.service.ModifierPizzaService;
import fr.pizzeria.service.SupprimerPizzaService;

public class PizzeriaAdminConsoleApp{
	/**
	 * @param args
	 */
	public static void main(String[] args){		
		
		PizzaMemDao dao = new PizzaMemDao();
		ListerPizzasService listePizzeService=new ListerPizzasService(dao);
		AjouterPizzaService ajoutePizzaService=new AjouterPizzaService(dao);
		ModifierPizzaService modifiePizzaService=new ModifierPizzaService(dao);
		SupprimerPizzaService supprimePizzaService=new SupprimerPizzaService(dao);
		
		int choix=0;
		while(choix!=99){

		System.out.println("***********************************");
		System.out.println("***   Pizzeria Administration   ***");
		System.out.println("***********************************");
		System.out.println("*  1. Lister les pizzas           *");
		System.out.println("*  2. Ajouter une nouvelle pizza  *");
		System.out.println("*  3. Mettre à jour une pizza     *");
		System.out.println("*  4. Supprimer une pizza         *");
		System.out.println("*  99. Sortir                     *");
		System.out.println("***********************************");
		System.out.print(">>>");
					
		Scanner user = new Scanner(System.in);
		choix = user.nextInt();
		
		
			if(choix==1){
				listePizzeService.executeUC(user);
			}
			else if(choix==2){
				ajoutePizzaService.executeUC(user);
			}
			else if(choix==3){
				modifiePizzaService.executeUC(user);
			}
			else if(choix==4){
				supprimePizzaService.executeUC(user);
				
				
				
			}
			else if(choix==99){				
				System.out.println("Au revoir \u2639");
				}
			
			else{
				System.out.println("Ce n'est pas un choix valide, try again \u263A");
				}
		}
		
	}
	
	public static void afficheCarte(Pizza pizza){
		System.out.println(pizza.getCode()+" -> "+pizza.getLibelle()+" ("+pizza.getPrix()+"€)");
		
	}

}
