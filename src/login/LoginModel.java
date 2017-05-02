package login;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * 
 * Dem Controller die aktuelle IP Adresse übergeben. Usernamen, IP und Port in
 * der main Klasse JavaFX_App_Template speichern.
 * 
 * @author mosta
 *
 */

public class LoginModel {

	// alternative to/with servicelocator
	private Logger logger = Logger.getLogger("");
	private Socket socket;

	public void connect(String player, String ip, int port) {
		try {
			socket = new Socket(ip, port);
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
