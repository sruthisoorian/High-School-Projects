import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class cli
{
	public static void main(String args[])throws UnknownHostException, IOException
	{
		String number, temp;
		Scanner sc = new Scanner(System.in);
		Socket s = new Socket("10.15.8.63", 1342);
		Scanner sc1 = new Scanner(s.getInputStream());
		System.out.println("Enter something");
		number = sc.nextLine();
		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(number);
		temp = sc1.nextLine();
		System.out.println(temp);

	}
}