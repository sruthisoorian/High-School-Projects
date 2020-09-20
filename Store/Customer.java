//This is the Customer Class
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Customer {

	Image cart;
	int wait;
	int spot;

	public Customer()
	{
		Random rnd = new Random();
		wait = rnd.nextInt(200) + 100;
		if (rnd.nextInt(10) > 8)
		{
			spot = rnd.nextInt(100) + 100;
		}
		else
		{
			spot = rnd.nextInt(40);
		}
		try
		{
			cart = ImageIO.read(new File("shopper.png"));
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}

	int getWait()
	{
		return wait;
	}

	void removeWait(int amount)
	{
		wait -= amount;
	}

	int getSpot()
	{
		return spot;
	}

	void draw(int x, int y, Graphics g)
	{
		//draw the image
		//g.drawImage(cart, x, y, null);  //change spacing of carts
		//waitBackground
		//g.fillRect(x + 4, y - 40, 50, 100);

		g.setColor(Color.RED);
		//if (wait > 10) g.setColor(Color.orange);
		//if (wait > 20) g.setColor(Color.yellow);
		//if (wait > 30) g.setColor(Color.GREEN);

		//g.fillRect(x , y - 5, 60, 75);
		//g.setColor(Color.black);

		//draw the image
		g.drawImage(cart, x, y, null);  //change spacing of carts
	}
}