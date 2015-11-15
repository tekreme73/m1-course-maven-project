package fr.univsmb.etu.interfaces;

import fr.univsmb.etu.Cuisine;

public interface ITicket
{
	/**
	 *
	 */
	public void annoter ();
	
	/**
	 *
	 */
	public void cloturer ();
	
	/**
	 *
	 * @param cuisine
	 */
	public void envoyer ( final Cuisine cuisine );
	
	/**
	 *
	 */
	public void preparer ();
}
