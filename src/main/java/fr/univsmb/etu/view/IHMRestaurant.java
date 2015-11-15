package fr.univsmb.etu.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.univsmb.etu.Restaurant;

public class IHMRestaurant extends IHM_Main
{
	/**
	 * Launch the application.
	 */
	public static void main ( String[] args )
	{
		EventQueue.invokeLater( new Runnable() {
			@Override
			public void run ()
			{
				try
				{
					IHMConnexion connexion = new IHMConnexion( new Restaurant() );
					connexion.makeAndShow();
				} catch ( Exception e )
				{
					e.printStackTrace();
				}
			}
		} );
	}

	private Restaurant	restaurant;

	private JButton		btnConsulterCarte;
	private JButton		btnConsulterSalle;
	private JButton		btnConsulterPersonnel;
	private JButton		btnConsulterCuisine;
	private JButton		btnConsulterComptoir;
	private JButton		btnConsulterCaisse;
	private JButton		btnQuitter;

	/**
	 * Create the application.
	 */
	public IHMRestaurant ( Restaurant restaurant ) {
		super( "Accueil - Bonjour " + Restaurant.getUtilisateur().getPrenom() );
		this.setRestaurant( restaurant );
	}
	
	/**
	 * @return the restaurant
	 */
	public Restaurant getRestaurant ()
	{
		return this.restaurant;
	}
	
	@Override
	protected JPanel initialize ()
	{
		JPanel homePanel = new JPanel();
		this.getMainPane().add( homePanel, BorderLayout.CENTER );
		homePanel.setLayout( new GridLayout( 1, 1, 0, 0 ) );
		
		JPanel listeActionPanel = new JPanel();
		homePanel.add( listeActionPanel );
		listeActionPanel.setLayout( new GridLayout( 2, 3, 0, 0 ) );
		
		JPanel consulterCartePanel = new JPanel();
		listeActionPanel.add( consulterCartePanel );
		consulterCartePanel.setLayout( new GridBagLayout() );
		consulterCartePanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnConsulterCarte = new JButton( "<html><div style=\"text-align:center;\"><p>CONSULTER</p><p>CARTE</p></div></html>" );
		consulterCartePanel.add( this.btnConsulterCarte );
		this.btnConsulterCarte.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnConsulterCarte.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel consulterSallePanel = new JPanel();
		listeActionPanel.add( consulterSallePanel );
		consulterSallePanel.setLayout( new GridBagLayout() );
		consulterSallePanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnConsulterSalle = new JButton( "<html><div style=\"text-align:center;\"><p>CONSULTER</p><p>SALLE</p></div></html>" );
		consulterSallePanel.add( this.btnConsulterSalle );
		this.btnConsulterSalle.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnConsulterSalle.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel consulterPersonnelPanel = new JPanel();
		listeActionPanel.add( consulterPersonnelPanel );
		consulterPersonnelPanel.setLayout( new GridBagLayout() );
		consulterPersonnelPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnConsulterPersonnel = new JButton( "<html><div style=\"text-align:center;\"><p>CONSULTER</p><p>PERSONNEL</p></div></html>" );
		consulterPersonnelPanel.add( this.btnConsulterPersonnel );
		this.btnConsulterPersonnel.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnConsulterPersonnel.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel consulterCuisinePanel = new JPanel();
		listeActionPanel.add( consulterCuisinePanel );
		consulterCuisinePanel.setLayout( new GridBagLayout() );
		consulterCuisinePanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnConsulterCuisine = new JButton( "<html><div style=\"text-align:center;\"><p>CONSULTER</p><p>CUISINE</p></div></html>" );
		consulterCuisinePanel.add( this.btnConsulterCuisine );
		this.btnConsulterCuisine.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnConsulterCuisine.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel consulterComptoirPanel = new JPanel();
		listeActionPanel.add( consulterComptoirPanel );
		consulterComptoirPanel.setLayout( new GridBagLayout() );
		consulterComptoirPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnConsulterComptoir = new JButton( "<html><div style=\"text-align:center;\"><p>CONSULTER</p><p>COMPTOIR</p></div></html>" );
		consulterComptoirPanel.add( this.btnConsulterComptoir );
		this.btnConsulterComptoir.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnConsulterComptoir.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel consulterCaissePanel = new JPanel();
		listeActionPanel.add( consulterCaissePanel );
		consulterCaissePanel.setLayout( new GridBagLayout() );
		consulterCaissePanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnConsulterCaisse = new JButton( "<html><div style=\"text-align:center;\"><p>CONSULTER</p><p>CAISSE</p></div></html>" );
		consulterCaissePanel.add( this.btnConsulterCaisse );
		this.btnConsulterCaisse.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnConsulterCaisse.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel quitterPanel = new JPanel();
		listeActionPanel.add( quitterPanel );
		quitterPanel.setLayout( new GridBagLayout() );
		quitterPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnQuitter = new JButton( "<html><div style=\"text-align:center;\"><p>QUITTER</p></div></html>" );
		quitterPanel.add( this.btnQuitter );
		this.btnQuitter.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnQuitter.setFont( new Font( "Verdana", Font.BOLD, 24 ) );

		this.updateWithPermissions();

		return homePanel;
	}

	@Override
	protected void initializeListeners ()
	{
		this.btnConsulterCarte.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMRestaurant.this.getRestaurant().consulterCarte();
			}
		} );
		this.btnConsulterSalle.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMRestaurant.this.getRestaurant().consulterSalle();
			}
		} );
		this.btnConsulterPersonnel.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMRestaurant.this.getRestaurant().consulterPersonnel();
			}
		} );
		this.btnConsulterCuisine.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMRestaurant.this.getRestaurant().consulterCuisine();
			}
		} );
		this.btnConsulterComptoir.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMRestaurant.this.getRestaurant().consulterComptoir();
			}
		} );
		this.btnConsulterCaisse.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMRestaurant.this.getRestaurant().consulterCaisse();
			}
		} );
		this.btnQuitter.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				System.out.println( "Application fermée" );
				System.exit( 1 );
			}
		} );
	}
	
	/**
	 * @param restaurant
	 *            the restaurant to set
	 */
	public void setRestaurant ( Restaurant restaurant )
	{
		this.restaurant = restaurant;
	}
	
	private void updateWithPermissions ()
	{
		this.btnConsulterCarte.setEnabled( Restaurant.getUtilisateur().canAccess( "carte" ) );
		this.btnConsulterCaisse.setEnabled( Restaurant.getUtilisateur().canAccess( "caisse" ) );
		this.btnConsulterComptoir.setEnabled( Restaurant.getUtilisateur().canAccess( "comptoir" ) );
		this.btnConsulterCuisine.setEnabled( Restaurant.getUtilisateur().canAccess( "cuisine" ) );
		this.btnConsulterPersonnel.setEnabled( Restaurant.getUtilisateur().canAccess( "personnel" ) );
		this.btnConsulterSalle.setEnabled( Restaurant.getUtilisateur().canAccess( "salle" ) );
	}
}
