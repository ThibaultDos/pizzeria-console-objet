package fr.pizzeria.Dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.Pizza;


public class PizzaMemDaoTest {
	
	
	/*
	 * 0. Identifier la méthode à tester
	 * 1. invoquer la méthode
	 * 2. récupérer le résultat
	 * 3. vérifier le résultat avec une assertion
	 */
	
	
	private static final Logger LOG = LoggerFactory.getLogger(PizzaMemDao.class);
	
	private PizzaMemDao dao;
	
	
	@Rule public TestName testName;
	@Rule public ExpectedException exE;
	
	@Before
	
	public void init(){
		LOG.info("Étant donné une instance de PizzaMemDao");
		dao = new PizzaMemDao();
	}


	@Test
	public void findAllPizzasTest() {
		
//		exE.expect(NumberFormatException.class);
//		exE.expectMessage("ousp");
//		
//		LOG.info("Exécution de la méthode {}", testName.getMethodName());

		
		
		LOG.info("Lorsqu'on recherche la liste de pizzas");
		Pizza[] resultat = dao.findAllPizzas();
		
		LOG.info("Alors la liste de pizzas contient au moins une pizza");

		Assert.assertTrue(resultat != null);
		Assert.assertTrue(resultat.length > 0);
	}
	
	@Test
	public void saveNewPizzaTest() {
		Pizza pizza = new Pizza("ABC", "jesaispas", 0.0);
		
		
				
		dao.saveNewPizza(pizza);
		
		Pizza[] carte = dao.findAllPizzas();
		
		boolean pizzaTrouve = false;
		
		for (Pizza pizza2 : carte) {
			if(pizza2.equals(pizza)) {
				pizzaTrouve = true;
			}
		}
		
		
		Assert.assertTrue(pizzaTrouve);
		
//		Assert.assertTrue(dao.saveNewPizza(pizza).length == carte.length+1);
//		Assert.assertTrue(carte[n+1] == pizza);
	}
	
	
	@Test
	public void updatePizzaTest(){
		
		Pizza pizza = new Pizza("ABC", "jesaispas", 0.0);				
				
		Pizza[] carte = dao.findAllPizzas();
		
		Pizza pizzaUp = carte[0];
		
		for (Pizza up : carte){
			if (up.getCode().equals("PEP")) pizzaUp = up;
		}
		
		dao.updatePizza("PEP", pizza);
		
		
	
		boolean trouvePizzaRemoved = false ;
		
		boolean pizzaUpdated = false ;
		
		for (Pizza p : carte){
			
			if((p.equals(pizza))){
				pizzaUpdated = true;
			}
			
			if(p.equals(pizzaUp)){
				trouvePizzaRemoved = true;
			}			
		}
		
		Assert.assertTrue(pizzaUpdated);
		Assert.assertFalse(trouvePizzaRemoved);	
		
	}	
	
	@Test
	public void deletePizzaTest(){
		
		Pizza[] carte = dao.findAllPizzas();
		
		dao.deletePizza("PEP");
				
		boolean trouvePizzaRemoved = false;
		
		for (Pizza pizza : carte) {
			if (pizza == null) continue;
			if(pizza.getCode().equals("PEP")) {
				trouvePizzaRemoved = true;
			}
		}
		
		Assert.assertFalse(trouvePizzaRemoved);	
		
	}
	
	

					
}
	
	

