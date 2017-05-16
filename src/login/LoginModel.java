package login;

import java.util.logging.Logger;

import tictactoe.TicTacToe;

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

	public void setUpUser(String ip, int port, String name) {
		TicTacToe.setIP(ip);
		TicTacToe.setPort(port);
		TicTacToe.SetName(name);

	}

}
