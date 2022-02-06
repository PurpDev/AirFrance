package controleur;

import modele.Modele;
import vue.VueConnexion;
import vue.VueGenerale;

public class AirFrance {

	private static VueConnexion uneVueConnexion ; 
	private static VueGenerale uneVueGenerale ; 
	
	public static void instancierVueGenerale (User unUser)
	{
		uneVueGenerale = new VueGenerale(unUser); 
	}
	public static void detruireVueGenerele ()
	{
		uneVueGenerale.dispose();
	}
	public static void rendreVisibleVueConnexion (boolean action)
	{
		uneVueConnexion.setVisible(action);
	}
	
	public static User selectWhereUser(String email, String mdp) 
	{
		//avant d'aller à la base , on controle l'email et le mdp 
		
		User unUser = Modele.selectWhereUser(email, mdp); 
		
		return unUser; 
	}
	public static void main(String[] args) {
		 
		uneVueConnexion = new VueConnexion();
	
	}

}
