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
		}
	
	@Override
	public void draw() //void Update
	{		
		background(255);
		System.out.println(mouseX + ", " + mouseY + ", " + (int)stageLoader.xStage + ", " + (-(int)stageLoader.xStage + mouseX));

		stageLoader.showStage(this);
		stageLoader.stageCollisions(this);
		charMove.drawPlayer(this);
		charMove.movement(this);
		
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
	
	public void keyReleased()
	{
		charMove.keyMovement(this);
	}
	
	public void keyPressed()
	{
		charMove.keyPress(this);
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
		
		//System.out.println(charMove.getPosX());
		//System.out.println(stageLoader.xStage);
	}

}
