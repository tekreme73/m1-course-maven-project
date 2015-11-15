package fr.univsmb.etu.product;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.univsmb.etu.interfaces.ICliquable;
import fr.univsmb.etu.interfaces.IDisplayable;
import fr.univsmb.etu.interfaces.ISelectionnable;

/**
 *
 */
public abstract class EntiteVente implements ICliquable, IDisplayable, ISelectionnable
{

	protected static int	DEFAULT_WIDTH	= 200;

	protected static int	DEFAULT_HEIGHT	= 200;

	/**
	 *
	 */
	protected String		nom;

	/**
	 *
	 */
	protected double		prix;

	/**
	 *
	 * @param other
	 */
	public EntiteVente ( EntiteVente other ) {
		this( other.nom, other.prix );
	}

	/**
	 * @param prix
	 * @param nom
	 *
	 */
	public EntiteVente ( String nom, double prix ) {
		this.setNom( nom );
		this.setPrix( prix );
	}

	@Override
	public AbstractButton button ()
	{
		JButton btn = new JButton( this.texte() );
		btn.setPreferredSize( new Dimension( EntiteVente.DEFAULT_WIDTH, EntiteVente.DEFAULT_HEIGHT ) );
		btn.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		return btn;
	}

	@Override
	public JCheckBox checkbox ()
	{
		JCheckBox chckbx = new JCheckBox( this.getNom() );
		chckbx.setPreferredSize( new Dimension( EntiteVente.DEFAULT_WIDTH, EntiteVente.DEFAULT_HEIGHT ) );
		chckbx.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		return chckbx;
	}

	@Override
	public abstract EntiteVente clone ();

	/**
	 * @return the nom
	 */
	@Override
	public String getNom ()
	{
		return this.nom;
	}
	
	/**
	 * @return the prix
	 */
	public double getPrix ()
	{
		return this.prix;
	}
	
	@Override
	public JPanel panel ()
	{
		JPanel panel = new JPanel();
		
		JLabel lblPanel = new JLabel( this.texte() );
		
		panel.add( lblPanel );
		
		return panel;
	}
	
	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom ( String nom )
	{
		this.nom = nom;
	}
	
	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix ( double prix )
	{
		this.prix = prix;
	}
	
	@Override
	public String texte ()
	{
		return this.texte( "" );
	}

	@Override
	public String texte ( String prefix )
	{
		return "<html><div style=\"height:" + EntiteVente.DEFAULT_HEIGHT + "px;text-align:center;\"><p style=\"margin-top:"
				+ EntiteVente.DEFAULT_HEIGHT / 3 + "px;word-wrap:break-word;\">" + prefix + this.getNom() + "</p></div></html>";
	}
}