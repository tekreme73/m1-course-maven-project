package fr.univsmb.etu.category;

import java.util.LinkedList;

import fr.univsmb.etu.interfaces.ICategorisable;
import fr.univsmb.etu.interfaces.ICliquable;
import fr.univsmb.etu.interfaces.IDisplayable;
import fr.univsmb.etu.interfaces.ISelectionnable;
import fr.univsmb.etu.view.IHM_Main;

public abstract class Categorie < T > extends LinkedList<T> implements ICategorisable<T>
{

	private static final long	serialVersionUID	= 1L;

	private String				nom;

	/**
	 *
	 * @param nom
	 * @param items
	 */
	public Categorie ( String nom, LinkedList<T> items ) {
		this.nom = nom;
		for ( T item : items )
		{
			this.add( item );
		}
	}
	
	/**
	 *
	 * @param nom
	 * @param items
	 */
	public Categorie ( String nom, T[] items ) {
		this.nom = nom;
		for ( T item : items )
		{
			this.add( item );
		}
	}

	public abstract IHM_Main consulter ();

	/**
	 * @return the name
	 */
	@Override
	public String getNom ()
	{
		return this.nom;
	}

	@SuppressWarnings ( "unchecked" )
	@Override
	public LinkedList<ICliquable> recupererCliquable ()
	{
		return (LinkedList<ICliquable>) this;
	}
	
	@SuppressWarnings ( "unchecked" )
	@Override
	public LinkedList<IDisplayable> recupererDescription ()
	{
		return (LinkedList<IDisplayable>) this;
	}
	
	@Override
	public LinkedList<T> recupererListe ()
	{
		return this;
	}
	
	@SuppressWarnings ( "unchecked" )
	@Override
	public LinkedList<ISelectionnable> recupererSelectionnable ()
	{
		return (LinkedList<ISelectionnable>) this;
	}
	
	/**
	 * @param name
	 *            the name to set
	 */
	public void setNom ( String nom )
	{
		this.nom = nom;
	}
	
	@Override
	public String texte ()
	{
		return this.texte( "" );
	}
	
	@Override
	public String texte ( String prefix )
	{
		return "<html><div style=\"text-align:center;\"><p style=\"word-wrap:break-word;\">" + prefix + this.getNom() + "</p></div></html>";
	}
}
