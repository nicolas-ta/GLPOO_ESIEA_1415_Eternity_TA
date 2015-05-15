package Jeu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Interface extends JFrame implements KeyListener,ActionListener,MouseListener{
	
	
	private int size = 4;
	
	private static int score=9999;
	private JPanel panel;
	private JFrame frame;
	private JButton begin;
	private JButton restart;
	private JButton Rotate;
	private JLabel time = new JLabel("00:00");
	private JButton[][] PlateauJeu;
	private JButton[][] Puzzle;
	
	
	Plateau Terrain;
	Plateau Reserve;
	
	
	//On mettra la fonction chrono de TArlouze
   
	Timer timer1;
    int var_time = 0;
    ActionListener action_timer = new ActionListener()  {
		  public void actionPerformed(ActionEvent e1)  {
			  // +1 et conversion en min sec
			  
			  var_time++;				  
			  int min = var_time/60;
	          int sec = var_time - (min*60);
	          String sm = Integer.toString(min);
	          if (min < 10){ sm = "0" + Integer.toString(min);}
	          String ss = Integer.toString(sec);
	          if (sec < 10){ ss = "0" + Integer.toString(sec);}
			  
	          //Actualiser le JLabel
			  time.setText(sm+":"+ss);		 
		 }
     };		 
     
 	//Remise a zero du timer
 	private void ResetTimer(){
 		timer1.stop(); 
 		timer1 = new Timer(1000, action_timer);		
 		timer1.start();  
 		var_time = -1;
 	}	
	

	private void init_terrain(int x, int y){
		
		PlateauJeu = new JButton[size][size];
	    Terrain = new Plateau(size,size,100);	
		
		//Creation des bouton des piece du plateau
		for(int i=0; i<x ; i++){
			for(int j=0; j<y ; j++){	
				//bouton
				PlateauJeu[i][j] = new JButton();			    

				PlateauJeu[i][j].setBounds(5+5*i+100*i, 5+5*j+100*j, 100,100);
				PlateauJeu[i][j].addActionListener(this); 
				PlateauJeu[i][j].setContentAreaFilled(false); 
				PlateauJeu[i][j].addMouseListener(this); 
			
				panel.add(PlateauJeu[i][j]);
				
				
				Terrain.pieces[i][j].setBounds(5+5*i+100*i, 5+5*j+100*j, 100,100);	
				panel.add(Terrain.pieces[i][j]);
			}
		}		
	}
	
	
	private void init_reserve(int x, int y){
		
		Reserve = new Plateau(size,size,50);	
		Puzzle = new JButton[size][size];
			
		
		
		//Peut �tre a modif, pense qu'il y a une erreur
		Reserve.Lecture();
		
		//Creation des bouton des pieces du Reserve
	    for(int i=0; i<x ; i++){
			
	    	for(int j=0; j<y ; j++){		
				
				//bouton
				
				Puzzle[i][j] = new JButton();			
				Puzzle[i][j].setBounds(440+5*i+50*i, 205+5*j+50*j, 50,50); 
				Puzzle[i][j].addActionListener(this); 
			    Puzzle[i][j].setContentAreaFilled(false);	
			    Puzzle[i][j].addMouseListener(this); 	
			    panel.add(Puzzle[i][j]);
			    
			   
			    Reserve.pieces[i][j].setBounds(440+5*i+50*i, 205+5*j+50*j, 50,50);	
			    panel.add(Reserve.pieces[i][j]);
			}
		
	    }	 
     
	}
		
	
private void Debut(){	
		
		//Creation de la fenetre

		frame = new JFrame("Eternity Game");  
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	    
	    panel = (JPanel)frame.getContentPane();  
	    panel.setLayout(null);
	    
	    //Creation des object graphique
	//    System.out.println("Creation des object graphique");	
	    

		Font font = new Font("Arial",Font.BOLD,33);
		time.setFont(font);		
		time.setBounds(505,30,500,30);	
	
	// Start
		begin = new JButton("Commencer");
	    begin.addActionListener(this);
		begin.setBounds(440, 150, 215,30);
		
	// Option qu'on devra integrer dans le menu on mettant une touche restart par exemple
		//bouton restart
	    restart = new JButton("Recommencer la partie");	 
        restart.addActionListener(this);
        restart.setBounds(440, 85, 215,30);
        
        //On ajoute tout sa a la page
        panel.add(time);
        panel.add(restart);             
        panel.add(begin);
      
	}
	

	public Interface() {
		
		//Debut nouvelle partie

		Debut();
		new Menu();
		
	   init_terrain(size,size);
	init_reserve(size,size);
        
        
        frame.setSize(677, 463);
		frame.setVisible(true);	
		frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    setAlwaysOnTop(false);
	    frame.setContentPane(panel);
	    frame.setVisible(true);	
		timer1 = new Timer(1000, action_timer);		
		timer1.start();     
		
	}
	
		
	
	//Evenement	
	private Piece last=null;
	public void actionPerformed(ActionEvent e) {	
		
		
		//Pour débuter la partie
		/*if(e.getSource() == begin){
			
			 init_reserve(size,size);
		
		}*/

		
		//Pour chaque piece du Terrain
		for(int i=0; i<4 ; i++){
			for(int j=0; j<4 ; j++){	
				if(e.getSource() == PlateauJeu[i][j]){
					Terrain.pieces[i][j].rotationGauche();
					Terrain.verification();
					last = Terrain.pieces[i][j];
				}				
			}
		}	
				
		
		//Pour chaque piece de la Reserve
		for(int i=0; i<4 ; i++){
			
			for(int j=0; j<4 ; j++){	
			
				if(e.getSource() == Puzzle[i][j]){
				
					Reserve.pieces[i][j].rotationGauche();
					Terrain.verification();
					last = Reserve.pieces[i][j];
				
				}				
			
			}
		
		}	
		
		
		// Si bouton Rotate presser	
		if(e.getSource() == Rotate){
			
			if (last != null){
			
					last.rotationGauche();	
					last.update();
				}	
		
			}					
	
		// Si bouton Restart presser
		if(e.getSource() == restart){
	//		System.out.println("On recommence du debut! .");				
			Terrain.init();		
			//Reserve.init(); //pourquoi tu as mis �a en commentaire ????	
			Reserve.Lecture();
			ResetTimer();
		}
	}
	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/*public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();	
	}*/

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	

	private Piece start = null;
	public void mousePressed(MouseEvent e) {
		

		
		//Pour chaque piece du Terrain
		for(int i=0; i<4 ; i++){
			for(int j=0; j<4 ; j++){	
				if(e.getSource() == PlateauJeu[i][j]){
					start = Terrain.pieces[i][j];
				}				
			}
		}	
		
		//Pour chaque piece du Reserve
		for(int i=0; i<4 ; i++){
			for(int j=0; j<4 ; j++){	
				if(e.getSource() == Puzzle[i][j]){
					start = Reserve.pieces[i][j];
				}				
			}
		}	
		if (start != null){
	//		System.out.println("Piece pressee!");	
			//setCursor(new Cursor(Cursor.MOVE_CURSOR) );
		}
		
	}
	
	
		
	private Piece stop = null;
	
	public void mouseReleased(MouseEvent e) {
		
		if (stop != null && start != null){
	//		System.out.println("Piece Relachee!");
			stop.Echange(start);
			stop.update();
			start.update();	
			last = stop;
			Terrain.verification();
		}
		stop = null;
		start = null;	
	}
	
	
	public void mouseEntered(MouseEvent e) {
								
				//Pour chaque piece du Terrain
				for(int i=0; i<4 ; i++){
					for(int j=0; j<4 ; j++){	
						if(e.getSource() == PlateauJeu[i][j]){
							stop = Terrain.pieces[i][j];
						}				
					}
				}
				
				//Pour chaque piece du Reserve
				for(int i=0; i<4 ; i++){
					for(int j=0; j<4 ; j++){	
						if(e.getSource() == Puzzle[i][j]){
							stop = Reserve.pieces[i][j];
						}				
					}
				}

	}
	
	
	
/*	public class Menu extends JFrame {
		  private JMenuBar menuBar = new JMenuBar();
		  private JMenu Jeu = new JMenu("Jeu");
		  private JMenu Highscores = new JMenu("Highscores");

		  private JMenuItem Nouvelle = new JMenuItem("Nouvelle partie");
		  private JMenuItem Save = new JMenuItem("Sauvegarder la partie");
		  private JMenuItem Load = new JMenuItem("Charger la partie");
		  private JMenuItem Quit = new JMenuItem("Quitter le jeu");
		  
			

		  public void main(String[] args){
		    Menu zFen = new Menu();
		  }

		  public Menu(){


		    //On initialise nos menus      
		    this.Jeu.add(Nouvelle);


		    Quit.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		        System.exit(0);
		      }
		      
		    });
		*/    
	/*	    Save.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent arg0) {
		        	MasterTable.fctSauvegarder();
		        }
		        
		      }); */
		    
		/*    Load.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent arg0) {
		        	MasterTable.fctRestaurer();
		        }
		        
		      }); 
		    */
		    
		/*    this.Jeu.add(Save);  
		    this.Jeu.add(Load);
		    this.Jeu.addSeparator();
		    this.Jeu.add(Quit);

		    //L'ordre d'ajout va d�terminer l'ordre d'apparition dans le menu de gauche � droite
		    //Le premier ajout� sera tout � gauche de la barre de menu et inversement pour le dernier
		    this.menuBar.add(Jeu);
		    this.menuBar.add(Highscores);
		    this.setJMenuBar(menuBar);
		    
		    this.setTitle("Eternity Game");
		    this.setSize(1280, 768);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setResizable(false);
		    setAlwaysOnTop(false);
		    //Instanciation d'un objet JPanel
		  //  JPanel pan = new JPanel();  
		//    pan.add(new Panneau());
		//  pan.add(new PanneauScore());
		//    pan.add(new PanneauDebut());
		    

		    
		//    this.setContentPane(pan);
		 //   this.setVisible(true);
		  }
		}


*/
}
