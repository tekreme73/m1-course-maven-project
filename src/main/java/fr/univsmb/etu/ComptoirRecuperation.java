/**
 *
 */
package fr.univsmb.etu;

import java.util.LinkedList;

import fr.univsmb.etu.category.Categorie;
import fr.univsmb.etu.command.Ticket;
import fr.univsmb.etu.view.IHMCategorieCliquable;
import fr.univsmb.etu.view.IHM_Main;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class ComptoirRecuperation extends Categorie<Ticket>
{
	private static final long	serialVersionUID	= 1L;
	
	/*
	 *
	 */
	public ComptoirRecuperation () {
		this( new LinkedList<Ticket>() );
	}
	
	/**
	 *
	 * @param nom
	 * @param items
	 */
	public ComptoirRecuperation ( LinkedList<Ticket> items ) {
		super( "Comptoir de récupération des plats prêts", items );
	}

	/**
	 *
	 * @param ticket
	 */
	public void ajouterTicket ( Ticket ticket )
	{
		this.add( ticket );
	}
	
	@Override
	public IHM_Main consulter ()
	{
		return new IHMCategorieCliquable();
	}
	
	/**
	 *
	 * @param ticket
	 */
	public void retirerTicket ( Ticket ticket )
	{
		this.remove( ticket );
	}

}
