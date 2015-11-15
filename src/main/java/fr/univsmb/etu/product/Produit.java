/**
 *
 */
package fr.univsmb.etu.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import fr.univsmb.etu.command.Commande;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public abstract class Produit extends EntiteVente
{
	
	protected int	joursAvantPeremption;
	
	/**
	 *
	 * @param other
	 */
	public Produit ( Produit other ) {
		this( other.nom, other.prix );
	}

	/**
	 * @param nom
	 * @param prix
	 */
	public Produit ( String nom, double prix ) {
		this( nom, prix, 4 );
	}

	/**
	 * @param nom
	 * @param prix
	 * @param joursAvantPeremption
	 */
	public Produit ( String nom, double prix, int joursAvantPeremption ) {
		super( nom, prix );
		this.joursAvantPeremption = joursAvantPeremption;
	}

	@Override
	public ItemListener actionCheck ( final List<Object> args )
	{
		return new ItemListener() {
			@SuppressWarnings ( "unchecked" )
			@Override
			public void itemStateChanged ( ItemEvent arg0 )
			{
				if ( !args.isEmpty() )
				{
					List<Produit> list = (List<Produit>) args.get( 0 );
					list.add( Produit.this );
				}
			}
		};
	}

	@Override
	public ActionListener actionClick ( final List<Object> args )
	{
		return new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				if ( !args.isEmpty() )
				{
					Commande commande = (Commande) args.get( 0 );
					commande.ajouterItem( Produit.this.clone() );
				}
			}
		};
	}

	/**
	 * @return the joursAvantPeremption
	 */
	public int getJoursAvantPeremption ()
	{
		return this.joursAvantPeremption;
	}
	
	/**
	 * @param joursAvantPeremption
	 *            the joursAvantPeremption to set
	 */
	public void setJoursAvantPeremption ( int joursAvantPeremption )
	{
		this.joursAvantPeremption = joursAvantPeremption;
	}
}
