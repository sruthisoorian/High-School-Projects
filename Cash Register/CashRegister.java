import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CashRegister extends JApplet implements ActionListener
{
	//Global Variables
	JTextField monies;
	JButton submition;
	JButton dirt;
	JButton coal;
	JButton gas;
	JButton silver;
	JButton gold;
	JButton diamond;
	JButton rhino;
	JButton truffle;
	JLabel moneysub;
	JLabel change;
	JButton reset;
	ImageIcon dollar1;
	ImageIcon dollar2;
	ImageIcon dollar5;
	ImageIcon dollar6;
	ImageIcon dollar10;
	ImageIcon dollar20;
	ImageIcon dollar50;
	ImageIcon dollar100;
	JPanel monee;
	JPanel register;
	JPanel backmonee;

	double convert;
	double loosechange;






	//initialization
		public void init()
		{
			//Make things things
		monies = new JTextField(8);
		submition = new JButton ("Submition");
		moneysub = new JLabel("You owe: ");
		change = new JLabel("");
		reset = new JButton("Reset");
			//image icons
			dollar1 = new ImageIcon("dirtswag1.png");
			dollar2 = new ImageIcon("coalswag$2.png");
			dollar5 = new ImageIcon("gasswag$5.png");
			dollar6 = new ImageIcon("silverswag$6.png");
			dollar10 = new ImageIcon("goldswag$10.png");
			dollar20 = new ImageIcon("diamondswag$20.png");
			dollar50 = new ImageIcon("rhinohornswag$50.png");
			dollar100 = new ImageIcon("truffleswag$100.png");
		dirt = new JButton(dollar1);
		coal = new JButton(dollar2);
		gas = new JButton(dollar5);
		silver = new JButton(dollar6);
		gold = new JButton(dollar10);
		diamond = new JButton(dollar20);
		rhino = new JButton(dollar50);
		truffle = new JButton(dollar100);



			//Start Construction

			Container c = getContentPane();
			c.setLayout(new GridLayout (3, 1));
				//Top Panel
			monee = new JPanel(new GridLayout (2,4));
			c.add(monee, BorderLayout.NORTH);
			monee.add(monies);
			monee.add(submition);
				//Mid Panel
			register = new JPanel(new GridLayout (2,4));
			c.add(register, BorderLayout.CENTER);
			register.add(dirt);
			register.add(coal);
			register.add(gas);
			register.add(silver);
			register.add(gold);
			register.add(diamond);
			register.add(rhino);
			register.add(truffle);
				//Lower Panel
			backmonee = new JPanel(new GridLayout (1, 3));
			c.add (backmonee, BorderLayout.SOUTH);
			backmonee.add(moneysub);
			backmonee.add(change);
			backmonee.add(reset);

			submition.addActionListener(this);
			reset.addActionListener(this);
			dirt.addActionListener(this);
			coal.addActionListener(this);
			gas.addActionListener(this);
			silver.addActionListener(this);
			gold.addActionListener(this);
			diamond.addActionListener(this);
			rhino.addActionListener(this);
			truffle.addActionListener(this);

			//disablization
			dirt.setEnabled(false);
			coal.setEnabled(false);
			gas.setEnabled(false);
			silver.setEnabled(false);
			gold.setEnabled(false);
			diamond.setEnabled(false);
			rhino.setEnabled(false);
			truffle.setEnabled(false);
			reset.setEnabled(false);



		}

			//Events
				public void actionPerformed(ActionEvent e)
	{
		//Hit submition
				if (e.getSource() == submition)
		{
			convert = Double.parseDouble(monies.getText());
			moneysub.setText("You owe: $" + convert);
			change = new JLabel("");
			dirt.setEnabled(true);
			coal.setEnabled(true);
			gas.setEnabled(true);
			silver.setEnabled(true);
			gold.setEnabled(true);
			diamond.setEnabled(true);
			rhino.setEnabled(true);
			truffle.setEnabled(true);
			submition.setEnabled(false);

		}
		//Hit register buttons
		if (e.getSource() == dirt)
		{
			convert = convert - 1.0;
			moneysub.setText("You owe: $" + convert);
		}
		if (e.getSource() == coal)
		{
			convert = convert - 2.0;
			moneysub.setText("You owe: $" + convert);

		}
		if (e.getSource() == gas)
		{
			convert = convert - 5.0;
			moneysub.setText("You owe: $" + convert);
		}
		if (e.getSource() == silver)
		{
			convert = convert - 6.0;
			moneysub.setText("You owe: $" + convert);
		}
		if (e.getSource() == gold)
		{
			convert = convert - 10.0;
			moneysub.setText("You owe: $" + convert);

		}
		if (e.getSource() == diamond)
		{
			convert = convert - 20.0;
			moneysub.setText("You owe: $" + convert);
		}
		if (e.getSource() == rhino)
		{
			convert = convert - 50.0;
			moneysub.setText("You owe: $" + convert);
		}
		if (e.getSource() == truffle)
		{
			convert = convert - 100.0;
			moneysub.setText("You owe: $" + convert);
		}
		if (convert == 0 || convert < 0 )
		{
			loosechange = -convert;
			change.setText("");
			dirt.setEnabled(false);
			coal.setEnabled(false);
			gas.setEnabled(false);
			silver.setEnabled(false);
			gold.setEnabled(false);
			diamond.setEnabled(false);
			rhino.setEnabled(false);
			truffle.setEnabled(false);
			reset.setEnabled(true);

		}
		if (e.getSource() == reset)
		{

			moneysub.setText("You owe: $");
			submition.setEnabled(true);
			reset.setEnabled(false);

		}






	}

	//End Bracket of Program
}