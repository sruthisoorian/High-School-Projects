import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintStream;


public class ser
{
	public static void main(String args[]) throws IOException
	{
		String number, temp;
		ServerSocket s1 = new ServerSocket(1342);
		Socket ss = s1.accept();
		Scanner sc = new Scanner(ss.getInputStream());
		number = sc.nextLine();

		temp = number;

		PrintStream p = new PrintStream(ss.getOutputStream());
		p.println(temp);
	}
}