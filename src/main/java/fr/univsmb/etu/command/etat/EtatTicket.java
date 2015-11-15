/**
 *
 */
package fr.univsmb.etu.command.etat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractButton;

import fr.univsmb.etu.command.Ticket;
import fr.univsmb.etu.interfaces.ICliquable;
import fr.univsmb.etu.interfaces.INameable;
import fr.univsmb.etu.interfaces.ITicket;
import fr.univsmb.etu.view.IHMTicket;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public abstract class EtatTicket implements ITicket, INameable, ICliquable
{
	
	/**
	 *
	 */
	protected Ticket	ticket;

	/**
	 *
	 */
	public EtatTicket ( Ticket ticket ) {
		this.setTicket( ticket );
	}

	@Override
	public ActionListener actionClick ( List<Object> args )
	{
		return new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMTicket window = new IHMTicket( EtatTicket.this.getTicket() );
				window.makeAndShow();
			}
		};
	}

	@Override
	public AbstractButton button ()
	{
		return this.getTicket().button();
	}

	/**
	 * @return the ticket
	 */
	public Ticket getTicket ()
	{
		return this.ticket;
	}

	/**
	 * @param ticket
	 *            the ticket to set
	 */
	public void setTicket ( Ticket ticket )
	{
		this.ticket = ticket;
	}

	/**
	 * @return
	 */
	public abstract EtatTicket suivant ();

	@Override
	public String texte ()
	{
		return this.texte( "" );
	}
	
	@Override
	public String texte ( String prefix )
	{
		return "<html><div style=\"text-align:center;\"><p style=\"word-wrap:break-word;\">" + prefix
				+ "</p><p style=\"word-wrap:break-word;\">" + this.getNom() + "</p></div></html>";
	}
}