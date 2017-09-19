import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game extends JFrame implements ActionListener, KeyListener{
	
	public Snake s = new Snake();
	String bevegelse = "h";
	
	public Game(){
		
		this.addKeyListener(this);
		
		this.setTitle("Snake");
		this.setLayout(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//Tegne
	public void drawStuff(){
		Graphics g = this.getGraphics();
		g.clearRect(0,0,this.getWidth(),this.getHeight());
		this.s.DrawStuff(g);	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	
	//Sjekker hva som er trykket
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_UP){
			System.out.println("Oppover");
			bevegelse = "o";
		}
		if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
			System.out.println("Venstre");
			bevegelse = "v";
		}
		if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
			System.out.println("Nedover");
			bevegelse = "n";
		}
		if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
			System.out.println("Høyre");
			bevegelse = "h";
		}
		
		//Beveger slangen
		if(bevegelse == "o"){
			this.s.y = this.s.y -10;
		}
		else if(bevegelse == "v"){
			this.s.x = this.s.x -10;
		}
		else if(bevegelse == "n"){
			this.s.y = this.s.y +10;
		}
		else{
			this.s.x = this.s.x +10;
		}
		
		this.drawStuff();
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
