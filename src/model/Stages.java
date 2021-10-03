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
	}
}
