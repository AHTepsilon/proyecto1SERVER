package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Stages 
{
	PImage stage1a, stage1b, stage1c, stage1d, stage1e, stage1f, stage1g;
	
	public static int xStage, yStage;
	
	public Stages(PApplet app)
	{
		stage1a = app.loadImage("water1.png");
		stage1b = app.loadImage("water2.png");
		stage1c = app.loadImage("water3.png");
		stage1d = app.loadImage("water4.png");
		stage1e = app.loadImage("water5.png");
		stage1f = app.loadImage("water6.png");
		stage1g = app.loadImage("water7.png");
		
		xStage = 0;
		yStage = 0;
	}
	
	public void showStage(PApplet app)
	{
		app.image(stage1a, xStage, yStage);
		app.image(stage1b, xStage + 1152, yStage);
		app.image(stage1c, xStage + (1152*2), yStage);
		app.image(stage1d, xStage + (1152*3), yStage);
		app.image(stage1e, xStage + (1152*4), yStage);
		app.image(stage1f, xStage + (1152*5), yStage);
		app.image(stage1g, xStage + (1152*6), yStage);
	}
	
	public void stageCollisions(PApplet app)
	{
		float CX = CharacterMovement.posX;
		float CY = CharacterMovement.posY;
		
		if(CharacterMovement.posX > (xStage - 10) && CharacterMovement.posX < (xStage + 76))
			{
			if(CharacterMovement.posY > 459-45)
				{
					CharacterMovement.posY = 459-45;
				}
			}
		if(CharacterMovement.posX > (xStage + 213) && CharacterMovement.posX < (xStage + 287))
		{
			if(CharacterMovement.posY > 577-45)
			{
				CharacterMovement.posY = 577-45;
			}
		}
		if(CharacterMovement.posX > (xStage + 287) && CharacterMovement.posX < (xStage + 358))
		{
			if(CharacterMovement.posY > 639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		if(CharacterMovement.posX > (xStage + 430) && CharacterMovement.posX < (xStage + 502))
		{
			if(CharacterMovement.posY > 639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		if(CharacterMovement.posX > (xStage + 502) && CharacterMovement.posX < (xStage + 641))
		{
			if(CharacterMovement.posY > 577-45)
			{
				CharacterMovement.posY = 577-45;
			}
		}
		if(CharacterMovement.posX > (xStage + 641) && CharacterMovement.posX < (xStage + 716))
		{
			if(CharacterMovement.posY > 639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		if(CharacterMovement.posX > (xStage + 748) && CharacterMovement.posX < (xStage + 826))
		{
			if(CharacterMovement.posY > 555-45)
			{
				CharacterMovement.posY = 555-45;
			}
		}
	}
}
