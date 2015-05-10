package timeAndScore;


//import java.lang.*;
//import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;

public class chrono
{
	private static int heure=0,minute=0,seconde=0,score=0;
	// private static String Newligne=System.getProperty("line.separator"); // j'essai de faire des retours à la ligne mais bon
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		
	
		/* Le timer */
		int delais=1000;
		ActionListener tache_timer;

		/* création des composants */
		final JLabel Label1 = new JLabel("Prêt à voir de la pâté?"); /* déclarer final car une classe interne va acceder à ce composant */

		final JButton debut = new JButton("COMMENCE LE JEU INFINITY YEAH");
		JButton fin = new JButton("Remise à zéro");
		JFrame fenetre = new JFrame("Chronomètre");
		JPanel Panel1 = new JPanel();

		/* Action réalisé par le timer */
		tache_timer= new ActionListener()
		{
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
			 chrono.score= 10000 - seconde * 10;
				
			 Label1.setText("Ton chrono de merde: "+heure+":"+minute+":"+seconde+"   "+"Et ton score bolosse! "+score);/* rafraichir le label */
			
			
				
			}
		};
		/* instanciation du timer */
		final Timer timer1= new Timer(delais,tache_timer);

		/* Ajout des composants aux conteneurs avec formatage */
		Panel1.add(debut);
		Panel1.add(fin);
		Label1.setBorder(new EmptyBorder(10,135,10,10));

		fenetre.getContentPane().add(Label1,"Center");

		fenetre.getContentPane().add(Panel1,"South");

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
					debut.setText("Non en fait il et trop nul arrête ");
					timer1.start();
				}
				else if(texte.compareTo("Stop ")==0)
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

		/* Afficher l'ihm */
		fenetre.pack();
		fenetre.setLocation(350,200);  /* Déplacer la fenetre à ce nouvel emplacement */
		fenetre.setSize(550,200);   /* dimension de la fenetre */
		fenetre.show();
	}
}