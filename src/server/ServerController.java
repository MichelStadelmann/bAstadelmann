package server;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import tictactoe.ServiceLocator;

public class ServerController {

	private ServerModel serverModel;
	private ServerView serverView;
	private ServiceLocator serviceLocator;

	public ServerController(ServerModel serverModel, ServerView serverView) {
		this.serverModel = serverModel;
		this.serverView = serverView;

		// start the server
		serverView.btnStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Integer port = new Integer(serverView.tfPort.getText());
				try {
					serverModel.startServer(port);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		// stop the server
		serverView.btnClose.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				serverModel.stopServer();
			}
		});

		// Close window.
		serverView.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				Platform.exit();
			}
		});

		// ChangeListener for the text-property of the IP
		serverView.tfIP.textProperty().addListener(
				// Parameters of any PropertyChangeListener
				(observable, oldValue, newValue) -> {
					validateIP(newValue);
				});

		// ChangeListener for the text-property of the port number
		serverView.tfPort.textProperty().addListener(
				// Parameters of any PropertyChangeListener
				(observable, oldValue, newValue) -> {
					validatePortNumber(newValue);
				});

		// register ourselves to handle window-closing event
		serverView.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				Platform.exit();
			}
		});

	}

	private void validatePortNumber(String newValue) {
		// TODO Auto-generated method stub

	}

	private void validateIP(String newValue) {
		// TODO Auto-generated method stub

	}

	private void validateUsername(String newValue) {
		// TODO Auto-generated method stub

	}

}
