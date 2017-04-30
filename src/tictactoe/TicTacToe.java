package tictactoe;

import java.util.logging.Logger;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class TicTacToe extends Application {

	private Model model;
	private View view;
	private Controller controller;
	private ServiceLocator serviceLocator;
	private static TicTacToe mainProgram;

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

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Initialize the GUI
		// Fat client architecture: The client contains the whole model and is
		// so equal to model
		model = new Model();
		view = new View(primaryStage, model);
		controller = new Controller(model, view);

		// Display the GUI after all initialization is complete
		view.start();

		// if (!Client.)

	}

	/**
	 * Optional: to clean house, disconnect from network server
	 */

	public void stop() {
		if (view != null)
			view.stop();
	}

}
