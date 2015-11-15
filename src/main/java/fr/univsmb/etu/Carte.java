package fr.univsmb.etu;

import java.util.LinkedList;
import java.util.List;

import fr.univsmb.etu.category.Categorie;
import fr.univsmb.etu.category.CategorieVente;
import fr.univsmb.etu.category.ListeBoissons;
import fr.univsmb.etu.category.ListeDesserts;
import fr.univsmb.etu.category.ListeEntrees;
import fr.univsmb.etu.category.ListeMenus;
import fr.univsmb.etu.category.ListePlatsPrincipaux;
import fr.univsmb.etu.command.Commande;
import fr.univsmb.etu.product.Dessert;
import fr.univsmb.etu.product.EntiteVente;
import fr.univsmb.etu.product.Entree;
import fr.univsmb.etu.product.Menu;
import fr.univsmb.etu.product.PlatPrincipal;
import fr.univsmb.etu.view.IHMCategorieCliquable;
import fr.univsmb.etu.view.IHM_Main;

/**
 *
 */
public class Carte
{
	
	/**
	 *
	 */
	protected ListeMenus			listeMenus;
	
	/**
	 *
	 */
	protected ListeMenus			listeMenusJ;
	
	/**
	 *
	 */
	protected ListeBoissons			listeBoissons;
	
	/**
	 *
	 */
	protected ListeEntrees			listeEntrees;
	
	/**
	 *
	 */
	protected ListePlatsPrincipaux	listePlatsPrincipaux;
	
	/**
	 *
	 */
	protected ListeDesserts			listeDesserts;
	
	/**
	 *
	 */
	public Carte () {
		this.setListeMenus( new ListeMenus() );
		this.setListeMenusJ( new ListeMenus() );
		this.setListeBoissons( new ListeBoissons() );

		this.setListeEntrees( new ListeEntrees() );
		this.setListePlatsPrincipaux( new ListePlatsPrincipaux() );
		this.setListeDesserts( new ListeDesserts() );
		
		this.getListeMenusJ().setNom( "Menus du Jour" );

		Menu menuJ = new Menu( "La balade en forêt", 15.00, new ListeEntrees( new Entree( "Salade composée", 6.50 ) ),
				new ListePlatsPrincipaux( new PlatPrincipal( "Carpaccio", 12.00 ) ), this.getListeBoissons() );
		this.getListeMenusJ().add( menuJ );
		
		Menu menu1 = new Menu( "Menu gourmand", 28.00, new ListeEntrees( new Entree( "Jardinière de légumes", 7.30 ) ),
				new ListePlatsPrincipaux( new PlatPrincipal( "Cote de boeuf", 21.00 ) ), new ListeDesserts( new Dessert(
						"Mousse au chocolat", 1.80 ) ), this.getListeBoissons() );
		Menu menu2 = new Menu( "Menu enfant", 14.00, new ListePlatsPrincipaux( new PlatPrincipal( "Steak + frite", 10.00 ) ),
				new ListeDesserts( new Dessert( "Glace", 3.50 ) ), this.getListeBoissons() );
		this.getListeMenus().add( menu1 );
		this.getListeMenus().add( menu2 );
	}

	/**
	 * @param cat
	 */
	public IHM_Main consulterCategorie ( Categorie<EntiteVente> cat )
	{
		return cat.consulter();
	}

	/**
	 * @return the listeBoissons
	 */
	public ListeBoissons getListeBoissons ()
	{
		return this.listeBoissons;
	}
	
	/**
	 * @return the listeDesserts
	 */
	public ListeDesserts getListeDesserts ()
	{
		return this.listeDesserts;
	}

	/**
	 * @return the listeEntrees
	 */
	public ListeEntrees getListeEntrees ()
	{
		return this.listeEntrees;
	}

	/**
	 * @return the listeMenus
	 */
	public ListeMenus getListeMenus ()
	{
		return this.listeMenus;
	}

	/**
	 * @return the listeMenusJ
	 */
	public ListeMenus getListeMenusJ ()
	{
		return this.listeMenusJ;
	}

	/**
	 * @return the listePlatsPrincipaux
	 */
	public ListePlatsPrincipaux getListePlatsPrincipaux ()
	{
		return this.listePlatsPrincipaux;
	}

	/**
	 * @param cat
	 */
	public IHMCategorieCliquable ouvrirCategorie ( CategorieVente<EntiteVente> cat )
	{
		return new IHMCategorieCliquable( cat );
	}
	
	public IHMCategorieCliquable ouvrirCategorie ( CategorieVente<EntiteVente> cat, Commande commande )
	{
		cat.setCommande( commande );
		IHMCategorieCliquable window = new IHMCategorieCliquable( cat );
		List<Object> args = new LinkedList<Object>();
		args.add( commande );
		window.setArgsBtnAction( args );
		return window;
	}

	/**
	 * @param listeBoissons
	 *            the listeBoissons to set
	 */
	private void setListeBoissons ( ListeBoissons listeBoissons )
	{
		this.listeBoissons = listeBoissons;
	}

	/**
	 * @param listeDesserts
	 *            the listeDesserts to set
	 */
	private void setListeDesserts ( ListeDesserts listeDesserts )
	{
		this.listeDesserts = listeDesserts;
	}

	/**
	 * @param listeEntrees
	 *            the listeEntrees to set
	 */
	private void setListeEntrees ( ListeEntrees listeEntrees )
	{
		this.listeEntrees = listeEntrees;
	}

	/**
	 * @param listeMenus
	 *            the listeMenus to set
	 */
	private void setListeMenus ( ListeMenus listeMenus )
	{
		this.listeMenus = listeMenus;
	}

	/**
	 * @param listeMenusJ
	 *            the listeMenusJ to set
	 */
	private void setListeMenusJ ( ListeMenus listeMenusJ )
	{
		this.listeMenusJ = listeMenusJ;
	}

	/**
	 * @param listePlatsPrincipaux
	 *            the listePlatsPrincipaux to set
	 */
	private void setListePlatsPrincipaux ( ListePlatsPrincipaux listePlatsPrincipaux )
	{
		this.listePlatsPrincipaux = listePlatsPrincipaux;
	}
	
}