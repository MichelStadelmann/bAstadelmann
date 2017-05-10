package messages;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

import tictactoe.ServiceLocator;

public abstract class Message implements Serializable {
	private static final long serialVersionUID = 1;

	private ServiceLocator serviceLocator;

	// Data included in a message
	private long id;
	private long timestamp;
	private String client;

	// Generator für a unique message ID
	private static long messageID = 0;

	private static long nextMessageID() {
		return messageID++;
	}

	protected Message() {
		this.id = -1;
	}

	protected MessageType type;

	public Message(MessageType type) {
		this.type = type;
	}

	/**
	 * Send this message, as a serialized object, over the given socket
	 * 
	 * @param socket
	 *            The socket to use when sending the message
	 */

	public void send(Socket s) {
		// Set the message id before sending (if not already done)
		if (this.id == -1)
			this.id = nextMessageID();

		// set the timestamp
		this.timestamp = System.currentTimeMillis();

		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(s.getOutputStream());
			out.writeObject(this);
			out.flush();
		} catch (IOException e) {
			serviceLocator = ServiceLocator.getServiceLocator();
			serviceLocator.getLogger().info(e.toString());
		}
	}

	/**
	 * Factory method to construct a message object from data reveived via
	 * socket
	 * 
	 * @param socket
	 *            The socket to ream from
	 * @return the new message object, on null in case of an error
	 */

	public static Message receive(Socket socket) throws Exception {
		ObjectInputStream in;
		Message msg = null;
		try {
			in = new ObjectInputStream((socket.getInputStream()));
			msg = (Message) in.readObject();
			// logger.info("Receive message: " + msgText);
			// msg = new GameMsg();

		} catch (IOException e) {

		}
		return msg;
	}

}
