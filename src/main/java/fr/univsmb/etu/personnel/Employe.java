package fr.univsmb.etu.personnel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.univsmb.etu.Restaurant;
import fr.univsmb.etu.interfaces.IAuthorizable;
import fr.univsmb.etu.interfaces.ICliquable;
import fr.univsmb.etu.interfaces.IDisplayable;

public abstract class Employe implements ICliquable, IDisplayable, IAuthorizable
{
	
	private static final int	DEFAULT_WIDTH	= 200;

	private static final int	DEFAULT_HEIGHT	= 200;

	/**
	 *
	 */
	protected String			nom;

	/**
	 *
	 */
	protected String			prenom;

	/**
	 *
	 * @param nom
	 * @param prenom
	 */
	public Employe ( String nom, String prenom ) {
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public ActionListener actionClick ( List<Object> args )
	{
		return new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				Restaurant.setUtilisateur( Employe.this );
			}
		};
	}

	@Override
	public AbstractButton button ()
	{
		JButton btn = new JButton( this.texte() );
		btn.setPreferredSize( new Dimension( Employe.DEFAULT_WIDTH, Employe.DEFAULT_HEIGHT ) );
		btn.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
		return btn;
	}

	@Override
	public boolean canAccess ( String permission )
	{
		return this.getPermissions().contains( permission );
	}
	
	@Override
	public String getNom ()
	{
		return this.nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom ()
	{
		return this.prenom;
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
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom ( String prenom )
	{
		this.prenom = prenom;
	}
	
	@Override
	public String texte ()
	{
		return this.texte( "" );
	}
	
	@Override
	public String texte ( String prefix )
	{
		return "<html><div style=\"text-align:center;\"><p style=\"word-wrap:break-word;\">" + this.getPrenom() + " " + this.getNom()
				+ "</p><p style=\"word-wrap:break-word;\">" + this.getClass().getSimpleName() + "</p></div></html>";
	}
}
