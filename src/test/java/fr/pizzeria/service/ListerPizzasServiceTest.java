package fr.pizzeria.service;


import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import fr.pizzeria.Dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class ListerPizzasServiceTest {
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void executeUC() throws StockageException {

		// création du mock

		IPizzaDao dao = Mockito.mock(IPizzaDao.class);
		

		// définir comportement du mock

		Pizza[] listePizza = dao.findAllPizzas() ;


		// étant donné la saisie utilisateur suivante

		systemInMock.provideLines("IOP", "yoplay", "12.00");

		ListerPizzasService listerPizzasService = new ListerPizzasService(dao);

		

		// vérifier que la méthode findAllPizzas du mock a été invoquée

		Mockito.verify(dao).findAllPizzas();
		

	}

	private TextFromStandardInputStream emptyStandardInputStream() {
		return null;
	}

}
