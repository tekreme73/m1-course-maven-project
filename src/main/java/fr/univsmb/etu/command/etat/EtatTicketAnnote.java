/**
 *
 */
package fr.univsmb.etu.command.etat;

import java.awt.event.ActionListener;
import java.util.List;

import fr.univsmb.etu.Cuisine;
import fr.univsmb.etu.command.Ticket;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class EtatTicketAnnote extends EtatTicket
{
	
	/**
	 * @param ticket
	 */
	public EtatTicketAnnote ( Ticket ticket ) {
		super( ticket );
	}
	
	@Override
	public ActionListener actionClick ( List<Object> args )
	{
		return null;
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
		return "Annoté";
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
		return null;
	}
}
