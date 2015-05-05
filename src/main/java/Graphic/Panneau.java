package Graphic;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel; 

public class Panneau extends JPanel { 
  public void paintComponent(Graphics g){
    this.setSize(512,768); 
    this.setLocation(0, 0);
    Graphics2D g2d = (Graphics2D)g;       
    GradientPaint gp,gp2;
    gp = new GradientPaint(0, 0,Color.magenta, 50, 50, Color.cyan, false);
    gp2 = new GradientPaint(0, 1360,Color.magenta, 50, 50, Color.cyan, false);
    
    g2d.setPaint(gp);
    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    g2d.setPaint(gp2);
    g2d.fillRect(0, 0, this.getWidth(), this.getHeight()); 
    
    

    	
  }               
}
