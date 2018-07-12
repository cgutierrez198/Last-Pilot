package lastPilot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Image;
public class Basic_Enemy extends GameObject {
	
	Handler handler;
	GameObject player;
	private final Image sprite;
	public Basic_Enemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler= handler;
		//velX=5;
		velY= 5;
		//for (int i =0;handler.object.get(i))
		sprite = new ImageIcon("assets/enemy.png").getImage();
	}

	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,16,16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if (y<=0 || y>=Game.HEIGHT-32) velY*=-1;
		if (x<=0 || x>=Game.WIDTH-32) velX*=-1;
		
		handler.addObject(new Trail(x,y,ID.Trail,Color.red,16,16,0.03f,handler));
	}

	
	public void render(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;	
	
	g.drawImage(sprite,(int)x,(int)y,null);
                       
                                    
	}


	
	
}
