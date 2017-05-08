package login;

import java.net.Socket;
import java.util.logging.Logger;

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

}
