package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import tictactoe.ServiceLocator;

public class Server {

	private boolean connection = false;
	private ServiceLocator serviceLocator;
	private String ip = "localhost";
	private int port = 22222;
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	private ServerSocket serverSocket;

	public Server() {

	}

	public void initializeServer() {
		// try{
		// ServerSocket = new ServerSocket(ip, port);
		// }catch (Exception e){
		// e.printStackTrace();
		// }

	}

	public void connectServer() {
		if (connection == false) {
			try {
				socket = new Socket(ip, port);
				dos = new DataOutputStream(socket.getOutputStream());
				dis = new DataInputStream(socket.getInputStream());

			} catch (Exception e) {
				serviceLocator = ServiceLocator.getServiceLocator();
				serviceLocator.getLogger().info("Unable to connect to Server" + ip + ":" + port);
			}

			connection = true;
			serviceLocator = ServiceLocator.getServiceLocator();
			serviceLocator.getLogger().info("Connected to Server");
		}

		// do nothing
		else {
		}
		;

	}

	public boolean getConnection() {
		return connection;
	}

	public void setConnection(boolean connection) {
		this.connection = connection;
	}

}
