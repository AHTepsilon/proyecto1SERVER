import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import model.CharacterMovement;
import model.CharacterMovement2;
import model.Stages;
import processing.core.PApplet;

public class Principal extends PApplet
{

	public static void main(String[] args) 
	{
		PApplet.main("Principal");
	}
	
	@Override
	public void settings() //void Awake
	{
		size(1152, 700);
	}
	
	BufferedReader reader;
	BufferedWriter writer;
	
	private Socket socket;
	
	InetAddress ipServer;
	
	CharacterMovement charMove;
	CharacterMovement2 charMove2;
	
	boolean gameOver;
	
	Stages stageLoader;
	
	@Override
	public void setup() //void Start
	{
		
		try {
			ipServer = InetAddress.getLocalHost();
			System.out.println(ipServer.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initServer();
		
		stageLoader = new Stages(this);
		charMove = new CharacterMovement(this);
		charMove2 = new CharacterMovement2(this);
		
		stageLoader.stageNum = 0;
		}
	
	@Override
	public void draw() //void Update
	{		
		background(255);
		System.out.println(mouseX + ", " + mouseY + ", " + (int)stageLoader.xStage + ", " + (-(int)stageLoader.xStage + mouseX));
		//System.out.println(charMove.getVelocityY());
		
		stageLoader.showStage(this);
		stageLoader.stageCollisions(this);
		charMove.drawPlayer(this, 0);
		charMove.movement(this);
		stageLoader.showStagePlayer2(this);
		charMove2.drawPlayer(this, 0);
		charMove2.movement(this);
		
		gameOver();
		moveStage();
	}
	
	public void initServer()
	{
		new Thread(
				() -> 
				{
					try {
						ServerSocket server = new ServerSocket(4000);
						System.out.println("Awaiting Connection...");
						socket = server.accept();
						System.out.println("Client Connected");
						
						InputStream is = socket.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);
						reader = new BufferedReader(isr);
						
						OutputStream os = socket.getOutputStream();
						OutputStreamWriter osw = new OutputStreamWriter(os);
						writer = new BufferedWriter(osw);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}).start();
	}
	
	@SuppressWarnings("static-access")
	public void keyReleased()
	{
		charMove.keyMovement(this);
		
		if(key == '0')
		{
			stageLoader.stageNum = 0;
		}
		
		if(key == '1')
		{
			stageLoader.stageNum = 1;
		}
		
		if(key == '2')
		{
			stageLoader.stageNum = 2;
		}
		
		if(key == '3')
		{
			stageLoader.stageNum = 3;
		}
		
		if(key == '4')
		{
			stageLoader.stageNum = 4;
		}
		
		if(key == '5')
		{
			stageLoader.stageNum = 5;
		}
		
	}
	
	public void keyPressed()
	{
		charMove.keyPress(this);
		charMove2.keyPress(this);
	}
	
	@SuppressWarnings("static-access")
	public void moveStage()
	{
		if(charMove.getPosX() > 801)
		{
			charMove.setPosX(800);
			stageLoader.xStage -= 5;
			
			/*if(stageLoader.xStage > 0)
			{
				stageLoader.xStage = 0;
			}*/
		}
		
		if(charMove.getPosX() < 24)
		{
			charMove.setPosX(25);
			stageLoader.xStage += 5;
			
			/*if(stageLoader.xStage < 1152 * 8)
			{
				stageLoader.xStage = (1152 * 8)-1;
			}*/
		}
		
		if(charMove2.getPosX() > 801)
		{
			charMove2.setPosX(800);
			stageLoader.xStage -= 5;
			
			/*if(stageLoader.xStage > 0)
			{
				stageLoader.xStage = 0;
			}*/
		}
		
		if(charMove2.getPosX() < 24)
		{
			charMove2.setPosX(25);
			stageLoader.xStage += 5;
			
			/*if(stageLoader.xStage < 1152 * 8)
			{
				stageLoader.xStage = (1152 * 8)-1;
			}*/
		}
		
		//System.out.println(charMove.getPosX());
		//System.out.println(stageLoader.xStage);
	}
	
	
	@SuppressWarnings("static-access")
	public void gameOver()
	{
		
		if(charMove.posY > 800)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31+10;
			charMove.posY = 406;
		}
		
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 579, 566) < 30)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31+10;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 683, 630) < 30)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31+10;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage +1600, 653) < 10)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31+10;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 1662, 593) < 30)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 2639, 478) < 40)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 2756, 478) < 40)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 2915, 644) < 40)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 3090, 644) < 40)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 4069, 644) < 40)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 4287, 555) < 40)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31+10;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 5009, 571) < 40)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31+10;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 5672, 571) < 40)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31+10;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 5939, 639) < 40)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31+10;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 6084, 639) < 40)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31+10;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 6403, 639) < 40)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31+10;
			charMove.posY = 406;
		}
		if(dist(charMove.posX, charMove.posY, stageLoader.xStage + 6703, 571) < 40)
		{
			stageLoader.xStage = 0;
			charMove.posX = 31+10;
			charMove.posY = 406;
		}
		
		//------------------------------------------------------------------------------------------------------------------------------------
		
		if(charMove2.posY > 800)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31+10;
			charMove2.posY = 406-350;
		}
		
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 579, 566) < 30)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31+10;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 683, 630) < 30)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31+10;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage +1600, 653) < 10)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31+10;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 1662, 593) < 30)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 2639, 478) < 40)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 2756, 478) < 40)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 2915, 644) < 40)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 3090, 644) < 40)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 4069, 644) < 40)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 4287, 555) < 40)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31+10;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 5009, 571) < 40)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31+10;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 5672, 571) < 40)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31+10;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 5939, 639) < 40)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31+10;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 6084, 639) < 40)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31+10;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 6403, 639) < 40)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31+10;
			charMove2.posY = 406-350;
		}
		if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage + 6703, 571) < 40)
		{
			stageLoader.xStage = 0;
			charMove2.posX = 31+10;
			charMove2.posY = 406-350;
		}
		
	}
	
	

}
