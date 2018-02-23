package lab1.networking;
import java.io.*;
import java.net.*;

public class Client {
	Socket socket;

	static class Sender extends Thread {
		PrintWriter writer;
		OutputStream out;
		InputStream in;
		BufferedReader thisReader;
		String message;

		public Sender(InputStream in, OutputStream out) {
			this.out = out;
			this.in = in;
			writer = new PrintWriter(out, true);
			thisReader = new BufferedReader(new InputStreamReader(in));
		}

		@Override
		public void run() {
			do {
				try {
					message = thisReader.readLine();
					synchronized (out) {
						writer.println(message);
					}
				} catch (Exception e) {
					break;
				}
			} while (message != null);
		}
	}

	static class Receiver extends Thread {
		InputStream in;
		BufferedReader servReader;
		String line;

		public Receiver(InputStream in) {
			this.in = in;
			servReader = new BufferedReader(new InputStreamReader(in));
		}

		@Override
		public void run() {
			do {
				try {
					line = servReader.readLine();
					System.out.println(line);
				} catch (Exception e) {
					break;
				}
			} while (line != null);
		}
	}

	public Client(String hostname, int port) throws Exception {
		this.socket = new Socket(hostname, port);

	}

	public void connect() throws Exception {
		InputStream in = this.socket.getInputStream();
		OutputStream out = this.socket.getOutputStream();

		// Handle the connection
		System.out.println("Handling connection to server");
		Thread sender = new Sender(System.in, out);
		Thread receiver = new Receiver(in);

		sender.start();
		receiver.start();

		sender.join();
		receiver.join();
	}

	public static void main(String[] args) throws Exception {
		int port = 8080;
		String hostname = "localhost";
		if (args.length > 1) {
			port = Integer.parseInt(args[1]);
			hostname = args[0];
			Client c = new Client(hostname, port);
			c.connect();
		} else {
			Client c = new Client(hostname, port);
			c.connect();
		}
	}
}