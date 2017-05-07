package tictactoe;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {

	private static final double HEIGHT = 600;
	private static final double WIDTH = 600;
	private static final int numButtons = 9;

	private Stage stage;
	private Model model;
	private ServiceLocator serviceLocator;
	protected Button button;
	public Button btn[] = new Button[9];
	protected Text text = new Text();

	/**
	 * The tic tac toe playground is created. 9 Buttons which are filled in an
	 * array and added to a GridPane Layout
	 * 
	 * @param stage
	 * @param model
	 */

	protected View(Stage stage, Model model) {
		this.stage = stage;
		this.model = model;

		stage.setTitle("Tic Tac Toe");

		GridPane root = new GridPane();
		root.setPrefSize(WIDTH, HEIGHT);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				// create buttons and add them to layout
				if (i == 0) {
					btn[j] = new Button();
					btn[j].setMaxWidth(Double.MAX_VALUE);
					btn[j].setMaxHeight(Double.MAX_VALUE);
					root.add(btn[j], i, j);
					// buttons fill max width of GridPane
					ColumnConstraints column = new ColumnConstraints();
					column.setPercentWidth(33);
					root.getColumnConstraints().add(column);

				}

				if (i == 1) {
					btn[j + 3] = new Button();
					btn[j + 3].setMaxWidth(Double.MAX_VALUE);
					btn[j + 3].setMaxHeight(Double.MAX_VALUE);
					root.add(btn[j + 3], i, j);

				}

				if (i == 2) {
					btn[j + 6] = new Button();
					btn[j + 6].setMaxWidth(Double.MAX_VALUE);
					btn[j + 6].setMaxHeight(Double.MAX_VALUE);
					root.add(btn[j + 6], i, j);

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

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public void start() {
		stage.show();

	}

	public void stop() {
		stage.hide();

	}

	public void drawSymbol(int index) {

		if (model.getTurnX() == true) {

			btn[index].setText("X");
			// btn[index].setDisable(true);
			model.setTurnX(false);
			model.setTurnY(true);

		}

		else {

			btn[index].setText("O");
			model.setTurnX(true);
			model.setTurnY(false);

		}

	}

	public Button[] getBtn() {
		return btn;
	}

	public void setBtn(Button[] btn) {
		this.btn = btn;
	}

}
