/**
 *
 */
package fr.univsmb.etu;

import java.util.LinkedList;

import fr.univsmb.etu.category.Categorie;
import fr.univsmb.etu.command.Commande;
import fr.univsmb.etu.view.IHMCategorieCliquable;
import fr.univsmb.etu.view.IHM_Main;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class Caisse extends Categorie<Commande>
{
	private static final long	serialVersionUID	= 1L;
	
	public Caisse () {
		super( "Caisse", new LinkedList<Commande>() );
	}
	
	@Override
	public IHM_Main consulter ()
	{
		return new IHMCategorieCliquable();
	}
}
