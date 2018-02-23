package lab1.networking;

import java.io.*;
import java.net.*;

import lab1.classes.Account;
import lab1.classes.BankDatabase;

public class Server {
	ServerSocket main;
	BankDatabase bankDB;

	class Reply extends Thread {
		OutputStream out;
		InputStream in;
		BufferedReader clientReader;
		PrintWriter writer;
		String[] clientMessage;
		String clientName;
		Account userAccount;

		public Reply(InputStream in, OutputStream out, String name) {
			this.in = in;
			this.out = out;
			clientReader = new BufferedReader(new InputStreamReader(in));
			writer = new PrintWriter(out, true);
			clientName = name;
		}

		@Override
		public void run() {
			do {
				try {
					synchronized (in) {
						clientMessage = (clientReader.readLine()).split(" ");
					}
					if (clientMessage.length > 1) {
						if (clientMessage[0].equals("deposit")) {
							// TODO: Do deposit logic
						} else if (clientMessage[0].equals("withdraw")) {
							// TODO: Do withdraw logic
						} else if (clientMessage[0].equals("viewBalance")) {
							// TODO: Do logic to view account balance
						} else if (clientMessage[0].equals("login")) {
							// TODO: Do login logic
							if (Server.this.bankDB.authenticateUser(Integer.parseInt(clientMessage[1]),
									Integer.parseInt(clientMessage[2]))) {
								// User is logged in
							} else {
								// return some error
							}
						} else {
							writer.println("Error: That is not a valid command. Please try again.");
						}
					} else {
						writer.println("Error: No command specified. Please enter a valid command.");
					}
				} catch (Exception e) {
					break;
				}
			} while (clientMessage != null);
		}
	}

	public Server(int port) throws Exception {
		this.main = new ServerSocket(port);
	}

	public void serve() throws Exception {
		int index = 1;
		while (true) {
			Socket socket = this.main.accept();
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			// handle the connection
			System.out.println("Handling connection to client " + index);
			(new Reply(in, out, "Client" + index)).start();
			index++;
		}
	}

	public static void main(String[] args) throws Exception {
		int port = 8080;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
			Server s = new Server(port);
			System.out.println("Serving.... on port " + port);
			s.serve();
		} else {
			Server s = new Server(port);
			System.out.println("Serving.... on port " + port);
			s.serve();
		}
	}
}