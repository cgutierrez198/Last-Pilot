package lastPilot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import lastPilot.Game.STATE;

public abstract class UIObject extends MouseAdapter{

	protected Game game;
	
	
	private int bgX,bgY;
	


	protected int My,Mx;
	
	public UIObject(Game game){
		
		
		this.game = game;
		
		
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
		
		if (mouseOver(mx,my,5,10,100,40)&&game.gameState==STATE.Help){
			
			game.gameState = STATE.Menu;
			
		}
		
			
		}
	
	public abstract void tick();
	
	public boolean mouseOver(int mx, int my, int x, int y,int width, int height){
		if (mx > x && mx <x+width){
			if(my > y && my <y + height){
				
				return true;
			}else return false;
			
		}else return false;
		
	}
	public abstract void render(Graphics g);
	public void setMx(int Mx){this.Mx = Mx;}
	public int getMx(){return Mx;}
	
	public void setMy(int My){this.My = My;}
	public int getMy(){return Mx;}
	
	protected void setState(STATE state){game.gameState = state;}
	protected STATE getState(){return game.gameState;}
	
	protected int getWidth(){return game.getWidth();}
	protected int getHeight(){return game.getHeight();}
	

	
	

}
