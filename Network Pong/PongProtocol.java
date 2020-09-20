import java.net.*;
import java.io.*;

public class PongProtocol {

    public int theOutput;

    public int getoutarr()
    {
	}


    public int processInput(int theInput)
    {
        if (theInput == 1)
        {
			theOutput = 2;
		}
		else if (theInput == 2)
		{
			theOutput = -2;
		}
        return theOutput;
    }
}