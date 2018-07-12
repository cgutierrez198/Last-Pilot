package lastPilot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Missile extends GameObject{
 
	private final float SPEED = 5; //missile moves at 5 pixels per tick.
	private final Image sprite;
	private Handler handler;
	private HUD hud;
	private int width;

	protected Missile(float x, float y, ID id, Handler handler,HUD hud){
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
		velY = SPEED;
		sprite = new ImageIcon("assets/missile.png").getImage();
		width = sprite.getWidth(null);

	}
	
	public void render(Graphics g){
		
		//g.drawImage(sprite, (int)(x - width/2), (int)y, null);
		g.setColor(Color.GRAY);
		g.fillOval((int)x, (int) y, 4, 4);
		g.drawOval((int)x, (int) y, 4, 4);
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle ((int)x,(int)y,16,16);
	}
	private void collision(){
		for(int i = 0;i <handler.object.size(); i ++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Track_Enemy || tempObject.getID() == ID.Basic_Enemy){
				
				
				
				
				if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(this);
					handler.object.remove(i);
					handler.addObject(new Currency((int)x,(int)y,ID.Currency,handler,hud));
					
				}
					
			}
		}
	}
	
	public void tick() {
		//x += velX;
				y -= velY;
				collision();
				if (y<=-8 ) {
					
					handler.removeObject(this);
				}
				
				
				
				
				
	}
}
