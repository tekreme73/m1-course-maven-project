package fr.univsmb.etu.interfaces;

import java.util.LinkedList;

/**
 * @param <T>
 *
 */
public interface ICategorisable < T > extends INameable
{
	public LinkedList<ICliquable> recupererCliquable ();

	public LinkedList<IDisplayable> recupererDescription ();

	/**
	 *
	 * @return
	 */
	public LinkedList<T> recupererListe ();
	
	public LinkedList<ISelectionnable> recupererSelectionnable ();
}