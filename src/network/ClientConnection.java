package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server.ServerModel;
import tictactoe.ServiceLocator;

public class ClientConnection extends Thread {

	private ObjectInputStream serverInputStream;
	private ObjectOutputStream serverOutputStream;
	private int id;
	private boolean running;
	private ServerModel serverModel;
	private ServiceLocator servicelocator;

	public ClientConnection(int client_id, Socket socket, ServerModel serverModel) throws IOException {
		this.id = id;
		this.serverModel = serverModel;

		serverInputStream = new ObjectInputStream(socket.getInputStream());
		serverOutputStream = new ObjectOutputStream(socket.getOutputStream());
	}

	public void run() {
		// while(running){
		// try{
		// listen();
		// }catch (Exception e){
		// e.printStackTrace();
		// }finally

	}

	private void listen() {
		// Message msg = null;
		//
		// while (running){
		//
		// }
		//
	}

}
