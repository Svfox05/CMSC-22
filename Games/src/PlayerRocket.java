import java.awt.Color;
import java.awt.Graphics;

public class PlayerRocket implements Rocket{
	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	final double FRICTION = 0.50;
	public PlayerRocket(int player) {
		upAccel = false; 
		downAccel = false;
		y = 210; 
		yVel = 0;
		
		if(player == 1) {
			x = 20;
		} else {
			x = 660;
		}
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, (int)y, 20, 80);
		
	}

	public void setUpAccel(boolean input) {
		upAccel = input;
	}
	
	public void setDownAccel(boolean input){
		downAccel = input;
	}
	
	public void move() {
		if(upAccel){
			yVel -= 2;
		} else if(downAccel){
			yVel += 2;
		} else if(!upAccel && !downAccel){
			yVel *= FRICTION;
		}
		
		if(yVel >= 5){
			yVel = 5;
		} else if(yVel <= -5){
			yVel = -5;
		}
		
		y += yVel;
		
		if(y < 1){
			y = 1;
		} else if(y > 419){
			y = 419;
		}
	}
	
	public int getY() {
		return (int)y;
	}

}
