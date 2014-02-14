import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
	private static final int PORT = 3333;
	private static final String HOST = "localhost";
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket(HOST, PORT);
		System.out.println("Client is connected to " + PORT);
		
		/*System.out.print("Enter please: \t");    
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();*/

		String str= "hello world!";
        // change to lowercase
        str = str.toLowerCase();
        
        PrintStream ops = new PrintStream(socket.getOutputStream());
        ops.println(str);
        
        //read from server
        
        BufferedReader  br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
		while ((line = br.readLine()) != null) {
			System.out.println("Client reads from server: " + line);
		}
		
		ops.close();
	}
	
}