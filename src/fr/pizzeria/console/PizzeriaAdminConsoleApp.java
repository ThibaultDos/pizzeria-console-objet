package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp{
	/**
	 * @param args
	 */
	public static void main(String[] args){
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
		while(choix!=99){
			System.out.println("***********************************");
			System.out.println("***   Pizzeria Administration   ***");
			System.out.println("***********************************");
			System.out.println("*  1. Lister les pizzas           *");
			System.out.println("*  2. Ajouter une nouvelle pizza  *");
			System.out.println("*  3. Mettre à jour une pizza     *");
			System.out.println("*  4. Supprimer une pizza         *");
			System.out.println("*  99. Sortir                     *");
			System.out.println("***********************************");
			System.out.print(">>>");
						
			Scanner user = new Scanner(System.in);
			choix = user.nextInt();
			
			if(choix==1){
				System.out.println("***********************************");
				System.out.println("**      Liste des pizze :        **");
				System.out.println("***********************************");
				
				for(int i = 0; i<carte.length;i++){
					if (carte[i] != null){
						afficheCarte(carte[i]);
					}
				}
			}
			else if(choix==2){
				System.out.println("Ajout d'une nouvelle pizza");
				System.out.print("Quel est le code de la nouvelle pizza ?\n>>>");
				String code = user.next();
				System.out.print("Et son libellé (nom de la pizza) ?\n>>>");
				String libelle = user.next();
				System.out.print("Combien coûte cette pizza ?\n>>>");
				double prix = user.nextDouble();
				Pizza addPizza = new Pizza(code, libelle, prix);
				Pizza [] newCarte = new Pizza[carte.length+1] ;
				for (int i=0;i<carte.length;i++){
					newCarte[i]=carte[i];
					}
				
				newCarte[newCarte.length-1] = addPizza;
				carte = newCarte;
				
				}
			else if(choix==3){
				System.out.println("Mise à jour d'une pizza");
				System.out.print("Quelle pizza souhaitez-vous modifier ? (code à trois lettres)\n>>>");
				String code = user.next();
				System.out.print("Entrez le nouveau code à trois lettres S.V.P\n>>>");
				String newCode = user.next();
				System.out.print("Quel sera son nouveau libellé ? (nom de pizza sans espace)\n>>>");
				String newLibelle = user.next();
				System.out.print("Et son nouveau prix ?\n>>>");
				double newPrix = user.nextDouble();
				
				for (int i=0;i< carte.length;i++){
					if (carte[i].getCode().equals(code)){
						carte[i].setCode(newCode);
						carte[i].setLibelle(newLibelle);
						carte[i].setPrix(newPrix);
					}
				}
				
			}
			else if(choix==4){
				System.out.println("Suppression d'une pizza");
				System.out.print("Quelle pizza souhaitez-vous supprimer ? (code à trois lettres)\n>>>");
				String code = user.next();	
				Pizza[] newCarte = new Pizza[carte.length] ;				
				for (int j=0;j< carte.length;j++){
					if (carte[j].getCode().equals(code)){
						System.out.println("Adieu, pizza "+carte[j].getLibelle());
						carte[j]=null;
						
//						for (int i=0;i<carte.length;i++){
//							newCarte[i]=carte[i];							
//						}	
					}				
				}
			}
			else if(choix==99){				
				System.out.println("Au revoir \u2639");
				}
			
			else{
				System.out.println("Ce n'est pas un choix valide, try again \u263A");
				}
		}
		
	}
	
	public static void afficheCarte(Pizza pizza){
		System.out.println(pizza.getCode()+" -> "+pizza.getLibelle()+" ("+pizza.getPrix()+"€)");
		
	}

}
