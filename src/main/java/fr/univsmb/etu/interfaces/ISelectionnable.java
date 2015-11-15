/**
 *
 */
package fr.univsmb.etu.interfaces;

import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JCheckBox;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public interface ISelectionnable extends INameable
{
	/**
	 *
	 * @return
	 */
	public ItemListener actionCheck ( final List<Object> args );

	/**
	 *
	 * @return
	 */
	public JCheckBox checkbox ();
}
