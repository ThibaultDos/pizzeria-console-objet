package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp 
{
	public static void main(String[] args) 
	{
		String code=null;
		String libelle=null;
		double prix=0;
		Pizza piz1 = new Pizza (code, libelle, prix);
		Pizza piz2 = new Pizza (code, libelle, prix);
		Pizza piz3 = new Pizza (code, libelle, prix);
		Pizza piz4 = new Pizza (code, libelle, prix);
		
		
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
				System.out.println("Liste des pizze");
				System.out.println(piz1.id);
				System.out.println(piz2.id);
				System.out.println(piz3.id);
				System.out.println(piz4.id);
				
				}
			else if(choix==2)
				{
				System.out.println("Ajout d'une nouvelle pizza");
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

}
