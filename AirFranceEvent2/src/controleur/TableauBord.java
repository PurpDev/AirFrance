package controleur;

public class TableauBord {
	private String nom, prenom; 
	private String avion, vol, date;
	
	public TableauBord(String nom, String prenom, String avion, String vol, String date) {
		this.nom = nom;
		this.prenom = prenom;
		this.avion = avion;
		this.vol = vol;
		this.date = date;
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

	public String getAvion() {
		return avion;
	}

	public void setAvion(String avion) {
		this.avion = avion;
	}

	public String getVol() {
		return vol;
	}

	public void setVol(String vol) {
		this.vol = vol;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	} 
	
	
}
