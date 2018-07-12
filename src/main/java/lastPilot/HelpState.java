package lastPilot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

import javax.swing.ImageIcon;

import lastPilot.Game.STATE;

public class HelpState extends UIObject{


	
	
	private  int MIDDLE_X =getHeight()/2;
	
	private final Image PLAYER, ENEMY, CURRENCY;
	private Image background;
	private final Image WASD, SPACE;
	private final Image ARROWS, NUMPAD0;
	private int bgX,bgY;
	private int Mx,My;
	
	public HelpState(Game game){
		
		super(game);
		//this.game=game;
		background = new ImageIcon("assets/background.png").getImage();
		PLAYER = new ImageIcon("assets/player1.png").getImage();
		ENEMY = new ImageIcon("assets/enemy.png").getImage();
		CURRENCY = new ImageIcon("assets/currency.gif").getImage();
		
		WASD = new ImageIcon("assets/wasd.png").getImage();
		SPACE = new ImageIcon("assets/space.png").getImage();
		
		ARROWS = new ImageIcon("assets/arrows.png").getImage();
		NUMPAD0 = new ImageIcon("assets/numpad0.png").getImage();
		
	}
	public void mouseMoved(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
		Mx=mx;
		My=my;
		
		
	}

	
	public void render(Graphics g){
		
		g.setColor(Color.WHITE);
	
	    g.setFont(new Font("ARIAL", Font.PLAIN, 20));
		
		//draw dividers
		//g.drawLine(MIDDLE_X, 200, MIDDLE_X, Game.WIDTH);
		g.drawLine(0, 200, Game.WIDTH, 200);
		
		//Top part: what to do
		g.drawImage(PLAYER, 60, 80, null);
		g.drawString("This is you!", 25, 150);
		
		g.drawImage(ENEMY, MIDDLE_X +15, 25, null);
		g.drawImage(ENEMY, MIDDLE_X-20, 55, null);
		g.drawImage(ENEMY, MIDDLE_X+55, 55, null);
		g.drawString("Shoot and avoid", MIDDLE_X - 25, 120);
		g.drawString("the enemies!", MIDDLE_X - 25, 145);
		
		
		g.drawImage(CURRENCY, 510, 50, null);
		g.drawString("Collect the coins!", 450, 120);
		
		//Player 1 controls
		g.setFont(new Font("Impact", Font.PLAIN, 25));
		g.drawString("CONTROLS", 255, 250);
		
		g.setFont(new Font("Impact", Font.PLAIN, 20));
		g.drawImage(WASD, 15, 300, null);
		g.drawString("To Move. ", 125, 350);
		
		g.drawImage(SPACE, 300, 330, null);
		g.drawString("To Fire. ", 425, 355);
		
		g.setFont(new Font("Arial", Font.PLAIN, 22));
		g.setColor(Color.GRAY);
		g.drawRect(5,10 , 100, 40);
		if (super.mouseOver(Mx,My,5,10,100,40)){g.setColor(Color.WHITE);}
		g.drawString("Return",20 ,40);
		

	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	

	
	

}
