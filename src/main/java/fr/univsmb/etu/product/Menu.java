package fr.univsmb.etu.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import fr.univsmb.etu.category.ListeBoissons;
import fr.univsmb.etu.category.ListeDesserts;
import fr.univsmb.etu.category.ListeEntrees;
import fr.univsmb.etu.category.ListePlatsPrincipaux;
import fr.univsmb.etu.command.Commande;
import fr.univsmb.etu.view.IHMCategorie;

/**
 *
 */
public class Menu extends EntiteVente
{
	
	/**
	 *
	 */
	protected ListeBoissons			boissons;

	/**
	 *
	 */
	protected ListeEntrees			entrees;

	/**
	 *
	 */
	protected ListePlatsPrincipaux	platsPrincipaux;

	/**
	 *
	 */
	protected ListeDesserts			desserts;
	
	/**
	 *
	 * @param other
	 */
	public Menu ( Menu other ) {
		this( other.nom, other.prix, other.entrees, other.platsPrincipaux, other.desserts, other.boissons );
	}

	public Menu ( String nom, double prix, ListeEntrees entrees, ListePlatsPrincipaux plats ) {
		this( nom, prix, entrees, plats, ListeDesserts.vide() );
	}

	public Menu ( String nom, double prix, ListeEntrees entrees, ListePlatsPrincipaux plats, ListeBoissons boissons ) {
		this( nom, prix, entrees, plats, ListeDesserts.vide(), boissons );
	}

	public Menu ( String nom, double prix, ListeEntrees entrees, ListePlatsPrincipaux plats, ListeDesserts desserts ) {
		this( nom, prix, entrees, plats, desserts, ListeBoissons.vide() );
	}
	
	public Menu ( String nom, double prix, ListeEntrees entrees, ListePlatsPrincipaux plats, ListeDesserts desserts, ListeBoissons boissons ) {
		super( nom, prix );
		this.setEntrees( entrees );
		this.setPlatsPrincipaux( plats );
		this.setDesserts( desserts );
		this.setBoissons( boissons );
	}

	public Menu ( String nom, double prix, ListePlatsPrincipaux plats ) {
		this( nom, prix, plats, ListeDesserts.vide() );
	}

	public Menu ( String nom, double prix, ListePlatsPrincipaux plats, ListeBoissons boissons ) {
		this( nom, prix, plats, ListeDesserts.vide(), boissons );
	}

	public Menu ( String nom, double prix, ListePlatsPrincipaux plats, ListeDesserts desserts ) {
		this( nom, prix, ListeEntrees.vide(), plats, desserts );
	}
	
	public Menu ( String nom, double prix, ListePlatsPrincipaux plats, ListeDesserts desserts, ListeBoissons boissons ) {
		this( nom, prix, ListeEntrees.vide(), plats, desserts, boissons );
	}

	@Override
	public ItemListener actionCheck ( List<Object> args )
	{
		return new ItemListener() {
			@Override
			public void itemStateChanged ( ItemEvent arg0 )
			{}
		};
	}

	@Override
	public ActionListener actionClick ( final List<Object> args )
	{
		return new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				if ( args.isEmpty() )
				{
					
					final IHMCategorie entrees = new IHMCategorie( Menu.this.getEntrees().toCat() );
					final IHMCategorie plats = new IHMCategorie( Menu.this.getPlatsPrincipaux().toCat() );
					final IHMCategorie desserts = new IHMCategorie( Menu.this.getDesserts().toCat() );
					final IHMCategorie boissons = new IHMCategorie( Menu.this.getBoissons().toCat() );
					
					if ( !Menu.this.getEntrees().isEmpty() )
					{
						entrees.makeAndShow();
						entrees.getItemTerminer().addActionListener( new ActionListener() {

							@Override
							public void actionPerformed ( ActionEvent e )
							{
								entrees.dispose();
								if ( !Menu.this.getPlatsPrincipaux().isEmpty() )
								{
									plats.makeAndShow();
									plats.getItemTerminer().addActionListener( new ActionListener() {

										@Override
										public void actionPerformed ( ActionEvent e )
										{
											plats.dispose();
											if ( !Menu.this.getDesserts().isEmpty() )
											{
												desserts.makeAndShow();
												desserts.getItemTerminer().addActionListener( new ActionListener() {

													@Override
													public void actionPerformed ( ActionEvent e )
													{
														desserts.dispose();
														if ( !Menu.this.getBoissons().isEmpty() )
														{
															boissons.makeAndShow();
															boissons.getItemTerminer().addActionListener( new ActionListener() {

																@Override
																public void actionPerformed ( ActionEvent e )
																{
																	boissons.dispose();
																}
															} );
														}
													}
												} );
											} else if ( !Menu.this.getBoissons().isEmpty() )
											{
												boissons.makeAndShow();
												boissons.getItemTerminer().addActionListener( new ActionListener() {

													@Override
													public void actionPerformed ( ActionEvent e )
													{
														boissons.dispose();
													}
												} );
											}
										}
									} );
								} else if ( !Menu.this.getDesserts().isEmpty() )
								{
									desserts.makeAndShow();
									desserts.getItemTerminer().addActionListener( new ActionListener() {

										@Override
										public void actionPerformed ( ActionEvent e )
										{
											desserts.dispose();
											if ( !Menu.this.getBoissons().isEmpty() )
											{
												boissons.makeAndShow();
												boissons.getItemTerminer().addActionListener( new ActionListener() {

													@Override
													public void actionPerformed ( ActionEvent e )
													{
														boissons.dispose();
													}
												} );
											}
										}
									} );
								} else if ( !Menu.this.getBoissons().isEmpty() )
								{
									boissons.makeAndShow();
									boissons.getItemTerminer().addActionListener( new ActionListener() {

										@Override
										public void actionPerformed ( ActionEvent e )
										{
											boissons.dispose();
										}
									} );
								}
							}
						} );
					} else if ( !Menu.this.getPlatsPrincipaux().isEmpty() )
					{
						plats.makeAndShow();
						plats.getItemTerminer().addActionListener( new ActionListener() {

							@Override
							public void actionPerformed ( ActionEvent e )
							{
								plats.dispose();
								if ( !Menu.this.getDesserts().isEmpty() )
								{
									desserts.makeAndShow();
									desserts.getItemTerminer().addActionListener( new ActionListener() {

										@Override
										public void actionPerformed ( ActionEvent e )
										{
											desserts.dispose();
											if ( !Menu.this.getBoissons().isEmpty() )
											{
												boissons.makeAndShow();
												boissons.getItemTerminer().addActionListener( new ActionListener() {

													@Override
													public void actionPerformed ( ActionEvent e )
													{
														boissons.dispose();
													}
												} );
											}
										}
									} );
								} else if ( !Menu.this.getBoissons().isEmpty() )
								{
									boissons.makeAndShow();
									boissons.getItemTerminer().addActionListener( new ActionListener() {

										@Override
										public void actionPerformed ( ActionEvent e )
										{
											boissons.dispose();
										}
									} );
								}
							}
						} );
					} else if ( !Menu.this.getDesserts().isEmpty() )
					{
						desserts.makeAndShow();
						desserts.getItemTerminer().addActionListener( new ActionListener() {

							@Override
							public void actionPerformed ( ActionEvent e )
							{
								desserts.dispose();
								if ( !Menu.this.getBoissons().isEmpty() )
								{
									boissons.makeAndShow();
									boissons.getItemTerminer().addActionListener( new ActionListener() {

										@Override
										public void actionPerformed ( ActionEvent e )
										{
											boissons.dispose();
										}
									} );
								}
							}
						} );
					} else if ( !Menu.this.getBoissons().isEmpty() )
					{
						boissons.makeAndShow();
						boissons.getItemTerminer().addActionListener( new ActionListener() {

							@Override
							public void actionPerformed ( ActionEvent e )
							{
								boissons.dispose();
							}
						} );
					}
					
				} else
				{
					Commande commande = (Commande) args.get( 0 );
					if ( !Menu.this.getEntrees().isEmpty() )
					{
						commande.ajouterItem( Menu.this.getEntrees().getFirst().clone() );
					}
					if ( !Menu.this.getPlatsPrincipaux().isEmpty() )
					{
						commande.ajouterItem( Menu.this.getPlatsPrincipaux().getFirst().clone() );
					}
					if ( !Menu.this.getDesserts().isEmpty() )
					{
						commande.ajouterItem( Menu.this.getDesserts().getFirst().clone() );
					}
					if ( !Menu.this.getBoissons().isEmpty() )
					{
						commande.ajouterItem( Menu.this.getBoissons().getFirst().clone() );
					}
				}
			}
		};
	}

	@Override
	public EntiteVente clone ()
	{
		return new Menu( this );
	}
	
	/**
	 * @return the boissons
	 */
	public ListeBoissons getBoissons ()
	{
		return this.boissons;
	}

	/**
	 * @return the dessert
	 */
	public ListeDesserts getDesserts ()
	{
		return this.desserts;
	}

	/**
	 * @return the entrees
	 */
	public ListeEntrees getEntrees ()
	{
		return this.entrees;
	}

	/**
	 * @return the platsPrincipaux
	 */
	public ListePlatsPrincipaux getPlatsPrincipaux ()
	{
		return this.platsPrincipaux;
	}

	/**
	 * @param boissons
	 *            the boissons to set
	 */
	public void setBoissons ( ListeBoissons boissons )
	{
		this.boissons = boissons;
	}

	/**
	 * @param dessert
	 *            the dessert to set
	 */
	public void setDesserts ( ListeDesserts desserts )
	{
		this.desserts = desserts;
	}

	/**
	 * @param entrees
	 *            the entrees to set
	 */
	public void setEntrees ( ListeEntrees entrees )
	{
		this.entrees = entrees;
	}
	
	/**
	 * @param platsPrincipaux
	 *            the platsPrincipaux to set
	 */
	public void setPlatsPrincipaux ( ListePlatsPrincipaux platsPrincipaux )
	{
		this.platsPrincipaux = platsPrincipaux;
	}
}