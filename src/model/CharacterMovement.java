package model;

import processing.core.PApplet;

public class CharacterMovement 
{

	public static float posX, posY;
	float velocityX, velocityY;
	float speed;
	float jumpVel;
	double gravity;
	boolean onGround;
	
	int jumpable;
	
	int size;
	
	float upKey, leftKey, rightKey, downKey;
	
	boolean subiendo,saltoBloqueado, colisionAbajo;
	int saltoYinicial, frameAereosMaximos, framesAereos, velocidadY, velocidadMovimiento;
	
	int velocidadTerminal, velocidadCaida;
	
	
	PApplet app;
	
	public CharacterMovement(PApplet app)
	{
		posX = 132;
		posY = 224;
		
		velocityX = 0;
		velocityY = 0;
		speed = 9;
		jumpVel = 5;
		gravity = 1.8;
		
		size = 25;
		
		jumpable = 1;
		
		subiendo= false;
		saltoBloqueado= false;
		saltoYinicial=0; 
		frameAereosMaximos=12;
		framesAereos= frameAereosMaximos; 
		
		velocidadTerminal=10;
		velocidadCaida=0;
		velocidadMovimiento=12;
		
		velocidadY=0;
		
		if(posY == 324) 
		{
			colisionAbajo=true;
		} 
		
		else 
		{
			colisionAbajo=false;
		}
	}
	
	public void drawPlayer(PApplet app)
	{
		app.fill(255, 0, 0);
		app.square(posX, posY, 30);
	}
	
	public void movement(PApplet app)
	{
		//System.out.println(velocityY);
		
		velocityY += gravity;
		
		if(velocityY > 100)
		{
			velocityY = 99;
		}
		
		velocityX = (rightKey - leftKey) * speed;
		float nextY = posY + velocityY;
		float nextX = posX;		
		boolean onGroundTemp = false;
		
		posX += velocityX;
		posY += velocityY;
		onGround = onGroundTemp;
		
		/*if(velocityY > 0 && posY < (351-(size/2)))
			{
				velocityY = 0;
				onGroundTemp = true;
			}*/
		
		if(posY > (351-(size/2)))
		{
			posY = (350-(size/2));
		}
	}
	
	@SuppressWarnings("static-access")
	public void keyMovement(PApplet app) //goes in keyReleased
	{
		if(app.key == app.CODED)
		{
			if(app.keyCode == app.LEFT)
			{
				leftKey = 0;
			}
			
			if(app.keyCode == app.RIGHT)
			{
				rightKey = 0;
			}
			
			if(app.keyCode == app.DOWN)
			{
				downKey = 0;
			}
			
			if(app.keyCode == app.UP)
			{
				upKey = 0;
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public void keyPress(PApplet app) //goes in keyPressed
	{
		if(app.key == ' ' && onGround)
		{
			velocityY = jumpVel;
		}
		
		if(app.key == app.CODED)
		{
			if(app.keyCode == app.LEFT)
			{
				leftKey = 1;
			}
			
			if(app.keyCode == app.RIGHT)
			{
				rightKey = 1;
			}
			
			if(app.keyCode == app.UP && velocityY > 20)
			{
				upKey = 1;
				saltoBloqueado=false;
				velocidadCaida=0;
				System.out.println("jumps");
				
//				if(jumpable == 1)
//				{
//					posY -= 200;
//				}
				
				if(saltoBloqueado==false && app.keyCode == app.UP ) {
					subiendo=true;
					saltoBloqueado=true;
				}
				
				if(subiendo) {
					
					framesAereos--;
					velocityY = -25;
					
				}
				if (framesAereos<=0)
				{
					subiendo=false;
					framesAereos=frameAereosMaximos;
				}	
				
				if(colisionAbajo==false && subiendo == false) {
					posY= (int) --velocidadCaida;
					System.out.println(velocidadY);
					if(velocidadCaida <velocidadTerminal) {
						velocidadCaida+=0.3;
					}
				}	
				
			}
			
			if(app.keyCode == app.DOWN)
			{
				downKey = 1;
			}
		}
	}
	
	/*public void keyPress(PApplet app) //goes in keyPressed
	{
		if(app.key == ' ' && onGround)
		{
			velocityY = jumpVel;
		}
		
		if(app.key == app.CODED && !Principal.gameOver)
		{
			if(app.keyCode == app.LEFT)
			{
				leftKey = 1;
			}
		}
	}*/
}
