package fr.univsmb.etu.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.univsmb.etu.category.CategorieEntite;
import fr.univsmb.etu.command.Table;

public class IHMTable extends IHM_Main
{
	private Table	table;
	
	private JButton	btnCreerCommande;
	private JButton	btnConsulterCommande;
	private JButton	btnEnvoyerTicket;
	private JButton	btnTerminerCommande;
	private JButton	btnSupprimerCommande;

	/**
	 * Create the application.
	 */
	public IHMTable ( Table table ) {
		super( table.getNom() );
		this.setTable( table );
	}

	/**
	 * @return the table
	 */
	public Table getTable ()
	{
		return this.table;
	}

	@Override
	protected JPanel initialize ()
	{
		JPanel homePanel = new JPanel();
		this.getMainPane().add( homePanel, BorderLayout.CENTER );
		homePanel.setLayout( new GridLayout( 2, 2, 0, 0 ) );
		
		JPanel creerCommandePanel = new JPanel();
		homePanel.add( creerCommandePanel );
		creerCommandePanel.setLayout( new GridBagLayout() );
		creerCommandePanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnCreerCommande = new JButton( "<html><div style=\"text-align:center;\"><p>CREER</p><p>COMMANDE</p></div></html>" );
		creerCommandePanel.add( this.btnCreerCommande );
		this.btnCreerCommande.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnCreerCommande.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel consulterCommandePanel = new JPanel();
		homePanel.add( consulterCommandePanel );
		consulterCommandePanel.setLayout( new GridBagLayout() );
		consulterCommandePanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnConsulterCommande = new JButton( "<html><div style=\"text-align:center;\"><p>CONSULTER</p><p>COMMANDE</p></div></html>" );
		consulterCommandePanel.add( this.btnConsulterCommande );
		this.btnConsulterCommande.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnConsulterCommande.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel envoyerTicketPanel = new JPanel();
		homePanel.add( envoyerTicketPanel );
		envoyerTicketPanel.setLayout( new GridBagLayout() );
		envoyerTicketPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnEnvoyerTicket = new JButton( "<html><div style=\"text-align:center;\"><p>ENVOYER</p><p>TICKET SUIVANT</p></div></html>" );
		envoyerTicketPanel.add( this.btnEnvoyerTicket );
		this.btnEnvoyerTicket.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnEnvoyerTicket.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel terminerCommandePanel = new JPanel();
		homePanel.add( terminerCommandePanel );
		terminerCommandePanel.setLayout( new GridBagLayout() );
		terminerCommandePanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnTerminerCommande = new JButton( "<html><div style=\"text-align:center;\"><p>TERMINER</p><p>COMMANDE</p></div></html>" );
		terminerCommandePanel.add( this.btnTerminerCommande );
		this.btnTerminerCommande.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnTerminerCommande.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel supprimerCommandePanel = new JPanel();
		homePanel.add( supprimerCommandePanel );
		supprimerCommandePanel.setLayout( new GridBagLayout() );
		supprimerCommandePanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnSupprimerCommande = new JButton( "<html><div style=\"text-align:center;\"><p>SUPPRIMER</p><p>COMMANDE</p></div></html>" );
		supprimerCommandePanel.add( this.btnSupprimerCommande );
		this.btnSupprimerCommande.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnSupprimerCommande.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		this.redraw();
		
		return homePanel;
	}

	@Override
	protected void initializeListeners ()
	{
		this.btnCreerCommande.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMTable.this.getTable().creerCommande();
				IHMTable.this.redraw();
			}
		} );
		this.btnConsulterCommande.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				if ( IHMTable.this.getTable().getCommande().getItems().isEmpty() )
				{
					System.out.println( "[Commande vide]" );
					IHMTable.this.getTable().supprimerCommande();
					IHMTable.this.redraw();
				} else
				{
					CategorieEntite cat = new CategorieEntite( "Éléments", IHMTable.this.getTable().getCommande().getItems() );

					IHMCategorie window = new IHMCategorie( cat );
					window.makeAndShow();
				}
			}
		} );
		this.btnEnvoyerTicket.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				if ( IHMTable.this.getTable().getCommande().getItems().isEmpty() )
				{
					System.out.println( "[Commande vide]" );
					IHMTable.this.getTable().supprimerCommande();
				} else if ( IHMTable.this.getTable().getCommande().getAvailableItems().isEmpty() )
				{
					System.out.println( "[Plus aucun produit à envoyer]" );
				} else
				{
					IHMTable.this.getTable().getCommande().envoyerTicket();
				}
			}
		} );
		this.btnTerminerCommande.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				if ( !IHMTable.this.getTable().getCommande().getAvailableItems().isEmpty() )
				{
					System.out.println( "Attention, il reste des plats à envoyer en cuisine !" );
				}
				IHMTable.this.getTable().terminerRepas();
			}
		} );
		this.btnSupprimerCommande.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMTable.this.getTable().supprimerCommande();
				IHMTable.this.redraw();
			}
		} );
	}

	/**
	 * @param table
	 *            the table to set
	 */
	public void setTable ( Table table )
	{
		this.table = table;
	}

	/* (non-Javadoc)
	 * @see albf.view.IHM_Main#update()
	 */
	@Override
	protected void update ()
	{
		this.btnCreerCommande.setEnabled( !this.getTable().hasCommande() );
		this.btnConsulterCommande.setEnabled( this.getTable().hasCommande() );
		this.btnEnvoyerTicket.setEnabled( this.getTable().hasCommande() );
		this.btnTerminerCommande.setEnabled( this.getTable().hasCommande() );
		this.btnSupprimerCommande.setEnabled( this.getTable().hasCommande() );

		this.btnCreerCommande.setFocusPainted( false );
		this.btnConsulterCommande.setFocusPainted( false );
		this.btnEnvoyerTicket.setFocusPainted( false );
		this.btnSupprimerCommande.setFocusPainted( false );
		this.btnTerminerCommande.setFocusPainted( false );
	}
}
