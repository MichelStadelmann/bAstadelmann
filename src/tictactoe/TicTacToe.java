package tictactoe;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class TicTacToe extends Application {

	private Client client;
	private View view;
	private Controller controller;
	private ServiceLocator serviceLocator;
	private static TicTacToe mainProgram;
	
	public static void main(String[] args) {
		launch(args);

	}


	
	
	/**
	 * Hier ist noch offen Verbindung zum Netzwerk Server aufnehmen Schritt 3)
	 * @param arg0
	 * @throws Exception
	 */
	
	public void init(){
		if(mainProgram == null){
			mainProgram = this;
		}else{
			Platform.exit();
		}
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Initialize the GUI
		// Fat client architecture: The client contains the whole model and is so equal to model
		client = new Client();
		view = new View(primaryStage, client);
		controller = new Controller(client, view);
		
		//Resource are now intialized
		serviceLocator = ServiceLocator.getServiceLocator();
		
		
		//Display the GUI after all initialization is complete
		view.start();
		
		
	}
	
	/**
	 * Optional: to clean house, disconnect from network server
	 */
	
	public void stop(){
		if (view !=null)
			view.stop();
	}

}
