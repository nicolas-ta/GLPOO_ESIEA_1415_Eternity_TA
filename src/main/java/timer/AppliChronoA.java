package timer;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JApplet;


public class AppliChronoA extends JApplet  {
	private static final long serialVersionUID = 1L;

	public void init()	{
		IHMChrono vue = new IHMChrono(Integer.parseInt(getParameter("duree")));
		vue.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setContentPane(vue);
		}
}