package fr.univsmb.etu.category;

import fr.univsmb.etu.product.Entree;
import fr.univsmb.etu.view.IHMCategorie;
import fr.univsmb.etu.view.IHM_Main;

/**
 *
 */
public class ListeEntrees extends CategorieVente<Entree>
{

	private static final long	serialVersionUID	= 1L;
	
	public static ListeEntrees vide ()
	{
		ListeEntrees l = new ListeEntrees();
		l.clear();
		return l;
	}
	
	/**
	 *
	 */
	public ListeEntrees () {
		this( new Entree( "Salade", 3.40 ), new Entree( "Oeufs mayonnaise", 2.60 ), new Entree( "Prairie de l'escargot", 5.10 ),
				new Entree( "Tomates mozzarella", 3.80 ) );
	}

	public ListeEntrees ( Entree... entrees ) {
		super( "Entrées", entrees );
	}

	@Override
	public IHM_Main consulter ()
	{
		return new IHMCategorie( this );
	}
}