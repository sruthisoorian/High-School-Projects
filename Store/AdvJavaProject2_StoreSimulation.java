//This is the Driver Class
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class AdvJavaProject2_StoreSimulation extends JApplet implements ActionListener, KeyListener{

	//Global Variables
	LinkedList<Line> registers;
	JButton addRegister;
	JButton subtractRegister;
	Timer time;
	int serviceSpeed;
	int serviceTick;
	int timeRemaining;
	ButtonGroup lineRate;
	JRadioButton slow;
	JRadioButton normal;
	JRadioButton fast;
	Random rnd;

	public void init()
	{
		serviceSpeed = 30;   //service speed
		serviceTick = 0;
		timeRemaining = 600;
		time = new Timer(100, this);//timer, og is 100
		time.start();

		//Content Pane Stuff
		this.setSize(1200, 800);
		setContentPane(new DrawingPanel());
		setFocusable(true);
		addKeyListener(this);
		registers = new LinkedList<Line>();
		registers.add(new Line(200, 100, 2)); //change x/y spacing of lines here
		lineRate = new ButtonGroup();
		slow = new JRadioButton("Slow");
		normal = new JRadioButton("Normal");
		fast = new JRadioButton("Fast");
		lineRate.add(slow);
		lineRate.add(normal);
		lineRate.add(fast);
		slow.addActionListener(this);
		normal.addActionListener(this);
		fast.addActionListener(this);
		add(slow);
		add(normal);
		add(fast);
		addRegister = new JButton("Add Register");
		subtractRegister = new JButton("Close Register");
		add(addRegister);
		add(subtractRegister);
		addRegister.addActionListener(this);
		subtractRegister.addActionListener(this);
		rnd = new Random();

	}

	public void keyPressed(KeyEvent e) {


	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	Line getShortestLine()
	{
		Line temp = registers.get(0);
		for (int i = 0; i < registers.size(); i++)
		{
			if (registers.get(i).getSize() < temp.getSize())
			{
				temp = registers.get(i);
			}

		}
		return temp;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == time && (slow.isSelected() || normal.isSelected() || fast.isSelected()))
		{
			if (timeRemaining > 0)
			{
				if (rnd.nextInt(5) > 3)
				{
					getShortestLine().addCustomer();
				}
				timeRemaining --;
				if(serviceTick == serviceSpeed)
				{

					for (int i = 0; i < registers.size(); i++)
					{
						if (registers.get(i).getSize() > 0)
						{
							registers.get(i).removeFirstCustomer();
						}
					}
					serviceTick = 0;
				}
				for (int j = 0; j < registers.size(); j++)
				{
					registers.get(j).updateWaitTime();
					registers.get(j).removeImpatientCustomers();
				}
				serviceTick++;
				repaint();
			}
		}

		if (e.getSource() == addRegister)
		{
			registers.add(new Line(200, 100 * (registers.size() + 1), registers.get(registers.size() - 1))); //x/y for additional registers

		}
		if (e.getSource() == subtractRegister)
		{
			registers.removeLast();
		}
	}

	 public class DrawingPanel extends JPanel
	 {
	   	public void paintComponent(Graphics g)
	   	{
			for (int j = 0; j < registers.size(); j++)
			{
				registers.get(j).draw(g);
			}
	   	}
	 }

}//end of driver
