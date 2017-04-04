package tictactoe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javafx.scene.text.Text;

public class Client {
	
	private boolean turnX = true;

	private String ip = "localhost";
	private int port = 22222;
	private Scanner scanner = new Scanner(System.in);
	
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;

	private ServerSocket serverSocket;
	
//		public Client() {
//			
//			System.out.println("Please input the IP: ");
//			ip = scanner.nextLine();
//			System.out.println("Please input the port: ");
//			port = scanner.nextInt();
//			while (port < 1 || port > 65535) {
//				System.out.println("The port you entered was invalid, please input another port: ");
//				port = scanner.nextInt();
//						
//		}
//			
//	}
		
		private boolean connect() {
			try {
				socket = new Socket(ip, port);
				dos = new DataOutputStream(socket.getOutputStream());
				dis = new DataInputStream(socket.getInputStream());
				
			} catch (IOException e) {
				System.out.println("Unable to connect to the address: " + ip + ":" + port + " | Starting a server");
				return false;
			}
			System.out.println("Successfully connected to the server.");
			return true;
		}

		private void initializeServer() {
			try {
				serverSocket = new ServerSocket(port, 8, InetAddress.getByName(ip));
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
}



	
	



