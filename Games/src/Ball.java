import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	double xVel, yVel, x, y;
	
	
	public Ball() {
		x = 350;
		y = 250;
		xVel = getSpeedRandom() * getDirection();
		yVel = getSpeedRandom() * getDirection();;
		
	}
	
	public double getSpeedRandom() {
		return (Math.random() *3 + 2);
	}
	
	public int getDirection() {
		int rand = (int)(Math.random() * 2);
		if(rand == 1){
			return 1;
		} else {
			return 2;
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.white);
		g.fillOval((int)x-10, (int)y-10, 25, 25);
	}
	
	public void RocketCollision(Rocket player1, Rocket player2){
		if(x <= 50){
			if(y >= player1.getY() && y <= player1.getY() + 80){
				xVel = -xVel;
			}
		} else if(x >= 650){
			if(y >= player2.getY() && y <= player2.getY() + 80){
				xVel = -xVel;
			}
		}
	}
	
	public void move(){
		x += xVel;
		y += yVel;
		
		if(y < 10){
			yVel = -yVel;
		} else if(y > 490){
			yVel = -yVel;
		}
	}
	
	public int getX(){
		return (int) x;
	}
	
	public int getY(){
		return (int) y;
	}
	
	
}
