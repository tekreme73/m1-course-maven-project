package fr.univsmb.etu.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;

import javax.swing.AbstractButton;

import fr.univsmb.etu.Restaurant;
import fr.univsmb.etu.interfaces.ICliquable;

public class IHMConnexion extends IHMCategorieCliquable
{
	private final Restaurant	restaurant;
	
	/**
	 * Create the application.
	 */
	public IHMConnexion ( Restaurant restaurant ) {
		super( restaurant.getPersonnel() );
		this.restaurant = restaurant;
	}
	
	@Override
	protected void initializeListeners ()
	{
		for ( Entry<ICliquable, AbstractButton> item : this.getItems().entrySet() )
		{
			item.getValue().addActionListener( new ActionListener() {
				@Override
				public void actionPerformed ( ActionEvent arg0 )
				{
					IHMRestaurant window = new IHMRestaurant( IHMConnexion.this.restaurant );
					window.makeAndShow();
				}
			} );
			item.getValue().addActionListener( item.getKey().actionClick( this.getArgsBtnAction() ) );
		}
	}
}
