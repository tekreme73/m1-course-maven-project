package fr.univsmb.etu.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.univsmb.etu.command.Table;
import fr.univsmb.etu.product.EntiteVente;

public class IHMCommande extends IHM_Main
{
	
	private Table			table;

	protected JSplitPane	splitPane;
	protected JPanel		commandePanel;
	protected JPanel		cartePanel;

	protected JButton		btnTerminer;

	/**
	 *
	 * @param carte
	 */
	public IHMCommande ( Table table ) {
		super( "Commande de la table " + table.getNumero() );
		this.setTable( table );
	}
	
	public IHMCommande ( Table table, JPanel cartePanel ) {
		this( table );
		this.setCartePanel( cartePanel );
	}
	
	/**
	 * @param cartePanel
	 *            the cartePanel to set
	 */
	protected IHMCommande changeCartePanel ( JPanel cartePanel )
	{
		return new IHMCommande( this.getTable(), cartePanel );
	}

	/**
	 * @return the table
	 */
	public Table getTable ()
	{
		return this.table;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	protected JPanel initialize ()
	{
		
		JPanel globalPanel = new JPanel();
		this.getMainPane().add( globalPanel, BorderLayout.CENTER );
		globalPanel.setLayout( new GridLayout( 1, 2, 0, 0 ) );

		this.splitPane = new JSplitPane();
		globalPanel.add( this.splitPane, BorderLayout.CENTER );
		this.splitPane.setDividerLocation( 700 );
		
		this.splitPane.setLeftComponent( this.cartePanel );
		
		this.commandePanel = new JPanel();
		this.commandePanel.setLayout( new GridLayout( 0, 2, 0, 0 ) );
		this.splitPane.setRightComponent( this.commandePanel );

		this.updateCommande();

		return globalPanel;
	}
	
	@Override
	protected void initializeListeners ()
	{}

	/**
	 *
	 * @param create
	 */
	protected void setCartePanel ( JPanel cartePanel )
	{
		this.cartePanel = cartePanel;
	}
	
	/**
	 * @param table
	 *            the table to set
	 */
	public void setTable ( Table table )
	{
		this.table = table;
	}

	/* (non-Javadoc)
	 * @see albf.view.IHM_Main#update()
	 */
	@Override
	protected void update ()
	{
		super.update();
		this.updateCommande();
	}

	/**
	 *
	 */
	protected void updateCommande ()
	{
		this.commandePanel.removeAll();
		for ( EntiteVente item : this.table.getCommande().getItems() )
		{
			JLabel lblItem = new JLabel( item.texte() );
			this.commandePanel.add( lblItem );
		}

		this.commandePanel.repaint();
		this.commandePanel.validate();
	}

}
