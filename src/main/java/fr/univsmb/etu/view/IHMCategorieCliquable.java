/**
 *
 */
package fr.univsmb.etu.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import fr.univsmb.etu.category.Categorie;
import fr.univsmb.etu.interfaces.ICliquable;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class IHMCategorieCliquable extends IHM_Main
{
	private Map<ICliquable, AbstractButton>	items;
	
	private List<Object>					argsBtnAction;
	
	public IHMCategorieCliquable () {
		super();
	}
	
	/**
	 *
	 * @param categorie
	 */
	public IHMCategorieCliquable ( Categorie<?> categorie ) {
		super( categorie.getNom() );

		this.setItems( new LinkedHashMap<ICliquable, AbstractButton>() );
		this.setArgsBtnAction( new LinkedList<Object>() );
		for ( ICliquable elem : categorie.recupererCliquable() )
		{
			this.getItems().put( elem, elem.button() );
		}
	}
	
	/**
	 * @return the args
	 */
	protected List<Object> getArgsBtnAction ()
	{
		return this.argsBtnAction;
	}

	/**
	 *
	 * @return
	 */
	public Map<ICliquable, AbstractButton> getItems ()
	{
		return this.items;
	}
	
	/* (non-Javadoc)
	 * @see albf.view.IHM_Main#initialize()
	 */
	@Override
	protected JPanel initialize ()
	{
		JPanel homePanel = new JPanel();
		this.getMainPane().add( homePanel, BorderLayout.CENTER );
		homePanel.setLayout( new GridLayout( 1, 1, 0, 0 ) );
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scrollPane.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		scrollPane.getVerticalScrollBar().setUnitIncrement( 16 );
		homePanel.add( scrollPane, BorderLayout.CENTER );
		
		JPanel scrollPanel = new JPanel();
		scrollPane.setViewportView( scrollPanel );
		scrollPanel.setLayout( new GridLayout( 0, 3, 20, 20 ) );
		
		for ( Entry<ICliquable, AbstractButton> item : this.getItems().entrySet() )
		{
			scrollPanel.add( item.getValue() );
		}
		
		return homePanel;
	}
	
	/* (non-Javadoc)
	 * @see albf.view.IHM_Main#initializeListeners()
	 */
	@Override
	protected void initializeListeners ()
	{
		for ( Entry<ICliquable, AbstractButton> item : this.getItems().entrySet() )
		{
			item.getValue().addActionListener( item.getKey().actionClick( this.getArgsBtnAction() ) );
			item.getValue().addActionListener( new ActionListener() {
				@Override
				public void actionPerformed ( ActionEvent arg0 )
				{
					IHMCategorieCliquable.this.dispose();
				}
			} );
		}
	}

	/**
	 * @param argsBtnAction
	 *            the argsBtnAction to set
	 */
	public void setArgsBtnAction ( List<Object> argsBtnAction )
	{
		this.argsBtnAction = argsBtnAction;
	}
	
	/**
	 *
	 * @param items
	 */
	public void setItems ( Map<ICliquable, AbstractButton> items )
	{
		this.items = items;
	}
}
