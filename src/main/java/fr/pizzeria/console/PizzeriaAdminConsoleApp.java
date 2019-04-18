package fr.pizzeria.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.Dao.IPizzaDao;
import fr.pizzeria.Dao.PizzaMemJbdc;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.AjouterPizzaService;
import fr.pizzeria.service.ListerPizzasService;
import fr.pizzeria.service.ModifierPizzaService;
import fr.pizzeria.service.SupprimerPizzaService;

public class PizzeriaAdminConsoleApp {

	private static final Logger LOGGER = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	public void executer(String param) {
		LOGGER.debug("Traitement 1 : param = {}", param);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LOGGER.info("Bonjour Slf4J !");
		LOGGER.info("Implémentation Logback");

		IPizzaDao dao = new PizzaMemJbdc();
		ListerPizzasService listePizzeService = new ListerPizzasService(dao);
		AjouterPizzaService ajoutePizzaService = new AjouterPizzaService(dao);
		ModifierPizzaService modifiePizzaService = new ModifierPizzaService(dao);
		SupprimerPizzaService supprimePizzaService = new SupprimerPizzaService(dao);

		int choix = 0;
		while (choix != 99) {
			afficherMenu();
			Scanner user = new Scanner(System.in);
			String choixStr = user.nextLine();
			if (choixStr.matches("[0-9]+")) {
				choix = Integer.parseInt(choixStr);
			} else {
				choix = 0;
			}

			try {

				if (choix == 1) {
					listePizzeService.executeUC(user);
				} else if (choix == 2) {
					try {
						ajoutePizzaService.executeUC(user);
					} catch (SavePizzaException e) {

						LOGGER.error("I AM ERROR --> SavePizzaException", e);
						System.err.println(e.getMessage());
					}
				} else if (choix == 3) {
					try {
						modifiePizzaService.executeUC(user);
					} catch (UpdatePizzaException e) {

						LOGGER.error("I AM ERROR --> UpdatePizzaException", e);	
						System.err.println(e.getMessage());
					}
				} else if (choix == 4) {
					try {
						supprimePizzaService.executeUC(user);
					} catch (DeletePizzaException e) {

						LOGGER.error("I AM ERROR --> DeletePizzaException", e);	
						System.err.println(e.getMessage());
					}
				} else if (choix == 99) {
					System.out.println("Au revoir \u2639");
				}

				else {
					System.out
							.println("Perdu, ce choix n'est pas valide.\n Veuillez utiliser le pavé numérique. \u263A");
				}

			} catch (PizzaException e) {
				LOGGER.error("I AM ERROR --> PizzaException", e);
			}
		}

	}

	public static void afficheCarte(Pizza pizza) {
		System.out.println(pizza.getCode() + " -> " + pizza.getLibelle() + " (" + pizza.getPrix() + "€)");
	}
	
	public static void afficherMenu(){
		System.out.println("***********************************");
		System.out.println("***   Pizzeria Administration   ***");
		System.out.println("***********************************");
		System.out.println("*  1. Lister les pizze            *");
		System.out.println("*  2. Ajouter une nouvelle pizza  *");
		System.out.println("*  3. Mettre à jour une pizza     *");
		System.out.println("*  4. Supprimer une pizza         *");
		System.out.println("*  99. Sortir                     *");
		System.out.println("***********************************");
		System.out.print(">>> ");
	}
}
