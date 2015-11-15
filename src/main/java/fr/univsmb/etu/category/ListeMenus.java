package fr.univsmb.etu.category;

import fr.univsmb.etu.product.Menu;
import fr.univsmb.etu.view.IHMCategorieCliquable;
import fr.univsmb.etu.view.IHM_Main;

/**
 *
 */
public class ListeMenus extends CategorieVente<Menu>
{

	private static final long	serialVersionUID	= 1L;

	/**
	 *
	 */
	public ListeMenus () {
		super( "Menus", new Menu[] {} );
	}

	@Override
	public IHM_Main consulter ()
	{
		return new IHMCategorieCliquable( this );
	}
}