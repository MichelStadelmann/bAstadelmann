package tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {

	ServiceLocator serviceLocator;
	private Client client;
	private View view;

	public Controller(Client client, View view) {
		this.client = client;
		this.view = view;

		view.button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				client.addSymbol();
				String newText = Integer.toString(client.getValue());

			}
		});

	}

}
