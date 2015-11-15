/**
 *
 */
package fr.univsmb.etu.interfaces;

import java.util.List;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public interface IAuthorizable
{
	public boolean canAccess ( final String permission );

	public List<String> getPermissions ();
}
