package fr.univsmb.etu.command;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import fr.univsmb.etu.Caisse;
import fr.univsmb.etu.Cuisine;
import fr.univsmb.etu.category.CategorieEntite;
import fr.univsmb.etu.interfaces.ICliquable;
import fr.univsmb.etu.product.EntiteVente;
import fr.univsmb.etu.product.Produit;
import fr.univsmb.etu.view.IHMCategorieSelectionnable;

/**
 *
 */
public class Commande implements ICliquable
{
	
	public static final Commande	VIDE		= new Commande();

	private static int				GLOBAL_ID	= 1;
	
	/**
	 * @return the id
	 */
	public static int getUniquelId ()
	{
		return Commande.GLOBAL_ID++ ;
	}
	
	/**
	 *
	 */
	protected LinkedList<Ticket>		tickets;
	
	/**
	 *
	 */
	protected Map<EntiteVente, Boolean>	items;
	
	/**
	 *
	 */
	private Cuisine						cuisine;

	/**
	 *
	 */
	private Caisse						caisse;
	
	private final int					id;
	
	/**
	 * Default constructor
	 */
	public Commande () {
		this.setTickets( new LinkedList<Ticket>() );
		this.setItems( new LinkedHashMap<EntiteVente, Boolean>() );
		this.id = Commande.getUniquelId();
	}
	
	@Override
	public ActionListener actionClick ( List<Object> args )
	{
		return new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{}
		};
	}
	
	/**
	 * @param item
	 */
	public void ajouterItem ( EntiteVente item )
	{
		this.items.put( item, false );
	}
	
	@Override
	public AbstractButton button ()
	{
		JButton btn = new JButton( this.texte() );
		btn.setPreferredSize( new Dimension( 200, 200 ) );
		btn.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		return btn;
	}
	
	/**
	 * @param produitsAPreparer
	 */
	public Ticket creerTicket ( List<Produit> produitsAPreparer )
	{
		Ticket t = new Ticket();
		this.getTickets().add( t );
		for ( Produit p : produitsAPreparer )
		{
			t.ajouterProduit( p );
			this.items.put( p, true );
		}
		return t;
	}
	
	/**
	 *
	 */
	public void envoyerTicket ()
	{
		LinkedList<Object> list = new LinkedList<Object>();
		list.add( new LinkedList<Produit>() );

		final IHMCategorieSelectionnable window = new IHMCategorieSelectionnable( new CategorieEntite( "Items", this.getAvailableItems() ) );
		window.makeAndShow();

		window.getItemTerminer().addActionListener( new ActionListener() {

			@Override
			@SuppressWarnings ( "unchecked" )
			public void actionPerformed ( ActionEvent arg0 )
			{
				if ( !Commande.this.getTickets().isEmpty() )
				{
					Ticket t_last = Commande.this.getTickets().getLast();
					t_last.annoter();
				}
				
				Ticket t_new = Commande.this.creerTicket( (List<Produit>) window.getResult() );
				window.dispose();
				t_new.envoyer( Commande.this.getCuisine() );
			}
		} );
	}
	
	/**
	 * @return the items
	 */
	public LinkedList<EntiteVente> getAvailableItems ()
	{
		LinkedList<EntiteVente> items = new LinkedList<EntiteVente>();
		for ( Entry<EntiteVente, Boolean> item : this.items.entrySet() )
		{
			if ( !item.getValue() )
			{
				items.add( item.getKey() );
			}
		}
		return items;
	}
	
	/**
	 * @return the caisse
	 */
	public Caisse getCaisse ()
	{
		return this.caisse;
	}

	/**
	 * @return the cuisine
	 */
	public Cuisine getCuisine ()
	{
		return this.cuisine;
	}
	
	public int getId ()
	{
		return this.id;
	}
	
	/**
	 * @return the items
	 */
	public LinkedList<EntiteVente> getItems ()
	{
		return new LinkedList<EntiteVente>( this.items.keySet() );
	}
	
	@Override
	public String getNom ()
	{
		return "Commande" + this.getId();
	}
	
	/**
	 * @return the tickets
	 */
	public LinkedList<Ticket> getTickets ()
	{
		return this.tickets;
	}

	/**
	 * @param caisse
	 *            the caisse to set
	 */
	public void setCaisse ( Caisse caisse )
	{
		this.caisse = caisse;
	}

	/**
	 *
	 * @param cuisine
	 */
	public void setCuisine ( Cuisine cuisine )
	{
		this.cuisine = cuisine;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems ( Map<EntiteVente, Boolean> items )
	{
		this.items = items;
	}

	/**
	 * @param tickets
	 *            the tickets to set
	 */
	public void setTickets ( LinkedList<Ticket> tickets )
	{
		this.tickets = tickets;
	}

	/**
	 *
	 */
	public void terminer ()
	{
		this.getCaisse().add( this );
	}

	@Override
	public String texte ()
	{
		return this.texte( "" );
	}
	
	@Override
	public String texte ( String prefix )
	{
		return "<html><div style=\"text-align:center;\"><p style=\"word-wrap:break-word;\">" + prefix
				+ "</p><p style=\"word-wrap:break-word;\">" + this.getNom() + "</p></div></html>";
	}
}