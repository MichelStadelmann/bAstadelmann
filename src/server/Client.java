package server;

import java.io.IOException;
import java.net.Socket;

import messages.GameMsg;

public class Client {

	private Socket socket;
	private String name;
	private int client_id;

	protected Client(int client_id, Socket socket) {
		this.socket = socket;
		this.client_id = client_id;
	}

	public void stop() {
		try {
			socket.close();
		} catch (IOException e) {

		}

	}

	public String toString() {
		return name + ": " + socket.toString();
	}

	public void send(GameMsg msg) {
		msg.send(socket);

	}

}
