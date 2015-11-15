package fr.univsmb.etu.category;

import fr.univsmb.etu.product.Boisson;
import fr.univsmb.etu.view.IHMCategorie;
import fr.univsmb.etu.view.IHM_Main;

/**
 *
 */
public class ListeBoissons extends CategorieVente<Boisson>
{

	private static final long	serialVersionUID	= 1L;
	
	public static ListeBoissons vide ()
	{
		ListeBoissons l = new ListeBoissons();
		l.clear();
		return l;
	}
	
	/**
	 *
	 */
	public ListeBoissons () {
		this( new Boisson( "Coca-cola", 0.80, "33cL" ), new Boisson( "Orangina", 0.80, "33cL" ), new Boisson( "Sirop", 0.60, "60cL" ),
				new Boisson( "Cidre", 1.20, "50cL" ), new Boisson( "Eau", 0, "1L" ) );
	}

	public ListeBoissons ( Boisson... boissons ) {
		super( "Boissons", boissons );
	}

	@Override
	public IHM_Main consulter ()
	{
		return new IHMCategorie( this );
	}
}