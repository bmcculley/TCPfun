import java.io.*;
import java.net.*;

class TCPClient
{
	 public static void main(String argv[]) throws Exception
	 {
		String sentence;
	 	String modifiedSentence;
	 	Boolean keepGoing = true;
	 	Socket clientSocket = new Socket("localhost", 6789);
	 	
	 	while (keepGoing) {
	 		System.out.println( "Enter a phrase to send to the server: " );
	 		// check this input incase it says quit or something similar....
	 		BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
	 		
	 		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		 	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		 	sentence = inFromUser.readLine();
		 	System.out.println( "In from user: " + sentence );
		 	outToServer.writeBytes(sentence + '\n');
		 	modifiedSentence = inFromServer.readLine();
		 	System.out.println("FROM SERVER: " + modifiedSentence);
		 	
		}
		
	 	clientSocket.close();
	 }
}
