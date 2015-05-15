package Jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Interface extends JFrame implements ActionListener,MouseListener{
	
	

	
	private static int coups=0;
	private static int jeu_init=0;
	private static int  score= 10000;
	private static JPanel panel;
	private static JFrame frame;
	private static JButton begin;
	private static JButton load;
	private static JButton Rotate;
	private static JButton save;
	private static JButton rules;
	private static JLabel time = new JLabel("00:00");
	private static JLabel coup = new JLabel("Coups joués = " + coups);
	private static JLabel scoring = new JLabel("Score = "+ score);
	private static JLabel regles = new JLabel("Les regles");

	private static JButton[][] PlateauJeu;
	private static JButton[][] Puzzle;
	
	
	Plateau Terrain;
	Plateau Reserve;
	
	
	//On mettra la fonction chrono de TArlouze
   
	Timer temps;
    int compteur = 0;
  
    ActionListener action_timer = new ActionListener()  {
		  public void actionPerformed(ActionEvent e1)  {
			  
			if(jeu_init==0){	temps.stop(); }
		
	
					  
			  int min = compteur/60;
	          int sec = compteur- (min*60);
	          String sm = Integer.toString(min);
	          if (min < 10){ sm = "0" + Integer.toString(min);}
	          String ss = Integer.toString(sec);
	          if (sec < 10){ ss = "0" + Integer.toString(sec);}
	     	 compteur++;	
	 
	          //Actualiser le JLabel
	     	 scoring.setText("Score = "+score);
			  time.setText(sm+":"+ss);		
			  coup.setText("Coups joués = "+coups);
		    	 score= 10000 - compteur*10 - coups*10;
		    	regles.setText("Vous devez placer les pièces de la réserve sur le plateau de sorte à ce que les couleurs d'une pièce soit les mêmes que les couleurs adjacentes des autres pièces."+" Pour cela, faites glisser et lachez les pièces sur le plateau et faites tourner les pièces en cliquant dessus."+ "Moins vous userez de mouvement et de temps et plus votre score sera élevée. Amusez vous bien :)");	  
			
		 }
     };		 
     
 	//Remise a zero du timer
 	private void ResetTimer(){
 		temps.stop(); 
 		temps = new Timer(1000, action_timer);		
 		temps.start();  
 		compteur = 0;
 		coups=0;
 		
 		
 	}	
	

	private void init_terrain(){
		
		PlateauJeu = new JButton[4][4];
	    Terrain = new Plateau(4,4,150);	
		
		//Creation des bouton des piece du plateau
		for(int i=0; i<4 ; i++){
			for(int j=0; j<4 ; j++){	
				//bouton
				PlateauJeu[i][j] = new JButton();			    

				PlateauJeu[i][j].setBounds(211+10*i+140*i, 125+5*j+140*j, 150,150);
				PlateauJeu[i][j].addActionListener(this); 
				PlateauJeu[i][j].setContentAreaFilled(false); 
				PlateauJeu[i][j].addMouseListener(this); 
			
				panel.add(PlateauJeu[i][j]);
				
				
				Terrain.pieces[i][j].setBounds(211+10*i+140*i, 125+5*j+140*j, 150,150);	
				panel.add(Terrain.pieces[i][j]);
			}
		}		
	}
	
	
	
	private void init_reserve(){
		
		Reserve = new Plateau(4,4,65);	
		Puzzle = new JButton[4][4];
			
		
		
		//Peut �tre a modif, pense qu'il y a une erreur
	Reserve.Lecture();
		
		//Creation des bouton des pieces du Reserve
	    for(int i=0; i<2 ; i++){
			
	    	for(int j=0; j<4 ; j++){		
				
				//bouton
				
				Puzzle[i][j] = new JButton();			
				Puzzle[i][j].setBounds(25+55*i+50*i, 205+55*j+70*j, 65,65); 
				Puzzle[i][j].addActionListener(this); 
			    Puzzle[i][j].setContentAreaFilled(false);	
			    Puzzle[i][j].addMouseListener(this); 	
			    panel.add(Puzzle[i][j]);
			    
			   
			    Reserve.pieces[i][j].setBounds(25+55*i+50*i, 205+55*j+70*j, 65,65);	
			    panel.add(Reserve.pieces[i][j]);
			}
		
	    }	 
 for(int i=2; i<4 ; i++){
			
	    	for(int j=0; j<4 ; j++){		
				
				//bouton
				
				Puzzle[i][j] = new JButton();			
				Puzzle[i][j].setBounds(620+55*i+50*i, 205+55*j+70*j, 65,65); 
				Puzzle[i][j].addActionListener(this); 
			    Puzzle[i][j].setContentAreaFilled(false);	
			    Puzzle[i][j].addMouseListener(this); 	
			    panel.add(Puzzle[i][j]);
			    
			   
			    Reserve.pieces[i][j].setBounds(620+55*i+50*i, 205+55*j+70*j, 65,65);	
			    panel.add(Reserve.pieces[i][j]);
			}
		
	    }	 
	}
		
	
public void Debut(){	
		

	
		//Creation de la fenetre
	//	System.out.println("Creation de la fenetre");	
		frame = new JFrame("Eternity Game");  
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	    
	    panel = (JPanel)frame.getContentPane();  
	    panel.setLayout(null);
		panel.setBackground(new Color(186,44,44));
	    
	   // panel.setBackground(Color.BLUE);
	    //Creation des object graphique
	//    System.out.println("Creation des object graphique");	
	    

		Font serif = new Font("Sans Serif", Font.CENTER_BASELINE,12);
		


		
		Font fontScore = new Font("Arial", Font.BOLD,30);
		scoring.setFont(fontScore);		
		scoring.setBounds(280,10,500,30);	

		time.setFont(fontScore);		
		time.setBounds(500,40,500,30);	
		
		coup.setFont(fontScore);
		coup.setBounds(500,10,500,30);
		

		
	
		
		//Bouton Start
		Font fontStart = new Font("Sans Serif", Font.BOLD,72);
		 begin = new JButton("Commencer");	
		 begin.addActionListener(this);
		 begin.setFont(fontStart);
		 begin.setBounds(25, 84, 975,632);
		 begin.setBackground(Color.DARK_GRAY);
		 begin.setForeground(Color.BLACK);
        
		 
        //bouton rules
        rules = new JButton("Règles du jeu");
        rules.addActionListener(this);
        rules.setFont(serif);
        rules.setBounds(512, 85, 215,30);
        rules.setBackground(Color.lightGray);
        
      
        //bouton charger
        load = new JButton("Charger la partie");
        load.addActionListener(this);
        load.setFont(serif);
        load.setBounds(312, 85, 215,30);
        load.setBackground(Color.lightGray);
        
        //bouton sauvegarder
        save = new JButton("Sauvegarder la partie");
        save.addActionListener(this);
        save.setFont(serif);
        save.setBounds(512, 85, 215,30);
        save.setBackground(Color.lightGray);
        
        //On ajoute tout sa a la page
        panel.add(time);
        panel.add(scoring);
        panel.add(coup);
        panel.add(begin);   
        panel.add(rules);
      //  panel.add(load);
     //   panel.add(save);
        
	}
	


	public Interface() {

		
		//Debut nouvelle partie
	//	System.out.println("Debut nouvelle partie");	
		Debut();
		
		
	    init_terrain();
	 init_reserve();

        frame.setSize(1024, 768);
		frame.setVisible(true);	
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
				
		temps = new Timer(1000, action_timer);		
	
		temps.start();     
		
	}
	
		
	
	//Evenement	
	private Piece last=null;
	public void actionPerformed(ActionEvent e) {			

		
		//Pour chaque piece du Terrain
		for(int i=0; i<4 ; i++){
			for(int j=0; j<4 ; j++){	
				if(e.getSource() == PlateauJeu[i][j]){
					Terrain.pieces[i][j].rotationDroite();
					Terrain.verification();
					last = Terrain.pieces[i][j];
				}				
			}
		}	
				
		
		//Pour chaque piece de la Reserve

		for(int i=0; i<4 ; i++){
			
			for(int j=0; j<4 ; j++){	
			
				if(e.getSource() == Puzzle[i][j]){
				
					Reserve.pieces[i][j].rotationDroite();
					Terrain.verification();
					last = Reserve.pieces[i][j];
			
				}				
			
			}
		
		}	
		
		// Si bouton sauvegarde
	if(e.getSource() == save){
			
			if (last != null){
			
				Reserve.fctSauvegarder();
			
				}	
		
			}	
		
		
		// Si bouton Rotate presser	
		if(e.getSource() == Rotate){
			
			if (last != null){
			
					last.rotationDroite();	
					last.update();
				}	
		
			}	
		
		String texte;
	       texte=begin.getText();
	       Font serif = new Font("Sans Serif", Font.CENTER_BASELINE,12);


	       if(e.getSource() == begin){
	       if(texte.compareTo("Commencer")==0)
	       {
	    	   jeu_init=1;
	    		temps.start(); 
			
	    		System.out.println("C'est parti.");
	    	   begin.setText("Recommencer la partie");
	  		 begin.setBounds(312, 85, 215,30);
	    		 begin.setBackground(Color.lightGray);
	    		 begin.setForeground(Color.white);
	    		 begin.setFont(serif);
	
	    	   
	       }
	      
	       else if(texte.compareTo("Recommencer la partie")==0)
	       {
		
				Terrain.init();		
				Reserve.Lecture();
				ResetTimer();
		    
		    
		    
				
	       }
	       
	       }
	       
	       //regles du eu
	       String textrules;
			Font fontStart = new Font("Sans Serif", Font.BOLD,42);
	      textrules=rules.getText();
	       if(e.getSource() == rules){
	       if(textrules.compareTo("Règles du jeu")==0)
	       {
	    	 
	    		temps.stop(); 
			
	    
	    		   rules.setText("Rêgles");
	    			  rules.setBounds(25,100, 975,632);
	    		 rules.setBackground(Color.DARK_GRAY);
	    		 rules.setForeground(Color.BLACK);
	    	      panel.add(regles);
	    	   
	       }
	      
	       else if(textrules.compareTo("Règles du jeu")!=0)
	       {
	    	   rules.setBounds(512, 85, 215,30);
	    	   rules.setText("Règles du jeu");
			temps.start();
			
		    
		    
				
	       }
	       
	       }
	       
	       
	       
	       
	       
	   	}


	



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
			coups++;
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

//Pour chaque piece de la Reserve
for(int i=0; i<4 ; i++){
for(int j=0; j<4 ; j++){	
if(e.getSource() == Puzzle[i][j]){
	stop = Reserve.pieces[i][j];
}				
}
}
}
}

	
	
	
