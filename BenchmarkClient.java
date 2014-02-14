import java.io.IOException;
import java.net.Socket;

public class BenchmarkClient {


	private static final int N = 10000;

	public static void main(String[] args){

		try {
			System.out.println("CLIENT MAIN: Client connected to the server");

			long start = System.currentTimeMillis();

			for (int i=0; i<N; i++) {
				Socket s = new Socket("localhost", 3333);
				new WorkerThreadClient(s).start();
			}
			long end = System.currentTimeMillis();

			System.out.println("CLIENT MAIN: Average time to serve a client request is " 
								+ (end-start) + " milliseconds");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}