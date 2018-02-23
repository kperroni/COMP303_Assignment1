package lab1.networking;
import java.io.*;
import java.net.*;

import lab1.gui.LoginFrame;
import lab1.gui.MenuFrame;

public class Client {
	Socket socket;
	LoginFrame frame = new LoginFrame();
	MenuFrame frameMenu;
	boolean userLogged = false;

	  class Sender extends Thread {
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

		// Sender
		@Override
		public void run() {
			do {
				try {
					//message = thisReader.readLine();
					synchronized (out) {
						if(userLogged == false) {
							if(frame.checkLogin) {
								char[] userPinChar = frame.txtPassword.getPassword();
								String passString = new String(userPinChar);
								//int userPin = Integer.parseInt(passString);
								writer.println("login-"+frame.txtUsername.getText()+"-"+passString);
								frame.checkLogin = false;
						}
						
							}				
					}
				} catch (Exception e) {
					break;
				}
			} while (true);
		}
	}

	 class Receiver extends Thread {
		InputStream in;
		BufferedReader servReader;
		String[] line;

		public Receiver(InputStream in) {
			this.in = in;
			servReader = new BufferedReader(new InputStreamReader(in));
		}

		// Receiver
		@Override
		public void run() {
			do {
				try {
					line = servReader.readLine().split("-");
					
					switch (line[0]) {
					
					case "login":{
						if(line[1].equals("success")) {
							userLogged = true;
							frameMenu = new MenuFrame(Integer.parseInt(line[2]));
							frameMenu.setVisible(true);
							frameMenu.setResizable(false);
							frameMenu.setLocationRelativeTo(null);
							frameMenu.setTitle("COMP303_Lab1");
							frame.setVisible(false);
						}
						if(line[1].equals("fail")) {
						
								frame.showMessage("Login Failed");		
						}
						break;
					}
					}
					System.out.println(line[0]);
					
					// Receive login status, open menu frame HERE
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
		frame.setVisible(true);
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