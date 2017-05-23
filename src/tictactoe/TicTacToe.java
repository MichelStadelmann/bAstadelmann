package tictactoe;

import java.util.logging.Logger;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import login.LoginController;
import login.LoginModel;
import login.LoginView;

public class TicTacToe extends Application {

	private LoginView loginView;
	private LoginController loginController;
	private LoginModel loginModel;

	private Model model;
	private View view;
	private Controller controller;
	private ServiceLocator serviceLocator;
	private static TicTacToe mainProgram;
	private static String iP;
	private static int port;
	private static String name;

	public static void main(String[] args) {
		launch(args);

	}

	/**
	 * Hier ist noch offen Verbindung zum Netzwerk Server aufnehmen Schritt 3)
	 * 
	 * @param arg0
	 * @throws Exception
	 */

	public void init() {
		if (mainProgram == null) {
			mainProgram = this;

			// Resource are now intialized
			serviceLocator = ServiceLocator.getServiceLocator();
			Logger l = Logger.getLogger("");
			serviceLocator.setLogger(l);

		} else {
			Platform.exit();
		}
	}

	/**
	 * After starting the java fx framework the login gui is first initialized.
	 * It's classes are in the package login. Then the Class Login Controller
	 * gives the order to build up the Tic Tac Toe Board, when the player logged
	 * in. The login Gui will be closed at that moment.
	 */

	@Override
	public void start(Stage primaryStage) throws Exception {
		loginModel = new LoginModel();
		loginView = new LoginView(primaryStage, loginModel);
		loginController = new LoginController(mainProgram, loginModel, loginView);

		loginView.start();

	}

	public static void startBoard() {

		Stage boardStage = new Stage();
		Model model = new Model();
		View view = new View(boardStage, model);
		Controller controller = new Controller(model, view);
		view.start();
		model.connect(iP, port, name);
		model.definePlayer();

	}

	/**
	 * The following parameters are sent by the loginModel. They are used to
	 * transfer the login data from the login-process to the game.
	 * 
	 * @param ip
	 */

	// ip
	public static void setIP(String s) {
		iP = s;

	}

	public static String getIP() {
		return iP;
	}

	// port
	public static void setPort(int p) {
		port = p;

	}

	public static int getPort() {
		return port;
	}

	// name
	public static void SetName(String n) {
		name = n;

	}

	// public void start(Stage primaryStage) throws Exception {
	// // Initialize the GUI

	// model = new Model();
	// view = new View(primaryStage, model);
	// controller = new Controller(model, view);
	//
	// // Display the GUI after all initialization is complete
	// view.start();
	//
	// // if (!Client.)

	// }

	/**
	 * Optional: to clean house, disconnect from network server
	 */

	// public void stop() {
	// if (view != null)
	// view.stop();
	// }

}