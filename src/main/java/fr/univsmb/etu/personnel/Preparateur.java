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
public class Preparateur extends Employe
{

	/**
	 * @param nom
	 * @param prenom
	 */
	public Preparateur ( String nom, String prenom ) {
		super( nom, prenom );
	}
	
	@Override
	public List<String> getPermissions ()
	{
		ArrayList<String> permissions = new ArrayList<String>();
		permissions.add( "cuisine" );
		return permissions;
	}
}
