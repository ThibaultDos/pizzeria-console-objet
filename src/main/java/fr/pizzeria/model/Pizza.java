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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code)) {
			return false;			
		}
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle)){
			return false;	
		}
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}
	
	
	
	
}
