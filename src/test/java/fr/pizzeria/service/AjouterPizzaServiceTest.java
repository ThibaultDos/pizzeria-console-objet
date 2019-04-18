package fr.pizzeria.service;


import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import fr.pizzeria.Dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;



public class AjouterPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void executeUC() throws StockageException {

		// création du mock

		IPizzaDao dao = Mockito.mock(IPizzaDao.class);
		

		// définir comportement du mock

		Pizza pizza = new Pizza("IOP", "yoplay", 12.0);
				

		// étant donné la saisie utilisateur suivante

		systemInMock.provideLines("IOP", "yoplay", "12.00");
		


		AjouterPizzaService ajouterPizzasService = new AjouterPizzaService(dao);

		ajouterPizzasService.executeUC(new Scanner(System.in));

		

		// vérifier que la méthode saveNewPizza du mock a été invoquée

		Mockito.verify(dao).saveNewPizza(pizza);
		

	}
	
	
	
	

}