package login;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import tictactoe.TicTacToe;

public class LoginController {

	private LoginModel loginModel;
	private LoginView LoginView;

	public LoginController(LoginModel loginModel, LoginView loginView) {
		this.loginModel = loginModel;
		this.LoginView = loginView;

		// Connect with the server.
		LoginView.btnConnect.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				btnConnect();
			}
		});

		// Close window.
		LoginView.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				Platform.exit();
			}
		});

		// ChangeListener for the text-property of the Username
		LoginView.tfPlayer.textProperty().addListener(
				// Parameters of any PropertyChangeListener
				(observable, oldValue, newValue) -> {
					validateUsername(newValue);
				});

		// ChangeListener for the text-property of the IP
		LoginView.tfIP.textProperty().addListener(
				// Parameters of any PropertyChangeListener
				(observable, oldValue, newValue) -> {
					validateIP(newValue);
				});

		// ChangeListener for the text-property of the port number
		LoginView.tfPort.textProperty().addListener(
				// Parameters of any PropertyChangeListener
				(observable, oldValue, newValue) -> {
					validatePortNumber(newValue);
				});

		// register ourselves to handle window-closing event
		LoginView.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
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
	protected void btnConnect() {
		String ip = LoginView.tfIP.getText();
		int port = Integer.parseInt(LoginView.tfPort.getText());
		String player = LoginView.tfPlayer.getText();
		LoginModel.setUpUser(player, ip, port);
		TicTacToe.startBoard();
		LoginView.getStage().close();

	}

}
