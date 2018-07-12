package lastPilot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import lastPilot.Game.STATE;

public class ShopMenu extends UIObject{

	private HUD hud;
	private Image missile,laser,doubleShot,TripleShot;
	public ShopMenu(Game game,HUD hud) {
		super(game);
		this.hud = hud;
		missile = new ImageIcon("assets/missile.png").getImage();
		
		laser = new ImageIcon("assets/laser.png").getImage();

	}
	@Override
	public void tick() {
		
		
	}
	

	@Override
	public void render(Graphics g) {

		
		g.setFont(new Font("Arial", Font.PLAIN, 22));
		g.setColor(Color.GRAY);
		g.drawRect(5,10 , 100, 40);
		
		
		
		g.setFont(new Font("Arial", Font.PLAIN, 15));
		g.drawString("Health: "+hud.HEALTH,20 ,140);
		g.drawString("String Spot: ",20 ,190);
		g.drawString("ammmo: "+hud.getScore(),20 ,240);
		
		
		g.setFont(new Font("Arial", Font.PLAIN, 22));
		if (super.mouseOver(Mx,My,5,10,100,40)){g.setColor(Color.WHITE);}
		g.drawString("Return",20 ,40);
		
		g.setFont(new Font("Arial", Font.PLAIN, 15));
		
		g.setColor(Color.GRAY);
		g.drawRect(150, 55, 100, 120);
		g.drawRect(150, 140, 100, 35);
		g.drawImage(missile, 195, 90, null);
		if (mouseOver(Mx,My,150, 140, 100, 35)){g.setColor(Color.WHITE);}
		g.drawString("Buy",185, 165);

		g.setColor(Color.GRAY);
		g.drawRect(300, 55, 100, 120);
		g.drawRect(300, 140, 100, 35);
		g.drawImage(missile, 355, 90, null);
		g.drawImage(missile, 335, 90, null);
		if (mouseOver(Mx,My,300, 140, 100, 35)){g.setColor(Color.WHITE);}
		g.drawString("Buy",335, 165);

		g.setColor(Color.GRAY);
		g.drawRect(450, 55, 100, 120);
		g.drawRect(450, 140, 100, 35);
		g.drawImage(missile, 470, 90, null);
		g.drawImage(missile, 490, 90, null);
		g.drawImage(missile, 510, 90, null);
		if (mouseOver(Mx,My,450, 140, 100, 35)){g.setColor(Color.WHITE);}
		g.drawString("Buy",485, 165);

		g.setColor(Color.GRAY);
		g.drawRect(220, 220, 100, 120);
		g.drawRect(220, 305, 100, 35);
		g.drawImage(laser, 265, 250, null);
		if (mouseOver(Mx,My,220, 305, 100, 35)){g.setColor(Color.WHITE);}
		g.drawString("Buy",260, 330);

		g.setColor(Color.GRAY);
		g.drawRect(380, 220, 100, 120);
		g.drawRect(380, 305, 100, 35);
		if (mouseOver(Mx,My,380, 305, 100, 35)){g.setColor(Color.WHITE);}
		g.drawString("Buy",415, 330);
		
	}
	
	public void mousePressed(MouseEvent e){
		if(getState()==STATE.shop){
			
			if (super.mouseOver(Mx,My,5,10,100,40)){
				//return
				setState(STATE.levelSet);
			}
			
			if (mouseOver(Mx,My,150, 140, 100, 35)){
				//buy1
			}
			
			if (mouseOver(Mx,My,300, 140, 100, 35)){
				//buy2
			}
			
			if (mouseOver(Mx,My,450, 140, 100, 35)){
				//buy3
			}
			
			if (mouseOver(Mx,My,220, 305, 100, 35)){
				//buy4
			}
			
			if (mouseOver(Mx,My,380, 305, 100, 35)){
				//buy4
			}
			
			
		}
	}
	
	
	

}
