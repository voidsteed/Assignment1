import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WorkerThread extends Thread {

	Socket clientSocket;

	public WorkerThread(Socket cs) {
		this.clientSocket = cs;
	}

	@Override
	public void run() {
		System.out.println("WORKER" + Thread.currentThread().getId()
				+ ": Worker thread starting");
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			String line;
			while ((line = r.readLine()) != null) {
				//change to uppercase
				line = line.toUpperCase();
				System.out.println("WORKER" + Thread.currentThread().getId()
						+ ": Received: " + line);
				
				PrintStream ops = new PrintStream(clientSocket.getOutputStream());
		        ops.println(line);
			}
			System.out.println("WORKER" + Thread.currentThread().getId()
					+ ": Client disconnected");
			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("WORKER" + Thread.currentThread().getId()
				+ ": Worker thread finished");
	}

}
