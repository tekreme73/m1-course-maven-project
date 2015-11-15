package fr.univsmb.etu.product;

/**
 *
 */
public class PlatPrincipal extends Plat
{
	
	/**
	 *
	 * @param other
	 */
	public PlatPrincipal ( PlatPrincipal other ) {
		this( other.nom, other.prix );
	}

	/**
	 *
	 */
	public PlatPrincipal ( String nom, double prix ) {
		super( nom, prix );
	}
	
	@Override
	public EntiteVente clone ()
	{
		return new PlatPrincipal( this );
	}
}