//Adv Java Project 1
//Driver
//Created by Sruthi Soorian
import java.applet.Applet;
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
public class AdvJavaProject1_Driver extends JApplet implements ActionListener, KeyListener
{
	//Global Variables
	GridMaker myGrid;
	JPanel center;
	Boxes [][] t;
	int sz = 20;
	int sy = 20;
	int rowcushion = 20;
	int columncushion = 20;
	int howmanyrows = 10;
	int howmanycolumns = 10;
	SpriteSheet eagleSheet;
	BufferedImage eagle;
	Timer time;
	int delay = 500;
	int picswitch = 0;
	int keyState;

	public void init()
	{
		setContentPane( new drawing_Panel());
		Container c = getContentPane();
		setFocusable(true);
		addKeyListener(this);
		center = new JPanel();
		t = new Boxes[10][10];
		time = new Timer(delay, this);
		time.start();

		try {
		    eagle = ImageIO.read(new File("EagleSpriteSheet.png"));
			} catch (IOException e) {
				System.out.print("file not found");
			}

		 eagleSheet = new SpriteSheet(eagle);

		for (int r = 0; r < howmanyrows; r++)
		{
			for (int a = 0; a < howmanycolumns; a++)
			{
				t[r][a] = new Boxes((r * rowcushion) + 100 , (a * columncushion) + 100, sz, sy);
			}
		}
	}

	public class drawing_Panel extends JPanel //This is where you can draw
		{
			public void paintComponent(Graphics g)//Put your shapes in here
			{
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				//eagleSheet.drawImage(g2);      draws entire sprite sheet
				eagleSheet.animate(g2, picswitch); // draws animated gif
				//eagleSheet.drawImageScaled(g2);
				eagleSheet.moveSpriteRight(g2);

				for (int r = 0; r < howmanyrows; r++)
				{
					for (int c = 0; c < howmanycolumns; c++)
					{
						t[r][c].draw(g);
					}
				}
			}
		}
		public void actionPerformed(ActionEvent e)
		{
			if (time.isRunning())
			{
				if (picswitch < 7)
				{
					picswitch++;
				}
				else
				{
					picswitch = 0;
				}
				repaint();
			}
		}
		public void keyPressed(KeyEvent e)
		{
			if( e.getKeyCode() == KeyEvent.VK_UP)
			{
				System.out.println("you pressed up");
				keyState = 1;
			}
			if( e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				System.out.println("you pressed down");
			}
			if( e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				System.out.println("you pressed left");
			}
			if( e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				System.out.println("you pressed right");
			}
			repaint();
		}
		public void keyReleased(KeyEvent e)
		{

		}
		public void keyTyped(KeyEvent e)
		{

		}

}//End of Program

//Other Code Samples
/*
//GridMaker myGrid = new GridMaker();
//center.add(myGrid.GetGrid());
//c.add(center, BorderLayout.CENTER);



*/