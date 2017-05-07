package login;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

import messages.ChangeMsg;
import messages.GameMsg;
import messages.Message;
import tictactoe.Controller;
import tictactoe.Model;
import tictactoe.View;

/**
 * 
 * Dem Controller die aktuelle IP Adresse übergeben. Usernamen, IP und Port in
 * der main Klasse JavaFX_App_Template speichern.
 * 
 * @author mosta
 *
 */

public class LoginModel {

	// protected SimpleStringProperty newestState = new SimpleStringProperty();

	// alternative to/with servicelocator
	private Logger logger = Logger.getLogger("");
	private Socket socket;

	private String name;

	private Controller controller;
	private View view;
	private Model model;
	private int field;
	private String content;

	public void connect(String name, String ip, int port, Model model) {
		logger.info("Connect");
		this.name = name;
		this.model = model;
		try {
			socket = new Socket("localhost", 22222);

			// Create thread to read incoming messages
			Runnable r = new Runnable() {

				@Override
				public void run() {
					while (true) {

						try {
							// GameMsg msg = (GameMsg) Message.receive(socket);
							ChangeMsg change = (ChangeMsg) Message.receive(socket);
							view.btn[0].setText("X");

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}

			};
			Thread t = new Thread(r);
			t.start();

			// Send game state update message to the server
			GameMsg gMsg = new GameMsg(field, content);
			gMsg.send(socket);

		} catch (Exception e) {
			logger.warning(e.toString());
		}

	}

	public void disconnect() {
		logger.info("Disconnect");
		if (socket != null)
			try {
				socket.close();
			} catch (IOException e) {

			}

	}

}
