package fr.univsmb.etu.command;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import fr.univsmb.etu.Carte;
import fr.univsmb.etu.interfaces.ICliquable;
import fr.univsmb.etu.personnel.Employe;
import fr.univsmb.etu.view.IHMCommandeDefault;
import fr.univsmb.etu.view.IHMTable;

/**
 *
 */
public class Table implements ICliquable
{
	
	/**
	 *
	 */
	protected int		numero;
	
	/**
	 *
	 */
	protected int		nbPersonne;
	
	/**
	 *
	 */
	protected Employe	employe;
	
	/**
	 *
	 */
	protected Commande	commande;

	/**
	 *
	 */
	protected Carte		carte;

	/**
	 *
	 * @param numero
	 * @param serveur
	 * @param carte
	 */
	public Table ( int numero, Employe employe ) {
		this.setNumero( numero );
		this.setNbPersonne( 0 );
		this.setEmploye( employe );
		this.setCommande( Commande.VIDE );
	}
	
	@Override
	public ActionListener actionClick ( List<Object> args )
	{
		return new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHMTable window = new IHMTable( Table.this );
				window.makeAndShow();
			}
		};
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
	 *
	 */
	public Commande creerCommande ()
	{
		Commande c = new Commande();
		c.setCuisine( this.getCommande().getCuisine() );
		c.setCaisse( this.getCommande().getCaisse() );
		this.setCommande( c );
		IHMCommandeDefault window = new IHMCommandeDefault( this );
		window.makeAndShow();
		return this.getCommande();
	}

	/**
	 * @return the carte
	 */
	public Carte getCarte ()
	{
		return this.carte;
	}

	/**
	 * @return the commande
	 */
	public Commande getCommande ()
	{
		return this.commande;
	}

	/**
	 * @return the serveur
	 */
	public Employe getEmploye ()
	{
		return this.employe;
	}

	/**
	 * @return the nbPersonne
	 */
	public int getNbPersonne ()
	{
		return this.nbPersonne;
	}

	@Override
	public String getNom ()
	{
		return "Table" + this.getNumero();
	}

	/**
	 * @return the numero
	 */
	public int getNumero ()
	{
		return this.numero;
	}

	/**
	 *
	 * @return
	 */
	public boolean hasCommande ()
	{
		return this.getCommande() != Commande.VIDE && this.getCommande() != null;
	}

	/**
	 * @param carte
	 *            the carte to set
	 */
	public void setCarte ( Carte carte )
	{
		this.carte = carte;
	}

	/**
	 * @param c
	 */
	public void setCommande ( Commande c )
	{
		this.commande = c;
	}

	/**
	 * @param serveur
	 *            the serveur to set
	 */
	public void setEmploye ( Employe employe )
	{
		this.employe = employe;
	}

	/**
	 * @param nbPersonne
	 *            the nbPersonne to set
	 */
	public void setNbPersonne ( int nbPersonne )
	{
		this.nbPersonne = nbPersonne;
	}
	
	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero ( int numero )
	{
		this.numero = numero;
	}
	
	/**
	 *
	 */
	public void supprimerCommande ()
	{
		this.setCommande( Commande.VIDE );
	}

	public void terminerRepas ()
	{
		this.getCommande().terminer();
		this.supprimerCommande();
	}
	
	@Override
	public String texte ()
	{
		if ( this.hasCommande() )
		{
			return this.texte( "-- Occupé --" );
		} else
		{
			return this.texte( "" );
		}
	}
	
	@Override
	public String texte ( String prefix )
	{
		return "<html><div style=\"text-align:center;\"><p style=\"word-wrap:break-word;\">" + prefix
				+ "</p><p style=\"word-wrap:break-word;\">" + this.getNom() + "</p></div></html>";
	}
}