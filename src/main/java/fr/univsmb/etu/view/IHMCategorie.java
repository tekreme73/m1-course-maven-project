/**
 *
 */
package fr.univsmb.etu.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import fr.univsmb.etu.category.Categorie;
import fr.univsmb.etu.interfaces.IDisplayable;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class IHMCategorie extends IHM_Main
{
	private Map<IDisplayable, JPanel>	items;

	/**
	 *
	 */
	public IHMCategorie () {
		super();
	}
	
	/**
	 *
	 * @param categorie
	 */
	public IHMCategorie ( Categorie<?> categorie ) {
		super( categorie.getNom() );
		
		this.setItems( new LinkedHashMap<IDisplayable, JPanel>() );
		for ( IDisplayable elem : categorie.recupererDescription() )
		{
			this.getItems().put( elem, elem.panel() );
		}
	}
	
	/**
	 *
	 * @return
	 */
	public Map<IDisplayable, JPanel> getItems ()
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
		
		for ( Entry<IDisplayable, JPanel> item : this.getItems().entrySet() )
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
		/*for ( Entry<IDisplayable, JPanel> item : this.getItems().entrySet() )
		{
		}*/
	}
	
	public void setItems ( Map<IDisplayable, JPanel> items )
	{
		this.items = items;
	}
}
