package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp 
{
	public static void main(String[] args) 
	{
		Pizza [] carte = new Pizza[8] ;
		carte[0] = new Pizza ("PEP", "Pepperoni", 12.50);
		carte[1] = new Pizza ("MAR", "Margherita", 14.00);
		carte[2] = new Pizza ("REI", "Reine", 11.50);
		carte[3] = new Pizza ("FRO", "4 fromages", 12.00);
		carte[4] = new Pizza ("CAN", "Cannibale", 12.50);
		carte[5] = new Pizza ("SAV", "Savoyarde", 13.00);
		carte[6] = new Pizza ("ORI", "L’orientale", 13.50);
		carte[7] = new Pizza ("IND", "L’indienne", 14.00);
		
		int choix=0;
		while(choix!=99)
		{
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir ");
			System.out.print(">>>");
						
			Scanner user = new Scanner(System.in);
			choix = user.nextInt();
			
			if(choix==1)
				{
				System.out.println("Liste des pizze :");
				
				for(int i = 0; i<carte.length;i++)
					{
					afficheCarte(carte[i]);
					}
				
				}
			else if(choix==2)
				{
				System.out.println("Ajout d'une nouvelle pizza");
				String code = user.next();
				
				Pizza piz8 = new Pizza ("IND", "L’indienne", 14.00);
				}
			else if(choix==3)
				{
				System.out.println("Mise à jour d'une pizza");
				}
			else if(choix==4)
				{
				System.out.println("Suppression d'une pizza");
				}
			else if(choix==99)
				{				
				System.out.println("Au revoir \u2639");
				}
			
			else
				{
				System.out.println("Faisez un choix valide, merci \u263A");
				}
		}
		
	}
	
	public static void afficheCarte(Pizza pizza)
	{
		System.out.println(pizza.id+" "+pizza.code+" -> "+pizza.libelle+" ("+pizza.prix+"€)");
	}

}
