import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MTServer {
	
	private static final int PORT = 4444;

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(PORT);
		System.out.println("MAIN: ServerSocket created");
		for(;;) {
			System.out.println("MAIN: Waiting for client connection on port " + PORT);				
			Socket cs = ss.accept();
			System.out.println("MAIN: Client connected");
			new WorkerThread(cs).start();
		}
	}
}
