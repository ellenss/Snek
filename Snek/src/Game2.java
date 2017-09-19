import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Game2 extends JFrame implements KeyListener, ActionListener{

		//Objectifying
		Eple ep = new Eple();
		Snake s = new Snake();
		Timer t = new Timer(40, this);
		
		//Variabler
		String beveg = "hoyre";
		int poeng = 0;
		JLabel score = new JLabel("Score: " + poeng);
		

		
	public Game2(){
		//Setup
		score.setSize(1000, 50);
		score.setLocation(800, 300);		
		this.add(score);
		
		this.setTitle("Snake");
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.addKeyListener(this);
		t.start();
		
		this.setVisible(true);
	}
	
	public void drawAlt(){
		Graphics g = this.getGraphics();
		this.ep.DrawStuff(g);
		this.s.DrawStuff(g);
		g.drawRect(39, 49, 601, 601);
		if(beveg.equals("opp")){
			g.clearRect(s.xPunkter[s.antallDeler - 1], s.yPunkter[s.antallDeler - 1], 10, 10);
		}
		if(beveg.equals("ned")){
			g.clearRect(s.xPunkter[s.antallDeler - 1], s.yPunkter[s.antallDeler - 1], 10, 10);
		}
		if(beveg.equals("hoyre")){
			g.clearRect(s.xPunkter[s.antallDeler - 1], s.yPunkter[s.antallDeler - 1], 10, 10);
		}
		if(beveg.equals("venstre")){
			g.clearRect(s.xPunkter[s.antallDeler - 1], s.yPunkter[s.antallDeler - 1], 10, 10);
		}
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(null, "Beklager, du tapte spillet. Du fikk " + poeng + " poeng.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//Oppover
		if(arg0.getKeyCode()==KeyEvent.VK_UP){
			if(beveg == "ned"){
				//Do nothing
			}
			else{
				beveg = "opp";
			}			
		}
		//Nedover
		if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
			if(beveg == "opp"){
				//Do nothing
			}
			else{
				beveg = "ned";
			}
		}
		//Venstre
		if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
			if(beveg == "hoyre"){
				//Do nothing
			}
			else{
				beveg = "venstre";
			}
		}
		//Høyre
		if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
			if(beveg == "venstre"){
				//Do nothing
			}
			else{
				beveg = "hoyre";
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// Intersections:
		
		//Spiser eplet
		if (s.xPunkter[0] == ep.x && s.yPunkter[0] == ep.y) {
			poeng += 1;
			score.setText("Score: " + poeng);
			ep.nyttEple();
			s.antallDeler += 1;
		}
		
		//Krasjer i veggen
		if (s.xPunkter[0] < 40 || s.xPunkter[0] > 635 || s.yPunkter[0] < 50 || s.yPunkter[0] > 645) {
			gameOver();
		}
		for (int i = 3; i < s.antallDeler; i++) {
			if (s.xPunkter[0] == s.xPunkter[i] && s.yPunkter[0] == s.yPunkter[i]) {
				gameOver();
			}
		}
		
		// Bevegelse:
		for (int i = s.antallDeler - 1; i > 0; i--) {
			s.yPunkter[i] = s.yPunkter[i-1];
			s.xPunkter[i] = s.xPunkter[i-1];
		}
		if (beveg.equals("opp")){
			s.yPunkter[0] -= 10;
		}
		if (beveg.equals("ned")){
			s.yPunkter[0] += 10;
		}
		if (beveg.equals("venstre")){
			s.xPunkter[0] -= 10;
		}
		if (beveg.equals("hoyre")){
			s.xPunkter[0] += 10;
		}
		this.drawAlt();
	}
}
