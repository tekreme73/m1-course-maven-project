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
public class EtatTicketAEnvoyer extends EtatTicket
{
	
	/**
	 * @param ticket
	 */
	public EtatTicketAEnvoyer ( Ticket ticket ) {
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
	{
		this.getTicket().setCuisine( cuisine );
		this.getTicket().getCuisine().ajouterTicket( this.getTicket() );
		this.getTicket().changeEtat( this.suivant() );
	}

	@Override
	public String getNom ()
	{
		return "A Envoyer";
	}

	@Override
	public void preparer ()
	{}

	/* (non-Javadoc)
	 * @see albf.command.etat.EtatTicket#suivant()
	 */
	@Override
	public EtatTicket suivant ()
	{
		return new EtatTicketEnCours( this.ticket );
	}
}
