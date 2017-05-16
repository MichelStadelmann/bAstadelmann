package login;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import tictactoe.TicTacToe;

public class LoginController {

	private LoginModel loginModel;
	private LoginView loginView;
	TicTacToe mainProgram;

	public LoginController(TicTacToe mainProgram, LoginModel loginModel, LoginView loginView) {
		this.loginModel = loginModel;
		this.loginView = loginView;

		// Connect with the server.
		loginView.btnConnect.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String ip = loginView.tfIP.getText();
				int port = Integer.parseInt(loginView.tfPort.getText());
				String name = loginView.tfPlayer.getText();
				loginModel.setUpUser(ip, port, name);
				TicTacToe.startBoard();

				// model.connect(ip, port, name);
				loginView.getStage().close();

			}
		});

		// Close window.
		loginView.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				Platform.exit();
			}
		});

		// ChangeListener for the text-property of the Username
		loginView.tfPlayer.textProperty().addListener(
				// Parameters of any PropertyChangeListener
				(observable, oldValue, newValue) -> {
					validateUsername(newValue);
				});

		// ChangeListener for the text-property of the IP
		loginView.tfIP.textProperty().addListener(
				// Parameters of any PropertyChangeListener
				(observable, oldValue, newValue) -> {
					validateIP(newValue);
				});

		// ChangeListener for the text-property of the port number
		loginView.tfPort.textProperty().addListener(
				// Parameters of any PropertyChangeListener
				(observable, oldValue, newValue) -> {
					validatePortNumber(newValue);
				});

		// register ourselves to handle window-closing event
		loginView.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
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

	// saves IP, Port and Playername in the mainClass
	// closes Login and open Board

}
