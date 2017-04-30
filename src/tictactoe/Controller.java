package tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {

	ServiceLocator serviceLocator;
	private Model model;
	private View view;

	protected Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		// register ourselves to listen for button clicks
		for (int i = 0; i < 9; i++) {
			view.btn[i].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.out.println("Hello World");

				}
			});
		}

		// String test = view.getButtonId();
		// serviceLocator = ServiceLocator.getServiceLocator();
		// serviceLocator.getLogger().info("test");

		// view.button.setOnAction(new EventHandler<ActionEvent>() {
		//
		// @Override
		// public void handle(ActionEvent event) {
		// client.addSymbol();
		// String newText = Integer.toString(client.getValue());
		//
		// }
		// });

	}

}
