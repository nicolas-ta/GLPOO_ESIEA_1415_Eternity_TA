import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Panneau extends JPanel { 
  public void paintComponent(Graphics g){
    int x1 = this.getWidth()/4;
    int y1 = this.getHeight()/4;
    //Permet de dessiner des cercles vide
    g.drawOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
    /* Permet de dessiner des cercles remplit
    g.fillOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
    	Permet de dessiner des rectangle (fill remplit et draw vide)*/
    	g.drawRect(x1, y1, this.getWidth()/2, this.getHeight()/2);
    // Rectangle avec bord arrondi : x1, y1, width, height, arcWidth, arcHeight
    	g.drawRoundRect(x1, y1, this.getWidth()/4, this.getHeight()/4,10,10);
    	//permet de dessiner des lignes : x1, y1, x2, y2
        g.drawLine(0, 0, this.getWidth(), this.getHeight());
        g.drawLine(0, this.getHeight(), this.getWidth(), 0);
        
        //dessiner polygon
        int x[] = {20, 30, 50, 60, 60, 50, 30, 20};
        int y[] = {30, 20, 20, 30, 50, 60, 60, 50};
        g.fillPolygon(x, y, 8);
    	
  }               
}
