package fr.pizzeria.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaMemJbdc implements IPizzaDao {	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PizzaMemJbdc.class);
	private static final Integer ACCORD_SINGULIER = 1 ;
	
	@Override
	public Pizza[] findAllPizzas() {
		
		List<Pizza> list = new ArrayList<>();
		
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
			
			} catch (ClassNotFoundException e) {
			
			LOGGER.error("Holà, my name is Error --> Le driver n'a pas été chargé", e);
			throw new PizzaException("Pas de driver, pas de connexion.", e);
			}
					
			String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria_bdd";
		

		
		try (Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
				
				Statement st = uneConnexion.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM PIZZA")){
			
			while(rs.next()) {
				String code = rs.getString("CODE");
				String libelle = rs.getString("NOM");
				Double prix = rs.getDouble("PRIX");
				
				list.add(new Pizza(code, libelle, prix));
				}
			
			} catch (SQLException e) {
		LOGGER.error("Holà, my name is Error --> Pas de connection à la base de données", e);
		throw new PizzaException("Pas de base de données, pas d'information.", e);
		
			} 
		
		Pizza[] carte = new Pizza[list.size()];
		carte = list.toArray(carte);
		return carte;
		
		
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			throw new PizzaException("Pas de driver, pas de connexion.", e);
		}
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria_bdd";
		
		try (Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
		
			Statement st = uneConnexion.createStatement()) {
			
			int nbPizzaInsere = st.executeUpdate("INSERT INTO PIZZA(CODE, NOM, PRIX) VALUES('"+pizza.getCode()+"','"+pizza.getLibelle()+"',"+pizza.getPrix()+")");
			//PreparedStatement saveNewPizza = uneConnexion.prepareStatement();
			
			if (nbPizzaInsere == ACCORD_SINGULIER)System.out.println(nbPizzaInsere + " pizza insérée");
			else if (nbPizzaInsere >ACCORD_SINGULIER)System.out.println(nbPizzaInsere + " pizze insérées");
		}
		
		catch (SQLException e) {
			LOGGER.error("Holà, my name is Error --> Pas de connection à la base de données", e);
			throw new PizzaException("Pas de base de données, pas d'information.", e);
			
		} 		
	}

	
	
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			} catch (ClassNotFoundException e) {
				throw new PizzaException("Pas de driver, pas de connexion.", e);
			}
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria_bdd";
			
			try (Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
					
				Statement st = uneConnexion.createStatement()){
					
				int nbPizzasMisAJour = st.executeUpdate("UPDATE PIZZA SET CODE='"+pizza.getCode()+"', NOM='"+pizza.getLibelle()+"', PRIX="+pizza.getPrix()+" WHERE CODE='"+codePizza+"'");
				
						
				if (nbPizzasMisAJour == ACCORD_SINGULIER)System.out.println(nbPizzasMisAJour + "  mise à jour");
				else if (nbPizzasMisAJour >ACCORD_SINGULIER)System.out.println(nbPizzasMisAJour + " pizze mises à jour");
				
			} catch (SQLException e) {
				
				throw new PizzaException("Pas de base de données, pas d'information.", e);
			}
			
		} 		
	
		
		

	@Override
	public void deletePizza(String codePizza) {
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
		} catch (ClassNotFoundException e) {
				throw new PizzaException("Pas de driver, pas de connexion.", e);
					
			}
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria_bdd";
		try	(Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
		
		Statement st = uneConnexion.createStatement()) {
			int nbPizzasSuppr = st.executeUpdate("DELETE FROM PIZZA WHERE CODE='"+codePizza+"'");
				
			if (nbPizzasSuppr == ACCORD_SINGULIER)System.out.println(nbPizzasSuppr + "  pizza supprimée");
			else if (nbPizzasSuppr >ACCORD_SINGULIER)System.out.println(nbPizzasSuppr + " pizze supprimées");
		} catch (SQLException e) {
			
			throw new PizzaException("Pas de base de données, pas d'information.", e);
			
		} 		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {

		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {

		return false;
	}	

}
