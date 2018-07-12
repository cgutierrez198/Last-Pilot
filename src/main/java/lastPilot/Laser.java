package lastPilot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Laser extends GameObject{
	private final float SPEED = 5; //missile moves at 5 pixels per tick.
	private final Image sprite;
	private Handler handler;
	private HUD hud;
	private int width;
	public Laser(float x, float y, ID id,Handler handler,HUD hud) {
		super(x, y, id);
		this.hud = hud;
		velY= -SPEED;
		sprite = new ImageIcon("laser.png").getImage();
		
		width = sprite.getWidth(null);
	}

	public Rectangle getBounds() {
		
		return new Rectangle ((int)x,(int)y,16,16);
	}

	@Override
	public void tick() {
		y -= velY;
		collision();
		if (y<=-8 ) {
			
			handler.removeObject(this);
		}
		
		
	}
	private void collision(){
		for(int i = 0;i <handler.object.size(); i ++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Track_Enemy || tempObject.getID() == ID.Basic_Enemy){
				
				
				
				
				if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(this);
					handler.object.remove(i);
					hud.credit++;
					
				}
					
			}
		}
	}
	@Override
	public void render(Graphics g) {

		g.drawImage(sprite, (int)(x - width/2), (int)y, null);
		g.setColor(Color.GRAY);
		//g.fillOval((int)x, (int) y, 4, 4);
		//g.drawOval((int)x, (int) y, 4, 4);
	}

}
