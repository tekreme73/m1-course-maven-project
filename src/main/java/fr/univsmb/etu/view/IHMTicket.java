package fr.univsmb.etu.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.univsmb.etu.category.CategorieEntite;
import fr.univsmb.etu.command.Ticket;
import fr.univsmb.etu.product.EntiteVente;

public class IHMTicket extends IHM_Main
{
	private Ticket	ticket;
	
	private JButton	btnConsulterTicket;
	private JButton	btnPreparerTicket;
	private JButton	btnCloturerTicket;

	/**
	 * Create the application.
	 */
	public IHMTicket ( Ticket ticket ) {
		super( ticket.getNom() );
		this.setTicket( ticket );
	}

	/**
	 * @return the ticket
	 */
	public Ticket getTicket ()
	{
		return this.ticket;
	}

	@Override
	protected JPanel initialize ()
	{
		JPanel homePanel = new JPanel();
		this.getMainPane().add( homePanel, BorderLayout.CENTER );
		homePanel.setLayout( new GridLayout( 1, 3, 0, 0 ) );
		
		JPanel consulterTicketPanel = new JPanel();
		homePanel.add( consulterTicketPanel );
		consulterTicketPanel.setLayout( new GridBagLayout() );
		consulterTicketPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnConsulterTicket = new JButton( "<html><div style=\"text-align:center;\"><p>CONSULTER</p><p>TICKET</p></div></html>" );
		consulterTicketPanel.add( this.btnConsulterTicket );
		this.btnConsulterTicket.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnConsulterTicket.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel preparerTicketPanel = new JPanel();
		homePanel.add( preparerTicketPanel );
		preparerTicketPanel.setLayout( new GridBagLayout() );
		preparerTicketPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnPreparerTicket = new JButton( "<html><div style=\"text-align:center;\"><p>PREPARER</p><p>TICKET</p></div></html>" );
		preparerTicketPanel.add( this.btnPreparerTicket );
		this.btnPreparerTicket.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnPreparerTicket.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel cloturerTicketPanel = new JPanel();
		homePanel.add( cloturerTicketPanel );
		cloturerTicketPanel.setLayout( new GridBagLayout() );
		cloturerTicketPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnCloturerTicket = new JButton( "<html><div style=\"text-align:center;\"><p>CLOTURER</p><p>TICKET</p></div></html>" );
		cloturerTicketPanel.add( this.btnCloturerTicket );
		this.btnCloturerTicket.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnCloturerTicket.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		return homePanel;
	}

	@Override
	protected void initializeListeners ()
	{
		this.btnConsulterTicket.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMCategorie window = new IHMCategorie( new CategorieEntite( "Produits à préparer", new LinkedList<EntiteVente>(
						IHMTicket.this.ticket.getProduitsAPreparer() ) ) );
				window.makeAndShow();
			}
		} );
		this.btnPreparerTicket.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMTicket.this.ticket.preparer();
			}
		} );
		this.btnCloturerTicket.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMTicket.this.ticket.cloturer();
			}
		} );
	}

	/**
	 * @param ticket
	 *            the ticket to set
	 */
	public void setTicket ( Ticket ticket )
	{
		this.ticket = ticket;
	}
}
