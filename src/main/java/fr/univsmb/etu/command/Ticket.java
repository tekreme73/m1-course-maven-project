package fr.univsmb.etu.command;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import fr.univsmb.etu.Cuisine;
import fr.univsmb.etu.command.etat.EtatTicket;
import fr.univsmb.etu.command.etat.EtatTicketAEnvoyer;
import fr.univsmb.etu.interfaces.ICliquable;
import fr.univsmb.etu.interfaces.ITicket;
import fr.univsmb.etu.product.Produit;

/**
 *
 */
public class Ticket implements ITicket, ICliquable
{

	/**
	 *
	 */
	protected List<Produit>	produitsAPreparer;
	
	/**
	 *
	 */
	protected Cuisine		cuisine;
	
	/**
	 *
	 */
	protected EtatTicket	etat;

	/**
	 * Default constructor
	 */
	public Ticket () {
		this.setProduitsAPreparer( new ArrayList<Produit>() );
		this.setEtat( new EtatTicketAEnvoyer( this ) );
	}

	@Override
	public ActionListener actionClick ( List<Object> args )
	{
		return this.getEtat().actionClick( args );
	}
	
	/**
	 *
	 */
	public void ajouterProduit ( Produit p )
	{
		this.getProduitsAPreparer().add( p );
	}
	
	@Override
	public void annoter ()
	{
		this.getEtat().annoter();
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
	 * @param etat
	 *            the etat to set
	 */
	public void changeEtat ( EtatTicket etat )
	{
		this.etat = etat;
	}
	
	@Override
	public void cloturer ()
	{
		this.getEtat().cloturer();
	}
	
	@Override
	public void envoyer ( Cuisine cuisine )
	{
		this.getEtat().envoyer( cuisine );
	}
	
	/**
	 * @return the cuisine
	 */
	public Cuisine getCuisine ()
	{
		return this.cuisine;
	}
	
	/**
	 * @return the etat
	 */
	public EtatTicket getEtat ()
	{
		return this.etat;
	}
	
	@Override
	public String getNom ()
	{
		return "Ticket";
	}
	
	/**
	 * @return the produitsAPreparer
	 */
	public List<Produit> getProduitsAPreparer ()
	{
		return this.produitsAPreparer;
	}

	@Override
	public void preparer ()
	{
		this.getEtat().preparer();
	}

	/**
	 * @param cuisine
	 *            the cuisine to set
	 */
	public void setCuisine ( Cuisine cuisine )
	{
		this.cuisine = cuisine;
	}
	
	/**
	 * @param etat
	 *            the etat to set
	 */
	public void setEtat ( EtatTicket etat )
	{
		this.etat = etat;
	}
	
	/**
	 * @param produitsAPreparer
	 *            the produitsAPreparer to set
	 */
	public void setProduitsAPreparer ( List<Produit> produitsAPreparer )
	{
		this.produitsAPreparer = produitsAPreparer;
	}
	
	@Override
	public String texte ()
	{
		return this.texte( this.getEtat().getNom() );
	}
	
	@Override
	public String texte ( String prefix )
	{
		return "<html><div style=\"text-align:center;\"><p style=\"word-wrap:break-word;\">" + prefix
				+ "</p><p style=\"word-wrap:break-word;\">" + this.getNom() + "</p></div></html>";
	}

}