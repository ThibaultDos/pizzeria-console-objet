package fr.pizzeria.model;

/**
 * @author 33689
 *cette classe représente une pizza
 */
public class Pizza 
{
	/**
	 * id : identifiant unique
	 */
	private int id=0;
	/**
	 * code : code à trois lettres de la pizza
	 */
	private String code=null;
	/**
	 * libelle : nom de la pizza
	 */
	private String libelle=null;
	/**
	 * prix : prix en euros
	 */
	private double prix=0;
	/**
	 * cpt : compteur pour incrémenter l'id de chaque pizza disponible sur le menu
	 */
	private static int cpt=0;
	
	/**
	 * constructeur pour créer une instance de la classe Pizza
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id, String code, String libelle, double prix) 
	{
		this.id=id;
		this.code=code;
		this.libelle=libelle;
		this.prix=prix;	
	}
	
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * constructeur pour instancier une pizza qui sera affichée par le menu
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(String code, String libelle, double prix) 
	{
		this.code=code;
		this.libelle=libelle;
		this.prix=prix;		
		cpt++;
		id=cpt;
	}
	
	
}
