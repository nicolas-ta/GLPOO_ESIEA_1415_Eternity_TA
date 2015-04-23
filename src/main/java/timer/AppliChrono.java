package timer;

import javax.swing.JFrame;


public class AppliChrono {
	  public static void main(String[] argv) {   
	      JFrame fenetre = new JFrame();
	      fenetre.setContentPane(new IHMChrono(Integer.parseInt(argv[0])));
	      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      fenetre.setLocation(100, 100);
	      fenetre.pack();
	      fenetre.setVisible(true);
	    }
	}
