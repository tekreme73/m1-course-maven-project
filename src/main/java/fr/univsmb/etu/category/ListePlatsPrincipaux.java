package fr.univsmb.etu.category;

import fr.univsmb.etu.product.PlatPrincipal;
import fr.univsmb.etu.view.IHMCategorie;
import fr.univsmb.etu.view.IHM_Main;

/**
 *
 */
public class ListePlatsPrincipaux extends CategorieVente<PlatPrincipal>
{

	private static final long	serialVersionUID	= 1L;
	
	public static ListePlatsPrincipaux vide ()
	{
		ListePlatsPrincipaux l = new ListePlatsPrincipaux();
		l.clear();
		return l;
	}
	
	/**
	 *
	 */
	public ListePlatsPrincipaux () {
		this( new PlatPrincipal( "Côte de porc", 12.20 ), new PlatPrincipal( "Pavé de veau", 15.20 ), new PlatPrincipal(
				"Spaghetti bolognaise", 7.50 ), new PlatPrincipal( "Crêpe complète", 10.30 ), new PlatPrincipal( "Friture", 9.60 ),
				new PlatPrincipal( "Raclette traditionnelle (pour 4 pers)", 35.00 ), new PlatPrincipal(
						"Raclette traditionnelle (pour 12 pers)", 95.00 ) );
	}

	public ListePlatsPrincipaux ( PlatPrincipal... plats ) {
		super( "Plats principaux", plats );
	}

	@Override
	public IHM_Main consulter ()
	{
		return new IHMCategorie( this );
	}
}