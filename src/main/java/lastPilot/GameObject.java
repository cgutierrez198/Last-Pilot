package lastPilot;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected float x,y;
	
	protected ID id;
	protected float velX, velY;
	
	public GameObject(float x , float y , ID id){
		this.x = x;
		this.y = y;
		this.id = id;
		
	}
	
	public abstract Rectangle getBounds();
	public abstract  void tick();
	public abstract void render(Graphics g);
	
	public void setx(float x)		{this.x = x;}
	public float getx()			{return x;}
	
	public void sety(float y)		{this.y = y;}
	public float gety()			{return y;}
	
	public void setID(ID id)	{this.id = id;}
	public ID getID()			{return id;}
	
	public void setVelX(float x)	{this.velX = x;}
	public float getVelX()		{return velX;}
	
	public void setVelY(float y)	{this.velY = y;}
	public float getVelY()		{return velY;}
	
}
