import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author User/SV-Admin
 *
 */
public class Pong extends Applet implements Runnable, KeyListener{
	final int HEIGHT = 500, WIDTH = 700;
	Thread thread;
	PlayerRocket player1, player2;
	Ball ball1;
	boolean gameStart;
	Graphics gfx;
	Image img;
	
	
	public void init(){
		this.resize(WIDTH, HEIGHT);
		
		gameStart = false;
		
		this.addKeyListener(this);
		
		player1 = new PlayerRocket(1);
		player2 = new PlayerRocket(2);
		
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		
		ball1 = new Ball();
		thread = new Thread(this);
		thread.start();
		
	}
	
	public void paint(Graphics g){
		
		gfx.setColor(Color.blue);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(ball1.getX() < -10 || ball1.getX() > 710){
			gfx.setColor(Color.green);
			gfx.drawString("Game Over!", 320, 250);
		} else{
			player1.draw(gfx);
			player2.draw(gfx);
			ball1.draw(gfx);
		}
		
		player1.draw(gfx);
		player2.draw(gfx);
		ball1.draw(gfx);
		
		if(!gameStart){
			gfx.setColor(Color.green);
			gfx.drawString("Pong", 340, 100);
			gfx.drawString("Press the Enter key to start the game...", 260, 130);
		}
		g.drawImage(img, 0, 0, this);
		
	}
	
	public void update(Graphics g){
		paint(g);
	}


	public void run() {

		for(;;){
			if(gameStart){
				player1.move();
				player2.move();
				ball1.move();
				ball1.RocketCollision(player1, player2);
			}
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}


	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W){
			player1.setUpAccel(true);
		} else if(e.getKeyCode() == KeyEvent.VK_UP){
			player2.setUpAccel(true);
		} else if(e.getKeyCode() == KeyEvent.VK_S){
			player1.setDownAccel(true);
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			player2.setDownAccel(true);
		} else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			gameStart = true;
		}
	}


	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W){
			player1.setUpAccel(false);
		} else if(e.getKeyCode() == KeyEvent.VK_UP){
			player2.setUpAccel(false);
		} else if(e.getKeyCode() == KeyEvent.VK_S){
			player1.setDownAccel(false);
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			player2.setDownAccel(false);
		}
	}


	public void keyTyped(KeyEvent arg0) {

		
	}
	
}
