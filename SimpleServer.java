import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SimpleServer {

	private static final int PORT = 3333;

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(PORT);
		System.out.println("ServerSocket created");
		
		while (true) {
			System.out.println("Waiting for client connection on port " + PORT);
			Socket cs = ss.accept();
			System.out.println("Client connected");

			BufferedReader r = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			PrintStream ops = new PrintStream(cs.getOutputStream());
			String line;
			while ((line = r.readLine()) != null) {
				line = line.toUpperCase();
				System.out.println("Server Received from Client: " + line);
		        ops.println(line);
			}
			System.out.println("Client disconnected");
			r.close();
		}
	}
}

/*telnew localhost 3333*/