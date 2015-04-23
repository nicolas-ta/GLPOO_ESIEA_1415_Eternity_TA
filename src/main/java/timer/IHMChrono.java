package timer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class IHMChrono extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	JButton demarrer = new JButton("demarrer");
	JButton suspendre = new JButton("suspendre");
	JButton reprendre = new JButton("reprendre");
	JButton arreter = new JButton("arreter");
	Chrono chrono;

	public IHMChrono(int duree) {
		setPreferredSize(new Dimension(500,300));
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		chrono = new Chrono(this, duree, 200, 120, 100);
		demarrer.addActionListener(this);
		suspendre.addActionListener(this);
		reprendre.addActionListener(this);
		arreter.addActionListener(this);
		add(demarrer);
		add(suspendre);
		add(reprendre);
		add(arreter);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();

		if (source == demarrer) chrono.demarrer();
		else if  (source == suspendre) chrono.suspendre();
		else if  (source == reprendre) chrono.reprendre();
		else if  (source == arreter) chrono.arreter();
	}

	public void paintComponent(Graphics g)  {
		super.paintComponent(g);
		chrono.dessine(g);
	}
}