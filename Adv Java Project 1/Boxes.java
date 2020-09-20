//Adv Java Project 1
//Box
//Created by Sruthi Soorian
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
public class Boxes
{
	int posx;
	int posy;
	int sizex;
	int sizey;

	//This class creates a box object
	public Boxes(int posx, int posy, int sizex, int sizey)
	{
		this.posx = posx;
		this.posy = posy;
		this.sizex = sizex;
		this.sizey = sizey;
	}

	public int XCoord()   //return X coordinate
	{
		return posx;
	}
	public int YCoord()   //return Y coordinate
	{
		return posy;
	}
	public int XSize()   //return X size
	{
		return sizex;
	}
	public int YSize()   //return Y size
	{
		return sizey;
	}

	public void draw(Graphics g)
	{
		g.drawRect(posx, posy, sizex, sizey);
	}


}