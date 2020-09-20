import java.net.*;
import java.io.*;
import java.util.*;

public class ClientClass
{
	private static String SIP = "";
	private static Thread sent;
	private static Thread recieved;

	public static void main(String[] args) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		SIP = scan.nextLine();

		Socket sock = new Socket(SIP, 4444);

		DataInputStream input = new DataInputStream(sock.getInputStream());
		DataOutputStream output = new DataOutputStream(sock.getOutputStream());
		sent = new Thread(new Runnable());{
			public void run(){
				while(true){
					String input = scan.nextLine();
					try{
						output.writeUTF(input);
						output.flush();
						if(input.equalsIgnoreCase("exit"))
							{
								sent.stop();
								recieved.stop();
								input.close();
								output.close();
								sock.close();
							}
						} catch (Exception e){}
					}
				}
			}
		}
	}
}