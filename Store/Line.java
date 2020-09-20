//This is the Line Class
import java.awt.Graphics;
import java.util.LinkedList;

public class Line {
	LinkedList<Customer> cart;
	Register aisle;
	int x;
	int y;

	public Line(int X, int Y, int initLength)
	{
		x = X;
		y = Y;
		cart = new LinkedList<Customer>();
		aisle = new Register();

		for (int j = 0; j < initLength; j++)
		{
			addCustomer();
		}
	}

	public Line(int X, int Y, Line oldLine)
	{
		x = X;
		y = Y;

		cart = new LinkedList<Customer>();
		aisle = new Register();

		int split = oldLine.getSize() / 2;
		for (int i = oldLine.getSize() - 1; i >= split; i--)
		{
			Customer m = oldLine.getCustomer(i);
			cart.add(m);
			oldLine.removeCustomerAt(i);
		}
	}

	void removeImpatientCustomers()
	{
		for (int j = 0; j < cart.size(); j++)
		{
			if(cart.get(j).getWait() <= 0)
			{
				removeCustomerAt(j);
			}
		}

	}

	void updateWaitTime()
	{
		for (int j = 0; j < cart.size(); j++)
		{
			cart.get(j).removeWait(1);
		}
	}

	Customer getCustomer(int index)
	{
		return cart.get(index);
	}

	void addCustomer()
	{
		cart.add(new Customer());
	}

	void removeCustomerAt(int index)
	{
		cart.remove(index);
	}

	void removeLastCustomer()
	{
		cart.removeLast();
	}

	void removeFirstCustomer()
	{
		if (cart.size() > 0) cart.removeFirst();
	}

	int getSize()
	{
		return cart.size();
	}

	void draw(Graphics g)
	{
		aisle.draw(x - 150, y, g); //change gap between front of line and register

		for (int i = 0; i < cart.size(); i++)
		{
			cart.get(i).draw(x + (i * 100) + 30, y, g); //multiple of i changes spacing between customers
		}
	}


}//end of class
