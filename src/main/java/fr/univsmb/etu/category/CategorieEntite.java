/**
 *
 */
package fr.univsmb.etu.category;

import java.util.LinkedList;

import fr.univsmb.etu.product.EntiteVente;
import fr.univsmb.etu.view.IHMCategorie;
import fr.univsmb.etu.view.IHM_Main;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class CategorieEntite extends CategorieVente<EntiteVente>
{
	private static final long	serialVersionUID	= 1L;

	public CategorieEntite ( String nom, EntiteVente[] items ) {
		super( nom, items );
	}
	
	public CategorieEntite ( String nom, LinkedList<EntiteVente> items ) {
		super( nom, items );
	}

	@Override
	public IHM_Main consulter ()
	{
		return new IHMCategorie();
	}

}
