package lastPilot;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import lastPilot.Game.STATE;

public class SinglePlayerMenu extends UIObject  {
	private boolean clicked, click2,loadMenu,newUser,nameClick,nameRelease,displayClick,displayRelease;
	private Handler handler;
	private String abc[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m"};
	private String abc2[]={"n","o","p","q","r","s","t","u","v","w","x","y","z"};
	private String ABC[]= {"A","B","C","D","E","F","G","H","I","J","K","L","M"};
	private String ABC2[]= {"N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private int topBoundx,topBoundy,width,height;
	private String userName;
	private HUD hud;
	
	ArrayList<String> name = new ArrayList<String>();
	public SinglePlayerMenu(Game game,Handler handler,HUD hud) {
		super(game);
		this.handler=handler;
		displayClick=false;
		displayRelease=false;
		nameClick = false;
		nameRelease = false;
		clicked = false;
		click2 = false;
		loadMenu = false;
		newUser = false;
		userName= " ";
		this.hud = hud;
		
	}

	@Override
	public void tick() {
		if(newUser&&getState()==STATE.singleMenu){
			for(int i=0;i<abc.length;i++){
				if (mouseOver(Mx,My,topBoundx+i*30,topBoundy,width,height)&&nameRelease){
					name.add(abc[i]);
					nameRelease = false;
					clicked = false;
					
				}
				
				}
			for(int i=0;i<abc2.length;i++){
				if (mouseOver(Mx,My,topBoundx+i*30,topBoundy+35,width,height)&&nameRelease){
					name.add(abc2[i]);
					nameRelease = false;
					clicked = false;
					
				}
				
				}
			for(int i=0;i<ABC.length;i++){
				if (mouseOver(Mx,My,topBoundx+i*30,topBoundy+65,width,height)&&nameRelease){
					name.add(ABC[i]);
					nameRelease = false;
					clicked = false;
					
				}
				
				}
			for(int i=0;i<ABC2.length;i++){
				if (mouseOver(Mx,My,topBoundx+i*30,topBoundy+100,width,height)&&nameRelease){
					name.add(ABC2[i]);
					nameRelease = false;
					clicked = false;
					
				}
				
				}
		}
		if(displayClick){
			for(int i =0;i<name.size();i++){
				
				userName+=name.get(i);
				
			}
			displayClick=false;
			displayRelease=false;
		}
	}

	@Override
	public void render(Graphics g) {
		
		
		if (newUser){
			topBoundx = 187;
			topBoundy = 309;
			width = 15;
			height = 12;
		for(int i=0;i<abc.length;i++){
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		g.setColor(Color.GRAY);
		g.drawRect(180, 250, 400, 400);
		
		g.drawString(abc[i],190+i*30 , 320);
		}
		
		for(int i=0;i<abc2.length;i++){
			
			g.setFont(new Font("Arial", Font.PLAIN, 12));
			g.setColor(Color.GRAY);
			
			g.drawString(abc2[i],190+i*30 , 350);
			
			}
		for(int i=0;i<ABC.length;i++){
			g.setFont(new Font("Arial", Font.PLAIN, 12));
			g.setColor(Color.GRAY);
			
			
			g.drawString(ABC[i],190+i*30 , 385);
			}
			
			for(int i=0;i<ABC2.length;i++){
				
				g.setFont(new Font("Arial", Font.PLAIN, 12));
				g.setColor(Color.GRAY);
				
				g.drawString(ABC2[i],190+i*30 , 420);
				
				}
			g.setColor(Color.GRAY);
			g.drawRect(280,200, 150,35);
			if (mouseOver(Mx,My,280,200, 150,35)&&!userName.isEmpty()){g.setColor(Color.WHITE);}
			g.drawString("Enter", 340, 225);
			
			g.setColor(Color.GRAY);
			if (mouseOver(Mx,My,520,260, 50,30)){g.setColor(Color.WHITE);}
			g.drawString("<----", 525, 280);
			
			g.setColor(Color.GRAY);
			if (mouseOver(Mx,My,200,260, 60,30)){g.setColor(Color.WHITE);}
			g.drawString("Clear", 200, 280);
			g.setColor(Color.GREEN);
			g.drawRect(215, 100, 300, 40);
			
			g.drawString(userName,260 , 125);
			
			
			
		}
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		
		
		
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		g.setColor(Color.GRAY);
		g.drawRect(30, 50, 120, 40);
		if (mouseOver(Mx,My,30,50,120,40)){g.setColor(Color.WHITE);}
		g.drawString("New Game",55 , 75);
		
		g.setColor(Color.GRAY);
		g.drawRect(30, 120, 120, 40);
		if (mouseOver(Mx,My,30,120,120,40)){g.setColor(Color.WHITE);}
		g.drawString("Load",80 , 145);
		
		g.setColor(Color.GRAY);
		g.drawRect(30, 190, 120, 40);
		if (mouseOver(Mx,My,30,190,120,40)){g.setColor(Color.WHITE);}
		g.drawString("Back",80 , 215);
		
		
		
		if (loadMenu &&getState()==STATE.singleMenu){
			g.setColor(Color.GRAY);
			g.drawRect(30, 190, 120, 40);
			if (mouseOver(Mx,My,30,190,120,40)){g.setColor(Color.WHITE);}
			g.drawString("Back",350 , 215);
			
				
		}
		
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
		System.out.println(mx+" "+my);
		
		namePressedMethod();
		//prevents automatic start
		if (mouseOver(mx,my,30,50,120,64 )&& getState()==STATE.singleMenu){
			clicked=true;
			
		}
		//new User Menu
		if(click2&&mouseOver(mx,my,30,50,120,64 )){
			newUser=true;
			loadMenu = false;
		}
		//switch to main Menu
		if (mouseOver(mx,my,30,190,120,64)&&getState()==STATE.singleMenu){
			clicked=false;
			click2=false;
			userName="";
			name.removeAll(name);
			setState(STATE.Menu);
			
		}
		//switch to loadMenu
		if (mouseOver(mx,my,30,120,120,64)&&getState()==STATE.singleMenu){
			loadMenu=true;
			newUser = false;
			userName="";
			name.removeAll(name);
			
			click2=false;
			
		}
		//BackSpace
		if (mouseOver(Mx,My,520,260, 50,30)&&getState()==STATE.singleMenu&&newUser&&name.size()>=1){
			
			userName="";
			
			name.remove(name.size()-1);
			displayClick=true;
			
			}
		//clear the Name
		if (mouseOver(Mx,My,200,260, 60,30)&&getState()==STATE.singleMenu&&newUser&&name.size()>=1){
			userName="";
			
			name.removeAll(name);
			displayClick=true;
			
		}
		//Enter User Name
		if (mouseOver(Mx,My,280,200, 150,35)&&getState()==STATE.singleMenu&&newUser==true&&!userName.isEmpty()){
			
			hud.setName(userName);
			
			userName="";
			name.removeAll(name);
			setState(STATE.levelSet);
			displayClick=true;
		}
		
		
	}
	
	public void mouseReleased(MouseEvent e){
	
		if (clicked){
			click2 = true;
		
		}
		nameReleaseMethod();
	
		if (mouseOver(Mx,My,180, 300, 400, 400)&&getState()==STATE.singleMenu&&newUser==true){
			
			
			userName="";
			displayClick=true;
		
		
		
}
		
	}
			
	
	
	private void nameReleaseMethod(){
		for(int i=0;i<abc.length;i++){
			if (mouseOver(Mx,My,topBoundx+i*30,topBoundy,width,height)){
				nameRelease= true;
				
			}
			
	
			if (mouseOver(Mx,My,topBoundx+i*30,topBoundy+30,width,height)){
				nameRelease= true;
				
			}
			
			if (mouseOver(Mx,My,topBoundx+i*30,topBoundy+65,width,height)){
				nameRelease= true;
				
			}
			
			if (mouseOver(Mx,My,topBoundx+i*30,topBoundy+100,width,height)){
				nameRelease= true;
				
			}
			
			}
	}
	
	private void namePressedMethod(){
		for(int i=0;i<abc.length;i++){
			if (mouseOver(Mx,My,topBoundx+i*30,topBoundy,width,height)){
				clicked = true;
				
			}
			if (mouseOver(Mx,My,topBoundx+i*30,topBoundy+35,width,height)){
				clicked = true;
				
			}
			if (mouseOver(Mx,My,topBoundx+i*30,topBoundy+65,width,height)){
				clicked = true;
				
			}
			if (mouseOver(Mx,My,topBoundx+i*30,topBoundy+100,width,height)){
				clicked = true;
				
			}
			
			}
	}

	

}
