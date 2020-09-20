import java.net.*;
import java.io.*;
import java.util.*;

public class ServerClass
{
	static ArrayList<ClientManager> clients;
	static Socket server;
	static ServerSocket sersoc;

	private static boolean serverStatus = true;

	public static void main(String[] args) throws Exception
	{
		clients = new ArrayList<ClientManager>();
		try{ sersoc = new ServerSocket(4444);
		}catch(Exception e){ System.err.println("Server Socket not created");}

		while(serverStatus == true)
		{
			try{server = sersoc.accept();} catch (IOException e){}
			DataInputStream input = new DataInputStream(server.getInputStream());
			DataOutputStream output = new DataOutputStream(server.getOutputStream());
			System.out.println("This Client is Now Online");
			try{
				ClientManager client = new ClientManager(server, input, output);
				Thread t = new Thread(client);
				clients.add(client);
				t.start();
			} catch(Exception e){ System.out.print("Reboot Connection");}
		}
	}

}