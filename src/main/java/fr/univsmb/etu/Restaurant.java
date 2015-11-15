package fr.univsmb.etu;

import fr.univsmb.etu.command.Table;
import fr.univsmb.etu.personnel.Employe;
import fr.univsmb.etu.personnel.Patron;
import fr.univsmb.etu.personnel.Personnel;
import fr.univsmb.etu.personnel.Preparateur;
import fr.univsmb.etu.personnel.Serveur;
import fr.univsmb.etu.view.IHMCarte;
import fr.univsmb.etu.view.IHMCategorie;
import fr.univsmb.etu.view.IHMCategorieCliquable;

/**
 *
 */
public class Restaurant
{

	private static Employe	UTILISATEUR;

	/**
	 * @return the utilisateur
	 */
	public final static Employe getUtilisateur ()
	{
		return Restaurant.UTILISATEUR;
	}
	
	/**
	 * @param utilisateur
	 *            the utilisateur to set
	 */
	public static void setUtilisateur ( Employe utilisateur )
	{
		Restaurant.UTILISATEUR = utilisateur;
	}
	
	/**
	 *
	 */
	protected final Carte		carte;

	/**
	 *
	 */
	protected final Salle		salle;

	/**
	 *
	 */
	protected final Cuisine		cuisine;
	
	/**
	 *
	 */
	protected final Caisse		caisse;

	/**
	 *
	 */
	protected final Personnel	personnel;

	/**
	 *
	 */
	public Restaurant () {
		this.carte = new Carte();
		this.caisse = new Caisse();
		this.cuisine = new Cuisine();
		
		Employe[] employes = new Employe[ 3 ];

		employes[ 0 ] = new Patron( "Ferraris", "Christine" );
		employes[ 1 ] = new Serveur( "Rebillard", "Rémi" );
		employes[ 2 ] = new Preparateur( "Senger", "Aurélien" );
		
		this.personnel = new Personnel( "Personnel", employes );
		
		Table[] tables = new Table[ 15 ];
		for ( int i = 0; i < tables.length; ++i )
		{
			tables[ i ] = new Table( i + 1, employes[ i % employes.length ] );
		}
		this.salle = new Salle( tables, this.getCarte(), this.getCuisine(), this.getCaisse() );
	}
	
	/**
	 *
	 */
	public void consulterCaisse ()
	{
		IHMCategorieCliquable window = new IHMCategorieCliquable( this.getCaisse() );
		window.makeAndShow();
	}
	
	/**
	 *
	 */
	public void consulterCarte ()
	{
		IHMCarte window = new IHMCarte( this.carte );
		window.makeAndShow();
	}
	
	/**
	 *
	 */
	public void consulterComptoir ()
	{
		IHMCategorieCliquable window = new IHMCategorieCliquable( this.getCuisine().getComptoir() );
		window.makeAndShow();
	}
	
	/**
	 *
	 */
	public void consulterCuisine ()
	{
		IHMCategorieCliquable window = new IHMCategorieCliquable( this.getCuisine() );
		window.makeAndShow();
	}

	/**
	 *
	 */
	public void consulterPersonnel ()
	{
		IHMCategorie window = new IHMCategorie( this.getPersonnel() );
		window.makeAndShow();
	}

	/**
	 *
	 */
	public void consulterSalle ()
	{
		IHMCategorieCliquable window = new IHMCategorieCliquable( this.getSalle() );
		window.makeAndShow();
	}

	/**
	 * @return the caisse
	 */
	public Caisse getCaisse ()
	{
		return this.caisse;
	}

	/**
	 * @return the carte
	 */
	public Carte getCarte ()
	{
		return this.carte;
	}

	/**
	 * @return the cuisine
	 */
	public Cuisine getCuisine ()
	{
		return this.cuisine;
	}

	/**
	 * @return the personnel
	 */
	public Personnel getPersonnel ()
	{
		return this.personnel;
	}
	
	/**
	 * @return the salle
	 */
	public Salle getSalle ()
	{
		return this.salle;
	}
}