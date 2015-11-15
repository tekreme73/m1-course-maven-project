/**
 *
 */
package fr.univsmb.etu.personnel;

import java.util.LinkedList;

import fr.univsmb.etu.category.Categorie;
import fr.univsmb.etu.view.IHMCategorie;
import fr.univsmb.etu.view.IHM_Main;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class Personnel extends Categorie<Employe>
{
	private static final long	serialVersionUID	= 1L;

	public Personnel ( String nom, Employe[] items ) {
		super( nom, items );
	}
	
	public Personnel ( String nom, LinkedList<Employe> items ) {
		super( nom, items );
	}

	@Override
	public IHM_Main consulter ()
	{
		return new IHMCategorie();
	}

}
