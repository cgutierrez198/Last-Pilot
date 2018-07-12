package lastPilot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Image;
public class Player extends GameObject{
	
	Handler  handler;
	public static float testX;
	public static float testY;
	private final Image sprite;

	private boolean fired;
	public Player(float x, float y, ID id,Handler handler){
		super(x,y,id);
		this.handler = handler;
		fired = false;
		sprite = new ImageIcon("assets/player1.png").getImage();
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,32,32);
	}
	public void tick() {
		x += velX;
		y += velY;
		
		x= Game.clamp((int)x, 0, Game.WIDTH-39);
		y= Game.clamp((int)y, 0, Game.HEIGHT-61);
		
		collision();
		testX=x;
		testY=y;
	}
	
	private void collision(){
		for(int i = 0;i <handler.object.size(); i ++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Basic_Enemy){
				
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 2;
				//	handler.object.remove(i);
					
				}
					
			}
		}
	}
	
	public void render(Graphics g) {
		
	Graphics2D g2d = (Graphics2D) g;
   
	g.drawImage(sprite,(int)x,(int)y,null);
                         
                                    
	
		
	}
	
	
	
	
}
