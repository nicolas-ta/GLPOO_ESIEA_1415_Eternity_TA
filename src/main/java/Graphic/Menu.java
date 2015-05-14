package Graphic;


import java.awt.Color;

import Initialisation.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {
   private JPanel pan = new JPanel();
  private JMenuBar menuBar = new JMenuBar();
  private JMenu Jeu = new JMenu("Jeu");
  private JMenu Highscores = new JMenu("Highscores");

  private JMenuItem Nouvelle = new JMenuItem("Nouvelle partie");
  private JMenuItem Save = new JMenuItem("Sauvegarder la partie");
  private JMenuItem Load = new JMenuItem("Charger la partie");
  private JMenuItem Quit = new JMenuItem("Quitter le jeu");
  
	private static int heure=0,minute=0,seconde=0,score=0;

  public static void main(String[] args){
	  
   Menu zFen = new Menu();  
   zFen.Score();

   
   
  }

  public Menu(){
	  
int n=0;
while(n<10){
System.out.println(n);
n++;
}

	    //On initialise nos menus      
	    this.Jeu.add(Nouvelle);


	    Quit.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	        System.exit(0);
	      }        
	    });
	    this.Jeu.add(Save);  
	    this.Jeu.add(Load);
	    this.Jeu.addSeparator();
	    this.Jeu.add(Quit);

	    //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
	    //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
	    this.menuBar.add(Jeu);
	    this.menuBar.add(Highscores);
	    this.setJMenuBar(menuBar);
	    
	    this.setTitle("Eternity Game");
	    this.setSize(1280, 768);
	    this.setBackground(Color.YELLOW);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    setAlwaysOnTop(false);
	
	
	        this.setVisible(true);


    Quit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
      }
      
    });
    
    Save.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {
        	MasterTable.fctSauvegarder();
        }
        
      }); 
    
    Load.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {
        	MasterTable.fctRestaurer();
        }
        
      }); 
    
    this.Jeu.add(Save);  
    this.Jeu.add(Load);
    this.Jeu.addSeparator();
    this.Jeu.add(Quit);

    //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
    //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
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
    JPanel pan = new JPanel();  
  /*  pan.add(new Panneau());
    pan.add(new PanneauScore());
    pan.add(new PanneauDebut());*/
    this.setContentPane(pan);
    this.setVisible(true);

  }
  
 private void Score(){
	
		    
System.out.println("lol");
		/* Le timer */
		int delais=1000;
		ActionListener tache_timer;

		/* création des composants */
		final JLabel Label1 = new JLabel("Prêt à voir de la pâté?"); /* déclarer final car une classe interne va acceder à ce composant */

		final JButton debut = new JButton("COMMENCE LE JEU INFINITY YEAH");
		JButton fin = new JButton("Remise à zéro");
		JPanel Panel1 = new JPanel();
	 
		/* Action réalisé par le timer */
		tache_timer= new ActionListener(){
			public void actionPerformed(ActionEvent e1)
			{
				
			
				seconde++;
				if(seconde==60)
				{
					seconde=0;
					minute++;
				}
				if(minute==60)
				{
					minute=0;
					heure++;
				}
			 Menu.score= 10000 - seconde * 10;
				
			 Label1.setText("Ton chrono de merde: "+heure+":"+minute+":"+seconde+"   "+"Et ton score bolosse! "+score);/* rafraichir le label */
			
			
				
			}
		};
		/* instanciation du timer */
		final Timer timer1= new Timer(delais,tache_timer);

		/* Ajout des composants aux conteneurs avec formatage */
		Panel1.add(debut);
		Panel1.add(fin);
		Label1.setBorder(new EmptyBorder(0,700,0,0));

	this.getContentPane().add(Label1,"Center");

		this.getContentPane().add(Panel1,"South");

		/* Action provoqué par l'utilisateur */
		/* Lors du clic sur le bouton debut */
		debut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String texte;
				texte=debut.getText();
				if(texte.compareTo("COMMENCE LE JEU INFINITY YEAH")==0)
				{
					debut.setText("Stop");
					timer1.start();
				}
				else if(texte.compareTo("Stop")==0)
				{
					debut.setText("COMMENCE LE JEU INFINITY YEAH");
					timer1.stop();
				}
			}
		});
		/* Lors du clic sur le bouton fin */
		fin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String texte;
				texte=debut.getText();
				if(texte.compareTo("COMMENCE LE JEU INFINITY YEAH")==0)
				{
					heure=0;
					minute=0;
					seconde=0;
					debut.setText("COMMENCE LE JEU INFINITY YEAH");
					Label1.setText(heure+":"+minute+":"+seconde);
			
				}
			}
		});
		

  }
 
  }
	
	
	
