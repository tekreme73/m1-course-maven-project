package fr.univsmb.etu.view;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public abstract class IHM_Main
{
	public static LinkedList<IHM_Main>	QUEUE;

	public static LinkedList<IHM_Main> getQueue ()
	{
		if ( IHM_Main.QUEUE == null )
		{
			IHM_Main.setQueue( new LinkedList<IHM_Main>() );
		}
		return IHM_Main.QUEUE;
	}
	
	/**
	 *
	 * @param queue
	 */
	private static void setQueue ( LinkedList<IHM_Main> queue )
	{
		IHM_Main.QUEUE = queue;
	}

	protected final String	app_name	= "A la bonne franquette";

	private JFrame			frame;

	private Container		main;
	
	private JPanel			content;
	
	protected JMenuBar		menuBar;

	protected boolean		isInQueue;
	
	protected JMenuItem		mntmRetour;
	protected JMenuItem		mntmTerminer;

	public IHM_Main () {
		this.setFrame( new JFrame() );
		this.setMainPane( this.getFrame().getContentPane() );
		this.setInQueue( true );
		this.makeDefaultFrame();
	}
	
	public IHM_Main ( Container main ) {
		this();
		this.setMainPane( main );
	}
	
	public IHM_Main ( Container main, String pageName ) {
		this( pageName );
		this.setMainPane( main );
	}
	
	public IHM_Main ( String pageName ) {
		this();
		this.setTitle( pageName );
	}
	
	public void dispose ()
	{
		this.setVisible( false );
		if ( IHM_Main.getQueue().size() > 1 && this.isInQueue() )
		{
			Point pt = IHM_Main.getQueue().getLast().getFrame().getLocation();
			IHM_Main.getQueue().removeLast();
			IHM_Main.getQueue().getLast().setVisible( true );
			IHM_Main.getQueue().getLast().getFrame().setLocation( pt );
		}
		this.getFrame().dispose();
	}
	
	/**
	 * @return the content
	 */
	public JPanel getContent ()
	{
		return this.content;
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame ()
	{
		return this.frame;
	}

	public JMenuItem getItemTerminer ()
	{
		this.mntmTerminer.setEnabled( true );
		return this.mntmTerminer;
	}

	/**
	 * @return the main
	 */
	public Container getMainPane ()
	{
		return this.main;
	}
	
	/**
	 * @return the result
	 */
	public Object getResult ()
	{
		return this.result();
	}
	
	protected abstract JPanel initialize ();

	protected abstract void initializeListeners ();

	/**
	 * @return the isInQueue
	 */
	public boolean isInQueue ()
	{
		return this.isInQueue;
	}

	public void make ()
	{
		this.make( true );
	}

	public void make ( boolean hidePrevious )
	{
		JPanel content = this.initialize();
		this.initializeListeners();
		if ( this.isInQueue() )
		{
			if ( !IHM_Main.getQueue().isEmpty() )
			{
				this.getFrame().setLocation( IHM_Main.getQueue().getLast().getFrame().getLocation() );
				IHM_Main.getQueue().getLast().getFrame().setVisible( !hidePrevious );
			} else
			{
				this.getFrame().setLocationRelativeTo( null );
			}
			IHM_Main.getQueue().add( this );
		}
		this.setContent( content );
	}
	
	public void makeAndShow ()
	{
		this.makeAndShow( true );
	}
	
	public void makeAndShow ( boolean hidePrevious )
	{
		this.make( hidePrevious );
		this.setVisible( true );
	}

	protected void makeDefaultFrame ()
	{
		this.getFrame().setTitle( this.app_name );
		this.getFrame().setSize( 1024, 728 );
		this.getFrame().setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
		this.getFrame().setResizable( false );

		this.menuBar = new JMenuBar();
		this.getFrame().setJMenuBar( this.menuBar );
		
		this.mntmRetour = new JMenuItem( "Retour" );
		this.mntmRetour.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHM_Main.this.dispose();
			}
		} );
		this.menuBar.add( this.mntmRetour );

		JMenuItem mntmActualiser = new JMenuItem( "Actualiser" );
		mntmActualiser.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				IHM_Main.this.update();
			}
		} );
		this.menuBar.add( mntmActualiser );
		
		JMenuItem mntmFermer = new JMenuItem( "Fermer" );
		mntmFermer.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent ae )
			{
				System.out.println( "Application fermée" );
				System.exit( 1 );
			}
		} );
		this.menuBar.add( mntmFermer );

		this.mntmTerminer = new JMenuItem( "Terminer" );
		this.mntmTerminer.setEnabled( false );
		this.menuBar.add( this.mntmTerminer );
	}
	
	/**
	 *
	 */
	public void redraw ()
	{
		this.update();
		this.getFrame().repaint();
		this.getFrame().revalidate();
	}
	
	protected Object result ()
	{
		return new Object();
	}
	
	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent ( JPanel content )
	{
		this.content = content;
	}
	
	/**
	 * @param frame
	 *            the frame to set
	 */
	public void setFrame ( JFrame frame )
	{
		this.frame = frame;
	}
	
	/**
	 * @param isInQueue
	 *            the isInQueue to set
	 */
	public void setInQueue ( boolean isInQueue )
	{
		this.isInQueue = isInQueue;
	}
	
	/**
	 * @param main
	 *            the main to set
	 */
	public void setMainPane ( Container main )
	{
		this.main = main;
	}

	public void setTitle ( String pageName )
	{
		this.getFrame().setTitle( this.app_name + " - " + pageName );
	}
	
	public void setVisible ( boolean visible )
	{
		this.update();
		this.getFrame().setVisible( visible );
	}

	protected void update ()
	{}
}
