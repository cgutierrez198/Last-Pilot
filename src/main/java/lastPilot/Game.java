package lastPilot;



import java.awt.AWTException;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.Random;


import javax.swing.ImageIcon;
import javax.swing.JTextField;


public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -1380302599731714594L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private static int testCount;
	private boolean running = false;
	public HUD hud;
	private Handler handler;
	private Random r;
	private Spawn spawner;
	private Menu menu;
	private HelpState help;
	private SinglePlayerMenu single;
	private LevelSelection levelSet;
	private ShopMenu SMenu;
	private inGameMenu IGMenu;
	private Image background;
	private int bgX,bgY;
	private int bkgCount;
	private String bkgString[]= new String[6];
	public static boolean testingInputs = false;
	
	public enum STATE{
		Menu,
		Game,
		Help,
		singleMenu,
		levelSet,
		shop;
		
	};
	
	public STATE gameState = STATE.Menu;
	
	public Game() throws Exception{
		testCount=0;
		r = new Random();
		handler = new Handler();
		instantiateAndset();
		this.addKeyListener(new KeyInput(handler,this,hud));
		
		new Window(WIDTH, HEIGHT, "The Last Pilot",this);
		
		
		
	}
	
	public Game(int k){
		r = new Random();
		testCount=0;
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler,this,hud));
		
		
		new Window(WIDTH, HEIGHT, "The Last Pilot",this);
		
		hud = new HUD();
		spawner = new Spawn(handler , hud);
		menu = new Menu(this,handler);
		help = new HelpState(this);
		background = new ImageIcon("maps/background.png").getImage();
		this.addMouseListener(menu);
		this.addMouseMotionListener(menu);
    	
		
		
		
		
	}
	
	
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
public void run() {
	this.requestFocusInWindow();
	long lastTime = System.nanoTime();
	double amountOfTicks = 60.0;
	double ns = 1000000000 / amountOfTicks;
	double delta = 0;
	long timer = System.currentTimeMillis();
	int frames = 0;
	while(running){
		long now = System.nanoTime();
		delta += (now - lastTime) / ns;
		lastTime = now;
		while(delta >= 1){
			tick();

			delta--;
		}
		if(running){
			
			render();
			
			if(testingInputs){
				
				if(isToRightEdge())System.out.println("D Key is Tested");
				if(isToLeftEdge())System.out.println("A Key is Tested");
				if(isUpToTopEdge())System.out.println("W Key is Tested");
				if(isDownToBottomEdge())System.out.println("S key Is Pressed");
				inputTest();
				
			
			}
			
		
		}
		frames++;
		
		if(System.currentTimeMillis() - timer > 1000){
			timer +=1000;
			//System.out.println("FPS: " + frames);
			frames = 0;
		}
	}
	stop(); 
	 	
	}
	private void tick(){
		handler.tick();
		
		if (gameState == STATE.Game){
		hud.tick();
		spawner.tick();
		}
		else if (gameState == STATE.Menu){
			menu.tick();
		}
		else if (gameState == STATE.Help){
			help.tick();
			
		}
		else if (gameState == STATE.singleMenu){
			single.tick();
			
		}
		else if (gameState == STATE.levelSet){
			levelSet.tick();
		}
		else if (gameState == STATE.shop){
			SMenu.tick();
		}
	}
	
	
	private void movingBkg(){
		bkgCount++;
		if(bkgCount==104){
			bgY++;
			bkgCount=0;
		}
		
		if(bgY > HEIGHT) bgY = 0;
	}
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null){
			this.createBufferStrategy(4);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
	
		movingBkg();
		
		
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 0, WIDTH, HEIGHT);
		g.drawImage(background, bgX, bgY - HEIGHT, null);
		
		g.drawImage(background, bgX, bgY, null);
		//g.drawLine(20, 20, 20, 20);
		
		handler.render(g);
		if(gameState == STATE.Game){
			
			background =new ImageIcon (bkgString[3]).getImage();
			
			
			
			
		hud.render(g);
		}
		else if (gameState == STATE.Menu){
			
			background =new ImageIcon (bkgString[0]).getImage();
			menu.render(g);
			
			
		}
		else if (gameState == STATE.Help){
			background =new ImageIcon (bkgString[1]).getImage();
			help.render(g);
			
		}
		else if(gameState == STATE.singleMenu){
			single.render(g);
		}
		else if (gameState ==STATE.levelSet){
			levelSet.render(g);
		}
		
		else if (gameState ==STATE.shop){
			SMenu.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max){
		if (var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else 
			return var;
			
			
	}
	public static void main(String[] args) throws Exception {
		
		new Game();
		//new Game(2);
		
		
	}
	
	public void instantiateAndset(){
		bkgString[0]= new String("maps/background.png");
		bkgString[1]= new String("maps/emptySpace.png");
		bkgString[2]= new String("maps/BlueSpace3 (2).png");
		bkgString[3]= new String("maps/redSpace2 (2).png");
		bkgString[4]= new String("maps/BlueSpace.png");
		bkgString[5]= new String("maps/giyagas.gif");
		
		hud = new HUD();
		spawner = new Spawn(handler , hud);
		menu = new Menu(this,handler);
		help = new HelpState(this);
		single = new SinglePlayerMenu(this,handler,hud);
		levelSet = new LevelSelection(this,handler,hud);
		SMenu = new ShopMenu(this,hud);
		IGMenu = new inGameMenu(this);
		background = new ImageIcon(bkgString[5]).getImage();
		
		bkgCount = 0;
		this.addMouseListener(menu);
		this.addMouseMotionListener(menu);
		this.addMouseMotionListener(help);
		this.addMouseListener(help);
		this.addMouseListener(single);
		this.addMouseMotionListener(single);
		this.addMouseListener(SMenu);
		this.addMouseMotionListener(SMenu);
		this.addMouseListener(IGMenu);
		this.addMouseMotionListener(IGMenu);
		this.addMouseListener(levelSet);
		this.addMouseMotionListener(levelSet);
		
	}

	public void keyinputs(int key){
		
		if (gameState ==STATE.Game){
			try {
				Robot rob = new Robot();
				
				//for (int i = 0;i<=1;i++)
				rob.keyPress(key);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void mouseStart(){
		
		try {
			Point point;
			point =GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
			
			Robot rob = new Robot();
			if (gameState == STATE.Menu){
			
			rob.mouseMove((int)point.getX()-220, (int)point.getY()-150);
			
			rob.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void inputTest(){
		if(gameState == STATE.Menu)
			mouseStart();
			if(testCount == 0 && gameState == STATE.Game){
			keyinputs(KeyEvent.VK_A);
			
				}
				
			if(testCount == 3000&& gameState == STATE.Game){
				keyinputs(KeyEvent.VK_D);
				
					}
			
			if(testCount == 7000 && gameState == STATE.Game){
				keyinputs(KeyEvent.VK_A);
				
					}
			if(testCount == 9000 && gameState == STATE.Game){
				keyinputs(KeyEvent.VK_W);
			
					}
			
			if(testCount == 10000 && gameState == STATE.Game){
				keyinputs(KeyEvent.VK_S);
				
					}
			
			if(testCount == 15000 && gameState == STATE.Game){
				keyinputs(KeyEvent.VK_ESCAPE);
				
					}
			//if(gameState ==STATE.Game)testCount++;
			
		
	}
	
	
	public boolean isUpToTopEdge(){
		if (Player.testY <= 40){
			return true;
		}
		else return false;
	}
	
	public boolean isDownToBottomEdge(){
		if (Player.testY >= 366){
			return true;
		}
		else return false;
	}
	
	public boolean isToLeftEdge(){
	if (Player.testX <= 46){
		return true;
	}
	else return false;
	}
	
	public boolean isToRightEdge(){
		if (Player.testX >= 206){
			return true;
		}
		else return false;
		}

	
}
