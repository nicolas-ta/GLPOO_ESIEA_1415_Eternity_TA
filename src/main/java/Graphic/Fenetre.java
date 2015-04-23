import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;

	public class Fenetre extends JFrame {
		  public Fenetre(){
		    this.setTitle("Eternity Game");
		    this.setSize(1024, 768);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setResizable(true);
		    setAlwaysOnTop(false);
		    //Instanciation d'un objet JPanel
		    JPanel pan = new JPanel();
		    //Définition de sa couleur de fond
		    pan.setBackground(Color.RED);    
		    this.setContentPane(pan);
		    this.setContentPane(new Panneau());
		    this.setVisible(true);
		  }

}
