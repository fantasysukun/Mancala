import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.JPanel;


public class MancalaPanel extends JPanel{
	private Mancala myMancala;
	public MancalaPanel(Mancala myM,int width, int height) {
		this.myMancala = myM;
		this.setPreferredSize(new Dimension(myMancala.getWidth() + 10, myMancala.getHeight() + 10));
	}

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		myMancala.draw(g2);
	}
}
