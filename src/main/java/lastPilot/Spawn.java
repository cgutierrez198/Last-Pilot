package lastPilot;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random r ;
	
	public Spawn (Handler handler,HUD hud){
		this.hud = hud;
		this.handler = handler;
		r=new Random();
		
		
		
	}
	
	public void tick(){
		
	scoreKeep++;
	
	if (scoreKeep==1 ){
	for(int i=0;i<=15;i++)
	handler.addObject(new Track_Enemy(r.nextInt(Game.WIDTH),-10,ID.Track_Enemy,handler));
	for (int i=0;i<=10;i++)
	handler.addObject(new PassingStar(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.PassingStar,handler));
	
	
	}
	
	}

}
