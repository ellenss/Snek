import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;


public class Eple extends Objekt{

	Random rg = new Random();
	
	public Eple(){
		this.x = (rg.nextInt(60) + 5)*10;
		this.y = (rg.nextInt(60) + 4)*10;
		this.hoyde = 10;
		this.bredde = 10;
		this.bilde = new ImageIcon(getClass().getResource("Apple.png"));
	}
	
	public void nyttEple() {
		this.x = rg.nextInt(60)*10;
		this.y = rg.nextInt(60)*10;
		
		//Kjører while loops for å få nye tall om eplene er out of bounds
		while(this.x < 45 || this.x > 635){
			this.x = rg.nextInt(60)*10;
		}
		while(this.y < 55 || this.y > 645){//Sjekk disse talla....
			this.y = rg.nextInt(60)*10;
		}
	}
	
	public void DrawStuff(Graphics g){
		this.bilde.paintIcon(null, g, this.x, this.y);
	}
}
