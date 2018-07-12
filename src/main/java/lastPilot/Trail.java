package lastPilot;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{

	private float alpha = 1;
	private Handler handler;
	private float life;
	private float height, width;
	private Color color;
	public Trail(float x, float y, ID id, Color color,float width, float height,float life , Handler handler) {
		super(x, y, id);
		this.color = color;
		this.width= width/6;
		this.height=height/6;
		this.life=life;
		this.handler = handler;
	
	}

	
	public Rectangle getBounds() {
		
		return null;
	}

	
	public void tick() {
		if(alpha >life){
			alpha -=life - 0.0006f;
		}else handler.removeObject(this);
		
	}


	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		g.fillRect((int)x,(int) y,(int) width,(int) height);
		g.setColor(color);
		g.fillRect((int)x+13,(int) y,(int) width, (int)height);
		
		g2d.setComposite(makeTransparent(1));
		
	}

	private AlphaComposite makeTransparent (float alpha){
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type, alpha));
		
	}
}
