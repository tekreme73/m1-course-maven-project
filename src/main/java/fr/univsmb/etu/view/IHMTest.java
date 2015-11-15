package fr.univsmb.etu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class IHMTest
{
	
	/**
	 * Launch the application.
	 */
	public static void main ( String[] args )
	{
		EventQueue.invokeLater( new Runnable() {
			@Override
			public void run ()
			{
				try
				{
					IHMTest window = new IHMTest();
					window.frame.setVisible( true );
				} catch ( Exception e )
				{
					e.printStackTrace();
				}
			}
		} );
	}
	
	private JFrame	frame;
	
	/**
	 * Create the application.
	 */
	public IHMTest () {
		this.initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize ()
	{
		this.frame = new JFrame();
		this.frame.setBounds( 100, 100, 932, 594 );
		this.frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		JPanel panel = new JPanel();
		this.frame.getContentPane().add( panel, BorderLayout.CENTER );
		panel.setLayout( new BorderLayout( 0, 0 ) );
		
		JSplitPane splitPane = new JSplitPane();
		panel.add( splitPane, BorderLayout.CENTER );
		splitPane.setDividerLocation( 700 );
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent( panel_1 );
		panel_1.setLayout( new GridLayout( 0, 1, 0, 0 ) );
		
		JButton b1 = new JButton( "1" );
		JButton b2 = new JButton( "1" );
		JButton b3 = new JButton( "1" );
		JButton b4 = new JButton( "1" );
		JButton b5 = new JButton( "1" );
		
		panel_1.add( b1 );
		panel_1.add( b2 );
		panel_1.add( b3 );
		panel_1.add( b4 );
		panel_1.add( b5 );
		
		JPanel panel_2 = new JPanel();
		splitPane.setLeftComponent( panel_2 );

		JCheckBox chckbxViande = new JCheckBox( "Viande" );
		panel_2.add( chckbxViande );
	}
	
}
