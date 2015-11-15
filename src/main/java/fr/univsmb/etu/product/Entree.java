package fr.univsmb.etu.product;

/**
 *
 */
public class Entree extends Plat
{
	
	/**
	 *
	 * @param other
	 */
	public Entree ( Entree other ) {
		this( other.nom, other.prix );
	}

	/**
	 *
	 */
	public Entree ( String nom, double prix ) {
		super( nom, prix );
	}
	
	@Override
	public EntiteVente clone ()
	{
		return new Entree( this );
	}
}