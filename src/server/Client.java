package server;

import java.io.IOException;
import java.net.Socket;

import messages.BoardMsg;
import messages.GameMsg;
import messages.JoinMsg;
import messages.Message;

public class Client {

	private Socket socket;
	private String name;
	private ServerModel serverModel;
	private volatile boolean stop = false;

	protected Client(ServerModel serverModel, Socket socket) {
		this.serverModel = serverModel;
		this.socket = socket;

		// Create thread to read incoming messages
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					while (!stop) {
						Message msg = Message.receive(socket);
						System.out.println("bereit für einkommende Nachrichten");
						if (msg instanceof BoardMsg) {
							serverModel.broadcast((BoardMsg) msg);
							System.out.println("broadcast to all clients");

							if (msg instanceof GameMsg) {
								serverModel.broadcast((BoardMsg) msg);

							}

						} else if (msg instanceof JoinMsg) {
							Client.this.name = ((JoinMsg) msg).getName();

						}
					}
				} catch (Exception e) {
				}

			}
		};
		Thread t = new Thread(r);
		t.start();
	}

	public void stop() {
		try {
			stop = true;
			socket.close();
		} catch (IOException e) {

		}

	}

	public String toString() {
		return name + ": " + socket.toString();
	}

	public void send(Message msg) {
		msg.send(socket);

	}

}
