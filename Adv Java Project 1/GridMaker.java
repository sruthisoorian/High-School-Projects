//Adv Java Project 1
//GridMaker
//Created by Sruthi Soorian
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
public class GridMaker implements ActionListener
{

	//To make the grid buttons
	Boxes [][] t;
	JPanel grid;

	//Create grid and buttons
	public GridMaker()
	{

	}

	public JPanel GetGrid()
	{
		return grid;
	}

	public class drawing_Panel extends JPanel //This is where you can draw
	{
		public void paintComponent(Graphics g)//Put your shapes in here
		{
			super.paintComponent(g);

			t = new Boxes[10][10];
			for (int r = 20; r < 220; r = r + 20)
			{
				for (int c = 20; c < 220; c = c + 20)
				{
					t[r][c] = new Boxes(r, c, 20, 20);
					(t[r][c]).draw(g);

				}
			}


		}

	}

	public void actionPerformed(ActionEvent e)
    {

	}

}