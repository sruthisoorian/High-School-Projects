import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Pong extends JFrame
{
	private final static int WIDTH = 700;
	private final static int HEIGHT = 450;
	private PongPanel panel;

	String hostName = "192.168.1.5";
    int portNumber = 1342;

	public static void main (String[] args) throws IOException
	{

		new Pong().setVisible(true);

	}

	public Pong()
	{
		try (
			Socket kkSocket = new Socket(hostName, portNumber);
			PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
				new InputStreamReader(kkSocket.getInputStream()));
		) {
			BufferedReader stdIn =
				new BufferedReader(new InputStreamReader(System.in));
			String fromServer;
			String fromUser;

			while ((fromServer = in.readLine()) != null) {
				System.out.println("Server: " + fromServer);
				if (fromServer.equals("Bye."))
					break;

				fromUser = stdIn.readLine();
				if (fromUser != null) {
					System.out.println("Client: " + fromUser);
					out.println(fromUser);
				}
			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " +
				hostName);
			System.exit(1);
        }




		setSize(WIDTH, HEIGHT);
		setTitle("Network Pong");
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new PongPanel(this);;
		add(panel);

	}

	public PongPanel getPanel()
	{
		return panel;
	}

}//end of class