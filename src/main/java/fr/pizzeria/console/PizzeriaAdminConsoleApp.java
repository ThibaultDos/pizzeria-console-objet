package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.Dao.IPizzaDao;
import fr.pizzeria.Dao.PizzaMemJbdc;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
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
		
		IPizzaDao dao = new PizzaMemJbdc();
		ListerPizzasService listePizzeService=new ListerPizzasService(dao);
		AjouterPizzaService ajoutePizzaService=new AjouterPizzaService(dao);
		ModifierPizzaService modifiePizzaService=new ModifierPizzaService(dao);
		SupprimerPizzaService supprimePizzaService=new SupprimerPizzaService(dao);
		
		int choix=0;
		while(choix!=99){

		System.out.println("***********************************");
		System.out.println("***   Pizzeria Administration   ***");
		System.out.println("***********************************");
		System.out.println("*  1. Lister les pizze            *");
		System.out.println("*  2. Ajouter une nouvelle pizza  *");
		System.out.println("*  3. Mettre à jour une pizza     *");
		System.out.println("*  4. Supprimer une pizza         *");
		System.out.println("*  99. Sortir                     *");
		System.out.println("***********************************");
		System.out.print(">>>");
					
		Scanner user = new Scanner(System.in);
		String choixStr=user.nextLine();
		if(choixStr.matches("[0-9]")){
			choix=Integer.parseInt(choixStr);
		}
		else {
			choix=0;	
		}		
			if(choix==1){
				listePizzeService.executeUC(user);
			}
			else if(choix==2){
				try {
					ajoutePizzaService.executeUC(user);
				} catch (SavePizzaException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
			}
			else if(choix==3){
				try {
					modifiePizzaService.executeUC(user);
				} catch (UpdatePizzaException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
			}
			else if(choix==4){
				try {
					supprimePizzaService.executeUC(user);
				} catch (DeletePizzaException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
				
				
				
			}
			else if(choix==99){				
				System.out.println("Au revoir \u2639");
				}
			
			else{
				System.out.println("Perdu, ce choix n'est pas valide.\n Veuillez utiliser le pavé numérique. \u263A");
				}
		}
		
	}
	
	public static void afficheCarte(Pizza pizza){
		System.out.println(pizza.getCode()+" -> "+pizza.getLibelle()+" ("+pizza.getPrix()+"€)");
		
	}
}
