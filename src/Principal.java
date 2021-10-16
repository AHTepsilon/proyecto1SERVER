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
import model.Connection;
import model.Stages;
import processing.core.PApplet;
import processing.core.PImage;

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
	
	public static boolean godmode;
	
	/*BufferedReader reader;
	BufferedWriter writer;
	
	private Socket socket;
	*/
	
	Connection TCPServer;
	
	InetAddress ipServer;
	
	CharacterMovement charMove;
	CharacterMovement2 charMove2;
	PImage winStage1, winStage2;
	
	int msgNum;
	
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
		
		stageLoader = new Stages(this);
		charMove = new CharacterMovement(this);
		charMove2 = new CharacterMovement2(this);
		
		stageLoader.stageNum = 0;
		
		TCPServer = new Connection();
		
		TCPServer.initServer();
		
		winStage1 = loadImage("winningFrame1.png");
		winStage2 = loadImage("winningFrame2.png");
		
		//initServer();
		}
	
	@Override
	public void draw() //void Update
	{		
		background(255);
		//System.out.println(mouseX + ", " + mouseY + " / " + (int)stageLoader.xStage + ", " + (-(int)stageLoader.xStage + mouseX) + " / character1 pos: " + charMove.getPosX() + ", " + charMove.getPosY() + " / character2 pos: " + charMove2.getPosX() + ", " + charMove2.getPosY());
		//System.out.println(charMove.getVelocityY());
		
		stageLoader.showStage(this);
		stageLoader.stageCollisions(this);

		charMove.drawPlayer(this, 0);
		charMove.movement(this);
		
		stageLoader.showStagePlayer2(this);
		
		charMove2.drawPlayer(this, 0);
		charMove2.movement(this);

		positions();
		
		gameOver();
		moveStage();
		gameFinish();
		
		godMode();
		
	}
	
	@SuppressWarnings("static-access")
	public void keyReleased()
	{
		
		if(Stages.stageNum == 4)
		{	
			charMove.keyMovement(this);
			charMove2.keyMovement(this);
		}
		
		
		//debug stage changer to quickly test stage changing
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

		if(Stages.stageNum == 4)
		{	
			charMove.keyPress(this);
			charMove2.keyPress(this);
		}
		
		if(key == 'p' || key == 'P')
		{
			godmode = !godmode;
		}
	}
	
	@SuppressWarnings("static-access")
	public void moveStage()
	{
		if(charMove.getPosX() > 801)
		{
			charMove.setPosX(800);
			stageLoader.xStage -= 5;
		}
		
		if(charMove.getPosX() < 24)
		{
			charMove.setPosX(25);
			stageLoader.xStage += 5;
		}
		
		if(charMove2.getPosX() > 801)
		{
			charMove2.setPosX(800);
			stageLoader.xStage2 -= 5;
		}
		
		if(charMove2.getPosX() < 24)
		{
			charMove2.setPosX(25);
			stageLoader.xStage2 += 5;
		}
		
		//System.out.println(charMove.getPosX());
		//System.out.println(stageLoader.xStage);
	}
	
	public void positions()
	{
		//controls the number that shows the position of the players regarding the other
		
		if(charMove.posX + -stageLoader.xStage > charMove2.posX + -stageLoader.xStage2 && Stages.stageNum == 4)
		{
			textSize(40);
			
			fill(255, 128, 0);
			text("2", 1121, 40);
			
			fill(255, 247, 0);
			text("1", 1121, 40+350);
		}
		
		else if(charMove2.posX + -stageLoader.xStage2 > charMove.posX + -stageLoader.xStage && Stages.stageNum == 4)
		{
			textSize(40);
			
			fill(255, 247, 0);
			text("1", 1121, 40);
			
			fill(255, 128, 0);
			text("2", 1121, 40+350);
		}
	}
	
	@SuppressWarnings("static-access")
	public void gameOver()
	{
		//Controls all the ways the game can land in a game over
		
		if(!godmode)
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
			
			if(charMove2.posY > 800 - 350)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31+10;
				charMove2.posY = 406-350;
			}
			
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 579, 566-350) < 30)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31+10;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 683, 630-350) < 30)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31+10;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 +1600, 653-350) < 10)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31+10;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 1662, 593-350) < 30)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 2639, 478-350) < 40)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 2756, 478-350) < 40)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 2915, 644-350) < 40)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 3090, 644-350) < 40)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 4069, 644-350) < 40)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 4287, 555-350) < 40)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31+10;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 5009, 571-350) < 40)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31+10;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 5672, 571-350) < 40)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31+10;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 5939, 639-350) < 40)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31+10;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 6084, 639-350) < 40)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31+10;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 6403, 639-350) < 40)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31+10;
				charMove2.posY = 406-350;
			}
			if(dist(charMove2.posX, charMove2.posY, stageLoader.xStage2 + 6703, 571-350) < 40)
			{
				stageLoader.xStage2 = 0;
				charMove2.posX = 31+10;
				charMove2.posY = 406-350;
			}
		}
	}
	
	public void godMode()
	{
		//Activates godmode (DEBUG ONLY)
		
		if(godmode && Stages.stageNum == 4)
		{
			textSize(15);
			fill(255, 0, 0);
			text("Godmode on", 5, 372);
		}
	}
	
	public void gameFinish()
	{
		//Finishes the game and shows the winning player
		
		if(charMove.getPosX() > 746 && charMove.getPosY() == 622)
		{
			textSize(25);
			fill(255);
			text("Press B to Win!", 649, 467);
			
			if(keyPressed  && Stages.stageNum == 4)
			{
				if(key == 'B' || key == 'b')
				{
					Stages.stageNum = 5;
				}
			}
		}
		
		if(charMove2.getPosX() > 746 && charMove2.getPosY() == 622-350)
		{
			textSize(25);
			fill(255);
			text("Press B to Win!", 649, 467-350);
			
			if(keyPressed  && Stages.stageNum == 4)
			{
				if(key == 'B' || key == 'b')
				{
					Stages.stageNum = 5;
				}
			}
		}
		
		if(Stages.stageNum == 5)
		{
			if(charMove.posX + -stageLoader.xStage > charMove2.posX + -stageLoader.xStage2)
			{
				textSize(40);
				image(winStage1, 0, 0);
				
				fill(0);
			}
			
			if(charMove2.posX + -stageLoader.xStage2 > charMove.posX + -stageLoader.xStage)
			{
				textSize(40);
				image(winStage2, 0, 0);
				
				fill(0);
			}
		}
	}
	

}
