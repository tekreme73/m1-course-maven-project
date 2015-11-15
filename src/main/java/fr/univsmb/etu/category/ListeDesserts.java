package fr.univsmb.etu.category;

import fr.univsmb.etu.product.Dessert;
import fr.univsmb.etu.view.IHMCategorie;
import fr.univsmb.etu.view.IHM_Main;

/**
 *
 */
public class ListeDesserts extends CategorieVente<Dessert>
{

	private static final long	serialVersionUID	= 1L;
	
	public static ListeDesserts vide ()
	{
		ListeDesserts l = new ListeDesserts();
		l.clear();
		return l;
	}
	
	/**
	 *
	 */
	public ListeDesserts () {
		this( new Dessert( "Tiramisu", 1.50 ), new Dessert( "Tarte au citron meringuée", 1.20 ), new Dessert( "Mousse au chocolat", 1.80 ),
				new Dessert( "Salade de fruits", 1.05 ), new Dessert( "Profiterole", 1.60 ) );
	}

	public ListeDesserts ( Dessert... desserts ) {
		super( "Desserts", desserts );
	}

	@Override
	public IHM_Main consulter ()
	{
		return new IHMCategorie( this );
	}
}