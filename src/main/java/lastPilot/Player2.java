package lastPilot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player2 extends GameObject{
	
	
	public Player2(float x, float y, ID id){
		super(x,y,id);
	}

	
	public void tick() {
		x += velX;
		y += velY;	
		
	}

	
	public void render(Graphics g) {
	g.setColor(Color.white);
	g.fillRect((int)x,(int) y, 32, 32);
	
	
		
	}


	
	public Rectangle getBounds() {
		
		return null;
	}
}
