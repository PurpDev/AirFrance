package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Avion;
import controleur.Pilote;
import controleur.TableauBord;
import controleur.User;
import controleur.Vol;

public class Modele {
	//pour les PC 
	//private static Bdd uneBdd = new Bdd ("localhost", "airfrance_p141", "root", ""); 
	
	private static Bdd uneBdd = new Bdd ("localhost:8889", "airfrance_p141", "root", "root");
	
	/************************ Gestion USER ***************************/
	public static User selectWhereUser (String email, String mdp)
	{
		String requete ="select * from user where email ='"+email+"' and mdp ='" + mdp +"';";
		User unUser = null; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete); 
			if(unResultat.next())
			{
				unUser = new User (
						unResultat.getInt("iduser"), 
						unResultat.getString("nom"), 
						unResultat.getString("prenom"), 
						unResultat.getString("email"), 
						unResultat.getString("mdp"), 
						unResultat.getString("role")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);	
		}
		return unUser; 
	}
	
	/************************ Gestion Pilote *************************/
	public static void insertPilote (Pilote unPilote)
	{
		String requete = "insert into pilote values (null, '" + unPilote.getNom() 
		+"','" + unPilote.getPrenom()+"','" + unPilote.getEmail() + "','" 
		+ unPilote.getBip()+"'); ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); //curseur
			unStat.execute(requete); //execute comme php
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
	}
	
	public static void updatePilote (Pilote unPilote)
	{
		String requete = "update pilote set nom='" + unPilote.getNom() 
		+"', prenom='" + unPilote.getPrenom()+"', email='" 
		+ unPilote.getEmail() + "', bip='" + unPilote.getBip()+
		"'   where idpilote =" + unPilote.getIdpilote()+ " ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); //curseur
			unStat.execute(requete); //execute comme php
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
	}
	
	public static ArrayList <Pilote> selectAllPilotes ()
	{
		String requete = "select * from pilote ; "; 
		ArrayList<Pilote> lesPilotes = new ArrayList<Pilote>(); 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			//fetchAll en PHP : extraction des données 
			ResultSet desResultats = unStat.executeQuery(requete); 
			//tant qu'il y a des résultats 
			while(desResultats.next())
			{
				Pilote unPilote = new Pilote (
						desResultats.getInt("idpilote"), 
						desResultats.getString("nom"), 
						desResultats.getString("prenom"), 
						desResultats.getString("email"), 
						desResultats.getString("bip")
						);
				//ajouter l'instance pilote dans l'ArrayList
				lesPilotes.add(unPilote);
			}
			
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);	
		}
		return lesPilotes;
	}
	
	public static Pilote selectWherePilote (int idpilote)
	{
		String requete = "select * from pilote where idpilote = " + idpilote; 
		Pilote unPilote = null ; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			//fetchAll en PHP : extraction des données 
			ResultSet unResultat = unStat.executeQuery(requete); 
			//s'il y a un résultat : un seul Pilote
			if(unResultat.next())
			{
				unPilote = new Pilote (
						unResultat.getInt("idpilote"), 
						unResultat.getString("nom"), 
						unResultat.getString("prenom"), 
						unResultat.getString("email"), 
						unResultat.getString("bip")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);	
		}
		return unPilote;
	}
	
	public static void deletePilote (int idpilote)
	{
		String requete = "delete from pilote where idpilote =  " + idpilote;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); //curseur
			unStat.execute(requete); //execute comme php
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
	}
	public static int countPilote ()
	{
		int nb = 0; 
		String requete = "select count(*) as nb from pilote ; "; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); //curseur
			ResultSet unResultat = unStat.executeQuery(requete); //execute comme php
			if(unResultat.next())
			{
				nb = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return nb; 
	}
	/************************* Gestion Avion **************************/
	public static void insertAvion  (Avion unAvion)
	{
		String requete = "insert into avion values (null, '" + unAvion.getDesigation()
		+"','" + unAvion.getConstructeur()+"','" + unAvion.getNbplaces() + "');"; 

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); //curseur
			unStat.execute(requete); //execute comme php
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
	}
	
	public static void updateAvion  (Avion unAvion)
	{
		String requete = "update avion set designation='" + unAvion.getDesigation() 
		+"',constructeur = '" + unAvion.getConstructeur()
		+"', nbplaces = '" + unAvion.getNbplaces() 
		+ "'   where idavion = " + unAvion.getIdavion() + ";"; 

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); //curseur
			unStat.execute(requete); //execute comme php
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
	}
	
	public static ArrayList <Avion> selectAllAvions ()
	{
		String requete = "select * from avion ; "; 
		ArrayList<Avion> lesAvions = new ArrayList<Avion>(); 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			//fetchAll en PHP : extraction des données 
			ResultSet desResultats = unStat.executeQuery(requete); 
			//tant qu'il y a des résultats 
			while(desResultats.next())
			{
				Avion unAvion = new Avion (
						desResultats.getInt("idavion"), 
						desResultats.getString("designation"), 
						desResultats.getString("constructeur"), 
						desResultats.getInt("nbplaces") 
						);
				//ajouter l'instance avion dans l'ArrayList
				lesAvions.add(unAvion);
			}
			
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);	
		}
		return lesAvions;
	}
	
	public static Avion selectWhereAvion (int idavion)
	{
		String requete = "select * from avion where idavion = " + idavion; 
		Avion unAvion = null ; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			//fetchAll en PHP : extraction des données 
			ResultSet unResultat = unStat.executeQuery(requete); 
			//s'il y a un résultat : un seul Pilote
			if(unResultat.next())
			{
				unAvion = new Avion (
						unResultat.getInt("idavion"), 
						unResultat.getString("designation"), 
						unResultat.getString("constructeur"), 
						unResultat.getInt("nbplaces") 
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);	
		}
		return unAvion;
	}
	
	public static void deleteAvion (int idavion)
	{
		String requete = "delete from avion where idavion =  " + idavion;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); //curseur
			unStat.execute(requete); //execute comme php
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
	}
	
	public static int countAvion ()
	{
		int nb = 0; 
		String requete = "select count(*) as nb from avion ; "; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); //curseur
			ResultSet unResultat = unStat.executeQuery(requete); //execute comme php
			if(unResultat.next())
			{
				nb = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return nb; 
	}
	
	/************************* Gestion VOL **************************/
	
	public static void insertVol  (Vol unVol)
	{
		String requete = "insert into vol values (null, '" 
		+ unVol.getDesignation()
		+"','" + unVol.getDatevol()+"','" + unVol.getHeurevol() 
		+"','" + unVol.getIdpilote1()+"','" + unVol.getIdpilote2() 
		+"','" + unVol.getIdavion()+"');"; 

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); //curseur
			unStat.execute(requete); //execute comme php
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
	}
	
	public static void updateVol  (Vol unVol)
	{
		String requete = "update vol set designation= '" + unVol.getDesignation()
		+"', datevol = '" + unVol.getDatevol()+"',heurevol ='" + unVol.getHeurevol() 
		+"', idpilote1='" + unVol.getIdpilote1()+"', idpilote2='" + unVol.getIdpilote2() 
		+"', idavion = '" + unVol.getIdavion()
		+"' where idvol = " + unVol.getIdvol() + ";"; 

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); //curseur
			unStat.execute(requete); //execute comme php
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
	}
	
	
	public static ArrayList <Vol> selectAllVols ()
	{
		String requete = "select * from vol ; "; 
		ArrayList<Vol> lesVols = new ArrayList<Vol>(); 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			//fetchAll en PHP : extraction des données 
			ResultSet desResultats = unStat.executeQuery(requete); 
			//tant qu'il y a des résultats 
			while(desResultats.next())
			{
				Vol unVol = new Vol (
						desResultats.getInt("idvol"), 
						desResultats.getString("designation"), 
						desResultats.getString("datevol"), 
						desResultats.getString("heurevol"), 
						desResultats.getInt("idpilote1") ,
						desResultats.getInt("idpilote2") ,
						desResultats.getInt("idavion") 
						);
				//ajouter l'instance Vol dans l'ArrayList
				lesVols.add(unVol);
			}
			
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);	
		}
		return lesVols;
	}
	
	public static Vol selectWhereVol (int idvol)
	{
		String requete = "select * from vol where idvol = " + idvol; 
		Vol unVol = null ; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			//fetchAll en PHP : extraction des données 
			ResultSet unResultat = unStat.executeQuery(requete); 
			//s'il y a un résultat : un seul Pilote
			if(unResultat.next())
			{
				unVol = new Vol (
						unResultat.getInt("idvol"), 
						unResultat.getString("designation"), 
						unResultat.getString("datevol"), 
						unResultat.getString("heurevol"), 
						unResultat.getInt("idpilote1") ,
						unResultat.getInt("idpilote2") ,
						unResultat.getInt("idavion") 
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);	
		}
		return unVol;
	}
	
	
	public static void deleteVol (int idvol)
	{
		String requete = "delete from vol where idvol =  " + idvol;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); //curseur
			unStat.execute(requete); //execute comme php
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
	}
	public static int countVol ()
	{
		int nb = 0; 
		String requete = "select count(*) as nb from vol ; "; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); //curseur
			ResultSet unResultat = unStat.executeQuery(requete); //execute comme php
			if(unResultat.next())
			{
				nb = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return nb; 
	}
	
	/****************** Tableau de bord *******************************/
	public static ArrayList<TableauBord> selectAllTableauBord ()
	{
		String requete = "select * from tb ; "; 
		ArrayList<TableauBord> lesTableauBords = new ArrayList<TableauBord>(); 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			//fetchAll en PHP : extraction des données 
			ResultSet desResultats = unStat.executeQuery(requete); 
			//tant qu'il y a des résultats 
			while(desResultats.next())
			{
				TableauBord unTableauBord = new TableauBord (
						desResultats.getString("nom"), 
						desResultats.getString("prenom"), 
						desResultats.getString("avion"), 
						desResultats.getString("vol"), 
						desResultats.getString("date") 
						);
				//ajouter l'instance Vol dans l'ArrayList
				lesTableauBords.add(unTableauBord);
			}
			
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de la requete :" + requete);	
		}
		return lesTableauBords;
	}
}
