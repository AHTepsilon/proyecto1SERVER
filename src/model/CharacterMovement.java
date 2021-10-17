package model;

import processing.core.PApplet;
import processing.core.PImage;

public class CharacterMovement 
{

	public static float posX, posY;
	public static float velocityX, velocityY;
	float speed;
	float jumpVel;
	double gravity;
	boolean onGround;
	
	int jumpable;
	
	int size;
	
	public static float upKey, leftKey, rightKey, downKey;
	
	boolean subiendo,saltoBloqueado, colisionAbajo;
	int saltoYinicial, frameAereosMaximos, framesAereos, velocidadY, velocidadMovimiento;
	
	int velocidadTerminal, velocidadCaida;
	
	PImage  charSprite, charSprite2;
	
	PApplet app;
	
	public CharacterMovement(PApplet app)
	{
		posX = 31;
		posY = 406;
		
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
		
		charSprite = app.loadImage("PERSONAJE.png");
		charSprite2 = app.loadImage("PERSONAJE2.png");
		
		if(posY == 324) 
		{
			colisionAbajo=true;
		} 
		
		else 
		{
			colisionAbajo=false;
		}
	}

	public void drawPlayer(PApplet app, int charId)
	{
		//Draws the player sprite
		
		app.fill(255, 0, 0);
		
		if(Stages.stageNum == 4)
		{
			switch(charId)
			{
			case 0:
				app.image(charSprite, posX, posY);
				break;
			case 1:
				app.image(charSprite, posX-20, posY-20);
				break;
			}
		}

	}
	
	public void movement(PApplet app)
	{
		//System.out.println(velocityY);
		
		//Controls the player movement
		
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
	}
	
	@SuppressWarnings("static-access")
	public void keyMovement(PApplet app) //goes in keyReleased
	{
		//Controls the movement by the keys
		
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
		//Controls the movement by the keys
		
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
				velocityY = -25;
			}
		}
	}
	
	public static float getPosX() {
		return posX;
	}

	public static void setPosX(float posX) {
		CharacterMovement.posX = posX;
	}

	public static float getPosY() {
		return posY;
	}

	public static void setPosY(float posY) {
		CharacterMovement.posY = posY;
	}

	public float getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(float velocityY) {
		this.velocityY = velocityY;
	}

	public int getVelocidadY() {
		return velocidadY;
	}

	public void setVelocidadY(int velocidadY) {
		this.velocidadY = velocidadY;
	}

	public int getVelocidadCaida() {
		return velocidadCaida;
	}

	public void setVelocidadCaida(int velocidadCaida) {
		this.velocidadCaida = velocidadCaida;
	}
	
	
}
