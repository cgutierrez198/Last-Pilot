package lastPilot;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	int num=0;
	
	public Handler(){
		for(int i = 0;i < object.size();i++){
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
		
	}
	
	public void tick(){
		for(int i = 0; i < object.size();i++){
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
		
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size();i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	public int enemySize(){
	    int temp=0;
	    for(int i = 0; i< object.size();i++){
		if(object.equals(Track_Enemy.class))
			temp++;

	    }
	    return temp;

	}
}
