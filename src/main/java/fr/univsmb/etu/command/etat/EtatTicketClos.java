/**
 *
 */
package fr.univsmb.etu.command.etat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import fr.univsmb.etu.Cuisine;
import fr.univsmb.etu.command.Ticket;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class EtatTicketClos extends EtatTicket
{
	
	/**
	 * @param ticket
	 */
	public EtatTicketClos ( Ticket ticket ) {
		super( ticket );
	}
	
	@Override
	public ActionListener actionClick ( List<Object> args )
	{
		return new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				EtatTicketClos.this.getTicket().annoter();
			}
		};
	}
	
	/* (non-Javadoc)
	 * @see albf.interfaces.ITicket#annoter()
	 */
	@Override
	public void annoter ()
	{
		this.getTicket().getCuisine().retirerTicket( this.getTicket() );
		this.getTicket().changeEtat( this.suivant() );
	}
	
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
		return "Clos";
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
		return new EtatTicketAnnote( this.ticket );
	}
}
