package server;

import java.io.IOException;
import java.net.Socket;

import messages.ChangeMsg;
import messages.JoinMsg;
import messages.Message;

public class Client {

	private Socket socket;
	private String name;
	private ServerModel serverModel;

	protected Client(ServerModel serverModel, Socket socket) {
		this.serverModel = serverModel;
		this.socket = socket;

		// Create thread to read incoming messages
		Runnable r = new Runnable() {
			@Override
			public void run() {
				while (true) {
					Message msg = Message.receive(socket);
					if (msg instanceof ChangeMsg) {
						serverModel.broadcast((ChangeMsg) msg);
					} else if (msg instanceof JoinMsg) {
						Client.this.name = ((JoinMsg) msg).getName();
					}
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
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

	public void send(ChangeMsg msg) {
		msg.send(socket);

	}

}
