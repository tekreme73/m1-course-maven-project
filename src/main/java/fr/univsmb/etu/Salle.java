/**
 *
 */
package fr.univsmb.etu;

import fr.univsmb.etu.category.Categorie;
import fr.univsmb.etu.command.Table;
import fr.univsmb.etu.view.IHMCategorieCliquable;
import fr.univsmb.etu.view.IHM_Main;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class Salle extends Categorie<Table>
{
	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	 *
	 * @param nom
	 * @param tables
	 */
	public Salle ( String nom, Table[] tables, Carte carte, Cuisine cuisine, Caisse caisse ) {
		super( nom, tables );
		for ( Table t : tables )
		{
			t.setCarte( carte );
			t.getCommande().setCaisse( caisse );
			t.getCommande().setCuisine( cuisine );
		}
	}

	/**
	 *
	 * @param tables
	 */
	public Salle ( Table[] tables, Carte carte, Cuisine cuisine, Caisse caisse ) {
		this( "Salle principale", tables, carte, cuisine, caisse );
	}

	@Override
	public IHM_Main consulter ()
	{
		return new IHMCategorieCliquable( this );
	}
}
