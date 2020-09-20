//This is the Register Class
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Register {
	Image register;

	public Register()
	{
		try
		{
			register = ImageIO.read(new File("register2.png"));
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}

	void draw(int x, int y, Graphics g)
	{
		g.drawImage(register, x, y, null);
	}


}//end of class