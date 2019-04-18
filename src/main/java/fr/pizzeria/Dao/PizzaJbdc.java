package fr.pizzeria.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

import fr.pizzeria.model.Pizza;


public class PizzaJbdc implements IPizzaDao {
	
	
	/*PizzaJbdc.connectJbdc();
	 * implémenter factorisation dans chaque redéfinition de méthode pour la classe PizzaMemJbdc
	 */
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		DriverManager.registerDriver(new Driver());
		// Etape 1 - Chargement du pilote
		Class.forName("com.mysql.jdbc.Driver");
		
		// Etape 2 - Définition de la JDBC URL
		String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria_bdd";
		
		// Etape 3 - Création de la connexion
		try (Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
				Statement st = uneConnexion.createStatement();
				
				//Etape 4 - exécution  de la requête
				ResultSet rs = st.executeQuery("select * from pizza")){
			
			uneConnexion.prepareStatement("update pizza set categories=? where ID=? and description=?");
			
				
				
						// Etape 5 - exploitation des résultats
						while(rs.next()) {
							int id = rs.getInt("id");
							String titre = rs.getString("code");	
							System.out.println("id=" + id + " nom : " + titre);
						}
					}
		}

	@Override
	public Pizza[] findAllPizzas() {
		return null;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
	}

	@Override
	public void deletePizza(String codePizza) {
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
