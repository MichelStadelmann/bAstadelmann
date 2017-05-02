package server;

import java.util.logging.Logger;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import tictactoe.ServiceLocator;

public class StartServer extends Application {

	private ServiceLocator serviceLocator;
	private ServerView serverView;
	private ServerModel serverModel;
	private ServerController serverController;
	private static StartServer mainProgram;

	public static void main(String[] args) {
		launch(args);

	}

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
	public void start(Stage serverStage) throws Exception {
		serverModel = new ServerModel();
		serverView = new ServerView(serverStage, serverModel);
		serverController = new ServerController(serverModel, serverView);

		serverView.start();

	}

	public void stop() {

		if (serverView != null) {
			// Make the view invisible
			serverView.stop();
		}
	}

}
