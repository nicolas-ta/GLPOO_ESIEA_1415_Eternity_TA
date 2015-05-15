package Jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;






	public class Menu extends JFrame {
		  private JMenuBar menuBar = new JMenuBar();
		  private JMenu Jeu = new JMenu("Jeu");
		  private JMenu More = new JMenu("more");

		  private JMenuItem Nouvelle = new JMenuItem("Nouvelle partie");
		  private JMenuItem Save = new JMenuItem("Sauvegarder la partie");
		  private JMenuItem Load = new JMenuItem("Charger la partie");
		  private JMenuItem Quit = new JMenuItem("Quitter le jeu");
		  private JMenuItem Help = new JMenuItem("Instruction");
		  private JMenuItem Score = new JMenuItem("Score");
		  
		 

	
	public Menu(){
		 //On initialise nos menus      
	    this.Jeu.add(Nouvelle);
	    this.More.add(Help);
	    this.More.add(Score);

	    Help.addActionListener(new ActionListener(){
	    
	    	public void actionPerformed(ActionEvent arg0){
	    		JFrame about = new JFrame();
	    		Font font = new Font("Arial", Font.BOLD, 20);
	    		about.setEnabled(true);
	    		about.setResizable(false);
	    		about.setAlwaysOnTop(true);
	    		about.setTitle("Help\r\n");
	    		about.setMinimumSize(new Dimension(500, 300));
	    		about.getContentPane().setLayout(
	    				new BoxLayout(about.getContentPane(), BoxLayout.X_AXIS));

	    		Panel panel_2 = new Panel();
	    		about.getContentPane().add(panel_2);
	    		panel_2.setLayout(null);

	    		JTextPane Help = new JTextPane();
	    		Help.setToolTipText("");
	    		Help.setEnabled(false);
	    		Help.setEditable(false);
	    		Help.setBounds(0, 0, 500, 300);
	    		panel_2.add(Help);
	    		Help.setFont(font);
	    		Help.setText("Some instructions to help you:\r\n -> To rotate, click on the piece.\r\n -> To move a piece, pressed it and released it where you want.\r\n Hope it help you ;)");
	    		about.setVisible(true);
	    	}
	    
	    });
	    Quit.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	        System.exit(0);
	      }
	      
	    });
	    
/*	    Save.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent arg0) {
	        	MasterTable.fctSauvegarder();
	        }
	        
	      }); 
	    */
	    /*
	    Load.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent arg0) {
	        	MasterTable.fctRestaurer();
	        }
	        
	      }); 
	    */
	  
	    this.Jeu.add(Save);  
	    this.Jeu.add(Load);
	    this.Jeu.addSeparator();
	    this.Jeu.add(Quit);

	    //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
	    //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
	    this.menuBar.add(Jeu);
	    this.menuBar.add(More);
	    this.setJMenuBar(menuBar);
	    
	    this.setTitle("Eternity Game");
		this.setSize(677, 463);
		this.setVisible(true);	
		this.setResizable(false);
		setResizable(false);
	    setAlwaysOnTop(false);
	    //Instanciation d'un objet JPanel
	    JPanel pan = new JPanel();  

	    this.setContentPane(pan);
	    this.setVisible(true);
	}

}
