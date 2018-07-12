package lastPilot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Currency extends GameObject{

	private final float SPEED = -1; // moves at 5 pixels per tick.
	private final Image sprite;
	private Handler handler;
	private HUD hud;
	private int width;

	protected Currency(float x, float y, ID id, Handler handler,HUD hud){
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
		velY = SPEED;
		sprite = new ImageIcon("assets/currency.gif").getImage();
		width = sprite.getWidth(null);

	}
	
	public void render(Graphics g){
		
		g.drawImage(sprite, (int)(x - width/2), (int)y, null);
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle ((int)x,(int)y,16,16);
	}
	private void collision(){
		for(int i = 0;i <handler.object.size(); i ++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player ){
				
				
				
				
				if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(this);
					
					hud.credit++;
					
				}
					
			}
		}
	}
	
	public void tick() {
		//x += velX;
				y -= velY;
				collision();
				if (y<=-8 ) {
					System.out.println("removed");
					handler.removeObject(this);
				}
				if (y>=Game.HEIGHT+19 ) {
					
					handler.removeObject(this);
				}
				
				
				
				
				
	}
}
