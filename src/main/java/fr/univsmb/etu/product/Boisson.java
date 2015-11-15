package fr.univsmb.etu.product;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.JButton;

/**
 *
 */
public class Boisson extends Produit
{
	
	/**
	 *
	 */
	protected String	contenance;
	
	/**
	 *
	 * @param other
	 */
	public Boisson ( Boisson other ) {
		this( other.nom, other.prix, other.contenance );
	}

	/**
	 *
	 */
	public Boisson ( String nom, double prix, String contenance ) {
		super( nom, prix, 14 );
		this.setContenance( contenance );
	}

	@Override
	public AbstractButton button ()
	{
		JButton btn = new JButton( this.texte() );
		btn.setPreferredSize( new Dimension( 200, 200 ) );
		btn.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		return btn;
	}

	@Override
	public EntiteVente clone ()
	{
		return new Boisson( this );
	}

	/**
	 * @return the contenance
	 */
	public String getContenance ()
	{
		return this.contenance;
	}
	
	/**
	 * @param contenance
	 *            the contenance to set
	 */
	public void setContenance ( String contenance )
	{
		this.contenance = contenance;
	}
	
	@Override
	public String texte ()
	{
		return "<html><div style=\"height:" + EntiteVente.DEFAULT_HEIGHT + "px;text-align:center;\"><p style=\"margin-top:"
				+ EntiteVente.DEFAULT_HEIGHT / 3 + "px;word-wrap:break-word;\">" + this.getNom()
				+ "</p><p style=\"word-wrap:break-word;\">" + this.getContenance() + "</p></div></html>";
	}
	
}