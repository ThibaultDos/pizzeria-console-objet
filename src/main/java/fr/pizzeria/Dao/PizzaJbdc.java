package fr.pizzeria.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.pizzeria.model.Pizza;


public class PizzaJbdc implements IPizzaDao {
	
	
	/*PizzaJbdc.connectJbdc();
	 * implémenter factorisation dans chaque redéfinition de méthode pour la classe PizzaMemJbdc
	 */
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// DriverManager.registerDriver(new Driver());
		// Etape 1 - Chargement du pilote
		Class.forName("com.mysql.jdbc.Driver");
		
		// Etape 2 - Définition de la JDBC URL
		String jdbcUrl = "jdbc:mysql://localhost:3306/pizzeria_bdd";
		
		// Etape 3 - Création de la connexion
		Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
		
		uneConnexion.prepareStatement("update pizza set categories=? where ID=? and description=?");
		
		Statement st = uneConnexion.createStatement();
		
		// Etape 4 - exécution  de la requête
		ResultSet rs = st.executeQuery("select * from pizza");
		
		// Etape 5 - exploitation des résultats
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String titre = rs.getString("code");
			
			System.out.println("id=" + id + " nom : " + titre);
		}

		// Etape 6 - Fermeture des ressources
		rs.close();
		
		st.close();
		
		uneConnexion.close();

	}

	@Override
	public Pizza[] findAllPizzas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		
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
