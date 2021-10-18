package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Principal;

import main.Main;

public class Connection extends Thread
{
	public static Connection instance;
	
	BufferedReader reader;
	BufferedWriter writer;
	
	private Socket socket;
	
	int msgNum;
	public static int connectedControllers;
	private Main observer;
	private ServerSocket server;
	
	public static Connection getInstance()
	{
		if(instance == null)
		{
			instance = new Connection();
		}
		
		return instance;
	}
	
	public void setServer(Main main)
	{
		this.observer = main;
	}
	
	public Connection()
	{
		
	}
	
	public void run() 
	{
		try {
			connectedControllers = 0;
			server = new ServerSocket(4000);
			
			while(true)
			{
				
				System.out.println("Awaiting connection...");
				Socket socket = server.accept();
				Session session = new Session(socket, connectedControllers);
				session.setObserver(observer);
				session.start();
				System.out.println("Client connected succesfully");
				connectedControllers++;
				System.out.println(connectedControllers);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initServer()
	{
		
	}
}
						