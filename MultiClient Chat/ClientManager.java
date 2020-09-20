import java.io.*;
import java.net.*;
import java.util.*;

public class ClientManager implements Runnable
{
	Socket client;
	private boolean status = false;
	DataInputStream input;
	DataOutputStream output;
	private String user;
	private String host;
	private String clientInput;

	public ClientManager ( Socket client, DataInputStream input, DataOutputStream output)
	{
		this.client = client;
		this.input = input;
		this.output = output;
		host = client.getInetAddress().getHostName();
		System.out.println(host + "is connected");
		status = true;
	}

	public void run()
	{
		try
		{
			output.writeUTF("What's your name?");
			output.flush();

			user = input.readUTF();
			output.writeUTF("Welcome " + user + " !");

			while(status == true)
			{
				clientInput = input.readUTF();
				if(clientInput.equalsIgnoreCase("exit"))
				{
					for( ClientManager CliMan: ServerClass.clients)
					{
						if(CliMan != this)
						{
							CliMan.output.writeUTF(user + ": " + clientInput);
						}
					}
				}
				else if(clientInput.contains("/"))
				{
					for(int i = 0; i < clientInput.length() - 1; i++)
					{
						if( clientInput.charAt(i) == ("/"))
						{
							CliMan.client(clientInput.subString(i,input.length()).output.writeUTF(user + ": " + clientInput.subString(0, i));
						}

					}
				}
			}
		} catch (Exception e){System.err.println("BAD!");}
	}



}