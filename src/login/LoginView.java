package login;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginView {

	private Stage stage;
	private LoginModel loginModel;

	protected Label lbIP = new Label("IP");
	protected TextField tfIP = new TextField("localhost");

	protected Label lbPort = new Label("Port");
	protected TextField tfPort = new TextField("22222");

	protected Label lbPlayer = new Label("Player");
	protected TextField tfPlayer = new TextField("John Doe");

	protected Button btnConnect = new Button("Login");

	protected LoginView(Stage stage, LoginModel loginModel) {
		this.stage = stage;
		this.loginModel = loginModel;

		stage.setTitle("Login");

		GridPane root = new GridPane();
		root.setPrefSize(200, 200);

		root.add(lbIP, 0, 0);
		root.add(tfIP, 1, 0);
		root.add(lbPort, 0, 1);
		root.add(tfPort, 1, 1);
		root.add(lbPlayer, 0, 2);
		root.add(tfPlayer, 1, 2);
		root.add(btnConnect, 0, 3);

		Scene scene = new Scene(root);
		stage.setScene(scene);

	}

	public void start() {
		stage.show();

	}

	public void stop() {
		stage.hide();
	}

	public Stage getStage() {
		return stage;
	}

}
