import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.JPanel;


public class PitPanel extends JPanel{
	private Pit myPit;
	public PitPanel(Pit pit) {
		this.myPit = pit;
		this.setPreferredSize(new Dimension(myPit.getWidth() + 5, myPit.getHeight() + 5));
		this.addMouseListener(myPit);
	}

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		myPit.draw(g2);
	/*	g.setColor(Color.RED);
		g.fillRect(0, 0, getWidth(), getHeight());*/
	}
}
