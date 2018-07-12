package lastPilot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class PassingStar extends GameObject{
	Handler handler;
	GameObject player;
	private Image star;
	private Random r;
	public PassingStar(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler= handler;
		//velX=5;
		velY= 1;
		
		
		r=new Random();
	}

	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,16,16);
	}

	public void tick() {
		//x += velX;
		y += velY;
		
		if (y<=0 || y>=Game.HEIGHT-32) velY*=-1;
		if (x<=0 || x>=Game.WIDTH-32) velX*=-1;
		
		if(y<=0)
			y+=10;
		else if(y>=Game.HEIGHT-35){
			y=r.nextInt(1)*-25;
			x=r.nextInt(Game.WIDTH+32);
		}
	}

	
	public void render(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;	
	
	
	g.setColor(Color.WHITE);
	g.drawOval((int)x, (int) y, 1, 1);
	
	}


	
}
