package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Stages 
{
	PImage stage1a, stage1b, stage1c, stage1d, stage1e, stage1f, stage1g, startScreen, insScreen, insScreen2, connectScreen;
	PImage stage1ap2, stage1bp2, stage1cp2, stage1dp2, stage1ep2, stage1fp2, stage1gp2;
	
	public static int xStage, yStage, xStage2, yStage2;
	
	public static int stageNum;
	
	public Stages(PApplet app)
	{
		//Loads the backgrounds for the game
		
		stage1a = app.loadImage("water1.png");
		stage1b = app.loadImage("water2.png");
		stage1c = app.loadImage("water3.png");
		stage1d = app.loadImage("water4.png");
		stage1e = app.loadImage("water5.png");
		stage1f = app.loadImage("water6.png");
		stage1g = app.loadImage("water7.png");
		
		stage1ap2 = app.loadImage("fire1.png");
		stage1bp2 = app.loadImage("fire2.png");
		stage1cp2 = app.loadImage("fire3.png");
		stage1dp2 = app.loadImage("fire4.png");
		stage1ep2 = app.loadImage("fire5.png");
		stage1fp2 = app.loadImage("fire6.png");
		stage1gp2 = app.loadImage("fire7.png");
		
		startScreen = app.loadImage("startScreen.png");
		insScreen = app.loadImage("instructionsOne.png");
		insScreen2 = app.loadImage("instructionsTwo.png");
		connectScreen = app.loadImage("connectScreen.png");
		
		xStage = 0;
		yStage = 0;
		
		xStage2 = 0;
		yStage2 = -350;
		
		startScreen.resize(1152, 700);
		insScreen.resize(1152, 700);
		insScreen2.resize(1152, 700);
		connectScreen.resize(1152, 700);
	}
	
	public void showStage(PApplet app)
	{
		//loads the backgrounds depending on the number of the stage
		
		switch (stageNum)
		{
		case 0:
			app.image(startScreen, 0, 0);
			break;
		case 1:
			app.image(insScreen, 0, 0);
			break;
		case 2:
			app.image(insScreen2, 0, 0);
			break;
		case 3:
			app.image(connectScreen, 0, 0);
			break;
		case 4:
			app.image(stage1a, xStage, yStage);
			app.image(stage1b, xStage + 1152, yStage);
			app.image(stage1c, xStage + (1152*2), yStage);
			app.image(stage1d, xStage + (1152*3), yStage);
			app.image(stage1e, xStage + (1152*4), yStage);
			app.image(stage1f, xStage + (1152*5), yStage);
			app.image(stage1g, xStage + (1152*6), yStage);
			break;
		case 5:
			
			break;
		}
	}
	
	public void showStagePlayer2(PApplet app)
	{
		//loads the stage for the second player
		
		switch (stageNum)
		{
		case 4:
			app.image(stage1ap2, xStage2, yStage2);
			app.image(stage1bp2, xStage2 + 1152, yStage2);
			app.image(stage1cp2, xStage2 + (1152*2), yStage2);
			app.image(stage1dp2, xStage2 + (1152*3), yStage2);
			app.image(stage1ep2, xStage2 + (1152*4), yStage2);
			app.image(stage1fp2, xStage2 + (1152*5), yStage2);
			app.image(stage1gp2, xStage2 + (1152*6), yStage2);
			break;
		}
	}
	
	public void stageCollisions(PApplet app)
	{
		
		//controls the collisions for each player on the stage
		
		float CX = CharacterMovement.posX;
		float CY = CharacterMovement.posY;
		
		if(CharacterMovement.posX > (xStage - 20) && CharacterMovement.posX < (xStage + 76))
			{
			if(CharacterMovement.posY > 459-45)
				{
					CharacterMovement.posY = 459-45;
				}
			}
		if(CharacterMovement.posX > (xStage + 203) && CharacterMovement.posX < (xStage + 287))
		{
			if(CharacterMovement.posY > 577-45)
			{
				CharacterMovement.posY = 577-45;
			}
		}
		if(CharacterMovement.posX > (xStage + 277) && CharacterMovement.posX < (xStage + 358))
		{
			if(CharacterMovement.posY > 639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		if(CharacterMovement.posX > (xStage + 420) && CharacterMovement.posX < (xStage + 502))
		{
			if(CharacterMovement.posY > 639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		if(CharacterMovement.posX > (xStage + 492) && CharacterMovement.posX < (xStage + 641))
		{
			if(CharacterMovement.posY > 577-45)
			{
				CharacterMovement.posY = 577-45;
			}
		}
		if(CharacterMovement.posX > (xStage + 631) && CharacterMovement.posX < (xStage + 716))
		{
			if(CharacterMovement.posY > 639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		if(CharacterMovement.posX > (xStage + 738) && CharacterMovement.posX < (xStage + 826))
		{
			if(CharacterMovement.posY > 555-45)
			{
				CharacterMovement.posY = 555-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 848) && CharacterMovement.posX < (xStage + 940))
		{
			if(CharacterMovement.posY > 555-45)
			{
				CharacterMovement.posY = 555-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 995) && CharacterMovement.posX < (xStage + 1086))
		{
			if(CharacterMovement.posY > 555-45)
			{
				CharacterMovement.posY = 555-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 1086) && CharacterMovement.posX < (xStage + 1295))
		{
			if(CharacterMovement.posY > 624-45)
			{
				CharacterMovement.posY = 624-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 1086) && CharacterMovement.posX < (xStage + 1295))
		{
			if(CharacterMovement.posY > 624-45)
			{
				CharacterMovement.posY = 624-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 1295) && CharacterMovement.posX < (xStage + 1371))
		{
			if(CharacterMovement.posY > 577-45)
			{
				CharacterMovement.posY = 577-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 1392) && CharacterMovement.posX < (xStage + 1497))
		{
			if(CharacterMovement.posY > 535-45)
			{
				CharacterMovement.posY = 535-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 1501) && CharacterMovement.posX < (xStage + 1570))
		{
			if(CharacterMovement.posY > 577-45)
			{
				CharacterMovement.posY = 577-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 1693) && CharacterMovement.posX < (xStage + 1752))
		{
			if(CharacterMovement.posY > 639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 1752) && CharacterMovement.posX < (xStage + 1813))
		{
			if(CharacterMovement.posY > 577-45)
			{
				CharacterMovement.posY = 577-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 1813) && CharacterMovement.posX < (xStage + 1873))
		{
			if(CharacterMovement.posY > 639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 1850) && CharacterMovement.posX < (xStage + 2039))
		{
			if(CharacterMovement.posY > 515-45)
			{
				CharacterMovement.posY = 515-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 2008) && CharacterMovement.posX < (xStage + 2159))
		{
			if(CharacterMovement.posY > 639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 2159) && CharacterMovement.posX < (xStage + 2229))
		{
			if(CharacterMovement.posY > 577-45)
			{
				CharacterMovement.posY = 577-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 2229) && CharacterMovement.posX < (xStage + 2380))
		{
			if(CharacterMovement.posY > 455-45)
			{
				CharacterMovement.posY = 455-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 2408) && CharacterMovement.posX < (xStage + 2500))
		{
			if(CharacterMovement.posY > 515-45)
			{
				CharacterMovement.posY = 515-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 2517) && CharacterMovement.posX < (xStage + 2852))
		{
			if(CharacterMovement.posY > 462-45)
			{
				CharacterMovement.posY = 462-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 2948) && CharacterMovement.posX < (xStage + 3024))
		{
			if(CharacterMovement.posY > 577-45)
			{
				CharacterMovement.posY = 577-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 3108) && CharacterMovement.posX < (xStage + 3200))
		{
			if(CharacterMovement.posY > 535-45)
			{
				CharacterMovement.posY = 535-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 3229) && CharacterMovement.posX < (xStage + 3318))
		{
			if(CharacterMovement.posY > 492-45)
			{
				CharacterMovement.posY = 492-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 3337) && CharacterMovement.posX < (xStage + 3557))
		{
			if(CharacterMovement.posY > 492-45)
			{
				CharacterMovement.posY = 492-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 3594) && CharacterMovement.posX < (xStage + 3673))
		{
			if(CharacterMovement.posY > 455-45)
			{
				CharacterMovement.posY = 455-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 3673) && CharacterMovement.posX < (xStage + 3743))
		{
			if(CharacterMovement.posY > 577-45)
			{
				CharacterMovement.posY = 577-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 3743) && CharacterMovement.posX < (xStage + 3891))
		{
			if(CharacterMovement.posY > 639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 3950) && CharacterMovement.posX < (xStage + 4035))
		{
			if(CharacterMovement.posY > 577-45)
			{
				CharacterMovement.posY = 577-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 4135) && CharacterMovement.posX < (xStage + 4225))
		{
			if(CharacterMovement.posY > 527-45)
			{
				CharacterMovement.posY = 527-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 4340) && CharacterMovement.posX < (xStage + 4434))
		{
			if(CharacterMovement.posY > 492-45)
			{
				CharacterMovement.posY = 492-45;
			}
		}
		if(CharacterMovement.posX > (xStage + 4457) && CharacterMovement.posX < (xStage + 4540))
		{
			if(CharacterMovement.posY > 462-45)
			{
				CharacterMovement.posY = 462-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 4540) && CharacterMovement.posX < (xStage + 4752))
		{
			if(CharacterMovement.posY > 555-45)
			{
				CharacterMovement.posY = 555-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 4812) && CharacterMovement.posX < (xStage + 4896))
		{
			if(CharacterMovement.posY > 639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 4896) && CharacterMovement.posX < (xStage + 5115))
		{
			if(CharacterMovement.posY > 569-45)
			{
				CharacterMovement.posY = 569-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 5137) && CharacterMovement.posX < (xStage + 5234))
		{
			if(CharacterMovement.posY > 515-45)
			{
				CharacterMovement.posY = 515-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 5246) && CharacterMovement.posX < (xStage + 5330))
		{
			if(CharacterMovement.posY > 455-45)
			{
				CharacterMovement.posY = 455-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 5330) && CharacterMovement.posX < (xStage + 5403))
		{
			if(CharacterMovement.posY > 575-45)
			{
				CharacterMovement.posY = 575-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 5403) && CharacterMovement.posX < (xStage + 5549))
		{
			if(CharacterMovement.posY > 639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 5545) && CharacterMovement.posX < (xStage + 5883))
		{
			if(CharacterMovement.posY > 569-45)
			{
				CharacterMovement.posY = 569-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 5969) && CharacterMovement.posX < (xStage + 6052))
		{
			if(CharacterMovement.posY > 575-45)
			{
				CharacterMovement.posY = 575-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 6116) && CharacterMovement.posX < (xStage + 6212))
		{
			if(CharacterMovement.posY > 505-45)
			{
				CharacterMovement.posY = 505-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 6235) && CharacterMovement.posX < (xStage + 6332))
		{
			if(CharacterMovement.posY > 450-45)
			{
				CharacterMovement.posY = 450-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 6305) && CharacterMovement.posX < (xStage + 6376))
		{
			if(CharacterMovement.posY > 575-45)
			{
				CharacterMovement.posY = 575-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 6427) && CharacterMovement.posX < (xStage + 6493))
		{
			if(CharacterMovement.posY > 515-45)
			{
				CharacterMovement.posY = 515-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 6493) && CharacterMovement.posX < (xStage + 6554))
		{
			if(CharacterMovement.posY > 633-45)
			{
				CharacterMovement.posY = 633-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 6582) && CharacterMovement.posX < (xStage + 6987))
		{
			if(CharacterMovement.posY > 564-45)
			{
				CharacterMovement.posY = 564-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 7119) && CharacterMovement.posX < (xStage + 7202))
		{
			if(CharacterMovement.posY > 575-45)
			{
				CharacterMovement.posY = 575-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 7202) && CharacterMovement.posX < (xStage + 7275))
		{
			if(CharacterMovement.posY >639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 7339) && CharacterMovement.posX < (xStage + 7416))
		{
			if(CharacterMovement.posY > 639-45)
			{
				CharacterMovement.posY = 639-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 7416) && CharacterMovement.posX < (xStage + 7485))
		{
			if(CharacterMovement.posY > 575-45)
			{
				CharacterMovement.posY = 575-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 7485) && CharacterMovement.posX < (xStage + 7562))
		{
			if(CharacterMovement.posY > 520-45)
			{
				CharacterMovement.posY = 520-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 7654) && CharacterMovement.posX < (xStage + 7742))
		{
			if(CharacterMovement.posY > 568-45)
			{
				CharacterMovement.posY = 568-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 7769) && CharacterMovement.posX < (xStage + 7853))
		{
			if(CharacterMovement.posY > 550-45)
			{
				CharacterMovement.posY = 550-45;
			}
		}
		
		if(CharacterMovement.posX > (xStage + 7986) && CharacterMovement.posX < (xStage + 8071))
		{
			if(CharacterMovement.posY > 616-45)
			{
				CharacterMovement.posY = 616-45;
			}
		}
		
		if(xStage > 0)
		{
			xStage = 0;
		}
		
		
		if(xStage < -6910)
		{
			xStage = -6909;
		}
		
		//------------------------------------------------------------------------------------------------------------------------------------
		
	if(CharacterMovement2.posX > (xStage2 - 20) && CharacterMovement2.posX < (xStage2 + 76))
	{
		if(CharacterMovement2.posY > 459-45-350)
		{
			CharacterMovement2.posY = 459-45-350;
		}
	}
	if(CharacterMovement2.posX > (xStage2 + 203) && CharacterMovement2.posX < (xStage2 + 287))
	{
		if(CharacterMovement2.posY > 577-45-350)
		{
			CharacterMovement2.posY = 577-45-350;
		}
	}
	if(CharacterMovement2.posX > (xStage2 + 277) && CharacterMovement2.posX < (xStage2 + 358))
	{
		if(CharacterMovement2.posY > 639-45-350)
		{
			CharacterMovement2.posY = 639-45-350;
		}
	}
	if(CharacterMovement2.posX > (xStage2 + 420) && CharacterMovement2.posX < (xStage2 + 502))
	{
		if(CharacterMovement2.posY > 639-45-350)
		{
			CharacterMovement2.posY = 639-45-350;
		}
	}
	if(CharacterMovement2.posX > (xStage2 + 492) && CharacterMovement2.posX < (xStage2 + 641))
	{
		if(CharacterMovement2.posY > 577-45-350)
		{
			CharacterMovement2.posY = 577-45-350;
		}
	}
	if(CharacterMovement2.posX > (xStage2 + 631) && CharacterMovement2.posX < (xStage2 + 716))
	{
		if(CharacterMovement2.posY > 639-45-350)
		{
			CharacterMovement2.posY = 639-45-350;
		}
	}
	if(CharacterMovement2.posX > (xStage2 + 738) && CharacterMovement2.posX < (xStage2 + 826))
	{
		if(CharacterMovement2.posY > 555-45-350)
		{
			CharacterMovement2.posY = 555-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 848) && CharacterMovement2.posX < (xStage2 + 940))
	{
		if(CharacterMovement2.posY > 555-45-350)
		{
			CharacterMovement2.posY = 555-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 995) && CharacterMovement2.posX < (xStage2 + 1086))
	{
		if(CharacterMovement2.posY > 555-45-350)
		{
			CharacterMovement2.posY = 555-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 1086) && CharacterMovement2.posX < (xStage2 + 1295))
	{
		if(CharacterMovement2.posY > 624-45-350)
		{
			CharacterMovement2.posY = 624-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 1086) && CharacterMovement2.posX < (xStage2 + 1295))
	{
		if(CharacterMovement2.posY > 624-45-350)
		{
			CharacterMovement2.posY = 624-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 1295) && CharacterMovement2.posX < (xStage2 + 1371))
	{
		if(CharacterMovement2.posY > 577-45-350)
		{
			CharacterMovement2.posY = 577-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 1392) && CharacterMovement2.posX < (xStage2 + 1497))
	{
		if(CharacterMovement2.posY > 535-45-350)
		{
			CharacterMovement2.posY = 535-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 1501) && CharacterMovement2.posX < (xStage2 + 1570))
	{
		if(CharacterMovement2.posY > 577-45-350)
		{
			CharacterMovement2.posY = 577-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 1693) && CharacterMovement2.posX < (xStage2 + 1752))
	{
		if(CharacterMovement2.posY > 639-45-350)
		{
			CharacterMovement2.posY = 639-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 1752) && CharacterMovement2.posX < (xStage2 + 1813))
	{
		if(CharacterMovement2.posY > 577-45-350)
		{
			CharacterMovement2.posY = 577-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 1813) && CharacterMovement2.posX < (xStage2 + 1873))
	{
		if(CharacterMovement2.posY > 639-45-350)
		{
			CharacterMovement2.posY = 639-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 1850) && CharacterMovement2.posX < (xStage2 + 2039))
	{
		if(CharacterMovement2.posY > 515-45-350)
		{
			CharacterMovement2.posY = 515-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 2008) && CharacterMovement2.posX < (xStage2 + 2159))
	{
		if(CharacterMovement2.posY > 639-45-350)
		{
			CharacterMovement2.posY = 639-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 2159) && CharacterMovement2.posX < (xStage2 + 2229))
	{
		if(CharacterMovement2.posY > 577-45-350)
		{
			CharacterMovement2.posY = 577-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 2229) && CharacterMovement2.posX < (xStage2 + 2380))
	{
		if(CharacterMovement2.posY > 455-45-350)
		{
			CharacterMovement2.posY = 455-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 2408) && CharacterMovement2.posX < (xStage2 + 2500))
	{
		if(CharacterMovement2.posY > 515-45-350)
		{
			CharacterMovement2.posY = 515-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 2517) && CharacterMovement2.posX < (xStage2 + 2852))
	{
		if(CharacterMovement2.posY > 462-45-350)
		{
			CharacterMovement2.posY = 462-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 2948) && CharacterMovement2.posX < (xStage2 + 3024))
	{
		if(CharacterMovement2.posY > 577-45-350)
		{
			CharacterMovement2.posY = 577-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 3108) && CharacterMovement2.posX < (xStage2 + 3200))
	{
		if(CharacterMovement2.posY > 535-45-350)
		{
			CharacterMovement2.posY = 535-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 3229) && CharacterMovement2.posX < (xStage2 + 3318))
	{
		if(CharacterMovement2.posY > 492-45-350)
		{
			CharacterMovement2.posY = 492-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 3337) && CharacterMovement2.posX < (xStage2 + 3557))
	{
		if(CharacterMovement2.posY > 492-45-350)
		{
			CharacterMovement2.posY = 492-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 3594) && CharacterMovement2.posX < (xStage2 + 3673))
	{
		if(CharacterMovement2.posY > 455-45-350)
		{
			CharacterMovement2.posY = 455-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 3673) && CharacterMovement2.posX < (xStage2 + 3743))
	{
		if(CharacterMovement2.posY > 577-45-350)
		{
			CharacterMovement2.posY = 577-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 3743) && CharacterMovement2.posX < (xStage2 + 3891))
	{
		if(CharacterMovement2.posY > 639-45-350)
		{
			CharacterMovement2.posY = 639-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 3950) && CharacterMovement2.posX < (xStage2 + 4035))
	{
		if(CharacterMovement2.posY > 577-45-350)
		{
			CharacterMovement2.posY = 577-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 4135) && CharacterMovement2.posX < (xStage2 + 4225))
	{
		if(CharacterMovement2.posY > 527-45-350)
		{
			CharacterMovement2.posY = 527-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 4340) && CharacterMovement2.posX < (xStage2 + 4434))
	{
		if(CharacterMovement2.posY > 492-45-350)
		{
			CharacterMovement2.posY = 492-45-350;
		}
	}
	if(CharacterMovement2.posX > (xStage2 + 4457) && CharacterMovement2.posX < (xStage2 + 4540))
	{
		if(CharacterMovement2.posY > 462-45-350)
		{
			CharacterMovement2.posY = 462-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 4540) && CharacterMovement2.posX < (xStage2 + 4752))
	{
		if(CharacterMovement2.posY > 555-45-350)
		{
			CharacterMovement2.posY = 555-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 4812) && CharacterMovement2.posX < (xStage2 + 4896))
	{
		if(CharacterMovement2.posY > 639-45-350)
		{
			CharacterMovement2.posY = 639-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 4896) && CharacterMovement2.posX < (xStage2 + 5115))
	{
		if(CharacterMovement2.posY > 569-45-350)
		{
			CharacterMovement2.posY = 569-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 5137) && CharacterMovement2.posX < (xStage2 + 5234))
	{
		if(CharacterMovement2.posY > 515-45-350)
		{
			CharacterMovement2.posY = 515-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 5246) && CharacterMovement2.posX < (xStage2 + 5330))
	{
		if(CharacterMovement2.posY > 455-45-350)
		{
			CharacterMovement2.posY = 455-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 5330) && CharacterMovement2.posX < (xStage2 + 5403))
	{
		if(CharacterMovement2.posY > 575-45-350)
		{
			CharacterMovement2.posY = 575-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 5403) && CharacterMovement2.posX < (xStage2 + 5549))
	{
		if(CharacterMovement2.posY > 639-45-350)
		{
			CharacterMovement2.posY = 639-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 5545) && CharacterMovement2.posX < (xStage2 + 5883))
	{
		if(CharacterMovement2.posY > 569-45-350)
		{
			CharacterMovement2.posY = 569-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 5969) && CharacterMovement2.posX < (xStage2 + 6052))
	{
		if(CharacterMovement2.posY > 575-45-350)
		{
			CharacterMovement2.posY = 575-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 6116) && CharacterMovement2.posX < (xStage2 + 6212))
	{
		if(CharacterMovement2.posY > 505-45-350)
		{
			CharacterMovement2.posY = 505-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 6235) && CharacterMovement2.posX < (xStage2 + 6332))
	{
		if(CharacterMovement2.posY > 450-45-350)
		{
			CharacterMovement2.posY = 450-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 6305) && CharacterMovement2.posX < (xStage2 + 6376))
	{
		if(CharacterMovement2.posY > 575-45-350)
		{
			CharacterMovement2.posY = 575-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 6427) && CharacterMovement2.posX < (xStage2 + 6493))
	{
		if(CharacterMovement2.posY > 515-45-350)
		{
			CharacterMovement2.posY = 515-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 6493) && CharacterMovement2.posX < (xStage2 + 6554))
	{
		if(CharacterMovement2.posY > 633-45-350)
		{
			CharacterMovement2.posY = 633-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 6582) && CharacterMovement2.posX < (xStage2 + 6987))
	{
		if(CharacterMovement2.posY > 564-45-350)
		{
			CharacterMovement2.posY = 564-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 7119) && CharacterMovement2.posX < (xStage2 + 7202))
	{
		if(CharacterMovement2.posY > 575-45-350)
		{
			CharacterMovement2.posY = 575-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 7202) && CharacterMovement2.posX < (xStage2 + 7275))
	{
		if(CharacterMovement2.posY >639-45-350)
		{
			CharacterMovement2.posY = 639-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 7339) && CharacterMovement2.posX < (xStage2 + 7416))
	{
		if(CharacterMovement2.posY > 639-45-350)
		{
			CharacterMovement2.posY = 639-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 7416) && CharacterMovement2.posX < (xStage2 + 7485))
	{
		if(CharacterMovement2.posY > 575-45-350)
		{
			CharacterMovement2.posY = 575-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 7485) && CharacterMovement2.posX < (xStage2 + 7562))
	{
		if(CharacterMovement2.posY > 520-45-350)
		{
			CharacterMovement2.posY = 520-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 7654) && CharacterMovement2.posX < (xStage2 + 7742))
	{
		if(CharacterMovement2.posY > 568-45-350)
		{
			CharacterMovement2.posY = 568-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 7769) && CharacterMovement2.posX < (xStage2 + 7853))
	{
		if(CharacterMovement2.posY > 550-45-350)
		{
			CharacterMovement2.posY = 550-45-350;
		}
	}
	
	if(CharacterMovement2.posX > (xStage2 + 7986) && CharacterMovement2.posX < (xStage2 + 8071))
	{
		if(CharacterMovement2.posY > 616-45-350)
		{
			CharacterMovement2.posY = 616-45-350;
		}
	}
	
	if(xStage2 > 0)
	{
		xStage2 = 0;
	}
	
	
	if(xStage2 < -6910)
	{
		xStage2 = -6909;
	}
	}

	public static int getxStage() {
		return xStage;
	}

	public static void setxStage(int xStage) {
		Stages.xStage = xStage;
	}

	public static int getyStage() {
		return yStage;
	}

	public static void setyStage(int yStage) {
		Stages.yStage = yStage;
	}
	
	
}
