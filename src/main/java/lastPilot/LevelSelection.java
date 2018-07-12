package lastPilot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import lastPilot.Game.STATE;

public class LevelSelection extends UIObject{

	private Handler handler;
	private HUD hud;
	public LevelSelection(Game game, Handler handler,HUD hud) {
		super(game);
		this.handler = handler;
		this.hud = hud;
		
	}

	@Override
	public void tick() {
		
		
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
		
		if (mouseOver(Mx,My,30,50,120,40)&&iscurrentState()){
			
			setState(STATE.Menu);
			
			}
		if (mouseOver(Mx,My,30,120,120,40)&&iscurrentState()){
			
			setState(STATE.shop);
			
			}
		if (mouseOver(Mx,My,30,190,120,40)&&iscurrentState()){
	
			//save it here
	
			}
		
		if (mouseOver(Mx,My,260, 80, 180, 35)&&iscurrentState()){
			setState(STATE.Game);
			startGame();
		}
		
		if (mouseOver(Mx,My,260, 150, 180, 35)){
			
		}
		if (mouseOver(Mx,My,260, 220, 180, 35)){
			
		}
		
		if (mouseOver(Mx,My,260,290, 180, 35)){
			
		}
		
		if (mouseOver(Mx,My,260, 360, 180, 35)){
			
		}
		}

	@Override
	public void render(Graphics g) {

		g.setFont(new Font("Arial", Font.PLAIN, 12));
		g.setColor(Color.GRAY);
		g.drawRect(30, 50, 120, 40);
		if (mouseOver(Mx,My,30,50,120,40)){g.setColor(Color.WHITE);}
		g.drawString("Main Menu",60 , 75);
		
		g.setColor(Color.GRAY);
		g.drawRect(30, 120, 120, 40);
		if (mouseOver(Mx,My,30,120,120,40)){g.setColor(Color.WHITE);}
		g.drawString("Shop",77 , 145);
		
		g.setColor(Color.GRAY);
		g.drawRect(30, 190, 120, 40);
		if (mouseOver(Mx,My,30,190,120,40)){g.setColor(Color.WHITE);}
		g.drawString("Save State",65 , 215);
		
		g.setColor(Color.GRAY);
		g.drawRect(260, 80, 180, 35);
		if (mouseOver(Mx,My,260, 80, 180, 35)){g.setColor(Color.WHITE);}
		g.drawString("Level One",320, 105);

		g.setColor(Color.GRAY);
		g.drawRect(260, 150, 180, 35);
		if (mouseOver(Mx,My,260, 150, 180, 35)){g.setColor(Color.WHITE);}
		g.drawString("Level two",320, 175);

		g.setColor(Color.GRAY);
		g.drawRect(260, 220, 180, 35);
		if (mouseOver(Mx,My,260, 220, 180, 35)){g.setColor(Color.WHITE);}
		g.drawString("Level three",320, 245);

		g.setColor(Color.GRAY);
		g.drawRect(260,290, 180, 35);
		if (mouseOver(Mx,My,260,290, 180, 35)){g.setColor(Color.WHITE);}
		g.drawString("Level four",320, 315);

		g.setColor(Color.GRAY);
		g.drawRect(260, 360, 180, 35);
		if (mouseOver(Mx,My,260, 360, 180, 35)){g.setColor(Color.WHITE);}
		g.drawString("Level Five",320, 385);
	}
private void startGame(){
		
		setState( STATE.Game);
		handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32, ID.Player,handler));
	}
private Boolean iscurrentState(){return getState()==STATE.levelSet;}


}
