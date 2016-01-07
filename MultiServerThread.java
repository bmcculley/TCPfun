import java.net.*;
import java.io.*;

public class MultiServerThread extends Thread {
	private Socket socket = null;
	
	public MultiServerThread(Socket socket) {
		super("MultiServerThread");
		this.socket = socket;
	}


	public void run() {
	
		try {
		    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		    BufferedReader in = new BufferedReader(
		                new InputStreamReader(
		                socket.getInputStream()));
		
		    String inputLine, outputLine;
		    //KnockKnockProtocol kkp = new KnockKnockProtocol();
		    //outputLine = kkp.processInput(null);
		    //out.println(outputLine);
		
		    while ((inputLine = in.readLine()) != null) {
		    //outputLine = kkp.processInput(inputLine);
		    outputLine = inputLine;
		    out.println(outputLine);
		    System.out.println("Received: " + inputLine);
		    if (outputLine.equals("Bye"))
		        break;
		    }
		    out.close();
		    in.close();
		    socket.close();
		
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
