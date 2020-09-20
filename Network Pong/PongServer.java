import java.net.*;
import java.io.*;

public class PongServer {
    public static void main(String[] args) throws IOException {

		int portNumber1 = 1342;
		int portNumber2 = 1343;

        if (args.length != 1) {
            System.err.println("Usage: java KnockKnockServer " + portNumber1 + " and " + portNumber2);
            //System.exit(1);
        }
        //int portNumber = Integer.parseInt(args[0]);

        try (
            ServerSocket serverSocket1 = new ServerSocket(portNumber1);
            Socket clientSocket1 = serverSocket1.accept();
            ServerSocket serverSocket2 = new ServerSocket(portNumber2);
            Socket clientSocket2 = serverSocket2.accept();

            PrintWriter out1 = new PrintWriter(clientSocket1.getOutputStream(), true);
            PrintWriter out2 = new PrintWriter(clientSocket2.getOutputStream(), true);
            BufferedReader in1 = new BufferedReader(
                new InputStreamReader(clientSocket1.getInputStream()));
            BufferedReader in2 = new BufferedReader(
                new InputStreamReader(clientSocket2.getInputStream()));
        ) {

            String inputLine1, outputLine1;
            String inputLine2, outputLine2;

            // Initiate conversation with client
            PongProtocol kkp1 = new PongProtocol();
            outputLine1 = kkp1.processInput(null);
            out1.println(outputLine1);

            PongProtocol kkp2 = new PongProtocol();
			outputLine2 = kkp2.processInput(null);
            out2.println(outputLine2);

            while ((inputLine1 = in1.readLine()) != null || (inputLine2 = in2.readLine()) != null) {
                outputLine1 = kkp1.processInput(inputLine1);
                out1.println(outputLine1);
                outputLine2 = kkp2.processInput(inputLine2);
				out2.println(outputLine2);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber1 + " or " + portNumber2 + " or listening for a connection");
            System.out.println(e.getMessage());
        }

    }
}