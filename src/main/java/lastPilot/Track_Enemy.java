package lastPilot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.Image;
import javax.swing.ImageIcon;
public class Track_Enemy extends GameObject {
	
	Handler handler;
	GameObject player;
	Random r;
	private final Image sprite;
	
	public Track_Enemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler= handler;
		//velX=5;
		r=new Random();
		for (int i = 0; i< handler.object.size(); i ++){
			if( handler.object.get(i).getID()== ID.Player) player = handler.object.get(i);
			
		}
		sprite = new ImageIcon("assets/enemy.png").getImage();
	}

	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,16,16);
	}

	public void tick() {
		if(player.gety()>=y+30&&player.getx()>x+25|player.getx()<x-25){
		x+=velX;
		y+=velY;
		}
		else if(player.getx()>x+5||player.getx()<x-10)
			y+=5;
		else if(y<=-25)
			y+=10;
		else if(y>=Game.HEIGHT-50){
			y=r.nextInt(1)*-1;
			x=r.nextInt(Game.WIDTH+32);
		}
		else if(y>=player.gety()+20)
			y+=velY+4;
		
		float diffx = x - player.getx()-8;
		float diffy = y - player.gety()-8;
		
		float distance =(float) Math.sqrt( (x-player.getx()) * (x-player.getx()) + (y-player.gety()) * (y-player.gety()) );
		
		velX = (float) ((-1.0/distance)* diffx);
		velY = (float) ((-1.0/distance)* diffy);
		
		
		
		
		
		
		
	
		//if (y<=0 || y>=Game.HEIGHT-32) velY*=-1;
		//if (x<=0 || x>=Game.WIDTH-32) velX*=-1;
		
		handler.addObject(new Trail(x,y,ID.Trail,Color.red,16,16,0.03f,handler));
	}

	
	public void render(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;	
	
	g.drawImage(sprite,(int)x,(int)y,null);
                        
                                    
	}


	
	
}
