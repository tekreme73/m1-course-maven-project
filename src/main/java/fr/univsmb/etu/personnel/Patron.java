/**
 *
 */
package fr.univsmb.etu.personnel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class Patron extends Employe
{
	
	/**
	 * @param nom
	 * @param prenom
	 */
	public Patron ( String nom, String prenom ) {
		super( nom, prenom );
	}
	
	@Override
	public List<String> getPermissions ()
	{
		ArrayList<String> permissions = new ArrayList<String>();
		permissions.add( "salle" );
		permissions.add( "carte" );
		permissions.add( "caisse" );
		permissions.add( "cuisine" );
		permissions.add( "comptoir" );
		permissions.add( "personnel" );
		return permissions;
	}
}
