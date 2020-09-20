//Adv Java Project 1
//Box
//Created by Sruthi Soorian
//http://www.java2s.com/Tutorials/Java/Graphics_How_to/Image/Use_the_subImage_Rectangle_method_to_create_the_smaller_image.htm
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.lang.Object.*;
import java.awt.Graphics.*;
import java.awt.Graphics2D.*;





public class SpriteSheet
{
	BufferedImage sprite;
	BufferedImage sub;
	BufferedImage sub2;
	int state;
	int picswitch;
	int subx1 = 0; //0,76,152 |0 ,76,152 |0, 76
	int suby1 = 0;  //0	    |105	   |190
	int subx2 = 76;  //76
	int suby2 = 65;  //65
	int beginingposx = 100;
	int beginingposy = 100;

	//This class creates a box object
	public SpriteSheet(BufferedImage sprite)
	{
		this.sprite = sprite;
	}

	public void drawImage (Graphics2D g)
	{
		g.drawImage(sprite, 10, 10, null);
	}
	public void drawImageScaled (Graphics2D g)
	{
		g.drawImage(sub, beginingposx, beginingposy, 20, 20, null);
	}
	public void moveSpriteUp(Graphics2D g)
	{
		beginingposy = beginingposy + 20;
		g.drawImage(sub, beginingposx, beginingposy, 20, 20, null);
	}
	public void moveSpriteDown(Graphics2D g)
	{
		beginingposy = beginingposy - 20;
		g.drawImage(sub, beginingposx, beginingposy, 20, 20, null);
	}
	public void moveSpriteLeft(Graphics2D g)
	{
		beginingposx = beginingposx - 20;
		g.drawImage(sub, beginingposx, beginingposy, 20, 20, null);
	}
	public void moveSpriteRight(Graphics2D g)
	{
		beginingposx = beginingposx + 20;
		g.drawImage(sub, beginingposx, beginingposy, 20, 20, null);
	}
	public void animate (Graphics2D g, int picswitch)
	{
		this.picswitch = picswitch;
		state = picswitch;

		if (state == 0)
		{
			subx1 = 0 ;
			suby1 = 0 ;
			subx2 = 76 ;
			suby2 = 65 ;
		}
		if (state == 1)
		{
			subx1 = 76 ;
			suby1 = 0 ;
			subx2 = 76 ;
			suby2 = 65 ;
		}
		if (state == 2)
		{
			subx1 = 152 ;
			suby1 = 0 ;
			subx2 = 76 ;
			suby2 = 65 ;
		}
		if (state == 3)
		{
			subx1 = 0 ;
			suby1 = 105 ;
			subx2 = 76 ;
			suby2 = 65 ;
		}
		if (state == 4)
		{
			subx1 = 76 ;
			suby1 = 105 ;
			subx2 = 76 ;
			suby2 = 65;
		}
		if (state == 5)
		{
			subx1 = 152 ;
			suby1 = 105 ;
			subx2 = 76 ;
			suby2 = 65 ;
		}
		if (state == 6)
		{
			subx1 = 0 ;
			suby1 = 190 ;
			subx2 = 76 ;
			suby2 = 65 ;
			state++;
		}
		if (state == 7)
		{
			subx1 = 76 ;
			suby1 = 190 ;
			subx2 = 76 ;
			suby2 = 65 ;
			state = 0;
		}

		sub = sprite.getSubimage(subx1, suby1, subx2, suby2);
		//g.drawImage(sub, 400, 400, null);

	}




}