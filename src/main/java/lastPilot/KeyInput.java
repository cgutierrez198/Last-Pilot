package lastPilot;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import lastPilot.Game.STATE;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private Boolean[] keyDown = new Boolean[4];
	private Game game;
	private HUD hud;
	
	
	public KeyInput(Handler handler,Game game,HUD hud){
		this.handler = handler;
		for(int i =0;i<keyDown.length;i++)
			keyDown[i]=false;
		this.game = game;
		this.hud = hud;
		
	}
	
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		
		for(int i = 0 ; i < handler.object.size() -1; i++ ){
			GameObject tempObject = handler.object.get(i);	
		
			if(tempObject.getID() == ID.Player){
			
				if(key == KeyEvent.VK_W) { tempObject.setVelY(-5); keyDown[0] = true;}			
				if(key == KeyEvent.VK_S) { tempObject.setVelY(5);  keyDown[1] = true;}
				if(key == KeyEvent.VK_A) { tempObject.setVelX(-5); keyDown[2] = true;}
				if(key == KeyEvent.VK_D) { tempObject.setVelX(5);  keyDown[3] = true;}
				if(game.gameState == STATE.Game){
					if(key == KeyEvent.VK_SPACE){ handler.addObject(new Missile(tempObject.getx(),tempObject.gety(),ID.Missle,handler,hud));}
				}
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE){ System.exit(0);}

	}
	
	public void keyReleased(KeyEvent e){
		
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
		
			if(tempObject.getID() == ID.Player){
			
				if(key == KeyEvent.VK_W) keyDown[0]=false;			
				if(key == KeyEvent.VK_S) keyDown[1]=false;
				if(key == KeyEvent.VK_A) keyDown[2]=false;
				if(key == KeyEvent.VK_D) keyDown[3]=false;
				
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
			
			
			
	}

	}
	
	
	
	
	
}