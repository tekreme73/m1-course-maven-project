package fr.univsmb.etu.product;

/**
 *
 */
public class Dessert extends Plat
{
	
	/**
	 *
	 * @param other
	 */
	public Dessert ( Dessert other ) {
		this( other.nom, other.prix );
	}

	/**
	 *
	 */
	public Dessert ( String nom, double prix ) {
		super( nom, prix );
	}
	
	@Override
	public EntiteVente clone ()
	{
		return new Dessert( this );
	}
}