import java.io.IOException;
import java.net.Socket;

public class BenchmarkClient {


	private static final int N = 1000;
	private static final String HOST = "localhost";
	private static final int PORT = 3333;

	public static void main(String[] args){

		try {
			System.out.println("Client connected to the server");

			long start = System.currentTimeMillis();

			for (int i = 0; i < N; i++) {
				Socket s = new Socket(HOST, PORT);
				new WorkerThreadClient(s).start();
			}
			long end = System.currentTimeMillis();

			System.out.println("Average time to serve a client request is " 
								+ (end-start) + " milliseconds");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
