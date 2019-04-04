package fr.pizzeria.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaMemJbdc implements IPizzaDao {	
	
	@Override
	public Pizza[] findAllPizzas() {
		
		List<Pizza> list = new ArrayList<>();
		
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria_bdd";
			Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");		
		
			Statement st = uneConnexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM PIZZA");
			//PreparedStatement findAllPizzas = uneConnexion.prepareStatement();
			
			while(rs.next()) {
				
				String code = rs.getString("CODE");
				String libelle = rs.getString("NOM");
				Double prix = rs.getDouble("PRIX");
				
				list.add(new Pizza(code, libelle, prix));
				
			}

			rs.close();		
			st.close();		
			uneConnexion.close();
			
			
			} catch (ClassNotFoundException e) {
				throw new PizzaException("Pas de driver, pas de connexion.", e);
				
			} catch (SQLException e) {
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
			String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria_bdd";
			Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
		
			Statement st = uneConnexion.createStatement();
			int nbPizzaInsere = st.executeUpdate("INSERT INTO PIZZA(CODE, NOM, PRIX) VALUES('"+pizza.getCode()+"','"+pizza.getLibelle()+"',"+pizza.getPrix()+")");
			//PreparedStatement saveNewPizza = uneConnexion.prepareStatement();
			
			if (nbPizzaInsere == 1)System.out.println(nbPizzaInsere + " pizza insérée");
			else if (nbPizzaInsere >1)System.out.println(nbPizzaInsere + " pizze insérées");
			
			uneConnexion.close();		
			st.close();		
			uneConnexion.close();
			
		} catch (ClassNotFoundException e) {
			throw new PizzaException("Pas de driver, pas de connexion.", e);
				
		} catch (SQLException e) {
			throw new PizzaException("Pas de base de données, pas d'information.", e);
			
		} 		
	}

	
	
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria_bdd";
			Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
			
			
			Statement st = uneConnexion.createStatement();
			int nbPizzasMisAJour = st.executeUpdate("UPDATE PIZZA SET CODE='"+pizza.getCode()+"', NOM='"+pizza.getLibelle()+"', PRIX="+pizza.getPrix()+" WHERE CODE='"+codePizza+"'");
			//PreparedStatement updatePizza = uneConnexion.prepareStatement();
						
			if (nbPizzasMisAJour == 1)System.out.println(nbPizzasMisAJour + "  mise à jour");
			else if (nbPizzasMisAJour >1)System.out.println(nbPizzasMisAJour + " pizze mises à jour");
			
			uneConnexion.close();		
			st.close();		
			uneConnexion.close();
			
			
		} catch (ClassNotFoundException e) {
			throw new PizzaException("Pas de driver, pas de connexion.", e);
				
		} catch (SQLException e) {
			throw new PizzaException("Pas de base de données, pas d'information.", e);
			
		} 		
	}
		
		

	@Override
	public void deletePizza(String codePizza) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria_bdd";
			Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
			
			Statement st = uneConnexion.createStatement();
			int nbPizzasSuppr = st.executeUpdate("DELETE FROM PIZZA WHERE CODE='"+codePizza+"'");
			//PreparedStatement deletePizza = uneConnexion.prepareStatement();
			
			
			if (nbPizzasSuppr == 1)System.out.println(nbPizzasSuppr + "  pizza supprimée");
			else if (nbPizzasSuppr >1)System.out.println(nbPizzasSuppr + " pizze supprimées");
			
			
			uneConnexion.close();		
			st.close();		
			uneConnexion.close();
			
			
		} catch (ClassNotFoundException e) {
			throw new PizzaException("Pas de driver, pas de connexion.", e);
				
		} catch (SQLException e) {
			throw new PizzaException("Pas de base de données, pas d'information.", e);
			
		} 		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}	

}
