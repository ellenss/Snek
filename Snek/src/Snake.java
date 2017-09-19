import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;


public class Snake extends Objekt{

	public final int xPunkter[] = new int[900];
	public final int yPunkter[] = new int[900];
	int antallDeler = 5;
	ImageIcon hode, hale;
	
	public Snake(){
		this.hoyde = 10;
		this.bredde = 10;
		this.bilde = new ImageIcon(getClass().getResource("Body.png"));
		hode = new ImageIcon(getClass().getResource("Hode.png"));
		hale = new ImageIcon(getClass().getResource("Hale.png"));
		
		for (int i = 0; i < antallDeler; i++) {
			xPunkter[i] = 40 - i*10;
			yPunkter[i] = 50;
		}
	}
	
	public void DrawStuff(Graphics g){
		for (int i = 1; i < antallDeler - 1; i++) {	
			this.bilde.paintIcon(null, g, xPunkter[i], yPunkter[i]);
		}
		hode.paintIcon(null, g, xPunkter[0], yPunkter[0]);
		hale.paintIcon(null, g, xPunkter[4], yPunkter[4]);
	}
}
