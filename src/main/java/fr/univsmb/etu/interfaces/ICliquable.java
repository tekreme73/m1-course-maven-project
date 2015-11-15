/**
 *
 */
package fr.univsmb.etu.interfaces;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractButton;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public interface ICliquable extends INameable
{
	/**
	 *
	 * @return
	 */
	public ActionListener actionClick ( final List<Object> args );

	/**
	 *
	 * @return
	 */
	public AbstractButton button ();
}
