package tictactoe;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class View {

	private static final double HEIGHT = 600;
	private static final double WIDTH = 600;

	private Stage stage;
	private Client client;
	private Scene scene1;
	private ServiceLocator serviceLocator;
	protected Button button;

	public View(Stage stage, Client client) {
		this.stage = stage;
		this.client = client;

		stage.setTitle("Tic Tac Toe");

		GridPane root = new GridPane();
		root.setPrefSize(WIDTH, HEIGHT);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				Button button = new Button();
				button.setMaxWidth(Double.MAX_VALUE);
				button.setMaxHeight(Double.MAX_VALUE);

				// button id's are set
				if (i == 0) {
					button.setId(String.valueOf(j + 1));
				}

				if (i == 1) {
					button.setId(String.valueOf(j + 1 + 3));
				}

				if (i == 2) {
					button.setId(String.valueOf(j + 1 + 6));
				}

				root.add(button, i, j);
				serviceLocator = ServiceLocator.getServiceLocator();
				serviceLocator.getLogger().info(button.getId());

				// buttons fill max width of GridPane
				if (i == 0) {
					ColumnConstraints column = new ColumnConstraints();
					column.setPercentWidth(33);
					root.getColumnConstraints().add(column);
				}
			}

			// buttons fill max height of GridPane
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setPercentHeight(33);
			root.getRowConstraints().add(rowConstraints);

		}

		Scene scene = new Scene(root);
		stage.setScene(scene);

		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Application view initialized");

	}

	public void start() {
		stage.show();

	}

	public void stop() {
		// TODO Auto-generated method stub

	}

}
