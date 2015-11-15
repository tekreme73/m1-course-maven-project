/**
 *
 */
package fr.univsmb.etu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.univsmb.etu.personnel.Preparateur;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class PreparateurTest
{
	private Preparateur	preparateur;

	@Before
	public void setUp ()
	{
		this.preparateur = new Preparateur( "Nom", "Prénom" );
	}
	
	@Test
	public void preparateurCanAccessCuisine ()
	{
		Assert.assertTrue( this.preparateur.canAccess( "cuisine" ) );
	}

	@Test
	public void preparateurCantAccessSalleAndComptoir ()
	{
		Assert.assertFalse( this.preparateur.canAccess( "salle" ) );
		Assert.assertFalse( this.preparateur.canAccess( "comptoir" ) );
	}
}
