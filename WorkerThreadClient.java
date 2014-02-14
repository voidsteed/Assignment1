import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class WorkerThreadClient extends Thread {

	Socket serverSocket;

	public WorkerThreadClient(Socket s) {
		this.serverSocket = s;
	}


	@Override
	public void run() {

		System.out.println("CLIENT THREAD " + Thread.currentThread().getId()
				+ " starting");

		try {
			System.out.println("CLIENT THREAD " + Thread.currentThread().getId()
					+  " connected to the server");
			PrintStream ops = new PrintStream(serverSocket.getOutputStream(), true);
			BufferedReader r = new BufferedReader(new InputStreamReader(
					serverSocket.getInputStream()));

			ops.println("hello world");

			String line = r.readLine();
			System.out.println("CLIENT THREAD "  + Thread.currentThread().getId()
					+" received: " + line);			
			//serverSocket.shutdownOutput();

			System.out.println("CLIENT THREAD " + Thread.currentThread().getId()
					+ " disconnected");

			
			ops.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
			try {
				serverSocket.close();
				System.out.println("CLIENT THREAD " + Thread.currentThread().getId()
						+ " finished");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}