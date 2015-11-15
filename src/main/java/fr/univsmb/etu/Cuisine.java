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
public class Cuisine extends Categorie<Ticket>
{
	private static final long		serialVersionUID	= 1L;
	
	private ComptoirRecuperation	comptoir;
	
	/*
	 *
	 */
	public Cuisine () {
		this( new LinkedList<Ticket>() );
	}
	
	/**
	 *
	 * @param nom
	 * @param items
	 */
	public Cuisine ( LinkedList<Ticket> items ) {
		super( "Cuisine", items );
		this.setComptoir( new ComptoirRecuperation() );
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
	 * @return the comptoir
	 */
	public ComptoirRecuperation getComptoir ()
	{
		return this.comptoir;
	}
	
	/**
	 *
	 * @param ticket
	 */
	public void retirerTicket ( Ticket ticket )
	{
		this.getComptoir().retirerTicket( ticket );
	}

	/**
	 * @param comptoir
	 *            the comptoir to set
	 */
	public void setComptoir ( ComptoirRecuperation comptoir )
	{
		this.comptoir = comptoir;
	}

	/**
	 *
	 * @param ticket
	 */
	public void sortirTicket ( Ticket ticket )
	{
		this.remove( ticket );
		this.getComptoir().ajouterTicket( ticket );
	}

}
