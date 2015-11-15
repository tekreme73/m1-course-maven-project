package fr.univsmb.etu.product;

/**
 *
 */
public abstract class Plat extends Produit
{

	/**
	 *
	 * @param other
	 */
	public Plat ( Plat other ) {
		this( other.nom, other.prix );
	}

	public Plat ( String nom, double prix ) {
		super( nom, prix );
	}
}