package controleur;

public class Avion {
	private int idavion; 
	private String desigation, constructeur; 
	private int nbplaces ;
	public Avion(int idavion, String desigation, String constructeur, int nbplaces) {
		super();
		this.idavion = idavion;
		this.desigation = desigation;
		this.constructeur = constructeur;
		this.nbplaces = nbplaces;
	} 
	
	public Avion(String desigation, String constructeur, int nbplaces) {
		super();
		this.idavion = 0;
		this.desigation = desigation;
		this.constructeur = constructeur;
		this.nbplaces = nbplaces;
	}

	public int getIdavion() {
		return idavion;
	}

	public void setIdavion(int idavion) {
		this.idavion = idavion;
	}

	public String getDesigation() {
		return desigation;
	}

	public void setDesigation(String desigation) {
		this.desigation = desigation;
	}

	public String getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}

	public int getNbplaces() {
		return nbplaces;
	}

	public void setNbplaces(int nbplaces) {
		this.nbplaces = nbplaces;
	} 
	
	
	
}
