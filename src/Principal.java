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
		size(500, 500);
	}
	
	BufferedReader reader;
	BufferedWriter writer;
	
	private Socket socket;
	
	InetAddress ipServer;
	
	CharacterMovement charMove;
	
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
		
		charMove = new CharacterMovement(this);
		}
	
	@Override
	public void draw() //void Update
	{		
		background(255);
		charMove.drawPlayer(this);
		charMove.movement(this);
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

}
