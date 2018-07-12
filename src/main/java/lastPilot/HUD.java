package lastPilot;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class HUD implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 552463283493821578L;
	public static int HEALTH = 100; 
	public static int greenValue = 255;
	public int score = 0;
	public int level = 1;
	public String name;
	public int credit = 0;
	
	public void tick(){
		
		
		HEALTH = Game.clamp(HEALTH,0, 100);
		greenValue = Game.clamp(greenValue,0, 255);
		greenValue = HEALTH * 2;
		
		
		
	}
	
	public void render( Graphics g){
		
		g.setColor(Color.gray);
		g.fillRect(15, 420, 200, 10);
		
		g.setColor(new Color(75,greenValue,0));
		g.fillRect(15, 420, HEALTH*2, 10);
		
		g.setColor(Color.white);
		g.drawRect(15, 420, 200, 10);
		
		g.drawString(name, 15, 405);
		g.drawString("Credits: "+ credit, 15, 380);
		g.drawString("level: "+ level, 15, 360);
		
	}
	
	public int getScore(){return score;}
	public int getLevel(){return level;}
	public void setLevel(int level){this.level=level;}
	public void setScore(int score){this.score=score;}
	public int setCredit(){return credit;}
	public void getCredit(int score){this.score=score;}
	
	public String getName(){return name;}
	public void setName(String name){this.name = name;}
	
	public void save(String fileName) throws IOException{
		
		FileOutputStream fileOutput = new FileOutputStream(fileName);
		ObjectOutputStream ObjectOutput = new ObjectOutputStream(fileOutput);
		ObjectOutput.writeObject(this);
		ObjectOutput.flush();
		ObjectOutput.close();
		
	}
	/**
	 * loads the file Object of ScoreBoard
	 * @param fileName the file name of object that was previously saved must be inputed here
	 * @return returns the saved Object  within the File
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static HUD load(String fileName)throws IOException, ClassNotFoundException{
		FileInputStream fileInput= new FileInputStream(fileName);
		ObjectInputStream ObjectInput = new ObjectInputStream(fileInput);
		HUD user= (HUD) ObjectInput.readObject();
		ObjectInput.close();
		return user;
	}
	
}
