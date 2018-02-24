package lab1.networking;

import java.io.*;
import java.net.*;

import lab1.classes.BankDatabase;

public class Server {
	ServerSocket main;
	BankDatabase bankDB = new BankDatabase();

	class Reply extends Thread {
		OutputStream out;
		InputStream in;
		BufferedReader clientReader;
		PrintWriter writer;
		String[] clientMessage;
		String clientName;
		int userAccount;

		public Reply(InputStream in, OutputStream out, String name) {
			this.in = in;
			this.out = out;
			clientReader = new BufferedReader(new InputStreamReader(in));
			writer = new PrintWriter(out, true);
			clientName = name;
		}

		// Server receiver
		@Override
		public void run() {
			do {
				try {
					synchronized (in) {
						clientMessage = (clientReader.readLine()).split("-");
						System.out.println(clientMessage[0]);
					}
					if (clientMessage.length >= 1) {
						if (clientMessage[0].equals("deposit")) {
							writer.println("Depositing");
							bankDB.deposit(userAccount, Double.parseDouble(clientMessage[1]));
							writer.println("deposit-" + "success-" + bankDB.getAvailableBalance(userAccount));
						} else if (clientMessage[0].equals("withdraw")) {
							// writer.println("withdraw-success-300");
							// writer.println("withdraw-fail");
							if (bankDB.getAvailableBalance(userAccount) - Double.parseDouble(clientMessage[1]) < 0) {
								writer.println("withdraw-" + "fail");
							} else {
								bankDB.debit(userAccount, Double.parseDouble(clientMessage[1]));
								writer.println("withdraw-" + "success-" + bankDB.getAvailableBalance(userAccount));
							}
						} else if (clientMessage[0].equals("viewBalance")) {
							writer.println("viewBalance-" + "success-" + bankDB.getAvailableBalance(userAccount));
							// JOptionPane.showMessageDialog(null, "Your balance is:
							// "+bankDB.getAvailableBalance(userAccount));
						} else if (clientMessage[0].equals("login")) {
							if (clientMessage[1].equals("fail")) {
								writer.println("login-fail");
							} else {
								int tempAccount = Integer.parseInt(clientMessage[1]);
								if (bankDB.authenticateUser(tempAccount, Integer.parseInt(clientMessage[2]))) {
									// User is logged in
									userAccount = tempAccount;
									writer.println("login-success-" + clientMessage[1]);
								} else {
									writer.println("login-fail");
								}
							}
						} else {
							writer.println("Error: That is not a valid command. Please try again.");
						}
					}
					/*
					 * else {
					 * writer.println("Error: No command specified. Please enter a valid command.");
					 * }
					 */
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
			} while (true);
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
			// index++;
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