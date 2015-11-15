/**
 * 
 */
package fr.univsmb.etu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.univsmb.etu.command.Ticket;
import fr.univsmb.etu.command.etat.EtatTicketClos;
import fr.univsmb.etu.command.etat.EtatTicketEnPreparation;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class TicketTest
{
	
	private Ticket ticket;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp () throws Exception
	{
		this.ticket = new Ticket();
		this.ticket.setCuisine( new Cuisine() );
	}
	
	@Test
	public void ticketHasToBeCloseOnlyByEnPreparation ()
	{
		this.ticket.cloturer();
		Assert.assertFalse( this.ticket.getEtat() instanceof EtatTicketClos );
		
		this.ticket.changeEtat( new EtatTicketEnPreparation( this.ticket ) );
		this.ticket.cloturer();
		Assert.assertTrue( this.ticket.getEtat() instanceof EtatTicketClos );
	}
}
