package fr.pizzeria.model;

public class Pizza 
{
	public int id=0;
	public String code=null;
	public String libelle=null;
	public double prix=0;
	public static int cpt=0;
	
	public Pizza(int id, String code, String libelle, double prix) 
	{
		this.id=id;
		this.code=code;
		this.libelle=libelle;
		this.prix=prix;	
	}
	
	public Pizza(String code, String libelle, double prix) 
	{
		this.code=code;
		this.libelle=libelle;
		this.prix=prix;		
		cpt++;
		id=cpt;
	}
	
	
}
