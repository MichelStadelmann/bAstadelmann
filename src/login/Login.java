package login;

import javafx.application.Application;
import javafx.stage.Stage;

public class Login extends Application {

	private LoginView loginView;
	private LoginController loginController;
	private LoginModel loginModel;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		loginModel = new LoginModel();
		loginView = new LoginView(primaryStage, loginModel);
		loginController = new LoginController(loginModel, loginView);

		loginView.start();

	}

	public void stop() {
		if (loginView != null)
			loginView.stop();
	}

}
