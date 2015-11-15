/**
 *
 */
package fr.univsmb.etu.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import fr.univsmb.etu.category.Categorie;
import fr.univsmb.etu.interfaces.ISelectionnable;

/**
 * @author Rémi REBILLARD (tekreme73@gmail.com)
 *
 */
public class IHMCategorieSelectionnable extends IHM_Main
{
	private Map<ISelectionnable, JCheckBox>	items;
	
	private List<Object>					argsBtnAction;
	
	/**
	 *
	 * @param categorie
	 */
	public IHMCategorieSelectionnable ( Categorie<?> categorie ) {
		super( categorie.getNom() );

		this.setItems( new LinkedHashMap<ISelectionnable, JCheckBox>() );
		this.setArgsBtnAction( new LinkedList<Object>() );
		for ( ISelectionnable elem : categorie.recupererSelectionnable() )
		{
			this.getItems().put( elem, elem.checkbox() );
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
	public Map<ISelectionnable, JCheckBox> getItems ()
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
		
		for ( Entry<ISelectionnable, JCheckBox> item : this.getItems().entrySet() )
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
		for ( Entry<ISelectionnable, JCheckBox> item : this.getItems().entrySet() )
		{
			item.getValue().addItemListener( item.getKey().actionCheck( this.getArgsBtnAction() ) );
		}
	}

	/* (non-Javadoc)
	 * @see albf.view.IHM_Main#result()
	 */
	@Override
	protected Object result ()
	{
		LinkedList<ISelectionnable> list = new LinkedList<ISelectionnable>();
		for ( Entry<ISelectionnable, JCheckBox> item : this.getItems().entrySet() )
		{
			if ( item.getValue().isSelected() )
			{
				list.add( item.getKey() );
			}
		}
		return list;
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
	public void setItems ( Map<ISelectionnable, JCheckBox> items )
	{
		this.items = items;
	}
}
