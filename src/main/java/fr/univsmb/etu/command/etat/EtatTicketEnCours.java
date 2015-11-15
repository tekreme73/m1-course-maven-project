/**
 *
 */
package fr.univsmb.etu.command.etat;

import fr.univsmb.etu.Cuisine;
import fr.univsmb.etu.command.Ticket;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class EtatTicketEnCours extends EtatTicket
{
	
	/**
	 * @param ticket
	 */
	public EtatTicketEnCours ( Ticket ticket ) {
		super( ticket );
	}
	
	/* (non-Javadoc)
	 * @see albf.interfaces.ITicket#annoter()
	 */
	@Override
	public void annoter ()
	{}
	
	@Override
	public void cloturer ()
	{}
	
	/* (non-Javadoc)
	 * @see albf.interfaces.ITicket#envoyer()
	 */
	@Override
	public void envoyer ( Cuisine cuisine )
	{}

	@Override
	public String getNom ()
	{
		return "En cours";
	}

	@Override
	public void preparer ()
	{
		this.getTicket().changeEtat( this.suivant() );
	}

	/* (non-Javadoc)
	 * @see albf.command.etat.EtatTicket#suivant()
	 */
	@Override
	public EtatTicket suivant ()
	{
		return new EtatTicketEnPreparation( this.ticket );
	}
}
