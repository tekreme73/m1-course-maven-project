/**
 *
 */
package fr.univsmb.etu.category;

import java.util.LinkedList;

import fr.univsmb.etu.command.Commande;
import fr.univsmb.etu.product.EntiteVente;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public abstract class CategorieVente < T extends EntiteVente > extends Categorie<T>
{
	private static final long	serialVersionUID	= 1L;
	
	private Commande			commande;
	
	/**
	 *
	 * @param nom
	 * @param items
	 */
	public CategorieVente ( String nom, LinkedList<T> items ) {
		super( nom, items );
	}
	
	/**
	 *
	 * @param nom
	 * @param items
	 */
	public CategorieVente ( String nom, T[] items ) {
		super( nom, items );
	}
	
	/**
	 *
	 * @param nom
	 * @param items
	 * @param commande
	 */
	public CategorieVente ( String nom, T[] items, Commande commande ) {
		this( nom, items );
		this.setCommande( commande );
	}
	
	/**
	 * @return the commande
	 */
	public Commande getCommande ()
	{
		return this.commande;
	}

	/**
	 *
	 * @param the
	 *            commande
	 */
	public void setCommande ( Commande commande )
	{
		this.commande = commande;
	}

	/**
	 *
	 * @return
	 */
	@SuppressWarnings ( "unchecked" )
	public Categorie<EntiteVente> toCat ()
	{
		return (Categorie<EntiteVente>) this;
	}
}
