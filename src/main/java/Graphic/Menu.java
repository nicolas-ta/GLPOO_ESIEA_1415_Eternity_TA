package Graphic;

import Initialisation.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class Menu extends JFrame {
  private JMenuBar menuBar = new JMenuBar();
  private JMenu Jeu = new JMenu("Jeu");
  private JMenu Highscores = new JMenu("Highscores");

  private JMenuItem Nouvelle = new JMenuItem("Nouvelle partie");
  private JMenuItem Save = new JMenuItem("Sauvegarder la partie");
  private JMenuItem Load = new JMenuItem("Charger la partie");
  private JMenuItem Quit = new JMenuItem("Quitter le jeu");

  public static void main(String[] args){
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
    pan.add(new Panneau());
    pan.add(new PanneauScore());
    pan.add(new PanneauDebut());
    this.setContentPane(pan);
    this.setVisible(true);
  }
}