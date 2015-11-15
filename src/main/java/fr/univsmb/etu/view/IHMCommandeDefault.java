package fr.univsmb.etu.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.univsmb.etu.category.CategorieVente;
import fr.univsmb.etu.command.Table;
import fr.univsmb.etu.product.EntiteVente;

public class IHMCommandeDefault extends IHMCommande
{
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
	public IHMCommandeDefault ( Table table ) {
		super( table );
		this.setCartePanel( this.create() );
	}
	
	protected JPanel create ()
	{
		JPanel cartePanel = new JPanel();
		cartePanel.setLayout( new GridLayout( 2, 1, 0, 0 ) );
		
		JPanel listeMenuPanel = new JPanel();
		cartePanel.add( listeMenuPanel );
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
		cartePanel.add( listePlatPanel );
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

		return cartePanel;
	}
	
	@Override
	protected void initializeListeners ()
	{
		this.btnMenu.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHM_Main carte_ihm = IHMCommandeDefault.this
						.getTable()
						.getCarte()
						.ouvrirCategorie(
								(CategorieVente<EntiteVente>) IHMCommandeDefault.this.getTable().getCarte().getListeMenus().toCat(),
								IHMCommandeDefault.this.getTable().getCommande() );
				carte_ihm.setInQueue( false );
				carte_ihm.make();
				carte_ihm.getContent().setSize( IHMCommandeDefault.this.splitPane.getLeftComponent().getSize() );
				carte_ihm.getContent().setPreferredSize( IHMCommandeDefault.this.splitPane.getLeftComponent().getSize() );

				IHMCommande window = IHMCommandeDefault.this.changeCartePanel( carte_ihm.getContent() );
				window.makeAndShow();
			}
		} );
		this.btnMenuJour.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHM_Main carte_ihm = IHMCommandeDefault.this
						.getTable()
						.getCarte()
						.ouvrirCategorie(
								(CategorieVente<EntiteVente>) IHMCommandeDefault.this.getTable().getCarte().getListeMenusJ().toCat(),
								IHMCommandeDefault.this.getTable().getCommande() );
				carte_ihm.setInQueue( false );
				carte_ihm.make();
				carte_ihm.getContent().setSize( IHMCommandeDefault.this.splitPane.getLeftComponent().getSize() );
				carte_ihm.getContent().setPreferredSize( IHMCommandeDefault.this.splitPane.getLeftComponent().getSize() );

				IHMCommande window = IHMCommandeDefault.this.changeCartePanel( carte_ihm.getContent() );
				window.makeAndShow();
			}
		} );
		
		this.btnEntree.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHM_Main carte_ihm = IHMCommandeDefault.this
						.getTable()
						.getCarte()
						.ouvrirCategorie(
								(CategorieVente<EntiteVente>) IHMCommandeDefault.this.getTable().getCarte().getListeEntrees().toCat(),
								IHMCommandeDefault.this.getTable().getCommande() );
				carte_ihm.setInQueue( false );
				carte_ihm.make();
				carte_ihm.getContent().setSize( IHMCommandeDefault.this.splitPane.getLeftComponent().getSize() );
				carte_ihm.getContent().setPreferredSize( IHMCommandeDefault.this.splitPane.getLeftComponent().getSize() );

				IHMCommande window = IHMCommandeDefault.this.changeCartePanel( carte_ihm.getContent() );
				window.makeAndShow();
			}
		} );
		this.btnPlatPrincipal.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHM_Main carte_ihm = IHMCommandeDefault.this
						.getTable()
						.getCarte()
						.ouvrirCategorie(
								(CategorieVente<EntiteVente>) IHMCommandeDefault.this.getTable().getCarte().getListePlatsPrincipaux()
								.toCat(), IHMCommandeDefault.this.getTable().getCommande() );
				carte_ihm.setInQueue( false );
				carte_ihm.make();
				carte_ihm.getContent().setSize( IHMCommandeDefault.this.splitPane.getLeftComponent().getSize() );
				carte_ihm.getContent().setPreferredSize( IHMCommandeDefault.this.splitPane.getLeftComponent().getSize() );

				IHMCommande window = IHMCommandeDefault.this.changeCartePanel( carte_ihm.getContent() );
				window.makeAndShow();
			}
		} );
		this.btnDessert.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHM_Main carte_ihm = IHMCommandeDefault.this
						.getTable()
						.getCarte()
						.ouvrirCategorie(
								(CategorieVente<EntiteVente>) IHMCommandeDefault.this.getTable().getCarte().getListeDesserts().toCat(),
								IHMCommandeDefault.this.getTable().getCommande() );
				carte_ihm.setInQueue( false );
				carte_ihm.make();
				carte_ihm.getContent().setSize( IHMCommandeDefault.this.splitPane.getLeftComponent().getSize() );
				carte_ihm.getContent().setPreferredSize( IHMCommandeDefault.this.splitPane.getLeftComponent().getSize() );

				IHMCommande window = IHMCommandeDefault.this.changeCartePanel( carte_ihm.getContent() );
				window.makeAndShow();
			}
		} );
		this.btnBoisson.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHM_Main carte_ihm = IHMCommandeDefault.this
						.getTable()
						.getCarte()
						.ouvrirCategorie(
								(CategorieVente<EntiteVente>) IHMCommandeDefault.this.getTable().getCarte().getListeBoissons().toCat(),
								IHMCommandeDefault.this.getTable().getCommande() );
				carte_ihm.setInQueue( false );
				carte_ihm.make();
				carte_ihm.getContent().setSize( IHMCommandeDefault.this.splitPane.getLeftComponent().getSize() );
				carte_ihm.getContent().setPreferredSize( IHMCommandeDefault.this.splitPane.getLeftComponent().getSize() );

				IHMCommande window = IHMCommandeDefault.this.changeCartePanel( carte_ihm.getContent() );
				window.makeAndShow();
			}
		} );
		
	}
}
