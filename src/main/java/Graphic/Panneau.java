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
    int x1 = this.getWidth()/4;
    int y1 = this.getHeight()/4;
    this.setSize(512,768); 
    /*Permet de dessiner des cercles vide
    g.drawOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
     Permet de dessiner des cercles remplit
    g.fillOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
    	Permet de dessiner des rectangle (fill remplit et draw vide)
    	g.drawRect(x1, y1, this.getWidth()/2, this.getHeight()/2);
     Rectangle avec bord arrondi : x1, y1, width, height, arcWidth, arcHeight
    	g.drawRoundRect(x1, y1, this.getWidth()/4, this.getHeight()/4,10,10);
    	permet de dessiner des lignes : x1, y1, x2, y2
        g.drawLine(0,0,0,0);
        g.drawLine(0, this.getHeight(), this.getWidth(), 0);
       
      dessiner polygon
        int x[] = {20, 30, 50, 60, 60, 50, 30, 20};
        int y[] = {30, 20, 20, 30, 50, 60, 60, 50};
        g.fillPolygon(x, y, 8);*/
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
