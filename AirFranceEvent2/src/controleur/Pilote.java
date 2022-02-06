package controleur;

public class Pilote {
	private int idpilote ; 
	private String nom, prenom, email, bip ;
	
	public Pilote(int idpilote, String nom, String prenom, String email, String bip) {
		 
		this.idpilote = idpilote;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.bip = bip;
	}
	
	public Pilote( String nom, String prenom, String email, String bip) {
		 
		this.idpilote = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.bip = bip;
	}

	public int getIdpilote() {
		return idpilote;
	}

	public void setIdpilote(int idpilote) {
		this.idpilote = idpilote;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBip() {
		return bip;
	}

	public void setBip(String bip) {
		this.bip = bip;
	}
	
}
