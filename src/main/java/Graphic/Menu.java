package Graphic;

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
  private JMenu test1 = new JMenu("Jeu");
  private JMenu test2 = new JMenu("Highscores");

  private JMenuItem item1 = new JMenuItem("Nouvelle partie");
  private JMenuItem item2 = new JMenuItem("Sauvegarder la partie");
  private JMenuItem item3 = new JMenuItem("Charger la partie");
  private JMenuItem item4 = new JMenuItem("Quitter le jeu");

  private JCheckBoxMenuItem jcmi1 = new JCheckBoxMenuItem("Choix 1");
  private JCheckBoxMenuItem jcmi2 = new JCheckBoxMenuItem("Choix 2");

  private JRadioButtonMenuItem jrmi1 = new JRadioButtonMenuItem("Radio 1");
  private JRadioButtonMenuItem jrmi2 = new JRadioButtonMenuItem("Radio 2");

  public static void main(String[] args){
    Menu zFen = new Menu();
  }

  public Menu(){


    //On initialise nos menus      
    this.test1.add(item1);


    //On met nos radios dans un ButtonGroup
    ButtonGroup bg = new ButtonGroup();
    bg.add(jrmi1);
    bg.add(jrmi1);
    //On présélectionne la première radio
    jrmi1.setSelected(true);



    //Ajout du sous-menu dans notre menu
    //Ajout d'un séparateur

    item2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
      }        
    });
    this.test1.add(item2);  
    this.test1.add(item3);
    this.test1.addSeparator();
    this.test1.add(item4);

    //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
    //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
    this.menuBar.add(test1);
    this.menuBar.add(test2);
    this.setJMenuBar(menuBar);
    
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
    pan.add(new PanneauDebut());
    this.setContentPane(pan);
    this.setVisible(true);
  }
}