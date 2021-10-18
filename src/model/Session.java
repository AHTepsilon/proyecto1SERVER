package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import main.Main;

public class Session extends Thread
{
	BufferedReader reader;
	BufferedWriter writer;
	
	private Socket socket;

	int msgNum;
	
	int sessionNum;
	
	Main observer;
	
	public Session(Socket socket, int CC)
	{
		this.socket = socket;
	}
	
	public void setObserver(Main observer)
	{
		this.observer = observer;
	}
	
	@Override
	public void run()
	{
		try
		{
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			reader = new BufferedReader(isr);
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			writer = new BufferedWriter(osw);
			
			sendMessage("Controller Connected Succesfully");
			
			sessionNum = Connection.connectedControllers;
			
			while (true)
			{
				System.out.println("Awaiting message...");
				String line = reader.readLine();
				System.out.println("Received message: " + line);
				
				msgNum = Integer.parseInt(line);
				

					if(Stages.stageNum == 0)
					{
						if(msgNum == 5)
						{
							Stages.stageNum = 1;
							msgNum = 0;
						}
					}
					
					if(Stages.stageNum == 1)
					{
						if(msgNum == 5)
						{
							Stages.stageNum = 2;
							msgNum = 0;
						}
					}
					
					if(Stages.stageNum == 2)
					{
						if(msgNum == 5)
						{
							Stages.stageNum = 3;
							msgNum = 0;
						}
					}
					
					if(Stages.stageNum == 3)
					{
						if(msgNum == 5)
						{
							Stages.stageNum = 4;
							msgNum = 0;
						}
					}
				
					
				
				if(sessionNum == 1 && Stages.stageNum == 4)
				{
					if(msgNum == 0)
					{
						CharacterMovement.leftKey = 0;
						CharacterMovement.rightKey = 0;
					}
					if(msgNum == 1  && CharacterMovement.velocityY > 20)
					{
						CharacterMovement.velocityY = -25;
					}
					
					if(msgNum == 2 && CharacterMovement.getPosX() > 746 && CharacterMovement.getPosY() == 622)
					{
						Stages.stageNum = 5;
					}
					
					if(msgNum == 3)
					{
						CharacterMovement.leftKey = 1;
						CharacterMovement.rightKey = 0;
					}
					
					if(msgNum == 4)
					{
						CharacterMovement.leftKey = 0;
						CharacterMovement.rightKey = 1;
					}
				}
				
				if(sessionNum == 2 && Stages.stageNum == 4)
				{
					if(msgNum == 0)
					{
						CharacterMovement2.leftKey = 0;
						CharacterMovement2.rightKey = 0;
					}
					
					if(msgNum == 1  && CharacterMovement2.velocityY > 20)
					{
						CharacterMovement2.velocityY = -25;
					}
					
					if(msgNum == 2 && CharacterMovement2.getPosX() > 746 && CharacterMovement2.getPosY() == 622-350)
					{
						Stages.stageNum = 5;
					}
					
					if(msgNum == 3)
					{
						CharacterMovement2.leftKey = 1;
						CharacterMovement2.rightKey = 0;
					}
					
					if(msgNum == 4)
					{
						CharacterMovement2.leftKey = 0;
						CharacterMovement2.rightKey = 1;
					}
				}

			}	
		}
		catch(Exception ex)
		{
			
		}
		
		
	}
	
    public void sendMessage(String msg)
    {
        new Thread(
                ()->
                {
                    try {
                        writer.write(msg + "\n");
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        ).start();
    }
}
