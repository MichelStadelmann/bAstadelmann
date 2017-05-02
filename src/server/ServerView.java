package server;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ServerView {

	private Stage stage;
	private ServerModel loginModel;

	protected Label lbIP = new Label("IP");
	protected TextField tfIP = new TextField("localhost");

	protected Label lbPort = new Label("Port");
	protected TextField tfPort = new TextField("22222");

	protected Button btnStart = new Button("Start");
	protected Button btnClose = new Button("Close");

	public ServerView(Stage stage, ServerModel loginModel) {
		this.stage = stage;
		this.loginModel = loginModel;

		stage.setTitle("Start or Close Server");

		GridPane root = new GridPane();
		root.setPrefSize(400, 200);

		root.add(lbIP, 0, 0);
		root.add(tfIP, 1, 0);
		root.add(lbPort, 0, 1);
		root.add(tfPort, 1, 1);
		root.add(btnStart, 0, 2);
		root.add(btnClose, 0, 3);

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

	public TextField getTfIP() {
		return tfIP;
	}

	public void setTfIP(TextField tfIP) {
		this.tfIP = tfIP;
	}

	public TextField getTfPort() {
		return tfPort;
	}

	public void setTfPort(TextField tfPort) {
		this.tfPort = tfPort;
	}

}
