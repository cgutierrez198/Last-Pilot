package lastPilot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import lastPilot.Game.STATE;

public class Menu extends UIObject{
	

	
	private int Mx,My;
	
	public Menu(Game game, Handler handler){
		super(game);

		
		
		
		
	}
	public void mouseMoved(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
		Mx=mx;
		My=my;
		
	}
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		if (mouseOver(mx,my,30,50,120,64 )&&getState()==STATE.Menu){
			
			setState( STATE.singleMenu);
			
		}
		
		
		
		
		if (mouseOver(mx,my,30,190,120,64)&&getState()==STATE.Menu){
			
			setState( STATE.Help);
			
		}
		
		if (mouseOver(mx,my,30,260,120,64)&&getState()==STATE.Menu){
			
			System.exit(1);
			
		}
	}
	
	public void mouseReleased(MouseEvent e){
		
		
	}
	
	public void tick(){
		 
	}
	
	public void render(Graphics g){
		
		
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		g.setColor(Color.GRAY);
		g.drawRect(30, 50, 120, 40);
		if (mouseOver(Mx,My,30,50,120,40)){g.setColor(Color.WHITE);}
		g.drawString("Single Player",55 , 75);
		
		g.setColor(Color.GRAY);
		g.drawRect(30, 120, 120, 40);
		if (mouseOver(Mx,My,30,120,120,40)){g.setColor(Color.WHITE);}
		g.drawString("Multi-Player",60 , 145);
		
		g.setColor(Color.GRAY);
		g.drawRect(30, 190, 120, 40);
		if (mouseOver(Mx,My,30,190,120,40)){g.setColor(Color.WHITE);}
		g.drawString("Help",80 , 215);
		
		g.setColor(Color.GRAY);
		g.drawRect(30, 260, 120, 40);
		if (mouseOver(Mx,My,30,260,120,40)){g.setColor(Color.WHITE);}
		g.drawString("Quit",80 , 285);
		
	}
}
