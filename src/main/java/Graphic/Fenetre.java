import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
	public class Fenetre extends JFrame {
		  public Fenetre(){
		    this.setTitle("Eternity Game");
		    this.setSize(1024, 768);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setResizable(false);
		    setAlwaysOnTop(false);
		    //Instanciation d'un objet JPanel
		    JPanel pan = new JPanel();  
		    pan.add(new Panneau());
		    pan.add(new PanneauScore());
		    this.setContentPane(pan);
		    this.setVisible(true);
		  }

}
