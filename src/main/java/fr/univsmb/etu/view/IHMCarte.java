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

import fr.univsmb.etu.Carte;
import fr.univsmb.etu.category.CategorieVente;
import fr.univsmb.etu.product.EntiteVente;

public class IHMCarte extends IHM_Main
{
	private Carte	carte;

	private JButton	btnMenu;
	private JButton	btnMenuJour;
	private JButton	btnEntree;
	private JButton	btnPlatPrincipal;
	private JButton	btnDessert;
	private JButton	btnBoisson;

	/**
	 *
	 * @param carte
	 */
	public IHMCarte ( Carte carte ) {
		super( "Carte" );
		this.setCarte( carte );
	}

	/**
	 * @return the carte
	 */
	public Carte getCarte ()
	{
		return this.carte;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	protected JPanel initialize ()
	{
		JPanel homePanel = new JPanel();
		this.getMainPane().add( homePanel, BorderLayout.CENTER );
		homePanel.setLayout( new GridLayout( 2, 1, 0, 0 ) );
		
		JPanel listeMenuPanel = new JPanel();
		homePanel.add( listeMenuPanel );
		listeMenuPanel.setLayout( new GridLayout( 1, 2, 0, 0 ) );
		
		JPanel menuPanel = new JPanel();
		listeMenuPanel.add( menuPanel );
		menuPanel.setLayout( new GridBagLayout() );
		menuPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnMenu = new JButton( "<html><div style=\"text-align:center;\"><p>MENU</p></div></html>" );
		menuPanel.add( this.btnMenu );
		this.btnMenu.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnMenu.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel menuJourPanel = new JPanel();
		listeMenuPanel.add( menuJourPanel );
		menuJourPanel.setLayout( new GridBagLayout() );
		menuJourPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnMenuJour = new JButton( "<html><div style=\"text-align:center;\"><p>MENU DU</p><p>JOUR</p></div></html>" );
		menuJourPanel.add( this.btnMenuJour );
		this.btnMenuJour.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnMenuJour.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel listePlatPanel = new JPanel();
		homePanel.add( listePlatPanel );
		listePlatPanel.setLayout( new GridLayout( 1, 4, 0, 0 ) );
		
		JPanel entreePanel = new JPanel();
		listePlatPanel.add( entreePanel );
		entreePanel.setLayout( new GridBagLayout() );
		entreePanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnEntree = new JButton( "<html><div style=\"text-align:center;\"><p>ENTRÉE</p></div></html>" );
		entreePanel.add( this.btnEntree );
		this.btnEntree.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnEntree.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel platPrincipalPanel = new JPanel();
		listePlatPanel.add( platPrincipalPanel );
		platPrincipalPanel.setLayout( new GridBagLayout() );
		platPrincipalPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnPlatPrincipal = new JButton( "<html><div style=\"text-align:center;\"><p>PLAT</p><p>PRINCIPAL</p></div></html>" );
		platPrincipalPanel.add( this.btnPlatPrincipal );
		this.btnPlatPrincipal.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnPlatPrincipal.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel dessertPanel = new JPanel();
		listePlatPanel.add( dessertPanel );
		dessertPanel.setLayout( new GridBagLayout() );
		dessertPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnDessert = new JButton( "<html><div style=\"text-align:center;\"><p>DESSERT</p></div></html>" );
		dessertPanel.add( this.btnDessert );
		this.btnDessert.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnDessert.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		JPanel boissonPanel = new JPanel();
		listePlatPanel.add( boissonPanel );
		boissonPanel.setLayout( new GridBagLayout() );
		boissonPanel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		
		this.btnBoisson = new JButton( "<html><div style=\"text-align:center;\"><p>BOISSON</p></div></html>" );
		boissonPanel.add( this.btnBoisson );
		this.btnBoisson.setPreferredSize( new Dimension( 200, 200 ) );
		this.btnBoisson.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		
		return homePanel;
	}
	
	@Override
	protected void initializeListeners ()
	{
		this.btnMenu.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMCarte.this.carte.ouvrirCategorie( (CategorieVente<EntiteVente>) IHMCarte.this.carte.getListeMenus().toCat() )
				.makeAndShow();
			}
		} );
		this.btnMenuJour.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMCarte.this.carte.ouvrirCategorie( (CategorieVente<EntiteVente>) IHMCarte.this.carte.getListeMenusJ().toCat() )
				.makeAndShow();
			}
		} );
		
		this.btnEntree.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMCarte.this.carte.consulterCategorie( IHMCarte.this.carte.getListeEntrees().toCat() ).makeAndShow();
			}
		} );
		this.btnPlatPrincipal.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMCarte.this.carte.consulterCategorie( IHMCarte.this.carte.getListePlatsPrincipaux().toCat() ).makeAndShow();
			}
		} );
		this.btnDessert.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMCarte.this.carte.consulterCategorie( IHMCarte.this.carte.getListeDesserts().toCat() ).makeAndShow();
			}
		} );
		this.btnBoisson.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMCarte.this.carte.consulterCategorie( IHMCarte.this.carte.getListeBoissons().toCat() ).makeAndShow();
			}
		} );
		
	}
	
	/**
	 * @param carte
	 *            the carte to set
	 */
	public void setCarte ( Carte carte )
	{
		this.carte = carte;
	}
}
